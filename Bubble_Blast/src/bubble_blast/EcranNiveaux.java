package bubble_blast;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class EcranNiveaux extends NouvelleFenetre {
	
	public EcranNiveaux(){
		super();
		initFenetre();
	}
	
	public void initFenetre(){
	    this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		JPanel niveauxPanel = new JPanel();
		niveauxPanel.setLayout(new BoxLayout(niveauxPanel, BoxLayout.Y_AXIS));
		niveauxPanel.setBackground(new Color(221,225,240));
		
		JLabel choixPanel = new JLabel("Choisir niveau");
		String[] items = {"Niveau 1", "Niveau 2", "Niveau 3"};
		JComboBox menuNiveaux = new JComboBox();
		menuNiveaux.setPreferredSize(new Dimension(100, 20));

	    /*JButton niveau1 = new JButton("Niveau 1");
	    niveau1.setMaximumSize(new Dimension(100, 50));
	    niveau1.setAlignmentX(Component.CENTER_ALIGNMENT);
	    niveau1.setBackground(new Color(130,200,255));*/

		niveauxPanel.add(Box.createRigidArea(new Dimension(0,150)));
		niveauxPanel.add(menuNiveaux);
		//niveauxPanel.add(niveau1);
		this.add(niveauxPanel);		
		
		/*niveau1.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent evt) {
		        jButtonNiv1ActionPerformed(evt);
		       }
		      });*/
	}  
	/*private void jButtonNiv1ActionPerformed(ActionEvent evt) {
		EcranJeu ecranJeu = new EcranJeu(1);
		this.setVisible(false);
	}*/
}
