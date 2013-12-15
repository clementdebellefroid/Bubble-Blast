package be.ephec.reseau;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import be.ephec.bubble_blast.*;

public class ServeurBubbleBlast {

	private static int numPort = 2013;
	
	public static void initServeur() throws Exception {
		
		ServerSocket s = new ServerSocket(numPort);
		System.out.println("Socket serveur: "+s);
		Socket socket = s.accept();
		System.out.println("Le serveur a accepté la connection: "+socket);
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.flush();
		ObjectInputStream  ois = new ObjectInputStream(socket.getInputStream());
		System.out.println("Le serveur a établi la connection.");
		String pret = "Prêt à commencer une partie.";
		oos.writeObject(pret);
		oos.flush();
		System.out.println("Le serveur a transmis les données: "+pret);
		Object objetRecu = ois.readObject();
		String donneeRecue = (String) objetRecu;

		System.out.println("Le serveur a reçu les données: " +donneeRecue);
	}
	public static void main(String[] args) throws Exception {
		initServeur();
	}
}

