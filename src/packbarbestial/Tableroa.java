package packbarbestial;

public class Tableroa {
	
	private static Tableroa nTableroa=new Tableroa();
	private Karta[] kartak;
	private int kop;

	private Tableroa() {
		kartak=new Karta[5];
		kop=0;
	}
	
	public Karta[] hartuKartak(){ return kartak; }
	
	public static Tableroa getnTableroa(){
		return nTableroa;
	}
	
	public void gehituKarta(int indarra){
		Karta k=bilatu(indarra);
		kartak[kop]=k;
		kop++;
	}
	
	public int getKop(){ return kop; }
	
	public void animaladakGauzatu(Karta pKarta){
		int i=kop-1;
		kartak[kop-1].egikaritu();
		while(i>=0){
			if(kartak[i].errekurrenteaDa() && !kartak[i].equals(pKarta)) kartak[i].egikaritu();
			i--;
		}
	}
	
	private Karta bilatu(int indarra){
		int i=0;
		while(i<kop){
			if(kartak[i].getIndarra()==indarra) return kartak[i];
			else i++;
		}
		return null;
	}

}
