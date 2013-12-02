package bubble_blast;

import java.util.Hashtable;

public class Niveau {

	private int titre;
	public static Hashtable<String,Bulle> MesBulles = new Hashtable<String,Bulle>(30);

	public Niveau(int titre){
		MesBulles.clear();
		this.titre = titre;
		if(titre == 1) initNiveau1();
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

}
