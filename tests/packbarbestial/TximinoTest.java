package packbarbestial;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TximinoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEgikaritu() {
		/** 2 tximino */
		Tableroa.getnTableroa().setKartak(new ArrayList<Karta>());
		ArrayList<Karta> k =Tableroa.getnTableroa().hartuKartak();
		k.add(new Hipopotamo("berdea"));
		Tximino tx1=new Tximino("berdea");
		k.add(tx1);
		Tximino tx2=new Tximino("urdina");
		k.add(tx2);
		k.get(2).egikaritu();
		assertEquals(k.get(0),tx2);
		assertEquals(k.get(1),tx1);
	}

	@Test
	public void testTximino() {
		assertNotNull(new Tximino("berdea"));
	}

}
