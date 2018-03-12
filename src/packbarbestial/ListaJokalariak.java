package packbarbestial;

import java.util.ArrayList;

public class ListaJokalariak {
	private static ListaJokalariak nireLista=new ListaJokalariak();
	private ArrayList<Jokalaria> lista;
	
	private ListaJokalariak(){
		this.lista=new ArrayList<Jokalaria>();
	}
	
	public static ListaJokalariak getNireLista(){
		return nireLista;
	}
	
	public void add(Jokalaria pJokalaria){
		this.lista.add(pJokalaria);
	}

}
