package be.ephec.GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import be.ephec.bubble_blast.Joueur;
import be.ephec.bubble_blast.Niveau;
import be.ephec.reseau.ClientBubbleBlast;

public class EcranFinJeu extends javax.swing.JFrame {

	private int niveauFini;
	private EcranJeu ecranJeu;

	public EcranFinJeu(int niveauFini, EcranJeu ecranJeu) {
		this.ecranJeu = ecranJeu;
		this.niveauFini = niveauFini;
		initFenetre();
	}

	private void initFenetre() {
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setResizable(false);
		setBackground(new java.awt.Color(255,255,255));
		this.setSize(350, 200);	
		
		JLabel finJeuLabel = new JLabel();
		finJeuLabel.setIcon(new ImageIcon("bin/images/popupLabel.jpg"));
		finJeuLabel.setLayout(new FlowLayout());

		JButton nivSuivant = new JButton(new ImageIcon("bin/images/niveauSuivantButton.jpg"));
		nivSuivant.setPreferredSize(new Dimension(120, 45));

		JButton reessayer = new JButton(new ImageIcon("bin/images/reessayerButton.jpg"));
		reessayer.setPreferredSize(new Dimension(100, 45));
	
		JButton menu = new JButton(new ImageIcon("bin/images/menuButton.jpg"));
		menu.setPreferredSize(new Dimension(85, 45));

		this.setContentPane(finJeuLabel);
		this.add(Box.createRigidArea(new Dimension(0,250)));
		if(niveauFini >= Niveau.getNbNiveaux())
		{
			nivSuivant.setVisible(false);
			this.add(Box.createRigidArea(new Dimension(124,45)));
			if(Joueur.isModeSolo() == false) {
				ClientBubbleBlast.setScoreJoueur1(Joueur.getScorePartie());
				EcranResultats ecranResultat = new EcranResultats();
				ecranJeu.setVisible(false);
				this.setVisible(false);
			}
		}
		this.add(nivSuivant);
		if(Joueur.isModeSolo() == false)
		{
			reessayer.setVisible(false);
			this.add(Box.createRigidArea(new Dimension(100,45)));
		}
		this.add(reessayer);
		this.add(menu);

		nivSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonNivSuivantActionPerformed(evt);
			}
		});
		reessayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonReessayerActionPerformed(evt);
			}
		});
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonMenuActionPerformed(evt);
			}
		});
	}

	private void jButtonNivSuivantActionPerformed(ActionEvent evt) {
			int niveauSuivant = niveauFini+1;
			ecranJeu.setVisible(false);
			ecranJeu = new EcranJeu(niveauSuivant);
			this.setVisible(false);
	}

	private void jButtonReessayerActionPerformed(ActionEvent evt) {
		ecranJeu.setVisible(false);
		ecranJeu = new EcranJeu(niveauFini);
		this.setVisible(false);
	}

	private void jButtonMenuActionPerformed(ActionEvent evt) {
		ecranJeu.setVisible(false);
		EcranAccueil ecranAccueil = new EcranAccueil();
		this.setVisible(false);
	}
}
