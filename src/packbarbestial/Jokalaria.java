package packbarbestial;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class Jokalaria {
	
	private String izena;
	private String kolorea;
	private Stack<Karta> hartzeke;
	private LinkedList<Karta> eskuan;
	
	public Jokalaria(String pIzen, String pKolore){
		this.izena=pIzen;
		this.kolorea=pKolore;
		this.hartzeke=new Stack<Karta>();
		this.eskuan=new LinkedList<Karta>();
	}
	
	public void hasieratu(){//Kartak banatzeko metodoa
		boolean[] pila=new boolean[12];
		int k=0;
		while(k<12){
			Random rn=new Random();
			int zk=rn.nextInt(12);
			zk++;
			if(!pila[zk-1]){
				gehituKarta(zk);
				pila[zk-1]=true;
				k++;
			}
		}
		for(int i=0;i<4;i++){//Eskua bete arte(5 karta egon behar dira)
			eskuan.add(hartzeke.pop());	
		}
		
	}
	
	private boolean eskuanDaukat(int indarra){ //Jokalariak karta bat eskuan badauka esaten duen metodoa
		Iterator<Karta> it=eskuan.iterator();
		boolean aurkituta=false;
		while(!aurkituta && it.hasNext()){
			Karta kart=it.next();
			if(kart.getIndarra()==indarra) aurkituta=true;
		}
		return aurkituta;
	}
	
	private void gehituKarta(int indarra){//Karta bat eskura gehitzeko metodoa
		hartzeke.add(KartenBilera.getKartenBilera().getKarta(1));
		
		switch (indarra){
		case 1:
			hartzeke.add(new Mofeta());
			break;
		case 2:
			hartzeke.add(new Loro());
			break;
		case 3:
			hartzeke.add(new Kanguru());
			break;
		case 4:
			hartzeke.add(new Tximino());
			break;
		case 5:
			hartzeke.add(new Kameleoi());
			break;
		case 6:
			hartzeke.add(new Foka());
			break;
		case 7:
			hartzeke.add(new Zebra());
			break;
		case 8:
			hartzeke.add(new Jirafa());
			break;
		case 9:
			hartzeke.add(new Sugea());
			break;
		case 10:
			hartzeke.add(new Krokodiloa());
			break;
		case 11:
			hartzeke.add(new Hipopotamo());
			break;
		case 12:
			hartzeke.add(new Lehoia());
			break;
		}
	}

}
