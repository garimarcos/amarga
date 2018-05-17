package packbarbestial;

import java.util.ArrayList;
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
		ArrayList<Karta> tximinoak=new ArrayList<Karta>();
		int i=0;
		while(itr.hasNext()){
			Karta kar=itr.next();
			if(kar.getIndarra()==4){
				Karta p = kar;
				tximinoak.add(p);
				i++;
			}
		}
		if(i>1) {
			bota(10);
			bota(11);
			Iterator<Karta> it=tximinoak.iterator();
			while(it.hasNext()){
				Karta txim=it.next();
				k.remove(txim);
				k.add(0,txim);
			}
			}
		
	}

}
