package packbarbestial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

public class Tableroa extends Observable{
	
	private static Tableroa nTableroa=new Tableroa();
	private ArrayList<Karta> kartak;

	private Tableroa() {
		kartak=new ArrayList<Karta>();
	}
	
	public ArrayList<Karta> hartuKartak(){ return kartak; }
	
	public static Tableroa getnTableroa(){
		return nTableroa;
	}
	
	public void gehituKarta(Karta pKarta){
		kartak.add(pKarta);
	}
	
	public int getKop(){ return kartak.size(); }
	
	public void animaladakGauzatu(int indarra, int jok){
		//Karta k=ListaJokalariak.getNireLista().jokLortu(jok);
		int q=kartak.size()-1;
		Karta k=kartak.get(q);
		kartak.get(kartak.size()-1).egikaritu();
//		while(q>=0){
//			if(kartak.get(q).errekurrenteaDa() && !kartak.get(q).equals(k)) kartak.get(q).egikaritu();
//			q--;
//		}
		if(kartak.size()==5){
			Mahaia m=Mahaia.getnMahaia();
			m.inpernura(kartak.get(kartak.size()-1));
			kartak.remove(kartak.size()-1);
			int i=0;
			while(i<2){
				m.zerura(kartak.get(0));
				kartak.remove(0);
				i++;
			}
		}
		egoeraAldatua(kartak);
	}
	
	public void kanporatu(int pPosizioa) throws IndexOutOfBoundsException{
		if(kartak.get(pPosizioa)!=null)Mahaia.getnMahaia().inpernura(kartak.remove(pPosizioa-1));
	}
	
	public void aurreratu(int pKopuru){
		int pPosizioa=kartak.size()-1;
		if(pKopuru==1) Collections.swap(kartak, pPosizioa, pPosizioa-1);
		else if(pKopuru==2){
			Collections.swap(kartak, pPosizioa, pPosizioa-1);
			Collections.swap(kartak, pPosizioa-1, pPosizioa-2);
		}
	}
	
	private void egoeraAldatua(ArrayList<Karta> k){
		ArrayList<Integer> kartak = new ArrayList<Integer>(); //posizio bikoitiak = indarra
									//posizio bakoitiak = kolorea --> 0=berdea 1=urdina
		int i = 0;
		int j = 0;
		while (j < k.size()){
			kartak.add(k.get(j).getIndarra());
			if(k.get(j).getKolore().equalsIgnoreCase("berdea")) kartak.add(0);
			else kartak.add(1);
			j++;
			i=i+2;
		}
		setChanged();
		notifyObservers(kartak);
	}
	
}
