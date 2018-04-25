package packbarbestial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Tximino extends Karta {

	public Tximino(String pKolore) {
		super(4, false, pKolore,3);
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
			int non=k.indexOf(this);
			Karta ee=k.remove(non);
			k.add(0,ee);
			int s=k.size()-1;
			int pos=1;
			while(s>=0){
				if(k.get(s).getIndarra()==4){
					Karta kart=k.remove(s);
					k.add(pos,kart);
					pos++;
				}
				s--;
			}
		}
	}

}
