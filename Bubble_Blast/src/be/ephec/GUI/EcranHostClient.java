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
	    hebergeurLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("hostClient.jpg")));
	   
	    JButton hebergeur = new JButton(new ImageIcon(getClass().getClassLoader().getResource("hebergeur.jpg")));
	    hebergeur.setMaximumSize(new Dimension(200, 100));
	    hebergeur.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton client = new JButton(new ImageIcon(getClass().getClassLoader().getResource("client.jpg")));
		client.setMaximumSize(new Dimension(200, 100));
		client.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.setContentPane(hebergeurLabel);
		hebergeurLabel.add(Box.createRigidArea(new Dimension(0,185)));
		hebergeurLabel.add(hebergeur);
		hebergeurLabel.add(Box.createRigidArea(new Dimension(0,50)));
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
		this.setVisible(false);
		EcranNbParties ecranNbParties = new EcranNbParties();
		ecranNbParties.setVisible(true);
	}
	
	private void jButtonClientActionPerformed(ActionEvent evt) {
		this.setVisible(false);
		EcranChoixIp ecranChoixp = new EcranChoixIp();
		ecranChoixp.setVisible(true);
	}
}
