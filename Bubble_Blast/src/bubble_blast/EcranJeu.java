package bubble_blast;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class EcranJeu extends NouvelleFenetre{
	private JPanel jPanel1;
	private JPanel infoJeu;
	private JTextField Score;
	private JTextField Niveau;
	private JTextField Touches;
	private static int nbColonnes = 5;
	private static int nbLignes = 6;
	private int largeur = 23;
	private int hauteur = 23;
	private static MesJButton[][] tabJButton = new MesJButton[nbColonnes][nbLignes];
	
	public EcranJeu() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
		    this.setLocationRelativeTo(null);
			this.setVisible(true);
		    this.setResizable(false);

			{			
			 BorderLayout thisLayout = new BorderLayout();
				setLayout(thisLayout);
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.SOUTH);
				GridBagLayout jPanel1Layout = new GridBagLayout();
				jPanel1Layout.columnWidths = new int[] {7, 20, 7, 7, 7};
				jPanel1Layout.rowHeights = new int[] {1,1,1,1,1,1};
				jPanel1Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1};
				jPanel1Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setBackground(new java.awt.Color(255,255,255));
				jPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				//jPanel1.setSize(nbColonnes*largeur, nbLignes*hauteur);
			    //jPanel1.setPreferredSize(new java.awt.Dimension(nbColonnes*largeur, nbLignes*hauteur));
				//jPanel1.setPreferredSize(new java.awt.Dimension(350, 250));
				for(int i=0; i<nbColonnes; i++)
				{
					for(int j=0; j<nbLignes; j++)
					{
						tabJButton[i][j] = new MesJButton(i,j);
						jPanel1.add(tabJButton[i][j], new GridBagConstraints(i, j, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						tabJButton[i][j].setSize(23, 23);
						tabJButton[i][j].setPreferredSize(new java.awt.Dimension(30, 30));
						tabJButton[i][j].setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/CaseVide.jpg")));
						tabJButton[i][j].setBorderPainted(false);
						tabJButton[i][j].addActionListener(new ActionListener() {
						       public void actionPerformed(ActionEvent evt) {
						        jButton1ActionPerformed(evt);
						       }
						      });
					}
				}				
			}
			{
				infoJeu = new JPanel();
				getContentPane().add(infoJeu, BorderLayout.WEST);
				{
					Score = new JTextField();
					Niveau = new JTextField();
					Touches = new JTextField();
					infoJeu.add(Niveau);
					infoJeu.add(Score);
					infoJeu.add(Touches);
					Niveau.setText("Niveau:");
					Niveau.setBackground(new java.awt.Color(0,255,0));
					Niveau.setEditable(false);
					Niveau.setHorizontalAlignment(SwingConstants.CENTER);
					Niveau.setSelectedTextColor(new java.awt.Color(255,255,255));
					Niveau.setSelectionColor(new java.awt.Color(255,255,255));
					Niveau.setPreferredSize(new java.awt.Dimension(100, 25));
					Niveau.setCaretColor(new java.awt.Color(0,0,0));
					Score.setText("Score:");
					Score.setBackground(new java.awt.Color(0,255,0));
					Score.setEditable(false);
					Score.setHorizontalAlignment(SwingConstants.CENTER);
					Score.setSelectedTextColor(new java.awt.Color(255,255,255));
					Score.setSelectionColor(new java.awt.Color(255,255,255));
					Score.setPreferredSize(new java.awt.Dimension(100, 25));
					Score.setCaretColor(new java.awt.Color(0,0,0));
					Touches.setText("Touches:");
					Touches.setBackground(new java.awt.Color(0,255,0));
					Touches.setEditable(false);
					Touches.setHorizontalAlignment(SwingConstants.CENTER);
					Touches.setSelectedTextColor(new java.awt.Color(255,255,255));
					Touches.setSelectionColor(new java.awt.Color(255,255,255));
					Touches.setPreferredSize(new java.awt.Dimension(100, 25));
					Touches.setCaretColor(new java.awt.Color(0,0,0));
				}
			}
			pack();
		//	this.setSize(nbColonnes*largeur, nbLignes*hauteur);
		} catch (Exception e) {
		    //add your error handling code here
			//e.printStackTrace();
		}
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
