package bubble_blast;

import javax.swing.ImageIcon;

public class Bulle{

	private int couleur;
	private int c;
	private int l;
	
	public Bulle(int couleur, int c, int l){
		this.couleur = couleur;
		this.c = c;
		this.l = l;
		if(couleur == 1) (EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleRouge.jpg")));
		else if(couleur == 2) (EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleVerte.jpg")));
		else if(couleur == 3) (EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleJaune.jpg")));
		else if(couleur == 4) (EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleBleue.jpg")));

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
	
	
	public void changerCouleur(){
		switch(couleur) {
		case (1): eclaterBulle(c,l);
		  try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {}
		  break;
		case (2): { (EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleRouge.jpg")));
					couleur = 1; break; }
		case (3): { (EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleVerte.jpg")));
					couleur = 2; break;	}
		case (4): { (EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleJaune.jpg")));
					couleur = 3; break; }
		}
	}

	public void eclaterBulle(int c, int l){
		(EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/CaseVide.jpg")));
		Niveau.MesBulles.remove(c+"/"+l);
		
		/*check mon commentaire dans EcranJeu */
		
		/* gr‰ce aux mŽthodes coordBulleDessus, coordBulleDessous, coordBulleGauche et coordBulleDroite, on
		 * recoit le string correspondant a la position de la prochaine bulle qu'il faut changerCouleur().
		 * Le string correspond en fait ˆ la Key de la Hashtable. Si le String re�u = null, ca veut dire qu'il
		 * n'y a pas de bulle ˆ Žclater. On a donc une bulleDessus et on applique changerCouleur sur celle-ci
		 * que si coordBulle renvoie autre chose que null */
		String coordDessus = coordBulleDessus(c, l);
		if(coordDessus != null)
		{
			Bulle bulleDessus = Niveau.MesBulles.get(coordDessus);
			bulleDessus.changerCouleur();
		}
		String coordDessous = coordBulleDessous(c, l);
		if(coordDessous != null)
		{
			Bulle bulleDessous = Niveau.MesBulles.get(coordDessous);
			bulleDessous.changerCouleur();
		}
		String coordGauche = coordBulleGauche(c, l);
		if(coordGauche != null)
		{
			Bulle bulleGauche = Niveau.MesBulles.get(coordGauche);
			bulleGauche.changerCouleur();
		}
		String coordDroite = coordBulleDroite(c, l);
		if(coordDroite != null)
		{
			Bulle bulleDroite = Niveau.MesBulles.get(coordDroite);
			bulleDroite.changerCouleur();
		}
	}
	
	/*Quand une bulle Žclate, on la supprime de la Hashtable. Sont donc prŽsentes dans la Hashtable que les
	 * bulles qu'on peut voir ˆ l'Žcran. Pour obtenir les coordonnŽes de la bulle au dessus, on va utiliser
	 * un simple "for(int i = l-1; ;i--)" parcourant les cases vides (celle au dessus de la bulle courante jusqu'ˆ celle tout en haut
	 * de la grille. On va utiliser la mŽthode .containsKey(c+"/"+i) pour vŽrifier si il existe une bulle dans la
	 * hashtable. Si oui, on renvoie ses coord.*/
	public String coordBulleDessus(int c, int l){
		for(int i = l-1; i>=0 ;i--){
			if(Niveau.MesBulles.containsKey(c+"/"+i)) return (c+"/"+i);
		}	
		return null;
	}
	
	public String coordBulleDessous(int c, int l){
		for(int i = l+1; i<=5 ;i++){
			if(Niveau.MesBulles.containsKey(c+"/"+i)) return (c+"/"+i);
		}	
		return null;
	}
	
	public String coordBulleGauche(int c, int l){
		for(int i = c-1; i>=0 ;i--){
			if(Niveau.MesBulles.containsKey(i+"/"+l)) return (i+"/"+l);
		}	
		return null;
	}
	
	public String coordBulleDroite(int c, int l){
		for(int i = c+1; i<=4 ;i++){
			if(Niveau.MesBulles.containsKey(i+"/"+l)) return (i+"/"+l);
		}	
		return null;
	}
}
