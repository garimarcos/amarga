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
		int maxOne = 0;
        int maxTwo = 0;
        for(Karta n:k){
            if(maxOne < n.getIndarra()){
                maxTwo = maxOne;
                maxOne =n.getIndarra();
            } else if(maxTwo < n.getIndarra()){
                maxTwo = n.getIndarra();
            }
        }
        bota(maxOne);
        bota(maxTwo);
	}
	

}
