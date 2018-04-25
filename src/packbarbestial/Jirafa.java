package packbarbestial;

import java.util.ArrayList;
import java.util.Collections;

public class Jirafa extends Karta{
	
	public Jirafa(String pKolore){
		super(8,true, pKolore,3);
		setAurreratu(new AurreratuIndarra());
	}

	@Override
	public void egikaritu() {
		ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
		int pos=k.indexOf(this);
		if(pos!=0){
			if(k.get(pos-1).getIndarra()<this.getIndarra()){
				Collections.swap(k, pos, pos-1);
			}
		}
	}
}
