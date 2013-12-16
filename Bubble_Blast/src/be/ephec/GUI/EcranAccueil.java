package be.ephec.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;

import be.ephec.bubble_blast.Joueur;
import be.ephec.reseau.*;

public class EcranAccueil extends NouvelleFenetre{
	
	public EcranAccueil(){
		super();
		initFenetre();
	}
	
	public void initFenetre(){
	    this.setLocationRelativeTo(null);
		this.setVisible(true);
	    
	    JLabel accueilLabel = new JLabel();
	    accueilLabel.setLayout(new BoxLayout(accueilLabel, BoxLayout.Y_AXIS));
	    accueilLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("accueil.jpg")));
	   
	    JButton unJoueur = new JButton(new ImageIcon(getClass().getClassLoader().getResource("1joueur.jpg")));
		unJoueur.setMaximumSize(new Dimension(200, 80));
		unJoueur.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton deuxJoueurs = new JButton(new ImageIcon(getClass().getClassLoader().getResource("2joueurs.jpg")));
		deuxJoueurs.setMaximumSize(new Dimension(200, 80));
		deuxJoueurs.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.setContentPane(accueilLabel);
		accueilLabel.add(Box.createRigidArea(new Dimension(0,238)));
		accueilLabel.add(unJoueur);
		accueilLabel.add(Box.createRigidArea(new Dimension(0,20)));
		accueilLabel.add(deuxJoueurs);
		
				
		unJoueur.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent evt) {
		        jButton1JoueurActionPerformed(evt);
		       }
		      });
		deuxJoueurs.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent evt) {
		        jButton2JoueursActionPerformed(evt);
		       }
		      });
	}
	
	private void jButton1JoueurActionPerformed(ActionEvent evt) {
		EcranNiveaux ecranNiveau = new EcranNiveaux();
		this.setVisible(false);
	}
	
	private void jButton2JoueursActionPerformed(ActionEvent evt) {
		Joueur joueur = new Joueur();
		Joueur.setModeSolo(false);
		EcranHostClient ecranHostClient = new EcranHostClient();
		this.setVisible(false);
	}
}
