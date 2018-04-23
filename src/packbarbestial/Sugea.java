package packbarbestial;

import java.util.ArrayList;
import java.util.Collections;

public class Sugea extends Karta {

	public Sugea(String pKolore) {
		super(9, false, pKolore);
	}

	@Override
	public void egikaritu() {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
		Collections.sort(k,Collections.reverseOrder());
	}


}
