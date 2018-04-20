package packbarbestial;

public class Jokoa {

	private Mahaia m=Mahaia.getnMahaia();
	private ListaJokalariak l=ListaJokalariak.getNireLista();
	private Tableroa t=Tableroa.getnTableroa();
	private KartenBilera k=KartenBilera.getnKartenBilera();

	private static Jokoa nJokoa=new Jokoa();

	private Jokoa() {
		
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
	
	public String getUrl(int indarra){
		return k.getURL(indarra, l.jokLortu(1).getKolore());
	}
	
	public void gehituTablerora(int indarra){
		t.gehituKarta(indarra);
	}
	
	public int getTableroKop(){ return t.getKop(); }
	
	public void ordenagailuaSortu(){
		String jokKolore=l.jokLortu(1).getKolore();
		String ordKolore="";
		if(jokKolore.equals("urdina")) ordKolore="berdea";
		else ordKolore="urdina";
		l.add(new Jokalaria("ordenagailua",ordKolore));
		//System.out.println(l.jokLortu(2).getKolore());
	}
	
	public void animaladakGauzatu(Karta pKarta){
		t.animaladakGauzatu(pKarta);
	}
	
	public void botaOrdenagailua(){
		l.jokLortu(2).bota(0);
	}
}
