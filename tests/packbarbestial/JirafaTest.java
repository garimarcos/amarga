package packbarbestial;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JirafaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEgikaritu() {
		//aurrekoa txikiagoa
		Tableroa.getnTableroa().setKartak(new ArrayList<Karta>());
		ArrayList<Karta> k =Tableroa.getnTableroa().hartuKartak();
		Tximino tx1=new Tximino("berdea");
		k.add(tx1);
		Loro l1=new Loro("urdina");
		k.add(l1);
		Jirafa j1=new Jirafa("urdina");
		k.add(j1);
		k.get(2).egikaritu();
		assertEquals(k.get(0),tx1);
		assertEquals(k.get(1),j1);
		assertEquals(k.get(2),l1);
		//aurrekoa handiagoa
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		k.add(l1);
		Krokodiloa kr1=new Krokodiloa("berdea");
		k.add(kr1);
		k.add(j1);
		k.get(2).egikaritu();
		assertEquals(k.get(0),l1);
		assertEquals(k.get(1),kr1);
		assertEquals(k.get(2),j1);
		//aurrekoa berdina
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		k.add(l1);
		Jirafa jirafaberria=new Jirafa("berdea");
		k.add(jirafaberria);
		k.add(j1);
		k.get(2).egikaritu();
		assertEquals(k.get(0),l1);
		assertEquals(k.get(1),jirafaberria);
		assertEquals(k.get(2),j1);
	}

	@Test
	public void testJirafa() {
		assertNotNull(new Jirafa("berdea"));
	}

}
