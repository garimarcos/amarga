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
		Jokalaria j1 = new Jokalaria("amaia","laranja");
		ListaJokalariak.getNireLista().add(j1);
		assertEquals(ListaJokalariak.getNireLista().jokLortu(1),j1);
	}

	@Test
	public void testJokLortu() {
		ListaJokalariak.getNireLista().add(new Jokalaria("amaia","laranja"));
		assertNotNull(ListaJokalariak.getNireLista().jokLortu(1));
	}
	
	@Test
	public void testClear() {
		ListaJokalariak.getNireLista().clear();
		assertTrue(ListaJokalariak.getNireLista().getKop()==0);
		assertTrue(ListaJokalariak.getNireLista().getKop()==1);
	}

}
