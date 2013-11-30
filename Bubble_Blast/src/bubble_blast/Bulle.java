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
		if(couleur == 0) (EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/CaseVide.jpg")));
		else if(couleur == 1) (EcranJeu.getTabJButton()[c][l]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleRouge.jpg")));
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
		case (1): eclaterBulle(c,l); break;
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
		couleur = 0;
		
	}
	
}
