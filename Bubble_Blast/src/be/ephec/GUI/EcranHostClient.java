package be.ephec.GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import be.ephec.bubble_blast.Joueur;
import be.ephec.reseau.ClientBubbleBlast;
import be.ephec.reseau.ServeurBubbleBlast;

public class EcranHostClient extends NouvelleFenetre{
	
	public EcranHostClient(){
		super();
		initFenetre();
	}
	
	public void initFenetre(){
	    this.setLocationRelativeTo(null);
		this.setVisible(true);
	    
	    JLabel hebergeurLabel = new JLabel();
	    hebergeurLabel.setLayout(new BoxLayout(hebergeurLabel, BoxLayout.Y_AXIS));
	    //hebergeurLabel.setIcon(new ImageIcon("bin/images/accueil.jpg"));
	   
	    JButton hebergeur = new JButton("Hebergeur");
	    hebergeur.setMaximumSize(new Dimension(200, 80));
	    hebergeur.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton client = new JButton("Client");
		client.setMaximumSize(new Dimension(200, 80));
		client.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.setContentPane(hebergeurLabel);
		hebergeurLabel.add(Box.createRigidArea(new Dimension(0,238)));
		hebergeurLabel.add(hebergeur);
		hebergeurLabel.add(Box.createRigidArea(new Dimension(0,20)));
		hebergeurLabel.add(client);
		
				
		hebergeur.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent evt) {
		        jButtonHebergeurActionPerformed(evt);
		       }
		      });
		client.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent evt) {
		    	   jButtonClientActionPerformed(evt);
		       }
		      });
	}
	
	private void jButtonHebergeurActionPerformed(ActionEvent evt) {
		EcranNbParties ecranNbParties = new EcranNbParties();
		ecranNbParties.setVisible(true);
		try {
			ServeurBubbleBlast.initServeur();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setVisible(false);
	}
	
	private void jButtonClientActionPerformed(ActionEvent evt) {
		try {
			ClientBubbleBlast.initClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setVisible(false);
	}
}
