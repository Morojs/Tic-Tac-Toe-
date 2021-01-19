package ma.classes;

public class TicTac {

	// DANS CETTE CLASSE J'AI DECLARE LA LOGIQUE DU JEUX X/O DU COTE SERVEUR
	
	public static char[][] matrice;
	private char symbole;
	private int ligne,colonne;
	public TicTac(char symbole) {
		this.symbole=symbole;
		this.ligne=(int) (Math.random() * ( 2 - 0 ));
		this.colonne=(int) (Math.random() * ( 2 - 0 ));
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
		
		if(occurence==1) {
			while(this.matrice[ligne][colonne]!='?') {
				 ligne=(int) (Math.random() * ( 2 - 0 ));
				 colonne=(int) (Math.random() * ( 2 - 0 ));
			}
			this.matrice[ligne][colonne]='O';
		 }
		
		return occurence > 1 ? true : false;
	}

	public boolean checkLignes() {
	
	   // check lignes
		return false;
	}
	public void checkColumns() {
		
	}
	public void checkDiagnoles() {
		
	}
	public void checkWinner() {
		
	}
	
	
	
	
	
	
	
}
