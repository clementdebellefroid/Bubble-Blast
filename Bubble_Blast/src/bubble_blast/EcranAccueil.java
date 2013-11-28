package bubble_blast;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EcranAccueil extends NouvelleFenetre{
	
	private JPanel accueilPanel;
	private JButton unJoueur;
	private JButton deuxJoueurs;
	
	public EcranAccueil(){
		initFenetre();
	}
	
	public void initFenetre(){
	    this.setLocationRelativeTo(null);
		this.setVisible(true);
	    this.setResizable(false);
	    
		accueilPanel = new JPanel();
		unJoueur = new JButton("1 joueur");
		unJoueur.setPreferredSize(new java.awt.Dimension(100, 50));
		deuxJoueurs = new JButton("2 joueurs");
		deuxJoueurs.setPreferredSize(new java.awt.Dimension(100, 50));

		accueilPanel.add(unJoueur);
		accueilPanel.add(deuxJoueurs);
		this.add(accueilPanel);		
		
		unJoueur.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent evt) {
		        jButton1ActionPerformed(evt);
		       }
		      });
		deuxJoueurs.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent evt) {
		        jButton2ActionPerformed(evt);
		       }
		      });
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		EcranJeu ecranJeu = new EcranJeu();
		this.setVisible(false);
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) {

	}
}
