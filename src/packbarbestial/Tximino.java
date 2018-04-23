package packbarbestial;

import java.util.ArrayList;
import java.util.Iterator;

public class Tximino extends Karta {

	public Tximino(String pKolore) {
		super(4, false, pKolore);
		setBota (new BotaIndarra());
		setAurreratu(new AurreratuIndarra());
	}

	@Override
	public void egikaritu() {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
		Iterator<Karta> itr=k.iterator();
		int i=0;
		while(itr.hasNext()){
			Karta kar=itr.next();
			if(kar.getIndarra()==4) i++;
		}
		if(i>1) {
			bota(10);
			bota(11);
			aurreratu(0);
			//lehenengoa jarri eta gainontzeko tximinoak bere atzean
		}
	}

}
