package be.ephec.bubble_blast;

public class Joueur {

	private static int scorePartie;
	private static boolean host;
	private static boolean modeSolo = true;
	
	public Joueur(){
		scorePartie = 0;
	}
	
	public static boolean isHost() {
		return host;
	}

	public static void setHost(boolean host) {
		Joueur.host = host;
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
