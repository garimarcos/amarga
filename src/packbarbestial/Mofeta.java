package packbarbestial;

import java.util.ArrayList;

public class Mofeta extends Karta {

	public Mofeta(String pKolore) {
		super(1, false, pKolore);
		setBota(new BotaIndarra());
	}

	@Override
	public void egikaritu() {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
		int kont = 0;
		int indarmax = 12;
		boolean aurkituak = false;
		while (indarmax > 0 && !aurkituak){
			for (int j = 0; j < k.size(); j++){
				if (k.get(j).getIndarra() == indarmax){
					bota(indarmax);
					kont++;
					if (kont==2) aurkituak=true;
				}
			}
			indarmax--;
		}
	}
}
