package packbarbestial;

public class Mahaia {
	private static Mahaia nMahaia=new Mahaia();
	
	private Mahaia(){
		
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
		ListaJokalariak.getNireLista().jokLortu(1).hasieratu();
		return ListaJokalariak.getNireLista().jokLortu(1).mahaiaPrestatu();
	}

}
