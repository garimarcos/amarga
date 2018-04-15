package packbarbestial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class Jokalaria {
	
	private String izena;
	private String kolorea;
	private Mazo hartzeke;
	private Karta[] eskuan;
	private int kop;
	private int azkena;
	private boolean hutsune;
	
	public Jokalaria(String pIzen, String pKolore){
		this.izena=pIzen;
		this.kolorea=pKolore;
		this.hartzeke=new Mazo();
		this.eskuan=new Karta[4];
		kop=0;
	}
	
	public Mazo getHartzeke(){ return hartzeke; }//test gauzatzeko
	
	public Karta[] getEskuan(){ return eskuan; }//test gauzatzeko
	
	public String getKolore(){ return kolorea; }
	
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
		for(int i=0;i<4;i++){//Eskua bete arte(4 karta egon behar dira)
			eskuan[i]=hartzeke.pop();
			kop++;
		}
		
	}
		
	private void gehituKarta(int indarra){//Karta bat eskura gehitzeko metodoa
		hartzeke.add(Factory.getnFactory().kartaSortu(indarra));
	}
	
	public String[] mahaiaPrestatu(){
		String[] urlak = new String[4];
		for (int i = 0; i < 4; i++){
			urlak[i]= KartenBilera.getnKartenBilera().getURL(eskuan[i].getIndarra(), this.kolorea);
		}
		return urlak;
	}
	
	public int[] hartu(){
		int[] ondoPosizioa=new int[3];
		ondoPosizioa[1]=azkena;
		if(kop!=4){
			if(eskuan[azkena]==null){
				eskuan[azkena]=hartzeke.pop();
				kop++;
				ondoPosizioa[2]=eskuan[azkena].getIndarra();
				ondoPosizioa[0]=1;
				hutsune=false;
				return ondoPosizioa;//ondo egin du
			}else{
				ondoPosizioa[0]=2;
				return ondoPosizioa;//ez du hartu karta
			}
		}
		else {
			ondoPosizioa[0]=0;
			return ondoPosizioa;//jada 4 karta daude	
		}
	}
	
	public Karta bota(int posizioa){
		if(hartzeke.size()>0 && !hutsune){
			kop--;
			azkena=posizioa-1;
			switch(posizioa){
			case 1:
				return bota1(0);
			case 2: 
				return bota1(1);
			case 3: 
				return bota1(2);
			case 4: 
				return bota1(3);
			}
			return null;
		}
		//return null;
		return new Lehoia(0,false);

	}
	
	private Karta bota1(int posizio){
		Karta k=eskuan[posizio];
		eskuan[posizio]=null;
		hutsune=true;
		return k;
	}

}
