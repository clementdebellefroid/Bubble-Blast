package be.ephec.GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import be.ephec.bubble_blast.Joueur;
import be.ephec.bubble_blast.Niveau;
import be.ephec.reseau.ClientBubbleBlast;
import be.ephec.reseau.ServeurBubbleBlast;

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
		this.setResizable(false);
		this.setSize(350, 200);	
		
		JLabel finJeuLabel = new JLabel();
		finJeuLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("popupLabel.jpg")));
		finJeuLabel.setLayout(new FlowLayout());

		JButton nivSuivant = new JButton(new ImageIcon(getClass().getClassLoader().getResource("niveauSuivantButton.jpg")));
		nivSuivant.setPreferredSize(new Dimension(120, 45));

		JButton reessayer = new JButton(new ImageIcon(getClass().getClassLoader().getResource("reessayerButton.jpg")));
		reessayer.setPreferredSize(new Dimension(100, 45));
	
		JButton menu = new JButton(new ImageIcon(getClass().getClassLoader().getResource("menuButton.jpg")));
		menu.setPreferredSize(new Dimension(85, 45));

		this.setContentPane(finJeuLabel);
		this.add(Box.createRigidArea(new Dimension(0,250)));
		
		if(Joueur.isModeSolo() == false) {
			if(Niveau.getNbNiveauxCrees() <= niveauFini){
				ClientBubbleBlast.setScoreJoueur1(Joueur.getScorePartie());
				this.setVisible(false);
				ecranJeu.setVisible(false);
				int scoreAutreJoueur = 0;
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
				EcranResultats ecranResultats = new EcranResultats(scoreAutreJoueur);
				ecranResultats.setVisible(true);
			}
		}
		else if(niveauFini >= Niveau.getNbNiveauxCrees())
		{
			nivSuivant.setVisible(false);
			this.add(Box.createRigidArea(new Dimension(124,45)));
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
			this.setVisible(false);
			EcranNiveaux.animNiveau = new Animation(niveauSuivant);
	}

	private void jButtonReessayerActionPerformed(ActionEvent evt) {
		ecranJeu.setVisible(false);
		this.setVisible(false);
		EcranNiveaux.animNiveau = new Animation(niveauFini);
	}

	private void jButtonMenuActionPerformed(ActionEvent evt) {
		ecranJeu.setVisible(false);
		this.setVisible(false);
		EcranAccueil ecranAccueil = new EcranAccueil();
	}
}
