package bubble_blast;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

		JLabel mainLabel = new JLabel();
		mainLabel.setLayout(new BorderLayout());
		
		JLabel infoLabel = new JLabel();
		infoLabel.setIcon(new ImageIcon("bin/images/infoLabel.jpg"));
		infoLabel.setPreferredSize(new Dimension(500,100));
		infoLabel.setLayout(new BorderLayout());

		niveauTxt = new JTextField();
		niveauTxt.setEditable(false);
		niveauTxt.setPreferredSize(new Dimension(150, 30));
		niveauTxt.setOpaque(false);
		niveauTxt.setBorder(null);

		scoreTxt = new JTextField();
		scoreTxt.setEditable(false);
		scoreTxt.setPreferredSize(new Dimension(220, 50));
		scoreTxt.setOpaque(false);
		scoreTxt.setBorder(null);

		touchesTxt = new JTextField("0");
		touchesTxt.setEditable(false);
		touchesTxt.setPreferredSize(new Dimension(130, 30));
		touchesTxt.setOpaque(false);
		touchesTxt.setBorder(null);

		infoLabel.add(niveauTxt, BorderLayout.WEST);
		infoLabel.add(scoreTxt, BorderLayout.CENTER);
		infoLabel.add(touchesTxt, BorderLayout.EAST);

		JLabel grilleJeuLabel = new JLabel();

		GridBagLayout grilleJeuLabelLayout = new GridBagLayout();
		grilleJeuLabel.setLayout(grilleJeuLabelLayout);
		grilleJeuLabel.setIcon(new ImageIcon("bin/images/mainLabel.jpg"));
		for(int c=0; c<nbColonnes; c++)
		{
			for(int l=0; l<nbLignes; l++)
			{
				tabJButton[c][l] = new MesJButton(c,l);
				grilleJeuLabel.add(tabJButton[c][l], new GridBagConstraints(c, l, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				tabJButton[c][l].setPreferredSize(new Dimension(tailleCoteBouton, tailleCoteBouton));
				tabJButton[c][l].setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/CaseVide.jpg")));
				tabJButton[c][l].setBorder(BorderFactory.createCompoundBorder());
				tabJButton[c][l].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
		}
		
		this.setContentPane(mainLabel);
		mainLabel.add(infoLabel, BorderLayout.NORTH);
		mainLabel.add(grilleJeuLabel, BorderLayout.CENTER);
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
		MesJButton source = (MesJButton)evt.getSource();
		if(Niveau.MesBulles.containsKey(source.getColonne()+"/"+source.getLigne()))
		{
			Bulle bulleCliquee = ((Bulle) Niveau.MesBulles.get(source.getColonne()+"/"+source.getLigne()));
			bulleCliquee.changerCouleur();
			touchesTxt.setText(""+(Integer.parseInt(touchesTxt.getText())+1));
		}
	}
}