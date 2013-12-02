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
	
	//private JPanel accueilPanel;
	//private JButton unJoueur;
	//private JButton deuxJoueurs;
	
	public EcranAccueil(){
		super();
		initFenetre();
	}
	
	public void initFenetre(){
	    this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		JPanel accueilPanel = new JPanel();
	    accueilPanel.setLayout(new BoxLayout(accueilPanel, BoxLayout.Y_AXIS));
	    
	    JPanel backgroundPanel = new JPanel();
	    backgroundPanel.add(new JLabel(new ImageIcon("bin/images/BubbleBlastAccueilBG.jpg")));

	    JButton unJoueur = new JButton("1 joueur");
		unJoueur.setMaximumSize(new Dimension(160, 80));
		unJoueur.setAlignmentX(Component.CENTER_ALIGNMENT);
		unJoueur.setBackground(new Color(130,200,255));
		
		JButton deuxJoueurs = new JButton("2 joueurs");
		deuxJoueurs.setMaximumSize(new Dimension(160, 80));
		deuxJoueurs.setAlignmentX(Component.CENTER_ALIGNMENT);
		deuxJoueurs.setBackground(new Color(130,200,255));

		accueilPanel.add(Box.createRigidArea(new Dimension(0,250)));
		accueilPanel.add(unJoueur);
		accueilPanel.add(Box.createRigidArea(new Dimension(0,20)));
		accueilPanel.add(deuxJoueurs);
		accueilPanel.setOpaque(false);
		this.add(backgroundPanel);
		this.add(accueilPanel);	
		
			
		
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
