package packbarbestial;

public class Factory {

	private static Factory nFactory=new Factory();
	
	private Factory(){}
	
	public static Factory getnFactory(){
		return nFactory;
	}
	
	public Karta kartaSortu(int pIndarra){
		switch(pIndarra){
		case 1: return new Mofeta();
		case 2:	return new Loro();
		case 3:	return new Kanguru();
		case 4: return new Tximino();
		case 5: return new Kameleoi();
		case 6: return new Foka();
		case 7:	return new Zebra();
		case 8: return new Jirafa();
		case 9:	return new Sugea();
		case 10:return new Krokodiloa();
		case 11:return new Hipopotamo();
		case 12:return new Lehoia();			
		}
		return null;
	}
}
