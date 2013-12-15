package be.ephec.GUI;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import be.ephec.bubble_blast.Bulle;
import be.ephec.bubble_blast.Joueur;
import be.ephec.bubble_blast.Niveau;

public class Animation{

	private Timer timer = new Timer();
	private Niveau niveauCourant;
	private EcranJeu ecranJeu;
	private boolean ecranFinJeuGenere = false;

	public Animation(int NumNiveauCourant){
		this.niveauCourant = new Niveau(NumNiveauCourant);
		this.ecranJeu = new EcranJeu(niveauCourant);
		genererBulles();
	}

	public void genererBulles(){
        Enumeration e = Niveau.MesBulles.keys();
        e = Niveau.MesBulles.elements();      
        while(e. hasMoreElements()){    
           Bulle bulle = (Bulle) e.nextElement();
           changerDeCouleur(bulle.getCouleur()+1,bulle.getC(),bulle.getL());
        }
	}
	public void verifierNiveauFini(){
		if(Niveau.MesBulles.isEmpty() && ecranFinJeuGenere == false){
			if(Joueur.isModeSolo()==false)Joueur.ajouterAScorePartie(ecranJeu.getScore().getScore());
			EcranFinJeu ecranFinJeu = new EcranFinJeu(niveauCourant.getTitre(), ecranJeu);
			ecranFinJeuGenere = true;
		}
	}
	
	public void mettreAJourScore(){
		ecranJeu.getScore().calculerScore();
		ecranJeu.initTextFields();
	}
	
	public void genererProjectileBille(Bulle bulle, int nbCasesAParcourir, int direction){
		for(int i = 1; i<=nbCasesAParcourir;i++){
			switch(direction){
			case(1): gifBilleBasHaut(bulle.getC(),bulle.getL()-i,i); break;
			case(2): gifBilleHautBas(bulle.getC(),bulle.getL()+i,i); break;
			case(3): gifBilleDroiteGauche(bulle.getC()-i,bulle.getL(),i); break;
			case(4): gifBilleGaucheDroite(bulle.getC()+i,bulle.getL(),i); break;
			}	
		}
	}
	
	public void gifBilleBasHaut(final int c, final int l, final int i){
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				ImageIcon animBille = new ImageIcon("bin/images/BilleBasHaut.gif");
				animBille.getImage().flush();
				(ecranJeu.getTabJButton()[c][l]).setIcon(animBille);
			}
		}, i * 650);
	}

	public void gifBilleHautBas(final int c, final int l, final int i){
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				ImageIcon animBille = new ImageIcon("bin/images/BilleHautBas.gif");
				animBille.getImage().flush();
				(ecranJeu.getTabJButton()[c][l]).setIcon(animBille);
			}
		}, i * 650);
	}

	public void gifBilleDroiteGauche(final int c, final int l, final int i){
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				ImageIcon animBille = new ImageIcon("bin/images/BilleDroiteGauche.gif");
				animBille.getImage().flush();
				(ecranJeu.getTabJButton()[c][l]).setIcon(animBille);
			}
		}, i * 650);
	}

	public void gifBilleGaucheDroite(final int c, final int l, final int i){
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				ImageIcon animBille = new ImageIcon("bin/images/BilleGaucheDroite.gif");
				animBille.getImage().flush();
				(ecranJeu.getTabJButton()[c][l]).setIcon(animBille);
			}
		}, i * 650);
	}

	public void changerDeCouleur(int couleur, int c, int l){
		switch(couleur){
		case(1):eclatement(c,l);break;
		case(2):bulleRouge(c,l);break;
		case(3):bulleVerte(c,l);break;
		case(4):bulleJaune(c,l);break;
		case(5):bulleBleue(c,l);break;
		}	
	}

	public void bulleRouge(int c, int l){
		(ecranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleRougeAnimation.gif"));
	}	

	public void bulleVerte(int c, int l){
		(ecranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleVerte.gif"));
	}	

	public void bulleJaune(int c, int l){
		(ecranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleJaune.gif"));
	}	
	
	public void bulleBleue(int c, int l){
		(ecranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleBleue.gif"));
	}	

	public void eclatement(int c, int l){
		ImageIcon animEclate = new ImageIcon("bin/images/BulleRougeEclateAnim.gif");
		animEclate.getImage().flush();
		(ecranJeu.getTabJButton()[c][l]).setIcon(animEclate);
	}
}