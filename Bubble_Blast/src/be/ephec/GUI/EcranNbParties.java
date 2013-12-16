package be.ephec.GUI;

import be.ephec.bubble_blast.*;
import be.ephec.reseau.ServeurBubbleBlast;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class EcranNbParties extends NouvelleFenetre{

	public EcranNbParties() {
		super();
		initFenetre();
	}

	public void initFenetre() {
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		JLabel nbPartiesLabel = new JLabel();
		nbPartiesLabel.setLayout(new BoxLayout(nbPartiesLabel, BoxLayout.Y_AXIS));
		nbPartiesLabel.setIcon(new ImageIcon("bin/images/nbparties.jpg"));

		String[] items = {"1 partie", "2 parties", "3 parties"};
		final JComboBox menuParties = new JComboBox(items);
		menuParties.setMaximumSize(new Dimension(100, 20));
		menuParties.setSelectedIndex(0);

		JButton demarrer = new JButton(new ImageIcon("bin/images/Go.jpg"));
		demarrer.setMaximumSize(new Dimension(200, 125));
		demarrer.setAlignmentX(Component.CENTER_ALIGNMENT);

		nbPartiesLabel.add(Box.createRigidArea(new Dimension(0,200)));
		nbPartiesLabel.add(menuParties);
		nbPartiesLabel.add(Box.createRigidArea(new Dimension(0,100)));
		nbPartiesLabel.add(demarrer);
		this.add(nbPartiesLabel);

		menuParties.setSelectedIndex(0);
		Niveau.setNbNiveaux(menuParties.getSelectedIndex()+1);
		
		menuParties.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie){
				Niveau.setNbNiveaux(menuParties.getSelectedIndex()+1);
				
			}
		});

		demarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonDemarrerActionPerformed(evt);
			}
		});
		
		this.setVisible(false);
		int niveauChoisi = Niveau.getNbNiveauxCrees() - Niveau.getNbNiveaux() +1;
		ServeurBubbleBlast.niveauAJouer = niveauChoisi;
	}
	
	private void jButtonDemarrerActionPerformed(ActionEvent evt) {
		this.setVisible(false);
		int niveauChoisi = Niveau.getNbNiveauxCrees() - Niveau.getNbNiveaux() +1;
		ServeurBubbleBlast.niveauAJouer = niveauChoisi;
	}
}
