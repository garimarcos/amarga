package packbarbestial;

import java.util.ArrayList;
import java.util.Iterator;

public class Mahaia {
	private static Mahaia nMahaia=new Mahaia();
	private ArrayList<Karta> zerua;
	private ArrayList<Karta> inpernua;
	
	private Mahaia(){
		zerua=new ArrayList<Karta>();
		inpernua=new ArrayList<Karta>();
	}
	
	public static Mahaia getnMahaia(){
		return nMahaia;
	}
	
	public void hasieratu(String pEmail, String pKolore){
		sortuJokalariak(pEmail, pKolore);
	}
	
	private void sortuJokalariak(String pEmail, String pKolore){
		ListaJokalariak.getNireLista().add(new Jokalaria(pEmail,pKolore));
	}
	
	public String[] mahaiaPrestatu(){
		return ListaJokalariak.getNireLista().jokLortu(1).mahaiaPrestatu();
	}
	
	public void zerura(Karta pKarta){
		zerua.add(pKarta);
	}
	
	public void inpernura(Karta pKarta){
		inpernua.add(pKarta);
	}
	
	public int[] lortuPuntuak(){
		int[] puntuak=new int[4]; //0--> Jokalariaren karta kopurua 1--> Jokalariaren puntuak 2--> Ordenagailuaren karta kopurua 3--> Ordenagailuaren puntuak
		int i = 0;
		while(i<puntuak.length-1){
			puntuak[i]=0;
			i++;
		}
		String jokKolore = ListaJokalariak.getNireLista().jokLortu(1).getKolore();
		Iterator<Karta> itr = zerua.iterator();
		while(itr.hasNext()){
			Karta kar = itr.next();
			if(kar.getKolore().equals(jokKolore)){
				puntuak[0]++;
				puntuak[1]+=kar.puntuakLortu();
			}else{
				puntuak[2]++;
				puntuak[3]+=kar.puntuakLortu();
			}
		}
		return puntuak;
	}

}
