package packbarbestial;

import java.util.HashMap;

public class KartenBilera{
	
	private static KartenBilera nKartenBilera=new KartenBilera();
	private HashMap<Integer,Karta> kartak=new HashMap<Integer,Karta>();

	private KartenBilera() {
		kartak.put(1, new Mofeta());
	}
	
	public static KartenBilera getKartenBilera(){
		return nKartenBilera;
	}
	
	public Karta getKarta(Integer pIndarra){
		Karta bueltatu=kartak.get(pIndarra);
		Class<? extends Karta> klasea=bueltatu.getClass();
		System.out.println(klasea.getName());
		return bueltatu;
	}

}
