package bubble_blast;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EcranNbParties extends NouvelleFenetre{
	
	public EcranNbParties() {
		super();
		initFenetre();
	}
	
	public void initFenetre() {
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		JPanel nbPartiesPanel = new JPanel();
		nbPartiesPanel.setLayout(new BoxLayout(nbPartiesPanel, BoxLayout.Y_AXIS));
		nbPartiesPanel.setBackground(new Color(221,225,240));
		
		JButton nb1 = new JButton("Jouer 1 partie(s)");
		nb1.setMaximumSize(new Dimension(150, 50));
		nb1.setAlignmentX(Component.CENTER_ALIGNMENT);
		nb1.setBackground(new Color(130,200,255));
		
		nbPartiesPanel.add(Box.createRigidArea(new Dimension(0,150)));
		nbPartiesPanel.add(nb1);
		this.add(nbPartiesPanel);
		
		nb1.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent evt) {
		        jButtonNb1ActionPerformed(evt);
		       }
		      });
	}
		
	private void jButtonNb1ActionPerformed(ActionEvent evt) {
		EcranJeu ecranJeu = new EcranJeu(1);
		this.setVisible(false);
	}
}
