package packbarbestial;

public abstract class Karta implements Comparable<Karta> {

	private int indarra;
	private boolean errekurrente;
	private Bota b;
	private Aurreratu a;
	
	public Karta(int pIndarra, boolean pErrekurrente){
		this.indarra=pIndarra;
		this.errekurrente=pErrekurrente;
	}
	
	@Override
	public int compareTo(Karta o) {
		if(this.indarra<o.indarra) return -1;
		else if(this.indarra>o.indarra) return 1;
		return 0;
	}
	
	public abstract void egikaritu();
	
	public int getIndarra(){
		return indarra;
	}
	
	public boolean errekurrenteaDa(){ return errekurrente; }
	
	
}
