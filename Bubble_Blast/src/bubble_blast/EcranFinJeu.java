package bubble_blast;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		this.setVisible(true);
		this.setResizable(false);
		setBackground(new java.awt.Color(255,255,255));
		this.setSize(350, 200);	

		JLabel finJeuLabel = new JLabel();
		finJeuLabel.setLayout(new FlowLayout());

		JButton nivSuivant = new JButton("Niveau Suivant");
		nivSuivant.setPreferredSize(new Dimension(120, 45));
		//	nivSuivant.setAlignmentX(Component.RIGHT_ALIGNMENT);

		JButton reessayer = new JButton("RŽessayer");
		reessayer.setPreferredSize(new Dimension(90, 45));
		//reessayer.setAlignmentX(Component.RIGHT_ALIGNMENT);

		JButton menu = new JButton("Menu");
		menu.setPreferredSize(new Dimension(55, 45));
		//menu.setAlignmentX(Component.RIGHT_ALIGNMENT);

		this.setContentPane(finJeuLabel);
		this.add(Box.createRigidArea(new Dimension(0,250)));
		this.add(nivSuivant);
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
