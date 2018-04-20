package packbarbestial;

public class Kameleoi extends Karta {
	
	private Karta state;
	

	public Kameleoi(int indarra) {
		super(5, false);
		this.state=Factory.getnFactory().kartaSortu(indarra);
	}

	public Kameleoi() {
		super(5, false);
	}

	@Override
	public void egikaritu() {
		state.egikaritu();

	}

}
