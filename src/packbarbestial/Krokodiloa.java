package packbarbestial;

public class Krokodiloa extends Karta {

	public Krokodiloa(String pKolore) {
		super(10, true, pKolore,3);
		setBota(new BotaIndarraGutxiago());
	}

	@Override
	public void egikaritu() {
		bota(10);		
	}

}
