package be.ephec.GUI;

import be.ephec.bubble_blast.*;
import be.ephec.reseau.ServeurBubbleBlast;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EcranNbParties extends NouvelleFenetre{

	public EcranNbParties() {
		super();
		initFenetre();
	}

	public void initFenetre() {
		this.setLocationRelativeTo(null);

		JLabel nbPartiesLabel = new JLabel();
		nbPartiesLabel.setLayout(new BoxLayout(nbPartiesLabel, BoxLayout.Y_AXIS));
		nbPartiesLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("nbparties.jpg")));

		String[] items = {"1 partie", "2 parties", "3 parties","4 parties","5 parties","6 parties"};
		final JComboBox menuParties = new JComboBox(items);
		menuParties.setMaximumSize(new Dimension(100, 20));
		menuParties.setSelectedIndex(0);
		
		Font font = new Font("Arial", Font.PLAIN,25);
		JTextField ipHostTxt = new JTextField("");
		ipHostTxt.setMaximumSize(new Dimension(380, 30));
		try {
			ipHostTxt.setText("ip du serveur: "+InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		ipHostTxt.setEditable(false);
		ipHostTxt.setOpaque(false);
		ipHostTxt.setBorder(null);
		ipHostTxt.setFont(font);
		ipHostTxt.setForeground(new Color(181,123,0));

		JButton demarrer = new JButton(new ImageIcon(getClass().getClassLoader().getResource("Go.jpg")));
		demarrer.setMaximumSize(new Dimension(200, 125));
		demarrer.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.setContentPane(nbPartiesLabel);
		nbPartiesLabel.add(Box.createRigidArea(new Dimension(0,10)));
		nbPartiesLabel.add(ipHostTxt);
		nbPartiesLabel.add(Box.createRigidArea(new Dimension(0,170)));
		nbPartiesLabel.add(menuParties);
		nbPartiesLabel.add(Box.createRigidArea(new Dimension(0,90)));
		nbPartiesLabel.add(demarrer);

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
		
	}
	
	private void jButtonDemarrerActionPerformed(ActionEvent evt) {

		this.setVisible(false);
		int niveauChoisi = Niveau.getNbNiveauxCrees() - Niveau.getNbNiveaux() +1;
		ServeurBubbleBlast.niveauAJouer = niveauChoisi;
		try {
			ServeurBubbleBlast.initServeur();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
