package bubble_blast;

import javax.swing.ImageIcon;

public class Bulle{

	private int couleur;
	private int i;
	private int j;
	
	public Bulle(int couleur, int i, int j){
		this.couleur = couleur;
		this.i = i;
		this.j = j;
		if(couleur == 0) (EcranJeu.getTabJButton()[i][j]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/CaseVide.jpg")));
		else if(couleur == 1) (EcranJeu.getTabJButton()[i][j]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleRouge.jpg")));
		else if(couleur == 2) (EcranJeu.getTabJButton()[i][j]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleVerte.jpg")));
		else if(couleur == 3) (EcranJeu.getTabJButton()[i][j]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleJaune.jpg")));
		else if(couleur == 4) (EcranJeu.getTabJButton()[i][j]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleBleue.jpg")));

	}
	
	public int getCouleur(){
		return couleur;
	}
	
	public void setCouleur(int couleur){
		this.couleur = couleur;
	}
	
	public int getI(){
		return i;
	}
	
	public int getJ(){
		return j;
	}

	public void changerCouleur(){
		if(couleur == 1) eclaterBulle(i,j);
		else if(couleur == 2)
		{ 
			(EcranJeu.getTabJButton()[i][j]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleRouge.jpg")));
			couleur = 1;
		}
		else if(couleur == 3)
		{ 
			(EcranJeu.getTabJButton()[i][j]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleVerte.jpg")));
			couleur = 2;
		}
		else if(couleur == 4)
		{ 
			(EcranJeu.getTabJButton()[i][j]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/BulleJaune.jpg")));
			couleur = 3;
		}
	}
	
	public void eclaterBulle(int i, int j){
		(EcranJeu.getTabJButton()[i][j]).setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/CaseVide.jpg")));
		couleur = 0;
	}
	
}
