package bubble_blast;

import javax.swing.JButton;

public class MesJButton extends JButton {
	private int colonne;
	private int ligne;
	
	public MesJButton(int colonne, int ligne) {
		super();
		this.colonne = colonne;
		this.ligne = ligne;
	}
	public int getColonne() {
		return colonne;
	}
	public int getLigne() {
		return ligne;
	}
}
