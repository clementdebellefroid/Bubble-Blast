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
		infoLabel.setIcon(new ImageIcon("bin/images/infoPanel.jpg"));
		infoLabel.setPreferredSize(new Dimension(500,100));

		/*JLabel niveauLabel = new JLabel("Niveau:");
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
		infoPanel.add(touchesTxt);*/


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