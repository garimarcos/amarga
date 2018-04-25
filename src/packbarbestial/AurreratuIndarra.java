package packbarbestial;

import java.util.ArrayList;
import java.util.Iterator;

public class AurreratuIndarra implements Aurreratu { //BESTE GUZTIAK (Aurreratu behar dutenak)

	public AurreratuIndarra() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aurreratu(int indarra) {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
		if(indarra==12){
			Karta kar=bilatu(indarra,k);
			k.remove(kar); 
			k.add(0, kar);
		}
		else{
			Karta kar=bilatu(indarra,k);
			int pos=k.indexOf(kar);
			if(pos!=0){
				if(k.get(pos-1).getIndarra()<indarra){
					Karta temp=k.get(pos-1);
					k.set(pos-1, kar);
					k.set(pos, temp);
				}
			}
			
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