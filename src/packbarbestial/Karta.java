package packbarbestial;

public abstract class Karta {

	private int indarra;
	private boolean errekurrente;
	
	public Karta(int pIndarra, boolean pErrekurrente){
		this.indarra=pIndarra;
		this.errekurrente=pErrekurrente;
	}
	
	public abstract void egikaritu();
	
	public int getIndarra(){
		return indarra;
	}
	
	
}
