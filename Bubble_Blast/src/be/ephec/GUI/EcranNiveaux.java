package be.ephec.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;

public class EcranNiveaux extends NouvelleFenetre {
        private int niveauChoisi;
        public static Animation animNiveau;
        
        public EcranNiveaux(){
                super();
                initFenetre();
        }
        
        public void initFenetre(){
            this.setLocationRelativeTo(null);
                this.setVisible(true);
                
                JLabel niveauxLabel = new JLabel();
                niveauxLabel.setLayout(new BoxLayout(niveauxLabel, BoxLayout.Y_AXIS));
                niveauxLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("niveau.jpg")));
                this.setContentPane(niveauxLabel);
                
                String[] items = {"Niveau 1", "Niveau 2", "Niveau 3", "Niveau 4", "Niveau 5", "Niveau 6"};
                final JComboBox menuNiveaux = new JComboBox(items);
                menuNiveaux.setMaximumSize(new Dimension(100, 20));
                menuNiveaux.setSelectedIndex(1);

                JButton demarrer = new JButton(new ImageIcon(getClass().getClassLoader().getResource("Go.jpg")));
                demarrer.setMaximumSize(new Dimension(200, 125));
                demarrer.setAlignmentX(Component.CENTER_ALIGNMENT);

                this.add(Box.createRigidArea(new Dimension(0,200)));
                this.add(menuNiveaux);
                this.add(Box.createRigidArea(new Dimension(0,100)));
                this.add(demarrer);
                
                menuNiveaux.setSelectedIndex(0);
                niveauChoisi = (menuNiveaux.getSelectedIndex()+1);
                
                menuNiveaux.addItemListener(new ItemListener(){
                                public void itemStateChanged(ItemEvent ie){
                                        niveauChoisi = (menuNiveaux.getSelectedIndex()+1);
                                }
                });
                
                demarrer.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent evt) {
                        jButtonDemarrerActionPerformed(evt);
                       }
                      });
        }  
        private void jButtonDemarrerActionPerformed(ActionEvent evt) {
                animNiveau = new Animation(niveauChoisi);
                this.setVisible(false);
        }
}