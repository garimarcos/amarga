package packbarbestial;

public class Hipopotamo extends Karta {

	public Hipopotamo(String pKolore) {
		super(11,true, pKolore,2);
		setAurreratu(new AurreratuZebraEz());
	}

	@Override
	public void egikaritu() {
		aurreratu(super.getIndarra());
	}

}
