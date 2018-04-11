package packbarbestial;

public class Tableroa {
	
	private static Tableroa nTableroa=new Tableroa();
	private Karta[] kartak;
	private int kop;

	private Tableroa() {
		kartak=new Karta[5];
		kop=0;
	}
	
	public static Tableroa getnTableroa(){
		return nTableroa;
	}
	
	public void gehituKarta(Karta pKarta){
		kartak[kop]=pKarta;
		kop++;
	}
	
	public int getKop(){ return kop; }

}
