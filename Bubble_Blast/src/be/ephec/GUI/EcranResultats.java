package be.ephec.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import be.ephec.bubble_blast.Joueur;

public class EcranResultats extends NouvelleFenetre{
	
	public EcranResultats(){
		super();
		initFenetre();
	}
	
	public void initFenetre() {
		
		 this.setLocationRelativeTo(null);
		 
		 JLabel classementLabel = new JLabel();
		 classementLabel.setIcon(new ImageIcon("bin/images/classement.jpg"));
		 classementLabel.setLayout(null);
		 
		 Font font = new Font("Arial", Font.PLAIN,25);
		 
		 JTextField scorePremier = new JTextField();
		 scorePremier = new JTextField();
		 scorePremier.setEditable(false);
		 scorePremier.setOpaque(false);
		 scorePremier.setBorder(null);
		 scorePremier.setBounds(130, 290, 300, 37);
		 scorePremier.setFont(font);
		 scorePremier.setForeground(new Color(45,110,220));
		 scorePremier.setText("Joueur 1: "+Joueur.getScorePartie()+" points");
		 
		 JTextField scoreDeuxieme = new JTextField();
		 scoreDeuxieme = new JTextField();
		 scoreDeuxieme.setEditable(false);
		 scoreDeuxieme.setOpaque(false);
		 scoreDeuxieme.setBorder(null);
		 scoreDeuxieme.setBounds(130, 400, 300, 37);
		 scoreDeuxieme.setFont(font);
		 scoreDeuxieme.setForeground(new Color(45,110,220));
		 scoreDeuxieme.setText("Joueur 2: "+Joueur.getScorePartie()+" points");
		 
		 this.setContentPane(classementLabel);
		 classementLabel.add(scorePremier);
		 classementLabel.add(scoreDeuxieme);

	}
}
