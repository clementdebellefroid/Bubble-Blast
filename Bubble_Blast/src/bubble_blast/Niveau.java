package bubble_blast;

import java.util.Hashtable;

public class Niveau {

	private int titre;
	public Hashtable<String,Bulle> MesBulles = new Hashtable<String,Bulle>(30);

	public Niveau(int titre){
		MesBulles.clear();
		this.titre = titre;
		if(titre == 1)initNiveau1();
	}

	public int getTitre() {
		return titre;
	}

	public void setTitre(int titre) {
		this.titre = titre;
	}
	
	public void initNiveau1(){
		Bulle b1 = new Bulle(1,0,0);
		MesBulles.put(0+"/"+0, b1);
		Bulle b2 = new Bulle(1,4,0);
		MesBulles.put(4+"/"+0, b2);
		Bulle b3 = new Bulle(1,4,5);
		MesBulles.put(4+"/"+5, b3);
		Bulle b4 = new Bulle(2,2,5);
		MesBulles.put(2+"/"+5, b4);
		Bulle b5 = new Bulle(4,3,3);
		MesBulles.put(3+"/"+3, b5);
	}

}
