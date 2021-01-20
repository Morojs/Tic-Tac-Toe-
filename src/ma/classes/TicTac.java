package ma.classes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ma.interfaces.TicTacInterface;

public class TicTac {

	// DANS CETTE CLASSE J'AI DECLARE LA LOGIQUE DU JEUX X/O DU COTE SERVEUR

	public static char[][] matrice;
	private char symbole;
	private int ligne, colonne;
	private boolean isExists;
	public static boolean winner;

	public TicTac(char symbole) {
		this.symbole = symbole;
		winner = false;
		this.ligne = (int) (Math.random() * (2 - 0));
		this.colonne = (int) (Math.random() * (2 - 0));
	}

	public void playRandom() {
		while (this.matrice[ligne][colonne] != '?') {
			ligne = (int) (Math.random() * (2 - 0));
			colonne = (int) (Math.random() * (2 - 0));
		}
		this.matrice[ligne][colonne] = 'O';
	}

	public boolean playState() {
		// je vérifie le nombre d'occurrence du symbole X dans la matrice pour
		// déterminer si le jeu il est dans l'etat start
		// si oui le serveur va jouer un symbole dans une case random dans la matrice

		int occurence = 0;
		for (int l = 0; l < matrice.length; l++) {
			for (int c = 0; c < matrice.length; c++) {
				if (matrice[l][c] == symbole)
					occurence++;
			}
		}

		return occurence > 1 ? true : false;
	}

	public boolean checkWinner() {
		int occurenceX = 0;
		for (int l = 0; l < matrice.length; l++) {
			occurenceX = 0;
			for (int c = 0; c < matrice.length; c++) {
				if (matrice[l][c] == symbole)
					occurenceX++;
			}

			if (occurenceX == 3) {
				break;
			} else {
				occurenceX = 0;
				for (int c = 0; c < matrice.length; c++) {
					if (matrice[c][l] == symbole)
						occurenceX++;
				}
				if (occurenceX == 3) {
					break;
				} else {
					occurenceX = 0;
					for (int c = 0; c < matrice.length; c++) {
						if (matrice[c][c] == symbole)
							occurenceX++;
					}
					if (occurenceX == 3) {
						break;
					} else {
						occurenceX = 0;
						for (int j = 0; j < matrice.length; j++) {
							if (matrice[j][matrice.length - (j + 1)] == symbole)
								occurenceX++;
						}
						if (occurenceX == 3) {
							break;
						}
					}
				}
			}
		}

		return occurenceX == 3 ? true : false;
	}

	public boolean tryToWin() {

		if (checkLignes())
			return true;

		if (checkColumns())
			return true;

		if (checkFirstDiagnoleLine())
			return true;

		if (checkSecondDiagnoleLine())
			return true;

		// if none of above

		return false;
	}

	public void findWinnerSymbol() {
		this.symbole = 'O';
		if (checkWinner()) {
			winner = true;
			return;
		}
		this.symbole = 'X';
		if (checkWinner()) {
			winner = true;
			return;
		}
	}

	public char getSymbole() {
		return symbole;
	}

	public void setSymbole(char symbole) {
		this.symbole = symbole;
	}

	public void playOrder() {
		findWinnerSymbol();
		if (playState()) {

			// try to win
			this.symbole = 'O';
			if (!tryToWin()) {
				this.symbole = 'X';
				if (!tryToWin())
					playRandom();
				findWinnerSymbol();
			} else
				findWinnerSymbol();

		} else
			playRandom();

	}

	public boolean checkLignes() {

		// check lignes
		int occurenceX = 0, col = 0, ligne = 0;

		if (playState()) {
			for (int l = 0; l < matrice.length; l++) {
				occurenceX = 0;
				for (int c = 0; c < matrice.length; c++) {
					if (matrice[l][c] == symbole)
						occurenceX++;
					else {
						col = c;
						ligne = l;
					}

				}

				if (occurenceX > 1 && this.matrice[ligne][col] == '?') {
					this.matrice[ligne][col] = 'O';
					this.isExists = true;
					break;
				} else {
					isExists = false;
				}
			}
		}
		// System.out.println("Occurence Ligne "+occurenceX+ " symbole exists "+
		// matrice[ligne][col]);
		return isExists;
	}

	public boolean checkColumns() {
		// check lignes
		int occurenceX = 0, col = 0, ligne = 0;

		if (playState()) {
			for (int l = 0; l < matrice.length; l++) {
				occurenceX = 0;
				for (int c = 0; c < matrice.length; c++) {
					if (matrice[c][l] == symbole)
						occurenceX++;
					else {
						col = l;
						ligne = c;
					}
				}
				if (occurenceX > 1 && this.matrice[ligne][col] == '?') {
					this.matrice[ligne][col] = 'O';
					this.isExists = true;
					break;
				} else {
					isExists = false;
				}
			}
		}
		return isExists;
	}

	public boolean checkFirstDiagnoleLine() {

		// check fisrt diagonales line
		int occurenceX = 0, col = 0, ligne = 0;
		;

		if (playState()) {
			for (int c = 0; c < matrice.length; c++) {

				if (matrice[c][c] == symbole)
					occurenceX++;
				else {
					col = c;
					ligne = c;
				}
			}

			if (occurenceX > 1 && this.matrice[col][ligne] == '?') {
				this.matrice[col][ligne] = 'O';
				this.isExists = true;
			} else
				isExists = false;
		}
		return isExists;
	}

	public boolean checkSecondDiagnoleLine() {

		// check Second diagonale line
		int occurenceX = 0, col = 0, ligne = 0;
		;

		if (playState()) {
			for (int c = 0; c < matrice.length; c++) {

				if (matrice[c][matrice.length - (c + 1)] == symbole)
					occurenceX++;
				else {
					col = matrice.length - (c + 1);
					ligne = c;
				}
			}

			if (occurenceX > 1 && this.matrice[ligne][col] == '?') {
				this.matrice[ligne][col] = 'O';
				this.isExists = true;
			} else
				isExists = false;
		}
		return isExists;
	}
}
