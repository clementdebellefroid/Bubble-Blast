package bubble_blast;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
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
	
	
	public void changerCouleur(){
		switch(couleur) {
		case (1): eclaterBulle(c,l);break;
		case (2):{
					(EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleRougeAnimation.gif"));
					Score.addCombo();
					couleur = 1;
					break; 
				}
		case (3):{
					(EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleVerte.gif"));
					Score.addCombo();			
					couleur = 2;
					break;
				}
		case (4):{
					(EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleJaune.gif"));
					Score.addCombo();
					couleur = 3;
					break;
				}
		}
	}

	public void eclaterBulle(int c, int l){
		Score.addCombo();
		Score.addCombo();
		animEclaterBulle(c,l);
		Niveau.MesBulles.remove(c+"/"+l);
		
		/*check mon commentaire dans EcranJeu */
		
		/* gr‰ce aux mŽthodes coordBulleDessus, coordBulleDessous, coordBulleGauche et coordBulleDroite, on
		 * recoit le string correspondant a la position de la prochaine bulle qu'il faut changerCouleur().
		 * Le string correspond en fait ˆ la Key de la Hashtable. Si le String re�u = null, ca veut dire qu'il
		 * n'y a pas de bulle ˆ Žclater. On a donc une bulleDessus et on applique changerCouleur sur celle-ci
		 * que si coordBulle renvoie autre chose que null */
		
		int coordDessus = coordBulleDessus(c, l);
		if(coordDessus != (-1))
		{
			for(int i=l-1; i>coordDessus; i--)
			{
				ImageIcon animBille = new ImageIcon("bin/images/BilleBasHaut.gif");
				animBille.getImage().flush();
				(EcranJeu.getTabJButton()[c][i]).setIcon(animBille);
				//Attendre 360 ms
			}
			
			Bulle bulleDessus = Niveau.MesBulles.get(c+"/"+coordDessus);
			bulleDessus.changerCouleur();
		}
		
		else
		{
			for(int i=l-1; i>=0;i--)
			{
				ImageIcon animBille = new ImageIcon("bin/images/BilleBasHaut.gif");
				animBille.getImage().flush();
				(EcranJeu.getTabJButton()[c][i]).setIcon(animBille);
				//Attendre 360 ms
			}
		}
		
		int coordDessous = coordBulleDessous(c, l);
		if(coordDessous != (-1))
		{
			for(int i=l+1; i<coordDessous; i++)
			{
				ImageIcon animBille = new ImageIcon("bin/images/BilleHautBas.gif");
				animBille.getImage().flush();
				(EcranJeu.getTabJButton()[c][i]).setIcon(animBille);
				//Attendre 360 ms
			}
			
			Bulle bulleDessous = Niveau.MesBulles.get(c+"/"+coordDessous);
			bulleDessous.changerCouleur();
		}
		
		else
		{
			for(int i=l+1; i<=5;i++)
			{
				ImageIcon animBille = new ImageIcon("bin/images/BilleHautBas.gif");
				animBille.getImage().flush();
				(EcranJeu.getTabJButton()[c][i]).setIcon(animBille);
				//Attendre 360 ms
			}
		}
		
		int coordGauche = coordBulleGauche(c, l);
		if(coordGauche != (-1))
		{
			for(int i=c-1; i>coordGauche; i--)
			{
	
				ImageIcon animBille = new ImageIcon("bin/images/BilleDroiteGauche.gif");
				animBille.getImage().flush();
				(EcranJeu.getTabJButton()[i][l]).setIcon(animBille);
				//Attendre 360 ms
			}
			
			Bulle bulleGauche = Niveau.MesBulles.get(coordGauche+"/"+l);
			bulleGauche.changerCouleur();
		}
		else
		{
			for(int i=c-1; i>=0;i--)
			{
	
				ImageIcon animBille = new ImageIcon("bin/images/BilleDroiteGauche.gif");
				animBille.getImage().flush();
				(EcranJeu.getTabJButton()[i][l]).setIcon(animBille);
				//Attendre 360 ms
			}
		}
		
		int coordDroite = coordBulleDroite(c, l);

		if(coordDroite != (-1))
		{
			for(int i=c+1; i<coordDroite; i++)
			{
				ImageIcon animBille = new ImageIcon("bin/images/BilleGaucheDroite.gif");
				animBille.getImage().flush();
				(EcranJeu.getTabJButton()[i][l]).setIcon(animBille);
				//Attendre 360 ms
			}
			
			Bulle bulleDroite = Niveau.MesBulles.get(coordDroite+"/"+l);
			bulleDroite.changerCouleur();
		}
		else
		{
			for(int i=c+1; i<=4;i++)
			{
				ImageIcon animBille = new ImageIcon("bin/images/BilleGaucheDroite.gif");
				animBille.getImage().flush();
				(EcranJeu.getTabJButton()[i][l]).setIcon(animBille);
				//Attendre 360 ms
			}
		}
	}
	
	public void animEclaterBulle(int c, int l){
		
		ImageIcon animEclate = new ImageIcon("bin/images/BulleRougeEclateAnim.gif");
		animEclate.getImage().flush();
		(EcranJeu.getTabJButton()[c][l]).setIcon(animEclate);
		//Attendre 720 ms

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
