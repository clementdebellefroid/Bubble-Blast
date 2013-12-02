package bubble_blast;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class EcranJeu extends NouvelleFenetre{
	private JTextField scoreTxt;
	private JTextField niveauTxt;
	private JTextField touchesTxt;
	private static int nbColonnes = 5;
	private static int nbLignes = 6;
	private int tailleCoteBouton = 60;
	private static MesJButton[][] tabJButton = new MesJButton[nbColonnes][nbLignes];
	private Niveau niveauChoisi;

	public EcranJeu(int choixNiveau) {
		super();
		initFenetre();
		niveauChoisi = new Niveau(choixNiveau);
		initTextFields();
	}

	private void initFenetre() {
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(new Color(130,200,255));
		infoPanel.setPreferredSize(new Dimension(500,100));

		JLabel niveauLabel = new JLabel("Niveau:");
		niveauTxt = new JTextField();
		niveauTxt.setEditable(false);
		niveauTxt.setBackground(new Color(130,200,255));
		niveauTxt.setPreferredSize(new Dimension(50, 30));

		JLabel scoreLabel = new JLabel("Score:");
		scoreTxt = new JTextField();
		scoreTxt.setEditable(false);
		scoreTxt.setBackground(new Color(130,200,255));
		scoreTxt.setPreferredSize(new Dimension(130, 50));

		JLabel touchesLabel = new JLabel("Touches:");
		touchesTxt = new JTextField("0");
		touchesTxt.setEditable(false);
		touchesTxt.setBackground(new Color(130,200,255));
		touchesTxt.setPreferredSize(new Dimension(50, 30));

		infoPanel.add(niveauLabel);
		infoPanel.add(niveauTxt);
		infoPanel.add(scoreLabel);
		infoPanel.add(scoreTxt);
		infoPanel.add(touchesLabel);
		infoPanel.add(touchesTxt);


		JPanel grilleJeuPanel = new JPanel();

		GridBagLayout grilleJeuPanelLayout = new GridBagLayout();
		grilleJeuPanel.setLayout(grilleJeuPanelLayout);
		grilleJeuPanel.setBackground(new Color(221,225,240));
		grilleJeuPanel.setBorder(new LineBorder(new Color(66,95,184),1,false));
		for(int c=0; c<nbColonnes; c++)
		{
			for(int l=0; l<nbLignes; l++)
			{
				tabJButton[c][l] = new MesJButton(c,l);
				grilleJeuPanel.add(tabJButton[c][l], new GridBagConstraints(c, l, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				tabJButton[c][l].setPreferredSize(new Dimension(tailleCoteBouton, tailleCoteBouton));
				tabJButton[c][l].setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/CaseVide.jpg")));
				tabJButton[c][l].setBorder(BorderFactory.createEtchedBorder());
				tabJButton[c][l].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
		}

		mainPanel.add(infoPanel);
		mainPanel.add(grilleJeuPanel);
		this.add(mainPanel);
	}

	public static MesJButton[][] getTabJButton() {
		return tabJButton;
	}

	public void initTextFields(){
		niveauTxt.setText(""+niveauChoisi.getTitre());
		scoreTxt.setText(""+0);
		touchesTxt.setText(""+0);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		/*J'ai pu supprimer le try catch qu'on avait. Ici, on regarde si il existe bien un objet Bulle sur la case
		 * sur laquelle on a cliquŽ. Si oui, on applique changerCouleur, si non, on fait rien.
		 * regarde la mŽthode containsKey(String) pcq on doit la rŽutiliser dans eclaterBulle()*/
		
			MesJButton source = (MesJButton)evt.getSource();
			if(Niveau.MesBulles.containsKey(source.getColonne()+"/"+source.getLigne()))
			{
				Bulle bulleCliquee = ((Bulle) Niveau.MesBulles.get(source.getColonne()+"/"+source.getLigne()));
				bulleCliquee.changerCouleur();
				touchesTxt.setText(""+(Integer.parseInt(touchesTxt.getText())+1));
			}
			else System.out.println("Pas d'objet present sur cette case");

			
		/*	Bulle bulleDessus = ((Bulle) niveauChoisi.MesBulles.get(source.getColonne()+"/"+(source.getLigne()-1)));
			Bulle bulleDessus1 = ((Bulle) niveauChoisi.MesBulles.get(source.getColonne()+"/"+(source.getLigne()-2)));
			Bulle bulleDessus2 = ((Bulle) niveauChoisi.MesBulles.get(source.getColonne()+"/"+(source.getLigne()-3)));
			Bulle bulleDessus3 = ((Bulle) niveauChoisi.MesBulles.get(source.getColonne()+"/"+(source.getLigne()-4)));
			Bulle bulleDessus4 = ((Bulle) niveauChoisi.MesBulles.get(source.getColonne()+"/"+(source.getLigne()-5)));
			Bulle bulleDessous = ((Bulle) niveauChoisi.MesBulles.get(source.getColonne()+"/"+(source.getLigne()+1)));
			Bulle bulleDessous1 = ((Bulle) niveauChoisi.MesBulles.get(source.getColonne()+"/"+(source.getLigne()+2)));
			Bulle bulleDessous2 = ((Bulle) niveauChoisi.MesBulles.get(source.getColonne()+"/"+(source.getLigne()+3)));
			Bulle bulleDessous3 = ((Bulle) niveauChoisi.MesBulles.get(source.getColonne()+"/"+(source.getLigne()+4)));
			Bulle bulleDessous4 = ((Bulle) niveauChoisi.MesBulles.get(source.getColonne()+"/"+(source.getLigne()+5)));
			Bulle bulleGauche = ((Bulle) niveauChoisi.MesBulles.get((source.getColonne()-1)+"/"+source.getLigne()));
			Bulle bulleGauche1 = ((Bulle) niveauChoisi.MesBulles.get((source.getColonne()-2)+"/"+source.getLigne()));
			Bulle bulleGauche2 = ((Bulle) niveauChoisi.MesBulles.get((source.getColonne()-3)+"/"+source.getLigne()));
			Bulle bulleGauche3 = ((Bulle) niveauChoisi.MesBulles.get((source.getColonne()-4)+"/"+source.getLigne()));
			Bulle bulleDroite = ((Bulle) niveauChoisi.MesBulles.get((source.getColonne()+1)+"/"+source.getLigne()));
			Bulle bulleDroite1 = ((Bulle) niveauChoisi.MesBulles.get((source.getColonne()+2)+"/"+source.getLigne()));
			Bulle bulleDroite2 = ((Bulle) niveauChoisi.MesBulles.get((source.getColonne()+3)+"/"+source.getLigne()));
			Bulle bulleDroite3 = ((Bulle) niveauChoisi.MesBulles.get((source.getColonne()+4)+"/"+source.getLigne()));
		 

			if(bulleCliquee.getCouleur() != 0)
			{
				touchesTxt.setText(""+(Integer.parseInt(touchesTxt.getText())+1));
				if(bulleCliquee.getCouleur() == 1)
				{
					if ((bulleCliquee.getC() == 0) && (bulleCliquee.getL() == 5))
					{
						bulleCliquee.changerCouleur();
						if (bulleDessus.getCouleur() != 0)	bulleDessus.changerCouleur();
						 else if (bulleDessus1.getCouleur() != 0) bulleDessus1.changerCouleur();
						  else if (bulleDessus2.getCouleur() != 0) bulleDessus2.changerCouleur();
						   else if (bulleDessus3.getCouleur() != 0) bulleDessus3.changerCouleur();
						    else if (bulleDessus4.getCouleur() != 0) bulleDessus4.changerCouleur();

						if (bulleDroite.getCouleur() != 0) bulleDroite.changerCouleur();
						 else if (bulleDroite1.getCouleur() != 0) bulleDroite1.changerCouleur();
						  else if (bulleDroite2.getCouleur() != 0) bulleDroite2.changerCouleur();	
						   else if (bulleDroite3.getCouleur() != 0) bulleDroite3.changerCouleur();	
					}
					if ((bulleCliquee.getC() == 0)  && (bulleCliquee.getL() != 0) && (bulleCliquee.getL() != 5))
					{
						bulleCliquee.changerCouleur();
						if (bulleDessus.getCouleur() != 0)	bulleDessus.changerCouleur();
						 else if (bulleDessus1.getCouleur() != 0) bulleDessus1.changerCouleur();
						  else if (bulleDessus2.getCouleur() != 0) bulleDessus2.changerCouleur();
						   else if (bulleDessus3.getCouleur() != 0) bulleDessus3.changerCouleur();

						if (bulleDroite.getCouleur() != 0) bulleDroite.changerCouleur();
						 else if (bulleDroite1.getCouleur() != 0) bulleDroite1.changerCouleur();
						  else if (bulleDroite2.getCouleur() != 0) bulleDroite2.changerCouleur();	
						   else if (bulleDroite3.getCouleur() != 0) bulleDroite3.changerCouleur();	
						
						if (bulleDessous.getCouleur() != 0) bulleDessous.changerCouleur();
						 else if (bulleDessous1.getCouleur() != 0) bulleDessous1.changerCouleur();
						  else if (bulleDessous2.getCouleur() != 0) bulleDessous2.changerCouleur();
						   else if (bulleDessous3.getCouleur() != 0) bulleDessous3.changerCouleur();
					}
					if ((bulleCliquee.getC() == 0) && (bulleCliquee.getL() == 0))
					{					
						bulleCliquee.changerCouleur();
						if (bulleDroite.getCouleur() != 0) bulleDroite.changerCouleur();
						 else if (bulleDroite1.getCouleur() != 0) bulleDroite1.changerCouleur();
						  else if (bulleDroite2.getCouleur() != 0) bulleDroite2.changerCouleur();	
						   else if (bulleDroite3.getCouleur() != 0) bulleDroite3.changerCouleur();	
						
						if (bulleDessous.getCouleur() != 0) bulleDessous.changerCouleur();
						 else if (bulleDessous1.getCouleur() != 0) bulleDessous1.changerCouleur();
						  else if (bulleDessous2.getCouleur() != 0) bulleDessous2.changerCouleur();
						   else if (bulleDessous3.getCouleur() != 0) bulleDessous3.changerCouleur();
						    else if (bulleDessous4.getCouleur() != 0) bulleDessous4.changerCouleur();
					}
					if ((bulleCliquee.getC() != 0) && (bulleCliquee.getC() != 4) && (bulleCliquee.getL() == 0))
					{
						bulleCliquee.changerCouleur();
						if (bulleGauche.getCouleur() != 0) bulleGauche.changerCouleur();
						 else if (bulleGauche1.getCouleur() != 0) bulleGauche1.changerCouleur();
						  else if (bulleGauche2.getCouleur() != 0) bulleGauche2.changerCouleur();
						
						if (bulleDessous.getCouleur() != 0) bulleDessous.changerCouleur();
						 else if (bulleDessous1.getCouleur() != 0) bulleDessous1.changerCouleur();
						  else if (bulleDessous2.getCouleur() != 0) bulleDessous2.changerCouleur();
						   else if (bulleDessous3.getCouleur() != 0) bulleDessous3.changerCouleur();
						    else if (bulleDessous4.getCouleur() != 0) bulleDessous4.changerCouleur();
						
						if (bulleDroite.getCouleur() != 0) bulleDroite.changerCouleur();
						 else if (bulleDroite1.getCouleur() != 0) bulleDroite1.changerCouleur();
						  else if (bulleDroite2.getCouleur() != 0) bulleDroite2.changerCouleur();	
					}
					if ((bulleCliquee.getC() == 4) && (bulleCliquee.getL() == 0))
					{
						bulleCliquee.changerCouleur();
						if (bulleGauche.getCouleur() != 0) bulleGauche.changerCouleur();
						 else if (bulleGauche1.getCouleur() != 0) bulleGauche1.changerCouleur();
						  else if (bulleGauche2.getCouleur() != 0) bulleGauche2.changerCouleur();
						   else if (bulleGauche3.getCouleur() != 0) bulleGauche3.changerCouleur();
						
						if (bulleDessous.getCouleur() != 0) bulleDessous.changerCouleur();
						 else if (bulleDessous1.getCouleur() != 0) bulleDessous1.changerCouleur();
						  else if (bulleDessous2.getCouleur() != 0) bulleDessous2.changerCouleur();
						   else if (bulleDessous3.getCouleur() != 0) bulleDessous3.changerCouleur();
						    else if (bulleDessous4.getCouleur() != 0) bulleDessous4.changerCouleur();
					}
					if ((bulleCliquee.getC() == 4) && (bulleCliquee.getL() != 0) && (bulleCliquee.getL() != 5))
					{
						bulleCliquee.changerCouleur();
						if (bulleGauche.getCouleur() != 0) bulleGauche.changerCouleur();
						 else if (bulleGauche1.getCouleur() != 0) bulleGauche1.changerCouleur();
						  else if (bulleGauche2.getCouleur() != 0) bulleGauche2.changerCouleur();
						   else if (bulleGauche3.getCouleur() != 0) bulleGauche3.changerCouleur();
						
						if (bulleDessous.getCouleur() != 0) bulleDessous.changerCouleur();
						 else if (bulleDessous1.getCouleur() != 0) bulleDessous1.changerCouleur();
						  else if (bulleDessous2.getCouleur() != 0) bulleDessous2.changerCouleur();
						   else if (bulleDessous3.getCouleur() != 0) bulleDessous3.changerCouleur();
						
						if (bulleDessus.getCouleur() != 0)	bulleDessus.changerCouleur();
						 else if (bulleDessus1.getCouleur() != 0) bulleDessus1.changerCouleur();
						  else if (bulleDessus2.getCouleur() != 0) bulleDessus2.changerCouleur();
						   else if (bulleDessus3.getCouleur() != 0) bulleDessus3.changerCouleur();
					}
					if ((bulleCliquee.getC() == 4) && (bulleCliquee.getL() == 5))
					{
						bulleCliquee.changerCouleur();
						if (bulleDessus.getCouleur() != 0)	bulleDessus.changerCouleur();
						 else if (bulleDessus1.getCouleur() != 0) bulleDessus1.changerCouleur();
						  else if (bulleDessus2.getCouleur() != 0) bulleDessus2.changerCouleur();
						   else if (bulleDessus3.getCouleur() != 0) bulleDessus3.changerCouleur();
						    else if (bulleDessus4.getCouleur() != 0) bulleDessus4.changerCouleur();
						
						if (bulleGauche.getCouleur() != 0) bulleGauche.changerCouleur();
						 else if (bulleGauche1.getCouleur() != 0) bulleGauche1.changerCouleur();
						  else if (bulleGauche2.getCouleur() != 0) bulleGauche2.changerCouleur();
						   else if (bulleGauche3.getCouleur() != 0) bulleGauche3.changerCouleur();
					}
					if ((bulleCliquee.getC() != 0) && (bulleCliquee.getC() != 5) && (bulleCliquee.getL() == 5))
					{
						bulleCliquee.changerCouleur();
						if (bulleDessus.getCouleur() != 0)	bulleDessus.changerCouleur();
						 else if (bulleDessus1.getCouleur() != 0) bulleDessus1.changerCouleur();
						  else if (bulleDessus2.getCouleur() != 0) bulleDessus2.changerCouleur();
						   else if (bulleDessus3.getCouleur() != 0) bulleDessus3.changerCouleur();
						    else if (bulleDessus4.getCouleur() != 0) bulleDessus4.changerCouleur();
						
						if (bulleGauche.getCouleur() != 0) bulleGauche.changerCouleur();
						 else if (bulleGauche1.getCouleur() != 0) bulleGauche1.changerCouleur();
						  else if (bulleGauche2.getCouleur() != 0) bulleGauche2.changerCouleur();
						
						if (bulleDroite.getCouleur() != 0) bulleDroite.changerCouleur();
						 else if (bulleDroite1.getCouleur() != 0) bulleDroite1.changerCouleur();
						  else if (bulleDroite2.getCouleur() != 0) bulleDroite2.changerCouleur();	
					}
					if ((bulleCliquee.getC() != 0) && (bulleCliquee.getC() != 5) && (bulleCliquee.getL() != 0) && (bulleCliquee.getL() != 5))
					{
						bulleCliquee.changerCouleur();
						if (bulleDessus.getCouleur() != 0)	bulleDessus.changerCouleur();
						 else if (bulleDessus1.getCouleur() != 0) bulleDessus1.changerCouleur();
						  else if (bulleDessus2.getCouleur() != 0) bulleDessus2.changerCouleur();
						   else if (bulleDessus3.getCouleur() != 0) bulleDessus3.changerCouleur();
						
						if (bulleDessous.getCouleur() != 0) bulleDessous.changerCouleur();
						 else if (bulleDessous1.getCouleur() != 0) bulleDessous1.changerCouleur();
						  else if (bulleDessous2.getCouleur() != 0) bulleDessous2.changerCouleur();
						   else if (bulleDessous3.getCouleur() != 0) bulleDessous3.changerCouleur();
						
						if (bulleGauche.getCouleur() != 0) bulleGauche.changerCouleur();
						 else if (bulleGauche1.getCouleur() != 0) bulleGauche1.changerCouleur();
						  else if (bulleGauche2.getCouleur() != 0) bulleGauche2.changerCouleur();
						
						if (bulleDroite.getCouleur() != 0) bulleDroite.changerCouleur();
						 else if (bulleDroite1.getCouleur() != 0) bulleDroite1.changerCouleur();
						  else if (bulleDroite2.getCouleur() != 0) bulleDroite2.changerCouleur();
					}
					
				}
				
				else bulleCliquee.changerCouleur();
			}
			*/
	
	}
}