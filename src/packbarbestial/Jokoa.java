package packbarbestial;

import java.util.Observer;

public class Jokoa {

	private Mahaia m=Mahaia.getnMahaia();
	private ListaJokalariak l=ListaJokalariak.getNireLista();
	private Tableroa t=Tableroa.getnTableroa();
	private KartenBilera k=KartenBilera.getnKartenBilera();

	private static Jokoa nJokoa=new Jokoa();

	private Jokoa() {
	}
	
	public void addObserver(Observer o){
		t.addObserver(o);
	}
	
	public static Jokoa getnJokoa(){
		return nJokoa;
	}
	
	public String[] mahaiaPrestatu(){
		return m.mahaiaPrestatu();
	}
	
	public int bota(int pPosizioa){
		return l.jokLortu(1).bota(pPosizioa);
	}
	
	public int[] hartu(){
		return l.jokLortu(1).hartu();
	}
	
	public String getUrl(int indarra,int jok){
		return k.getURL(indarra, l.jokLortu(jok).getKolore());
	}
	
	public void gehituTablerora(Karta pKarta){
		t.gehituKarta(pKarta);
	}
	
	public int getTableroKop(){ return t.getKop(); }
	
	public void ordenagailuaSortu(){
		String jokKolore=l.jokLortu(1).getKolore();
		String ordKolore="";
		if(jokKolore.equalsIgnoreCase("urdina")) ordKolore="berdea";
		else ordKolore="urdina";
		l.add(new Jokalaria("ordenagailua",ordKolore));
		//System.out.println(l.jokLortu(2).getKolore());
	}
	
	public void animaladakGauzatu(int indarra,int jok){
		t.animaladakGauzatu(indarra, jok);
	}
	
	public String getKartaUrl(int pIndarra,int pKolore){
		if(pKolore==0) return KartenBilera.getnKartenBilera().getURL(pIndarra, "berdea");
		else return KartenBilera.getnKartenBilera().getURL(pIndarra, "urdina");
	}
	
	public int botaOrdenagailua(){
		return l.jokLortu(2).botaOrd();
	}
	
	public void addJokalaria(String pIzen, String pKolore){
		ListaJokalariak.getNireLista().add(new Jokalaria(pIzen,pKolore));
	}
}
