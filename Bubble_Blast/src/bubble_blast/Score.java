package bubble_blast;

public class Score {
	
	private int temps;
	private int nbTouches;
	
	public Score(int temps, int nbTouches){
		this.temps = temps;
		this.nbTouches = nbTouches;
	}
	
	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public int getNbTouches() {
		return nbTouches;
	}

	public void setNbTouches(int nbTouches) {
		this.nbTouches = nbTouches;
	}
	
	public int calculerScore(){
		int score = temps*nbTouches;
		return score;
	}
}
