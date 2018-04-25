package packbarbestial;

import java.util.ArrayList;
import java.util.Iterator;

public class Lehoia extends Karta {

	public Lehoia(String pKolore) {
		super(12,false, pKolore,2);
		setBota(new BotaIndarra());
		setAurreratu(new AurreratuIndarra());
	}

	@Override
	public void egikaritu() {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
		Iterator<Karta> itr=k.iterator();
		int i=0;
		Mahaia m=Mahaia.getnMahaia();
		while(itr.hasNext()){
			Karta kar=itr.next();
			if(kar.getIndarra()==12) i++;
		}
		if(i==1) bota(4);
		else{
			m.inpernura(this);
			k.remove(this);
		}
		aurreratu(12);
	}

}
