package packbarbestial;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FokaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEgikaritu() {
		Tableroa.getnTableroa().setKartak(new ArrayList<Karta>());
		ArrayList<Karta> k =Tableroa.getnTableroa().hartuKartak();
		Tximino tx1=new Tximino("berdea");
		k.add(tx1);
		Loro l1=new Loro("urdina");
		k.add(l1);
		Hipopotamo h1 = new Hipopotamo("berdea");
		k.add(h1);
		Foka f1=new Foka("urdina");
		k.add(f1);
		k.get(3).egikaritu();
		assertEquals(k.get(0),f1);
		assertEquals(k.get(1),h1);
		assertEquals(k.get(2),l1);
		assertEquals(k.get(3),tx1);
		assertEquals(k.size(),4);
	}

	@Test
	public void testFoka() {
		assertNotNull(new Foka("berdea"));
	}

}
