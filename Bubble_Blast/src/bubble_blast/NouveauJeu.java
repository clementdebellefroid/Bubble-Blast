package bubble_blast;

import javax.swing.SwingUtilities;

public class NouveauJeu {
	
	private int nbNiveaux;
	private boolean modeSolo;
	
	public NouveauJeu(int nbNiveaux, boolean modeSolo){
		this.nbNiveaux = nbNiveaux;
		this.modeSolo = modeSolo;
	}
	
	public int getNbNiveaux() {
		return nbNiveaux;
	}

	public void setNbNiveaux(int nbNiveaux) {
		this.nbNiveaux = nbNiveaux;
	}

	public boolean isModeSolo() {
		return modeSolo;
	}

	public void setModeSolo(boolean modeSolo) {
		this.modeSolo = modeSolo;
	}
	public void afficherResultat(){
		
	}
	public static void main(String []args){
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				EcranAccueil lancement = new EcranAccueil();
			}
		});
	}
	
}
