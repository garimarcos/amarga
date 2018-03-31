package packbarbestial;

public class Tableroa {
	
	private static Tableroa nTableroa=new Tableroa();
	private UnorderedDoubleLinkedList<Karta> tableroa;
	private Karta[] kartak;
	private int kop;

	private Tableroa() {
		tableroa=new UnorderedDoubleLinkedList<Karta>();
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
	
//	public void gehituKarta(Karta pKarta, int posizioa){
//		if(posizioa==1) tableroa.addToFront(pKarta);
//		else if(posizioa==5)
//	}

}
