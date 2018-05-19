package packbarbestial;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KrokodiloTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEgikaritu() {
		//guztiak txikiagoak
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
		k.get(3).egikaritu();
		assertEquals(k.get(0),kr1);
		assertEquals(k.size(),1);
		
		//handiago bat aurkitu
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		k.add(tx1);
		k.add(l1);
		Hipopotamo h1 = new Hipopotamo("berdea");
		k.add(h1);
		k.add(f1);
		k.add(kr1);
		assertEquals(k.size(),5);
		k.get(4).egikaritu();
		assertEquals(k.get(0),tx1);
		assertEquals(k.get(1),l1);
		assertEquals(k.get(2),h1);
		assertEquals(k.get(3),kr1);
		assertEquals(k.size(),4);
		
		
	}

	@Test
	public void testKrokodiloa() {
		assertNotNull(new Krokodiloa("berdea"));
	}

}
