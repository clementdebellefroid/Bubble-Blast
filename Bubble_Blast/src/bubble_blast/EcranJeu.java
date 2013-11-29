package bubble_blast;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public EcranJeu() {
		super();
		initFenetre();
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
		niveauTxt.setBackground(new Color(0,255,0));
		niveauTxt.setPreferredSize(new Dimension(50, 30));

		JLabel scoreLabel = new JLabel("Score:");
		scoreTxt = new JTextField();
		scoreTxt.setEditable(false);
		scoreTxt.setBackground(new Color(0,255,0));
		scoreTxt.setPreferredSize(new Dimension(130, 50));

		JLabel touchesLabel = new JLabel("Touches:");
		touchesTxt = new JTextField();
		touchesTxt.setEditable(false);
		touchesTxt.setBackground(new Color(0,255,0));
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
				tabJButton[c][l].setBorderPainted(true);
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

	private void jButton1ActionPerformed(ActionEvent evt) {
		try
		{
			MesJButton source = (MesJButton)evt.getSource();
			// ((Bulle) MesBulles.get(source.getColonne()+"/"+source.getLigne())).changerCouleur();
		} 
		catch(Exception e){}
	}
}
