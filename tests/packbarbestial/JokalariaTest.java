package packbarbestial;

import static org.junit.Assert.*;

import org.junit.Test;

public class JokalariaTest {
	
	private Jokalaria j1=new Jokalaria("Ariane","beltza");

	@Test
	public void testJokalaria() {
		assertNotNull(j1);
	}

	@Test
	public void testHasieratu() {
		j1.hasieratu();
	}

}
