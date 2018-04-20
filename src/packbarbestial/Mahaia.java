package packbarbestial;

import java.util.ArrayList;

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
	
	public void hasieratu(String pIzen, String pKolore){
		sortuJokalariak(pIzen, pKolore);
	}
	
	private void sortuJokalariak(String pIzen, String pKolore){
		ListaJokalariak.getNireLista().add(new Jokalaria(pIzen,pKolore));
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

}
