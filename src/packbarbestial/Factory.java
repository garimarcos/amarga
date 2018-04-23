package packbarbestial;

public class Factory {

	private static Factory nFactory=new Factory();
	
	private Factory(){}
	
	public static Factory getnFactory(){
		return nFactory;
	}
	
	public Karta kartaSortu(int pIndarra,String pKolore){
		switch(pIndarra){
		case 1: return new Mofeta(pKolore);
		case 2:	return new Loro(pKolore);
		case 3:	return new Kanguru(pKolore);
		case 4: return new Tximino(pKolore);
		case 5: return new Kameleoi(pKolore);
		case 6: return new Foka(pKolore);
		case 7:	return new Zebra(pKolore);
		case 8: return new Jirafa(pKolore);
		case 9:	return new Sugea(pKolore);
		case 10:return new Krokodiloa(pKolore);
		case 11:return new Hipopotamo(pKolore);
		case 12:return new Lehoia(pKolore);			
		}
		return null;
	}
}
