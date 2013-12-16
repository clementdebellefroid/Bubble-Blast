package be.ephec.reseau;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import be.ephec.GUI.Animation;
import be.ephec.GUI.EcranNbParties;
import be.ephec.GUI.EcranNiveaux;
import be.ephec.bubble_blast.*;

public class ServeurBubbleBlast {

	private static int numPort = 2013;
	public static int niveauAJouer;
	public static Socket socket;
	
	public static void initServeur() throws Exception {
			Joueur.setHost(true);
			
			ServerSocket s = new ServerSocket(numPort);
			socket = s.accept();
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.flush();
			oos.writeObject(niveauAJouer);
			EcranNiveaux.animNiveau = new Animation(niveauAJouer);
	}
	public static void ecrireScoreSocket() throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.flush();
		oos.writeObject(Joueur.getScorePartie());
	}
	
	public static int lireScoreSocket() throws Exception{
		Object objetRecu = null;
		System.out.println("Serv avant"+objetRecu);
		do{
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		objetRecu = ois.readObject();
		System.out.println("Serv apres"+objetRecu);
		return (Integer) objetRecu;
		}while(objetRecu == null);
	}
	
	public static void main(String[] args) throws Exception {
		initServeur();
	}
}

