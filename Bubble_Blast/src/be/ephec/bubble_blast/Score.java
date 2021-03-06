package be.ephec.bubble_blast;

public class Score {
	
	private int score;
	private int nbTouches;
	private static int combo;
	
	public Score(){
		this.score = 0;
		this.nbTouches = 0;
		combo = 0;
	}
	
	public static void addCombo() {
		combo++;
	}
	
	public void setCombo(int newCombo) {
		combo = newCombo;
	}

	public int getNbTouches() {
		return nbTouches;
	}

	public void ajouterTouche() {
		nbTouches++;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void calculerScore(){
		int scoreAAjouter = 0;
		scoreAAjouter = combo * (100/nbTouches);
		score += scoreAAjouter;
	}
	
	public void calculerBonus(){
		int bonus = score * ((100/(nbTouches)))/10 - score;
		score += bonus;
	}
}
