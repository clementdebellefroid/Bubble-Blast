package be.ephec.bubble_blast;

import java.util.Hashtable;

import be.ephec.GUI.Animation;

public class Niveau {

	private int titre;
	private static int nbNiveauxCrees = 6;
	private static int nbNiveaux = 6;
	public static Hashtable<String,Bulle> MesBulles = new Hashtable<String,Bulle>(30);

	public Niveau(int titre){
		MesBulles.clear();
		this.titre = titre;
		if(titre == 1) initNiveau1();
		if(titre == 2) initNiveau2();
		if(titre == 3) initNiveau3();
		if(titre == 4) initNiveau4();
		if(titre == 5) initNiveau5();
		if(titre == 6) initNiveau6();
	}

	public static int getNbNiveauxCrees() {
		return nbNiveauxCrees;
	}

	public static int getNbNiveaux(){
		return nbNiveaux;
	}

	public static void setNbNiveaux(int NouveauNbNiveaux){
		nbNiveaux = NouveauNbNiveaux;
	}

	public Hashtable<String, Bulle> getMesBulles() {
		return MesBulles;
	}

	public void setMesBulles(Hashtable<String, Bulle> mesBulles) {
		MesBulles = mesBulles;
	}

	public int getTitre() {
		return titre;
	}

	public void setTitre(int titre) {
		this.titre = titre;
	}

	public void initNiveau1(){
		Bulle b1 = new Bulle(1,0,3);
		MesBulles.put(0+"/"+3, b1);
		Bulle b2 = new Bulle(1,2,3);
		MesBulles.put(2+"/"+3, b2);
		Bulle b3 = new Bulle(1,4,3);
		MesBulles.put(4+"/"+3, b3);
		Bulle b4 = new Bulle(1,0,3);
		MesBulles.put(0+"/"+3, b4);
		Bulle b5 = new Bulle(1,0,0);
		MesBulles.put(0+"/"+0, b5);
		Bulle b6 = new Bulle(1,4,0);
		MesBulles.put(4+"/"+0, b6);
		Bulle b7 = new Bulle(2,0,5);
		MesBulles.put(0+"/"+5, b7);
		Bulle b8 = new Bulle(2,4,5);
		MesBulles.put(4+"/"+5, b8);
		Bulle b9 = new Bulle(3,2,5);
		MesBulles.put(2+"/"+5, b9);
	}

	public void initNiveau2(){
		Bulle b1 = new Bulle(2,0,0);
		MesBulles.put(0+"/"+0, b1);
		Bulle b2 = new Bulle(1,4,0);
		MesBulles.put(4+"/"+0, b2);
		Bulle b3 = new Bulle(1,4,5);
		MesBulles.put(4+"/"+5, b3);
		Bulle b4 = new Bulle(2,2,5);
		MesBulles.put(2+"/"+5, b4);
		Bulle b5 = new Bulle(4,3,3);
		MesBulles.put(3+"/"+3, b5);
		Bulle b6 = new Bulle(4,2,4);
		MesBulles.put(2+"/"+4, b6);
		Bulle b7 = new Bulle(2,3,4);
		MesBulles.put(3+"/"+4, b7);
		Bulle b8 = new Bulle(2,3,5);
		MesBulles.put(3+"/"+5, b8);
		Bulle b9 = new Bulle(2,4,4);
		MesBulles.put(4+"/"+4, b9);
		Bulle b10 = new Bulle(2,0,1);
		MesBulles.put(0+"/"+1, b10);
		Bulle b11 = new Bulle(2,1,0);
		MesBulles.put(1+"/"+0, b11);
		Bulle b12 = new Bulle(2,1,1);
		MesBulles.put(1+"/"+1, b12);
		Bulle b13 = new Bulle(2,0,2);
		MesBulles.put(0+"/"+2, b13);
		Bulle b14 = new Bulle(2,2,0);
		MesBulles.put(2+"/"+0, b14);
		Bulle b15 = new Bulle(2,3,0);
		MesBulles.put(3+"/"+0, b15);
		Bulle b16 = new Bulle(2,4,1);
		MesBulles.put(4+"/"+1, b16);
		Bulle b17 = new Bulle(2,2,1);
		MesBulles.put(2+"/"+1, b17);
		Bulle b18 = new Bulle(2,1,2);
		MesBulles.put(1+"/"+2, b18);
		Bulle b19 = new Bulle(2,3,2);
		MesBulles.put(3+"/"+2, b19);
	}

	public void initNiveau3(){
		Bulle b1 = new Bulle(2,2,0);
		MesBulles.put(2+"/"+0, b1);
		Bulle b2 = new Bulle(1,4,0);
		MesBulles.put(4+"/"+0, b2);
		Bulle b3 = new Bulle(3,0,1);
		MesBulles.put(0+"/"+1, b3);
		Bulle b4 = new Bulle(1,1,1);
		MesBulles.put(1+"/"+1, b4);
		Bulle b5 = new Bulle(4,2,1);
		MesBulles.put(2+"/"+1, b5);
		Bulle b6 = new Bulle(4,3,1);
		MesBulles.put(3+"/"+1, b6);
		Bulle b7 = new Bulle(3,4,1);
		MesBulles.put(4+"/"+1, b7);
		Bulle b8 = new Bulle(4,0,2);
		MesBulles.put(0+"/"+2, b8);
		Bulle b9 = new Bulle(2,1,2);
		MesBulles.put(1+"/"+2, b9);
		Bulle b10 = new Bulle(4,2,2);
		MesBulles.put(2+"/"+2, b10);
		Bulle b11 = new Bulle(1,4,2);
		MesBulles.put(4+"/"+2, b11);
		Bulle b12 = new Bulle(4,0,3);
		MesBulles.put(0+"/"+3, b12);
		Bulle b13 = new Bulle(1,1,3);
		MesBulles.put(1+"/"+3, b13);
		Bulle b14 = new Bulle(1,2,3);
		MesBulles.put(2+"/"+3, b14);
		Bulle b15 = new Bulle(4,3,3);
		MesBulles.put(3+"/"+3, b15);
		Bulle b16 = new Bulle(1,4,3);
		MesBulles.put(4+"/"+3, b16);
		Bulle b17 = new Bulle(2,0,4);
		MesBulles.put(0+"/"+4, b17);
		Bulle b18 = new Bulle(1,1,4);
		MesBulles.put(1+"/"+4, b18);
		Bulle b19 = new Bulle(2,2,4);
		MesBulles.put(2+"/"+4, b19);
		Bulle b20 = new Bulle(4,3,4);
		MesBulles.put(3+"/"+4, b20);
		Bulle b21 = new Bulle(4,4,4);
		MesBulles.put(4+"/"+4, b21);
		Bulle b22 = new Bulle(2,0,5);
		MesBulles.put(0+"/"+5, b22);
		Bulle b23 = new Bulle(1,1,5);
		MesBulles.put(1+"/"+5, b23);
		Bulle b24 = new Bulle(2,2,5);
		MesBulles.put(2+"/"+5, b24);
		Bulle b25 = new Bulle(2,3,5);
		MesBulles.put(3+"/"+5, b25);
		Bulle b26 = new Bulle(1,4,5);
		MesBulles.put(4+"/"+5, b26);
	}
	
	public void initNiveau4() {
		Bulle b1 = new Bulle(1,0,5);
		MesBulles.put(0+"/"+5, b1);
		Bulle b2 = new Bulle(1,1,5);
		MesBulles.put(1+"/"+5, b2);
		Bulle b3 = new Bulle(2,2,5);
		MesBulles.put(2+"/"+5, b3);
		Bulle b4 = new Bulle(1,3,5);
		MesBulles.put(3+"/"+5, b4);
		Bulle b5 = new Bulle(1,4,5);
		MesBulles.put(4+"/"+5, b5);
		Bulle b6 = new Bulle(2,1,4);
		MesBulles.put(1+"/"+4, b6);
		Bulle b7 = new Bulle(1,2,4);
		MesBulles.put(2+"/"+4, b7);
		Bulle b8 = new Bulle(2,3,4);
		MesBulles.put(3+"/"+4, b8);
		Bulle b9 = new Bulle(3,2,3);
		MesBulles.put(2+"/"+3, b9);
		
	}
	
	public void initNiveau5() {
		Bulle b1 = new Bulle(1,2,0);
		MesBulles.put(2+"/"+0, b1);
		Bulle b2 = new Bulle(1,0,1);
		MesBulles.put(0+"/"+1, b2);
		Bulle b3 = new Bulle(1,2,1);
		MesBulles.put(2+"/"+1, b3);
		Bulle b4 = new Bulle(1,4,1);
		MesBulles.put(4+"/"+1, b4);
		Bulle b5 = new Bulle(2,1,2);
		MesBulles.put(1+"/"+2, b5);
		Bulle b6 = new Bulle(2,3,2);
		MesBulles.put(3+"/"+2, b6);
		Bulle b7 = new Bulle(4,2,3);
		MesBulles.put(2+"/"+3, b7);
		Bulle b8 = new Bulle(2,1,4);
		MesBulles.put(1+"/"+4, b8);
		Bulle b9 = new Bulle(2,3,4);
		MesBulles.put(3+"/"+4, b9);
		Bulle b10 = new Bulle(1,0,5);
		MesBulles.put(0+"/"+5, b10);
		Bulle b11 = new Bulle(1,4,5);
		MesBulles.put(4+"/"+5, b11);
		Bulle b12 = new Bulle(1,2,2);
		MesBulles.put(2+"/"+2, b12);
		Bulle b13 = new Bulle(1,2,4);
		MesBulles.put(2+"/"+4, b13);
		Bulle b14 = new Bulle(1,2,5);
		MesBulles.put(2+"/"+5, b14);
	}
	
	public void initNiveau6() {
		Bulle b1 = new Bulle(2,0,0);
		MesBulles.put(0+"/"+0, b1);
		Bulle b2 = new Bulle(1,0,1);
		MesBulles.put(0+"/"+1, b2);
		Bulle b5 = new Bulle(1,0,5);
		MesBulles.put(0+"/"+5, b5);
		Bulle b6 = new Bulle(4,1,0);
		MesBulles.put(1+"/"+0, b6);
		Bulle b7 = new Bulle(2,1,1);
		MesBulles.put(1+"/"+1, b7);
		Bulle b8 = new Bulle(3,1,2);
		MesBulles.put(1+"/"+2, b8);
		Bulle b9 = new Bulle(1,1,3);
		MesBulles.put(1+"/"+3, b9);
		Bulle b10 = new Bulle(2,1,4);
		MesBulles.put(1+"/"+4, b10);
		Bulle b11 = new Bulle(1,2,0);
		MesBulles.put(2+"/"+0, b11);
		Bulle b12 = new Bulle(1,2,1);
		MesBulles.put(2+"/"+1, b12);
		Bulle b15 = new Bulle(4,2,4);
		MesBulles.put(2+"/"+4, b15);
		Bulle b16 = new Bulle(3,3,0);
		MesBulles.put(3+"/"+0, b16);
		Bulle b17 = new Bulle(2,3,1);
		MesBulles.put(3+"/"+1, b17);
		Bulle b18 = new Bulle(1,3,2);
		MesBulles.put(3+"/"+2, b18);
		Bulle b19 = new Bulle(4,3,3);
		MesBulles.put(3+"/"+3, b19);
		Bulle b20 = new Bulle(2,3,4);
		MesBulles.put(3+"/"+4, b20);
		Bulle b21 = new Bulle(2,4,0);
		MesBulles.put(4+"/"+0, b21);
		Bulle b22 = new Bulle(3,4,1);
		MesBulles.put(4+"/"+1, b22);
		Bulle b24 = new Bulle(1,4,3);
		MesBulles.put(4+"/"+3, b24);
		Bulle b25 = new Bulle(3,4,4);
		MesBulles.put(4+"/"+4, b25);
		Bulle b26 = new Bulle(4,1,5);
		MesBulles.put(1+"/"+5, b26);
		Bulle b27 = new Bulle(2,2,5);
		MesBulles.put(2+"/"+5, b27);
		Bulle b28 = new Bulle(1,3,5);
		MesBulles.put(3+"/"+5, b28);
		Bulle b29 = new Bulle(1,4,5);
		MesBulles.put(4+"/"+5, b29);
	}
}