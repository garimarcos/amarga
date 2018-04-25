package packbarbestial;

public class Loro extends Karta {

	public Loro(String pKolore) {
		super(2, false, pKolore,4);
		setBota(new BotaIndarra());
	}

	@Override
	public void egikaritu() {
		
	}

}
