package be.ephec.GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class NouvelleFenetre extends javax.swing.JFrame {
		
	public NouvelleFenetre() {
		initFenetre();
	}
	
	private void initFenetre() {
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Bubble Blast");
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("BulleVerte.gif")).getImage());
		this.setSize(500, 500);	
	}
}
