package packbarbestial;

import java.util.ArrayList;

public class Tableroa {
	
	private static Tableroa nTableroa=new Tableroa();
	private ArrayList<Karta> kartak;

	private Tableroa() {
		kartak=new ArrayList<Karta>();
	}
	
	public ArrayList<Karta> hartuKartak(){ return kartak; }
	
	public static Tableroa getnTableroa(){
		return nTableroa;
	}
	
	public void gehituKarta(Karta pKarta){
		kartak.add(pKarta);
	}
	
	public int getKop(){ return kartak.size(); }
	
	public void animaladakGauzatu(int jok, int indarra){
		//Karta k=ListaJokalariak.getNireLista().jokLortu(jok);
		kartak.get(kartak.size()-1).egikaritu();
//		while(i>=0){
//			if(kartak[i].errekurrenteaDa() && !kartak[i].equals(k)) kartak[i].egikaritu();
//			i--;
//		}
	}
	
}
