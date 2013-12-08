package bubble_blast;

import javax.swing.JFrame;

public class EcranFinJeu extends javax.swing.JFrame {
	
public EcranFinJeu() {
	initFenetre();
}

	private void initFenetre() {
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		setBackground(new java.awt.Color(255,255,255));
		this.setSize(350, 200);	
	}
}
