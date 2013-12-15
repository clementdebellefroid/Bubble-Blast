package be.ephec.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import be.ephec.bubble_blast.Joueur;

public class EcranResultats extends NouvelleFenetre{

	private JTextField scoreJ1;
	private JTextField scoreJ2;
	//private static final long serialVersionUID = 1L;
	
	public EcranResultats(){
		super();
		initFenetre();
	}
	
	public void initFenetre() {
		
		 this.setLocationRelativeTo(null);
		 this.setVisible(true);
		 
		 JLabel classementLabel = new JLabel();
		 classementLabel.setLayout(null);
		 classementLabel.setIcon(new ImageIcon("bin/images/classement.jpg"));
		 
		 Font font = new Font("Arial", Font.PLAIN,25);
		 scoreJ1 = new JTextField();
		 scoreJ1.setEditable(false);
		 scoreJ1.setOpaque(false);
		 scoreJ1.setBorder(null);
		 scoreJ1.setBounds(200, 55, 110, 37);
		 scoreJ1.setFont(font);
		 scoreJ1.setForeground(new Color(42,137,205));
		 scoreJ1.setAlignmentX(Component.CENTER_ALIGNMENT);
		 scoreJ1.setText(""+Joueur.getScorePartie());
		 
		/* scoreJ2 = new JTextField();
		 scoreJ2.setEditable(false);
		 scoreJ2.setOpaque(false);
		 scoreJ2.setBorder(null);
		 scoreJ2.setFont(font);
		 scoreJ2.setForeground(new Color(42,137,205));
		 scoreJ2.setAlignmentX(Component.CENTER_ALIGNMENT);*/
		 
		 classementLabel.add(scoreJ1);
		 this.setContentPane(classementLabel);
		 this.add(Box.createRigidArea(new Dimension(0,238)));
		 /*this.add(Box.createRigidArea(new Dimension(0,20)));
		 classementLabel.add(scoreJ2);*/
	}
}
