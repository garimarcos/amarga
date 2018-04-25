package packbarbestial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BotaIndarraGutxiago implements Bota {

	public BotaIndarraGutxiago() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bota(int indarra) {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
		Mahaia m=Mahaia.getnMahaia();
		boolean irten=false;
		ArrayList<Karta> alderantziz=k;
		Collections.reverse(alderantziz);
		Iterator<Karta> it=alderantziz.iterator();
		Karta kar;
		kar = it.next();
		while(it.hasNext() && !irten){
			kar=it.next();
			if(kar.getIndarra()<indarra && kar.getIndarra()!=7){
				m.inpernura(kar);
				it.remove();
			}else irten=true;
		}
		Collections.reverse(alderantziz);
		k=alderantziz;
	}
	
//	private boolean bilatuPos(int indarra,ArrayList<Karta> k){
//		int i=k.size()-1;
//		if(k.get(i).getIndarra()==11) return true;
//		return false;
//	}

}
