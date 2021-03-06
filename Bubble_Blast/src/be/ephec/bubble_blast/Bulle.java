package be.ephec.bubble_blast;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import be.ephec.GUI.Animation;
import be.ephec.GUI.EcranJeu;
import be.ephec.GUI.EcranNiveaux;

public class Bulle{

	private int couleur;
	private int c;
	private int l;
	private boolean explosionEnCours = false;
	private Animation animation;
	
	public Bulle(int couleur, int c, int l){
		this.couleur = couleur;
		this.c = c;
		this.l = l;
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
	
	
	public boolean isExplosionEnCours() {
		return explosionEnCours;
	}

	public void setExplosionEnCours(boolean explosionEnCours) {
		this.explosionEnCours = explosionEnCours;
	}

	public void changerCouleur(int tempsAttente){
		this.animation = EcranNiveaux.animNiveau;
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				animation.changerDeCouleur(couleur,c,l);
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
				animation.verifierNiveauFini();
			}
		}, tempsAttente);
	}

	public void eclaterBulle(){
	
		int ligneBulleDessus = lBulleDessus(c, l);
		int casesVidesDessus = l - ligneBulleDessus - 1;
		if(ligneBulleDessus == -1) casesVidesDessus = l;
		animation.genererProjectileBille(this, casesVidesDessus, 1);
		if(ligneBulleDessus != -1){
			Bulle bulleDessus = Niveau.MesBulles.get(c+"/"+ligneBulleDessus);
			if(bulleDessus.getCouleur()==1) {
				Niveau.MesBulles.remove(c+"/"+ligneBulleDessus);
				bulleDessus.explosionEnCours = true;
				bulleDessus.changerCouleur((casesVidesDessus+1)*650);
			}
			if((bulleDessus != null) && (bulleDessus.explosionEnCours == false)) bulleDessus.changerCouleur((casesVidesDessus+1)*650);
		}
		
		int ligneBulleDessous = lBulleDessous(c, l);
		int casesVidesDessous = ligneBulleDessous - l - 1;
		if(ligneBulleDessous == -1) casesVidesDessous = 5 - l;
		animation.genererProjectileBille(this, casesVidesDessous, 2);
		if(ligneBulleDessous != -1){
			Bulle bulleDessous = Niveau.MesBulles.get(c+"/"+ligneBulleDessous);
			if(bulleDessous.getCouleur()==1){
				Niveau.MesBulles.remove(c+"/"+ligneBulleDessous);
				bulleDessous.explosionEnCours = true;
				bulleDessous.changerCouleur((casesVidesDessous+1)*650);
			}
			if((bulleDessous != null) && (bulleDessous.explosionEnCours == false))bulleDessous.changerCouleur((casesVidesDessous+1)*650);
		}
		
		int colonneBulleGauche = cBulleGauche(c, l);
		int casesVidesGauche = c - colonneBulleGauche - 1;
		if(colonneBulleGauche == -1) casesVidesGauche = c;
		animation.genererProjectileBille(this, casesVidesGauche, 3);
		if(colonneBulleGauche != -1){
			Bulle bulleGauche = Niveau.MesBulles.get(colonneBulleGauche+"/"+l);
			if(bulleGauche.getCouleur()==1){
				Niveau.MesBulles.remove(colonneBulleGauche+"/"+l);
				bulleGauche.explosionEnCours = true;
				bulleGauche.changerCouleur((casesVidesGauche+1)*650);
			}
			if((bulleGauche != null) && (bulleGauche.explosionEnCours == false))bulleGauche.changerCouleur((casesVidesGauche+1)*650);
		}
		
		int colonneBulleDroite = cBulleDroite(c, l);
		int casesVidesDroite = colonneBulleDroite - c - 1;
		if(colonneBulleDroite == -1) casesVidesDroite = 4 - c;
		animation.genererProjectileBille(this, casesVidesDroite, 4);
		if(colonneBulleDroite != -1){
			Bulle bulleDroite = Niveau.MesBulles.get(colonneBulleDroite+"/"+l);
			if(bulleDroite.getCouleur()==1){
				Niveau.MesBulles.remove(colonneBulleDroite+"/"+l);
				bulleDroite.explosionEnCours = true;
				bulleDroite.changerCouleur((casesVidesDroite+1)*650);
			}
			if((bulleDroite != null) && (bulleDroite.explosionEnCours == false))bulleDroite.changerCouleur((casesVidesDroite+1)*650);
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
