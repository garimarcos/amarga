package packbarbestial;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SugeaTest {

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
		Foka f1=new Foka("urdina");
		k.add(f1);
		Krokodiloa kr1 = new Krokodiloa("berdea");
		k.add(kr1);
		Sugea s1=new Sugea("urdina");
		k.add(s1);
		k.get(4).egikaritu();
		assertEquals(k.get(0),kr1);
		assertEquals(k.get(1),s1);
		assertEquals(k.get(2),f1);
		assertEquals(k.get(3),tx1);
		assertEquals(k.get(4),l1);
		
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		Sugea s2=new Sugea("urdina");
		k.add(s2);
		Zebra z1=new Zebra("berdea");
		k.add(z1);
		k.add(kr1);
		k.add(l1);
		k.add(s1);
		k.get(4).egikaritu();
		assertEquals(k.get(0),kr1);
		assertEquals(k.get(1),s2);
		assertEquals(k.get(2),s1);
		assertEquals(k.get(3),z1);
		assertEquals(k.get(4),l1);
	}

	@Test
	public void testSugea() {
		assertNotNull(new Sugea("berdea"));
	}

}
