package be.ephec.reseau;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

import be.ephec.bubble_blast.*;

public class ClientBubbleBlast {
	private static String serverName = "localhost";
	private static int serverPort = 2013;
	private static int scoreJoueur1;

	public static int getScoreJoueur1() {
		return scoreJoueur1;
	}

	public static void setScoreJoueur1(int nouveauScore) {
		scoreJoueur1 = nouveauScore;
	}

	public static void initClient() throws Exception {

		Socket socket = new Socket(serverName, serverPort);
		System.out.println("Socket client: "+socket);

		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.flush();

		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		
		String ok = "Ok, prêt aussi";
		oos.writeObject(ok);
		oos.flush();

		System.out.println("Le client a établi la connection.");

		Object objetRecu = ois.readObject();
		String donneeRecue = (String) objetRecu;

		System.out.println("Le client a reçu: " +donneeRecue);
		oos.writeObject(getScoreJoueur1());
	}

	public static void main(String[] args) throws Exception {
		initClient();
	}
}