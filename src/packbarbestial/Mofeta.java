package packbarbestial;

import java.util.ArrayList;

public class Mofeta extends Karta {

	public Mofeta(String pKolore) {
		super(1, false, pKolore,4);
		setBota(new BotaIndarra());
	}

	@Override
	public void egikaritu() {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
//		 int maxOne = 0;
//	        int maxTwo = 0;
//	        for(Karta n:k){
//	            if(maxOne < n.getIndarra()){
//	                maxTwo = maxOne;
//	                maxOne =n.getIndarra();
//	            } else if(maxTwo < n.getIndarra()){
//	                maxTwo = n.getIndarra();
//	            }
//	        }
//	        bota(maxOne);
//	        bota(maxTwo);
		int kont = 0;
		int indarmax = 12;
		boolean aurkituak = false;
		while (indarmax > 0 && !aurkituak){
			for (int j = 0; j < k.size(); j++){
				if (k.get(j).getIndarra() == indarmax && indarmax!=1){
					bota(indarmax);
					kont++;
					if (kont==2) aurkituak=true;
				}
			}
			indarmax--;
		}
	}
}
