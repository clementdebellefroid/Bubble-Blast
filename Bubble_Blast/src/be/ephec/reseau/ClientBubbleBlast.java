package be.ephec.reseau;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;

import be.ephec.GUI.Animation;
import be.ephec.GUI.EcranNiveaux;
import be.ephec.bubble_blast.*;

public class ClientBubbleBlast {
	private static String serverName = "";
	private static int serverPort = 2013;
	public static Socket socket;

	public static void initClient(String ipServer) throws Exception {
		Joueur.setHost(false);
		serverName = ipServer;
		socket = new Socket(serverName, serverPort);
		System.out.println("Socket client: "+socket);
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		Object objetRecu = ois.readObject();
		int niveauAJouer = (Integer) objetRecu;
		EcranNiveaux.animNiveau = new Animation(niveauAJouer);
	}
	
	public static void ecrireScoreSocket() throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.flush();
		oos.writeObject(Joueur.getScorePartie());
	}
	
	
	public static int lireScoreSocket() throws Exception{

		System.out.println("Client 0: ");
			ObjectInputStream ois = new ObjectInputStream(ServeurBubbleBlast.socket.getInputStream());
			System.out.println("Client 1: "+ois);
			Object objetRecu = ois.readObject();
			System.out.println("Client 2: "+objetRecu);			
			return (Integer) objetRecu;
	}


	public static void main(String[] args) throws Exception {
		initClient("");
	}
}