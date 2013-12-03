package bubble_blast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;

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
	    accueilLabel.setIcon(new ImageIcon("bin/images/accueilBackground.jpg"));
	   
	    JButton unJoueur = new JButton((new ImageIcon("bin/images/1joueur.jpg")));
		unJoueur.setMaximumSize(new Dimension(200, 80));
		unJoueur.setAlignmentX(Component.CENTER_ALIGNMENT);
		unJoueur.setBackground(new Color(130,200,255));
		
		JButton deuxJoueurs = new JButton((new ImageIcon("bin/images/2joueurs.jpg")));
		deuxJoueurs.setMaximumSize(new Dimension(200, 80));
		deuxJoueurs.setAlignmentX(Component.CENTER_ALIGNMENT);
		deuxJoueurs.setBackground(new Color(130,200,255));

		this.setContentPane(accueilLabel);
		this.add(Box.createRigidArea(new Dimension(0,250)));
		this.add(unJoueur);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(deuxJoueurs);
		
				
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
		EcranNbParties ecranNbParties = new EcranNbParties();
		this.setVisible(false);
	}
}
