package be.ephec.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import be.ephec.bubble_blast.Joueur;
import be.ephec.reseau.ClientBubbleBlast;
import be.ephec.reseau.ServeurBubbleBlast;

public class EcranResultats extends NouvelleFenetre{
	
	public EcranResultats(){
		super();
		try {
			initFenetre();
		} catch (Exception e) {
		}
	}
	
	public void initFenetre() throws Exception{
		int scoreAutreJoueur = 0;
		String nomGagnant = "";
		String nomPerdant = "";
		int scoreGagnant = 0;
		int scorePerdant = 0;
		
		if(Joueur.isHost()){
			try {
				ServeurBubbleBlast.ecrireScoreSocket();
				scoreAutreJoueur = ServeurBubbleBlast.lireScoreSocket();
			} catch (Exception e) {}
		}
		else{
			try {
				ClientBubbleBlast.ecrireScoreSocket();
				scoreAutreJoueur = ClientBubbleBlast.lireScoreSocket();
			} catch (Exception e) {}
		}

		if(scoreAutreJoueur>Joueur.getScorePartie()){
			nomGagnant = "Rival : ";
			nomPerdant = "Vous : ";
			scoreGagnant = scoreAutreJoueur;
			scorePerdant = Joueur.getScorePartie();
		}
		else{
			nomGagnant = "Vous : ";
			nomPerdant = "Rival : ";
			scoreGagnant = Joueur.getScorePartie();
			scorePerdant = scoreAutreJoueur;
		}
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
		 scorePremier.setText(nomGagnant+scoreGagnant+" points");
		 
		 JTextField scoreDeuxieme = new JTextField();
		 scoreDeuxieme = new JTextField();
		 scoreDeuxieme.setEditable(false);
		 scoreDeuxieme.setOpaque(false);
		 scoreDeuxieme.setBorder(null);
		 scoreDeuxieme.setBounds(130, 400, 300, 37);
		 scoreDeuxieme.setFont(font);
		 scoreDeuxieme.setForeground(new Color(45,110,220));
		 scoreDeuxieme.setText(nomPerdant+scorePerdant+" points");
		 
		 this.setContentPane(classementLabel);
		 classementLabel.add(scorePremier);
		 classementLabel.add(scoreDeuxieme);

	}
}
