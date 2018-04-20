package packbarbestial;

import java.util.ArrayList;
import java.util.Iterator;


public class BotaIndarra implements Bota {

	public BotaIndarra() {
	}

	@Override
	public void bota(int indarra) {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
		Mahaia m=Mahaia.getnMahaia();
		Iterator<Karta> it=k.iterator();
		while(it.hasNext()){
			Karta kar=it.next();
			if(kar.getIndarra()==indarra){
				m.inpernura(kar);
				k.remove(kar);
			}
		}
	}

}
