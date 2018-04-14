package packbarbestial;

import java.util.Stack;

public class Mazo{
	
	private Stack<Karta> mazo;

	public Mazo() {
		mazo=new Stack<Karta>();
	}
	
	public Karta pop(){
		return mazo.pop();
	}

	public void add(Karta kartaSortu) {
		mazo.add(kartaSortu);		
	}
	
	public int size(){
		return mazo.size();
	}

}
