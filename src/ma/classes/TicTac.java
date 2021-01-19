package ma.classes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTac {

	// DANS CETTE CLASSE J'AI DECLARE LA LOGIQUE DU JEUX X/O DU COTE SERVEUR
	
	public static char[][] matrice;
	private char symbole;
	private int ligne,colonne;
	public static boolean isPlayed;
	public static boolean winner;
	public TicTac(char symbole) {
		this.symbole=symbole;
		isPlayed=false;
		winner=false;
		this.ligne=(int) (Math.random() * ( 2 - 0 ));
		this.colonne=(int) (Math.random() * ( 2 - 0 ));
	}
	
	public void playRandom() {
		while(this.matrice[ligne][colonne]!='?') {
			 ligne=(int) (Math.random() * ( 2 - 0 ));
			 colonne=(int) (Math.random() * ( 2 - 0 ));
		}
		this.matrice[ligne][colonne]='O';
	}
	
	
	public boolean playState() {
		// je vérifie le nombre d'occurrence du symbole X dans la matrice pour déterminer si le jeu il est dans l'etat start 
		// si oui le serveur va jouer un symbole dans une case random dans la matrice
		
		int occurence=0;
		for (int l = 0; l < matrice.length; l++) {
			for (int c = 0; c < matrice.length; c++) {
		 		if(matrice[l][c]==symbole) 
		 			occurence++;
			}
		}
		
		if(occurence==1 && !isPlayed) {
			isPlayed=true;
			playRandom();
		 }
		
		return occurence > 1 ? true : false;
	}
	
	public boolean checkWinner() {
		int occurenceX=0;
		for (int l = 0; l < matrice.length; l++) {
			occurenceX=0;
			for (int c = 0; c < matrice.length; c++) {
		 		if(matrice[l][c]==symbole) occurenceX++;
			}
			
			if(occurenceX==3) {
				break;
			}
			else
			{
				occurenceX=0;
				for (int c = 0; c < matrice.length; c++) {
			 		if(matrice[c][l]==symbole) occurenceX++;
				}
				if(occurenceX==3) {
					break;
				}
				else
				{
					occurenceX=0;
					for (int c = 0; c < matrice.length; c++) {
				 		if(matrice[c][c]==symbole) occurenceX++;
					}
					if(occurenceX==3) {
						break;
					}
					else
					{
						occurenceX=0;
						for (int j = 0; j < matrice.length; j++) {
					 		if(matrice[j][matrice.length-(j+1)]==symbole) occurenceX++;
						}
						if(occurenceX==3) {
							break;
						}
					}
				}
			}
		}
		
		return occurenceX==3 ? true : false;
	}
	
	public void playOrder() {
		if(checkWinner()) {
			JOptionPane pane = new JOptionPane();
			int dialogResult = JOptionPane.showConfirmDialog(pane, "Game Over. "+ symbole + " wins. Would you like to play again?","Game over.",
					JOptionPane.YES_NO_OPTION);
			winner=true;
			return;
		}
		if(checkLignes()) return;
		
		if(checkColumns()) return;
		
		// Random Play

		
		
		
	}
	public boolean checkLignes() {
	
	   // check lignes
		int occurenceX=0,col=0,ligne=0;;
		
		if(playState()) {	
		 for (int l = 0; l < matrice.length; l++) {
			occurenceX=0;
			for (int c = 0; c < matrice.length; c++) {
		 		if(matrice[l][c]==symbole) 
		 			occurenceX++;
		 		else {
		 			col=c;
		 			ligne=l;
		 		}
		 		  
			}
			
			if(occurenceX>1 && this.matrice[l][col]=='?') {
				this.matrice[l][col]='O';
				break;
			}
		}
	  }
		return occurenceX > 1 && this.matrice[ligne][col]=='?'  ? true : false;
	}
	public boolean checkColumns() {
		 // check lignes
		int occurenceX=0,col=0,ligne=0;
		
		if(playState()) {
		for (int l = 0; l < matrice.length; l++) {
			occurenceX=0;
			for (int c = 0; c < matrice.length; c++) {
		 		if(matrice[c][l]==symbole) 
		 			occurenceX++;
		 		else {
		 		  col=c;
		 		  ligne=l;
		 		}
			}
			if(occurenceX>1 && this.matrice[l][col]=='?') {
				this.matrice[col][l]='O';
			}
		}
	  }
		return occurenceX > 1 && this.matrice[ligne][col]=='?' ? true : false;
	}
	public void checkDiagnoles() {
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
