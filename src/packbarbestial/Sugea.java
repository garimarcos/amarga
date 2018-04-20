package packbarbestial;

import java.util.Arrays;

public class Sugea extends Karta {

	public Sugea() {
		super(9, false);
	}

	@Override
	public void egikaritu() {
		Karta[] k=Tableroa.getnTableroa().hartuKartak();
		Arrays.sort(k);
	}


}
