package bubble_blast;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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
		infoLabel.setLayout(null);
		
		Font font = new Font("Arial", Font.PLAIN,25);
		niveauTxt = new JTextField();
		niveauTxt.setEditable(false);
		niveauTxt.setOpaque(false);
		niveauTxt.setBorder(null);
		niveauTxt.setBounds(50, 41, 45, 30);
		niveauTxt.setFont(font);
		niveauTxt.setForeground(new Color(181,123,0));

		scoreTxt = new JTextField();
		scoreTxt.setEditable(false);
		scoreTxt.setOpaque(false);
		scoreTxt.setBorder(null);
		scoreTxt.setHorizontalAlignment(JTextField.RIGHT);
		scoreTxt.setBounds(200, 55, 110, 37);
		scoreTxt.setFont(font);
		scoreTxt.setForeground(new Color(42,137,205));

		touchesTxt = new JTextField("0");
		touchesTxt.setEditable(false);
		touchesTxt.setOpaque(false);
		touchesTxt.setBounds(415, 43, 60, 30);
		touchesTxt.setBorder(null);
		touchesTxt.setFont(font);
		touchesTxt.setForeground(new Color(42,137,205));

		infoLabel.add(niveauTxt);
		infoLabel.add(scoreTxt);
		infoLabel.add(touchesTxt);

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
				tabJButton[c][l].setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/CaseVide.gif")));
				tabJButton[c][l].setBorder(BorderFactory.createCompoundBorder());
				tabJButton[c][l].setOpaque(false);
				tabJButton[c][l].setContentAreaFilled(false);
				tabJButton[c][l].setBorderPainted(false);
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
			if(Niveau.MesBulles.isEmpty()){
				EcranFinJeu ecranFinJeu = new EcranFinJeu();;
			}
		}
	}
}