package packbarbestial;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MofetaTest {

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
		Tximino tx2=new Tximino("urdina");
		k.add(tx2);
		Loro l1=new Loro("urdina");
		k.add(l1);
		Jirafa j1=new Jirafa("urdina");
		k.add(j1);
		Mofeta m1=new Mofeta("urdina");
		k.add(m1);
		assertEquals(k.size(),5);
		k.get(4).egikaritu();
		assertEquals(k.get(0),l1);
		assertEquals(k.get(1),m1);
		assertEquals(k.size(),2);
		
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		k.add(l1);
		Krokodiloa kr1=new Krokodiloa("berdea");
		k.add(kr1);
		k.add(j1);
		k.add(m1);
		assertEquals(k.size(),4);
		k.get(3).egikaritu();
		assertEquals(k.get(0),l1);
		assertEquals(k.get(1),m1);
		assertEquals(k.size(),2);
		
		//tableroan mofetak bakarrik
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		k.add(m1);
		assertEquals(k.size(),1);
		k.get(0).egikaritu();
		assertEquals(k.get(0),m1);
		assertEquals(k.size(),1);
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		Mofeta mofetaberria=new Mofeta("urdina");
		k.add(mofetaberria);
		k.add(m1);
		assertEquals(k.size(),2);
		k.get(1).egikaritu();
		assertEquals(k.get(0),mofetaberria);
		assertEquals(k.get(1),m1);
		assertEquals(k.size(),2);
		
		//tableroan mofetak eta beste animalia bat bakarrik 
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		Lehoia leh1=new Lehoia("urdina");
		k.add(leh1);
		k.add(mofetaberria);
		k.add(m1);
		assertEquals(k.size(),3);
		k.get(2).egikaritu();
		assertEquals(k.get(0),mofetaberria);
		assertEquals(k.get(1),m1);
		assertEquals(k.size(),2);
	}

	@Test
	public void testMofeta() {
		assertNotNull(new Mofeta("berdea"));
	}

}
