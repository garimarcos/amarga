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
		hartzeke.add(Factory.getnFactory().kartaSortu(indarra));
	}

}
