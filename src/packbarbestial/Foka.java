package packbarbestial;

import java.util.ArrayList;

public class Foka extends Karta {

	public Foka() {
		super(6, false);
	}

	@Override
	public void egikaritu() {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
		int kop=Tableroa.getnTableroa().getKop();
		for(int i = 0; i < kop / 2; i++)
		{
		    Karta temp = k.get(i);
		    k.set(i,k.get(kop-i-1));
		    k.set(kop-i-1, temp);
		}
	}

}
