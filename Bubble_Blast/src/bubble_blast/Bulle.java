package bubble_blast;

import javax.swing.ImageIcon;

public class Bulle{

	private int couleur;
	private int c;
	private int l;
	private boolean ready = false;
	private Animation animation = new Animation(this);
	
	public Bulle(int couleur, int c, int l){
		this.couleur = couleur;
		this.c = c;
		this.l = l;
		if(couleur == 1) (EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleRougeAnimation.gif"));
		else if(couleur == 2) (EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleVerte.gif"));
		else if(couleur == 3) (EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleJaune.gif"));
		else if(couleur == 4) (EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleBleue.gif"));

	}
	
	public int getCouleur(){
		return couleur;
	}
	
	public void setCouleur(int couleur){
		this.couleur = couleur;
	}
	
	public int getC(){
		return c;
	}
	
	public int getL(){
		return l;
	}
	
	
	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public void changerCouleur(){
		animation.changerDeCouleur(this);
		if(couleur == 1){
			Score.addCombo();
			Score.addCombo();
			Niveau.MesBulles.remove(c+"/"+l);
			eclaterBulle();
		}
		else {
			Score.addCombo();
			couleur--;
		}
	}

	public void eclaterBulle(){
	
		int ligneBulleDessus = lBulleDessus(c, l);
		int casesVidesDessus = l - ligneBulleDessus - 1;
		if(ligneBulleDessus == -1) casesVidesDessus = l;

		int ligneBulleDessous = lBulleDessous(c, l);
		int casesVidesDessous = ligneBulleDessous - l - 1;
		if(ligneBulleDessous == -1) casesVidesDessous = 5 - l;
		
		int colonneBulleGauche = cBulleGauche(c, l);
		int casesVidesGauche = c - colonneBulleGauche - 1;
		if(colonneBulleGauche == -1) casesVidesGauche = c;
		
		int colonneBulleDroite = cBulleDroite(c, l);
		int casesVidesDroite = colonneBulleDroite - c - 1;
		if(colonneBulleDroite == -1) casesVidesDroite = 4 - c;
		
		animation.genererProjectileBille(this, casesVidesDessus, 1);
		animation.genererProjectileBille(this, casesVidesDessous, 2);
		animation.genererProjectileBille(this, casesVidesGauche, 3);
		animation.genererProjectileBille(this, casesVidesDroite, 4);
		
		if(ligneBulleDessus != -1){
			Bulle bulleDessus = Niveau.MesBulles.get(c+"/"+ligneBulleDessus);
			bulleDessus.changerCouleur();
		}
		if(ligneBulleDessous != -1){
			Bulle bulleDessous = Niveau.MesBulles.get(c+"/"+ligneBulleDessous);
			bulleDessous.changerCouleur();
		}
		if(colonneBulleGauche != -1){
			Bulle bulleGauche = Niveau.MesBulles.get(colonneBulleGauche+"/"+l);
			bulleGauche.changerCouleur();
		}
		if(colonneBulleDroite != -1){
			Bulle bulleDroite = Niveau.MesBulles.get(colonneBulleDroite+"/"+l);
			bulleDroite.changerCouleur();
		}
	}
	
	/*Quand une bulle Žclate, on la supprime de la Hashtable. Sont donc prŽsentes dans la Hashtable que les
	 * bulles qu'on peut voir ˆ l'Žcran. Pour obtenir les coordonnŽes de la bulle au dessus, on va utiliser
	 * un simple "for(int i = l-1; ;i--)" parcourant les cases vides (celle au dessus de la bulle courante jusqu'ˆ celle tout en haut
	 * de la grille. On va utiliser la mŽthode .containsKey(c+"/"+i) pour vŽrifier si il existe une bulle dans la
	 * hashtable. Si oui, on renvoie ses coord.*/
	public int lBulleDessus(int c, int l){
		for(int i = l-1; i>=0 ;i--){
			if(Niveau.MesBulles.containsKey(c+"/"+i)){
				return (i);
			}
		}	
		return (-1);
	}
	
	public int lBulleDessous(int c, int l){
		for(int i = l+1; i<=5 ;i++){
			if(Niveau.MesBulles.containsKey(c+"/"+i)){
				return (i);
			}
		}	
		return (-1);
	}
	
	public int cBulleGauche(int c, int l){
		for(int i = c-1; i>=0 ;i--){
			if(Niveau.MesBulles.containsKey(i+"/"+l)){
				return (i);
			}
		}	
		return (-1);
	}
	
	public int cBulleDroite(int c, int l){
		for(int i = c+1; i<=4 ;i++){
			if(Niveau.MesBulles.containsKey(i+"/"+l)){
				return (i);
			}
		}	
		return (-1);
	}
}
