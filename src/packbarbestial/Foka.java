package packbarbestial;

import java.util.ArrayList;
import java.util.Collections;

public class Foka extends Karta {
	

	public Foka(String pKolore) {
		super(6, false,pKolore,2);
	}

	@Override
	public void egikaritu() {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
		Collections.reverse(k);
	}

}
