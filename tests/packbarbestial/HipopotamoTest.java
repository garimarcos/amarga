package packbarbestial;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HipopotamoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEgikaritu() {
		//txikiagoak guztiak
		Tableroa.getnTableroa().setKartak(new ArrayList<Karta>());
		ArrayList<Karta> k =Tableroa.getnTableroa().hartuKartak();
		Tximino tx1=new Tximino("berdea");
		k.add(tx1);
		Loro l1=new Loro("urdina");
		k.add(l1);
		Foka f1=new Foka("urdina");
		k.add(f1);
		Hipopotamo h1 = new Hipopotamo("berdea");
		k.add(h1);
		k.get(3).egikaritu();
		assertEquals(k.get(0),h1);
		assertEquals(k.get(1),tx1);
		assertEquals(k.get(2),l1);
		assertEquals(k.get(3),f1);
		assertEquals(k.size(),4);
		
		//handiagoak eta txikiagoak
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		k.add(tx1);
		Lehoia leh1=new Lehoia("berdea");
		k.add(leh1);
		k.add(f1);
		k.add(h1);
		k.get(3).egikaritu();
		assertEquals(k.get(0),tx1);
		assertEquals(k.get(1),leh1);
		assertEquals(k.get(2),h1);
		assertEquals(k.get(3),f1);
		assertEquals(k.size(),4);
		
		//zebra
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		k.add(tx1);
		Zebra z1=new Zebra("berdea");
		k.add(z1);
		k.add(f1);
		k.add(h1);
		k.get(3).egikaritu();
		assertEquals(k.get(0),tx1);
		assertEquals(k.get(1),z1);
		assertEquals(k.get(2),h1);
		assertEquals(k.get(3),f1);
		assertEquals(k.size(),4);
		
		//beste hipopotamo bat
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		k.add(tx1);
		Hipopotamo hipoberria=new Hipopotamo("berdea");
		k.add(hipoberria);
		k.add(f1);
		k.add(h1);
		k.get(3).egikaritu();
		assertEquals(k.get(0),tx1);
		assertEquals(k.get(1),hipoberria);
		assertEquals(k.get(2),h1);
		assertEquals(k.get(3),f1);
		assertEquals(k.size(),4);
	}

	@Test
	public void testHipopotamo() {
		assertNotNull(new Hipopotamo("berdea"));
	}

}
