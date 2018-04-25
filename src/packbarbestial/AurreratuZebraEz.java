package packbarbestial;

import java.util.ArrayList;
import java.util.Iterator;

public class AurreratuZebraEz implements Aurreratu { //HIPOPOTAMO

	public AurreratuZebraEz() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aurreratu(int indarra) {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
		boolean gelditu=false;
		Karta kar=bilatu(indarra,k);
		while(!gelditu){
			int pos=k.indexOf(kar);
			if(pos!=0){
				if(k.get(pos-1).getIndarra()<indarra && k.get(pos-1).getIndarra()!=7){
					Karta temp=k.get(pos-1);
					k.set(pos-1, kar);
					k.set(pos, temp);
				}else gelditu=true;
			}else gelditu=true;
			pos--;
		}
	}

	private Karta bilatu(int ind,ArrayList<Karta> k){
		Iterator<Karta> itr=k.iterator();
		while(itr.hasNext()){
			Karta kar=itr.next();
			if(kar.getIndarra()==ind) return kar;
		}
		return null;
	}
}
