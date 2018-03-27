package packbarbestial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class ListaJokalariakTest {
	
	@After
	public void tearDown(){
		ListaJokalariak.getNireLista().clear();
	}

	@Test
	public void testGetNireLista() {
		assertNotNull(ListaJokalariak.getNireLista());
	}

	@Test
	public void testAdd() {
		ListaJokalariak.getNireLista().add(new Jokalaria("amaia","laranja"));
		assertTrue(ListaJokalariak.getNireLista().getKop()==1);
	}

	@Test
	public void testJokLortu() {
		ListaJokalariak.getNireLista().add(new Jokalaria("amaia","laranja"));
		assertNotNull(ListaJokalariak.getNireLista().jokLortu(1));
	}

	@Test
	public void testSetKop() {
		ListaJokalariak.getNireLista().setKop(3);
		assertTrue(ListaJokalariak.getNireLista().getKop()==3);
		assertFalse(ListaJokalariak.getNireLista().getKop()==1);
		ListaJokalariak.getNireLista().clear();
	}

	@Test
	public void testGetKop() {
		assertTrue(ListaJokalariak.getNireLista().getKop()==0);
		assertFalse(ListaJokalariak.getNireLista().getKop()==1);
	}

}
