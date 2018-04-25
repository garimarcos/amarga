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
	private Jokaera j;
	private int kameleoi;
	
	public Jokalaria(String pIzen, String pKolore){
		this.izena=pIzen;
		this.kolorea=pKolore;
		this.hartzeke=new Mazo();
		this.eskuan=new Karta[4];
		kop=0;
		hasieratu();
	}
	
	//public Mazo getHartzeke(){ return hartzeke; }//test gauzatzeko
	
	//public Karta[] getEskuan(){ return eskuan; }//test gauzatzeko
	
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
		int[] ondoPosizioa=new int[3];//0--> ondo egin du? 1--> non dago hutsunea 2--> kartaren indarra
		ondoPosizioa[1]=azkena;
		if(hartzeke.size()==0) ondoPosizioa[0]=3; //mazo hutsik
		else{
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
		return ondoPosizioa;
	}
	
	public int bota(int posizioa){
		Karta k=null;
		boolean hutsik=eskuan[posizioa-1]==null;
		//if(hartzeke.size()>0){
			if(!hutsune || (hartzeke.size()==0 && !hutsik)){
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
			} else return -1; 
		//else return 0;
		//return null;
		//return 0; //4 karta jadanik
	}
	
	
	private Karta bota1(int posizio){
		Karta k=eskuan[posizio];
		if(k instanceof Kameleoi) k=new Kameleoi(kameleoi,kolorea);
		eskuan[posizio]=null;
		hutsune=true;
		return k;
	}
	
	public int botaOrd(){
		int k=0;
		k=botaOrd1();
		return k;
	}
	
	private int botaOrd1(){
		Karta k =null;
		int i=0;
		boolean ondo=false;
		while(!ondo){
			if(eskuan[i]!=null) ondo=true;
			else i++;
		}
		if (eskuan[i]!=null){
			k=eskuan[i];
			if(k instanceof Kameleoi) k=new Kameleoi(random(),kolorea);
			Jokoa.getnJokoa().gehituTablerora(k);
			k=bota1(i);
			kop--;
			if(hartzeke.size()!=0) hartu();
			return k.getIndarra();
		}
		return 0;
	}
	
	private int random(){
		Random rn=new Random();
		int ind=rn.nextInt(11);
		if(ind==5 || ind==0) ind++;
		return ind;
	}
	
	public void esleituKameleoi(int indarra){ 
		kameleoi=indarra; 
		
		}
	
	}


