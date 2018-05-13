package packbarbestial;

import java.util.ArrayList;
import java.util.Collections;

public class Kameleoi extends Karta {
	
	private Karta state;
	

	public Kameleoi(int indarra,String pKolore) {
		super(5, false, pKolore,3);
		this.state=Factory.getnFactory().kartaSortu(indarra,pKolore);
	}

	public Kameleoi(String pKolore) {
		super(5, false, pKolore,3);
	}

	@Override
	public void egikaritu() {
		super.setIndarra(state.getIndarra());
		if(state.getIndarra()==8){
			ArrayList<Karta> k=Tableroa.getnTableroa().hartuKartak();
			int pos=k.indexOf(this);
			if(pos!=0){
				if(k.get(pos-1).getIndarra()<this.getIndarra()){
					Collections.swap(k, pos, pos-1);
				}
			}
		}
		else state.egikaritu();
		super.setIndarra(5);
	}
	
	
}
