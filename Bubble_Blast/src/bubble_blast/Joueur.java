package bubble_blast;

public class Joueur {

	private static int scorePartie;
	private static boolean modeSolo = true;
	
	public Joueur(){
		scorePartie = 0;
	}
	
	public static boolean isModeSolo() {
		return modeSolo;
	}

	public static void setModeSolo(boolean modeSolo) {
		Joueur.modeSolo = modeSolo;
	}

	public static int getScorePartie() {
		return scorePartie;
	}

	public static void ajouterAScorePartie(int scoreSupp) {
		scorePartie = scorePartie + scoreSupp;
	}

}
