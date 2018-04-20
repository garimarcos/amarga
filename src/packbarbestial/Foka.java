package packbarbestial;

public class Foka extends Karta {

	public Foka() {
		super(6, false);
	}

	@Override
	public void egikaritu() {
		Karta[] k=Tableroa.getnTableroa().hartuKartak();
		int kop=Tableroa.getnTableroa().getKop();
		for(int i = 0; i < kop / 2; i++)
		{
		    Karta temp = k[i];
		    k[i] = k[kop - i - 1];
		    k[kop - i - 1] = temp;
		}
	}

}
