package packbarbestial;

import java.util.Random;

public class Jokalaria{
	
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
		hasieratu();
	}
	
	public Mazo getHartzeke(){ return hartzeke; }//test gauzatzeko
	
	public Karta[] getEskuan(){ return eskuan; }//test gauzatzeko
	
	public String getKolore(){ return kolorea; }
	
	private void hasieratu(){//Kartak banatzeko metodoa
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
		Factory f=Factory.getnFactory();
		hartzeke.add(f.kartaSortu(indarra,kolorea));
	}
	
	public String[] mahaiaPrestatu(){
		String[] urlak = new String[4];
		KartenBilera k=KartenBilera.getnKartenBilera();
		for (int i = 0; i < 4; i++){
			urlak[i]= k.getURL(eskuan[i].getIndarra(), this.kolorea);
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
				//notifyObservers();
				return ondoPosizioa;//ondo egin du
			}else{
				ondoPosizioa[0]=2;
				//notifyObservers();
				return ondoPosizioa;//ez du hartu karta
			}
		}
		else {
			ondoPosizioa[0]=0;
			//notifyObservers();
			return ondoPosizioa;//jada 4 karta daude	
		}
		
	}
	
	public int bota(int posizioa){
		Karta k=null;
		if(hartzeke.size()>0){
			if(!hutsune){
				kop--;
				azkena=posizioa-1;
				switch(posizioa){
				case 1:
					 k= bota1(0);
					 break;
				case 2: 
					 k= bota1(1);
					 break;
				case 3: 
					 k= bota1(2);
					 break;
				case 4: 
					 k= bota1(3);
					 break;
				}
				Jokoa.getnJokoa().gehituTablerora(k);
				return k.getIndarra();
			}else return -1; 
		}else return 0;
		//return null;
		//return 0; //4 karta jadanik
	}
	
	
	private Karta bota1(int posizio){
		Karta k=eskuan[posizio];
		eskuan[posizio]=null;
		hutsune=true;
		return k;
	}
	
	public int botaOrd(){
		boolean ondo=false;
		int i=0;
		int k=0;
		while(!ondo){
			k=botaOrd1(i);
			if(k!=0) return k;
		}
		return 0;
	}
	
	private int botaOrd1(int pos){
		Karta k =null;
		if (eskuan[pos]!=null){
			k=eskuan[pos];
			if(k.getIndarra()==5){
				int ind=kameleoiEsleitu(0);
				k=new Kameleoi(ind,kolorea);
			}
			Jokoa.getnJokoa().gehituTablerora(k);
			bota1(pos);
			kop--;
			hartu();
			return k.getIndarra();
		}
		return 0;
	}
	
	public int kameleoiEsleitu(int indarra){
		if(indarra==0){
			Random rn=new Random();
			int ind=rn.nextInt(11)+1;
			return ind;
		}return 0;
	}

}
