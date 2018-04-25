package packbarbestial;

public class Kameleoi extends Karta {
	
	private Karta state;
	

	public Kameleoi(int indarra,String pKolore) {
		super(5, false, pKolore,3);
		this.state=Factory.getnFactory().kartaSortu(indarra,pKolore);
	}

	public Kameleoi(String pKolore) {
		super(5, false, pKolore,3);
	}

	@Override
	public void egikaritu() {
		state.egikaritu();
		//setState(5,"berdea");
	}
	
	public void setState(int indarra,String pKolore){
		this.state=Factory.getnFactory().kartaSortu(indarra,pKolore);
	}

}
