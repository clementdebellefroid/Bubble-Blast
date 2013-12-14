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
	
	
	public void changerCouleur(int casesParcouruesBille){
		switch(couleur) {
		case (1): eclaterBulle(casesParcouruesBille);break;
		case (2):{
					Animation anim = new Animation(c,l,casesParcouruesBille,couleur,true);
					Score.addCombo();
					couleur = 1;
					break; 
				}
		case (3):{
					Animation anim = new Animation(c,l,casesParcouruesBille,couleur,true);
					Score.addCombo();			
					couleur = 2;
					break;
				}
		case (4):{
					Animation anim = new Animation(c,l,casesParcouruesBille,couleur,true);
					Score.addCombo();
					couleur = 3;
					break;
				}
		}
	}

	public void eclaterBulle(int casesParcouruesBille){
		Score.addCombo();
		Score.addCombo();
		int casesVidesAParcourirDessus=0;
		int casesVidesAParcourirDessous=0;
		int casesVidesAParcourirGauche=0;
		int casesVidesAParcourirDroite=0;
		if(casesParcouruesBille == -1) {
			Animation animEclatement = new Animation(this, -1);
		}
		else 	{
			Animation animEclatement = new Animation(this, casesParcouruesBille);
		}
		Niveau.MesBulles.remove(c+"/"+l);

		int coordDessus = coordBulleDessus(c, l);
		if(coordDessus != (-1))
		{
			for(int i=l-1; i>coordDessus; i--)
			{
				casesVidesAParcourirDessus = l-i;
				Animation animBilleDessus = new Animation(c,i,1,casesVidesAParcourirDessus);				  
			}
			Bulle bulleDessus = Niveau.MesBulles.get(c+"/"+coordDessus);
			bulleDessus.changerCouleur(casesVidesAParcourirDessus);
		}
		else
		{
			for(int i=l-1; i>=0;i--)
			{
				casesVidesAParcourirDessus = l-i;
				Animation animBilleDessus = new Animation(c,i,1,casesVidesAParcourirDessus);		
			}
		}

		int coordDessous = coordBulleDessous(c, l);
		if(coordDessous != (-1))
		{
			for(int i=l+1; i<coordDessous; i++)
			{
				casesVidesAParcourirDessous = i-l;
				Animation animBilleDessous = new Animation(c,i,2,casesVidesAParcourirDessous);
			}
			Bulle bulleDessous = Niveau.MesBulles.get(c+"/"+coordDessous);
			bulleDessous.changerCouleur(casesVidesAParcourirDessous);
		}
		else
		{
			for(int i=l+1; i<=5;i++)
			{
				casesVidesAParcourirDessous = i-l;
				Animation animBilleDessous = new Animation(c,i,2,casesVidesAParcourirDessous);		
			}
		}

		int coordGauche = coordBulleGauche(c, l);
		if(coordGauche != (-1))
		{
			for(int i=c-1; i>coordGauche; i--)
			{
				casesVidesAParcourirGauche = c-i;
				Animation animBilleGauche = new Animation(i,l,3,casesVidesAParcourirGauche);		
			}
			Bulle bulleGauche = Niveau.MesBulles.get(coordGauche+"/"+l);
			bulleGauche.changerCouleur(casesVidesAParcourirGauche);
		}
		else
		{
			for(int i=c-1; i>=0;i--)
			{
				casesVidesAParcourirGauche = c-i;
				Animation animBilleGauche = new Animation(i,l,3,casesVidesAParcourirGauche);		
			}
		}

		int coordDroite = coordBulleDroite(c, l);
		if(coordDroite != (-1))
		{
			for(int i=c+1; i<coordDroite; i++)
			{
				casesVidesAParcourirDroite = i-c;
				Animation animBilleDroite = new Animation(i,l,4,casesVidesAParcourirDroite);		
			}
			Bulle bulleDroite = Niveau.MesBulles.get(coordDroite+"/"+l);
			bulleDroite.changerCouleur(casesVidesAParcourirDroite);
		}
		else
		{
			for(int i=c+1; i<=4;i++)
			{
				casesVidesAParcourirDroite = i-c;
				Animation animBilleDroite = new Animation(i,l,4,casesVidesAParcourirDroite);		
			}
		}
	}
	
	/*Quand une bulle Žclate, on la supprime de la Hashtable. Sont donc prŽsentes dans la Hashtable que les
	 * bulles qu'on peut voir ˆ l'Žcran. Pour obtenir les coordonnŽes de la bulle au dessus, on va utiliser
	 * un simple "for(int i = l-1; ;i--)" parcourant les cases vides (celle au dessus de la bulle courante jusqu'ˆ celle tout en haut
	 * de la grille. On va utiliser la mŽthode .containsKey(c+"/"+i) pour vŽrifier si il existe une bulle dans la
	 * hashtable. Si oui, on renvoie ses coord.*/
	public int coordBulleDessus(int c, int l){
		for(int i = l-1; i>=0 ;i--){
			if(Niveau.MesBulles.containsKey(c+"/"+i)){
				return (i);
			}
		}	
		return (-1);
	}
	
	public int coordBulleDessous(int c, int l){
		for(int i = l+1; i<=5 ;i++){
			if(Niveau.MesBulles.containsKey(c+"/"+i)){
				return (i);
			}
		}	
		return (-1);
	}
	
	public int coordBulleGauche(int c, int l){
		for(int i = c-1; i>=0 ;i--){
			if(Niveau.MesBulles.containsKey(i+"/"+l)){
				return (i);
			}
		}	
		return (-1);
	}
	
	public int coordBulleDroite(int c, int l){
		for(int i = c+1; i<=4 ;i++){
			if(Niveau.MesBulles.containsKey(i+"/"+l)){
				return (i);
			}
		}	
		return (-1);
	}
}
