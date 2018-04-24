package packbarbestial;

public class Krokodiloa extends Karta {

	public Krokodiloa(String pKolore) {
		super(10, true, pKolore);
		setBota(new BotaIndarraGutxiago());
	}

	@Override
	public void egikaritu() {
		bota(10);		
	}

}
