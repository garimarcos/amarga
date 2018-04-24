package packbarbestial;

import java.util.ArrayList;
import java.util.Iterator;

public class BotaIndarraGutxiago implements Bota {

	public BotaIndarraGutxiago() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bota(int indarra) {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
		Mahaia m=Mahaia.getnMahaia();
		Iterator<Karta> it=k.iterator();
		while(it.hasNext()){
			Karta kar=it.next();
			if(kar.getIndarra()<indarra && kar.getIndarra()!=7){
				m.inpernura(kar);
				it.remove();
			}
		}

	}

}
