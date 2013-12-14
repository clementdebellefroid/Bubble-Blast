package bubble_blast;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Animation {

	private Timer timer = new Timer();

	public Animation(Bulle bulleCliquee){

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
//
	public void gifBilleBasHaut(final int c, final int l, final int i){
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				ImageIcon animBille = new ImageIcon("bin/images/BilleBasHaut.gif");
				animBille.getImage().flush();
				(EcranJeu.getTabJButton()[c][l]).setIcon(animBille);
			}
		}, i * 650);
	}

	public void gifBilleHautBas(final int c, final int l, final int i){
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				ImageIcon animBille = new ImageIcon("bin/images/BilleHautBas.gif");
				animBille.getImage().flush();
				(EcranJeu.getTabJButton()[c][l]).setIcon(animBille);
			}
		}, i * 650);
	}

	public void gifBilleDroiteGauche(final int c, final int l, final int i){
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				ImageIcon animBille = new ImageIcon("bin/images/BilleDroiteGauche.gif");
				animBille.getImage().flush();
				(EcranJeu.getTabJButton()[c][l]).setIcon(animBille);
			}
		}, i * 650);
	}

	public void gifBilleGaucheDroite(final int c, final int l, final int i){
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				ImageIcon animBille = new ImageIcon("bin/images/BilleGaucheDroite.gif");
				animBille.getImage().flush();
				(EcranJeu.getTabJButton()[c][l]).setIcon(animBille);
			}
		}, i * 650);
	}

	public void changerDeCouleur(Bulle bulle){
		switch(bulle.getCouleur()){
		case(1):eclatement(bulle.getC(),bulle.getL());break;
		case(2):vertARouge(bulle.getC(),bulle.getL());break;
		case(3):jauneAVert(bulle.getC(),bulle.getL());break;
		case(4):bleuAJaune(bulle.getC(),bulle.getL());break;
		}	
	}

	public void vertARouge(int c, int l){
		(EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleRougeAnimation.gif"));
	}	

	public void jauneAVert(int c, int l){
		(EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleVerte.gif"));
	}	

	public void bleuAJaune(int c, int l){
		(EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon("bin/images/BulleJaune.gif"));
	}	

	public void eclatement(int c, int l){
		ImageIcon animEclate = new ImageIcon("bin/images/BulleRougeEclateAnim.gif");
		animEclate.getImage().flush();
		(EcranJeu.getTabJButton()[c][l]).setIcon(animEclate);
	}

}