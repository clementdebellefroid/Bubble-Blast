package bubble_blast;

public class Joueur {

	private String nom;
	private Score score;
	
	public Joueur(String nom, Score score){
		this.nom = nom;
		this.score = score;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

}
