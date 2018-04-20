package packbarbestial;

import java.util.ArrayList;
import java.util.Collections;

public class Sugea extends Karta {

	public Sugea() {
		super(9, false);
	}

	@Override
	public void egikaritu() {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
		Collections.sort(k,Collections.reverseOrder());
	}


}
