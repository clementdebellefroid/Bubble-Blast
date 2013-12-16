package be.ephec.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import be.ephec.bubble_blast.Niveau;
import be.ephec.reseau.ClientBubbleBlast;
import be.ephec.reseau.ServeurBubbleBlast;

public class EcranChoixIp extends NouvelleFenetre{
	
	private JTextField ipHostTxt;
	
	public EcranChoixIp() {
		super();
		initFenetre();
	}

	public void initFenetre() {
		this.setLocationRelativeTo(null);

		JLabel choixIpLabel = new JLabel();
		choixIpLabel.setLayout(new BoxLayout(choixIpLabel, BoxLayout.Y_AXIS));
		choixIpLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("choixIp.jpg")));
		
		Font font = new Font("Arial", Font.PLAIN,25);
		ipHostTxt = new JTextField("");
		ipHostTxt.setMaximumSize(new Dimension(180, 30));
		ipHostTxt.setBorder(null);
		ipHostTxt.setFont(font);
		ipHostTxt.setForeground(new Color(181,123,0));

		JButton demarrer = new JButton(new ImageIcon(getClass().getClassLoader().getResource("Go.jpg")));
		demarrer.setMaximumSize(new Dimension(200, 125));
		demarrer.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.setContentPane(choixIpLabel);
		choixIpLabel.add(Box.createRigidArea(new Dimension(0,210)));
		choixIpLabel.add(ipHostTxt);
		choixIpLabel.add(Box.createRigidArea(new Dimension(0,90)));
		choixIpLabel.add(demarrer);

		demarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonDemarrerActionPerformed(evt);
			}
		});
		
	}
	
	private void jButtonDemarrerActionPerformed(ActionEvent evt) {
		if(!ipHostTxt.getText().equals("")){
			try {
				this.setVisible(false);
				ClientBubbleBlast.initClient(ipHostTxt.getText());
			} catch (Exception e) {}	
		}
	}
}
