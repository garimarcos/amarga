package packbarbestial;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KameleoiTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEgikaritu() {
		//lehoi bihurtu
		Tableroa.getnTableroa().setKartak(new ArrayList<Karta>());
		ArrayList<Karta> k =Tableroa.getnTableroa().hartuKartak();
		Lehoia leh1=new Lehoia("berdea");
		k.add(leh1);
		Loro lo1=new Loro("urdina");
		k.add(lo1);
		Foka fok1=new Foka("berdea");
		k.add(fok1);
		Kameleoi kam1=new Kameleoi(12,"urdina");
		k.add(kam1);
		k.get(3).egikaritu();
		assertEquals(k.get(0),leh1);
		assertEquals(k.get(1),lo1);
		assertEquals(k.get(2),fok1);
		assertEquals(k.size(),3);
		
		//hipopotamo bihurtu
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		k.add(new Hipopotamo("berdea"));
		Tximino tx1=new Tximino("berdea");
		k.add(tx1);
		Kameleoi kam2=new Kameleoi(11,"urdina");
		k.add(kam2);
		k.get(2).egikaritu();
		assertEquals(k.get(2),tx1);
		assertEquals(k.get(1),kam2);
		
		//krokodilo bihurtu
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		k.add(new Krokodiloa("berdea"));
		k.add(tx1);
		k.add(lo1);
		Kameleoi kam3=new Kameleoi(10,"urdina");
		k.add(kam3);
		k.get(3).egikaritu();
		assertEquals(k.get(1),kam3);
		assertEquals(k.size(),2);
		//krokodilo bihurtu zebra bat badago
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		k.add(new Krokodiloa("berdea"));
		k.add(tx1);
		Zebra z1=new Zebra("urdina");
		k.add(z1);
		k.add(lo1);
		k.add(kam3);
		k.get(4).egikaritu();
		assertEquals(k.get(1),tx1);
		assertEquals(k.get(2),z1);
		assertEquals(k.get(3),kam3);
		assertEquals(k.size(),4);
		
		//suge bihurtu
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		Sugea s1=new Sugea("berdea");
		k.add(s1);
		k.add(z1);
		Hipopotamo h1=new Hipopotamo("berdea");
		k.add(h1);
		Kameleoi kam4=new Kameleoi (9,"urdina");
		k.add(kam4);
		k.get(3).egikaritu();
		assertEquals(k.get(0),h1);
		assertEquals(k.get(1),s1);
		assertEquals(k.get(2),kam4);
		assertEquals(k.get(3),z1);
		
		//jirafa bihurtu
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		Jirafa j1=new Jirafa("berdea");
		k.add(j1);
		k.add(z1);
		k.add(lo1);
		Kameleoi kam5=new Kameleoi (8,"urdina");
		k.add(kam5);
		k.get(3).egikaritu();
		assertEquals(k.get(0),j1);
		assertEquals(k.get(1),z1);
		assertEquals(k.get(2),kam5);
		assertEquals(k.get(3),lo1);
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		k.add(j1);
		k.add(h1);
		k.add(kam5);
		k.get(2).egikaritu();
		assertEquals(k.get(0),j1);
		assertEquals(k.get(1),h1);
		assertEquals(k.get(2),kam5); //Aurrekoa handiagoa bada ez du aurreratzen
		
		//foka bihurtu
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		k.add(fok1);
		k.add(z1);
		k.add(lo1);
		Kameleoi kam7=new Kameleoi (6,"urdina");
		k.add(kam7);
		k.get(3).egikaritu();
		assertEquals(k.get(0),kam7);
		assertEquals(k.get(1),lo1);
		assertEquals(k.get(2),z1);
		assertEquals(k.get(3),fok1);
		
		//kameleoi bihurtu
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		Kameleoi kam8=new Kameleoi (5,"urdina");
		k.add(kam8);
		Kameleoi kamberria=new Kameleoi (5,"urdina");
		k.add(kamberria);
		k.get(1).egikaritu();
		assertEquals(k.get(0),kam8);
		assertEquals(k.get(1),kamberria);

		//tximino bihurtu
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		k.add(s1);
		k.add(tx1);
		k.add(lo1);
		Kameleoi kam9=new Kameleoi (4,"urdina");
		k.add(kam9);
		k.get(3).egikaritu();
		assertEquals(k.get(0),kam9);
		assertEquals(k.get(1),tx1);
		assertEquals(k.get(2),s1);
		assertEquals(k.get(3),lo1);
		//tximino bihurtu hipo eta kroko egonda
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		k.add(h1);
		Krokodiloa kr1=new Krokodiloa("urdina");
		k.add(kr1);
		k.add(lo1);
		k.add(tx1);
		k.add(kam9);
		k.get(4).egikaritu();
		assertEquals(k.get(0),kam9);
		assertEquals(k.get(1),tx1);
		assertEquals(k.get(2),lo1);
		assertEquals(k.size(),3);
		
		//mofeta bihurtu
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		Mofeta mof1=new Mofeta("urdina");
		k.add(mof1);
		k.add(kr1);
		k.add(tx1);
		k.add(h1);
		Kameleoi kam10=new Kameleoi (1,"urdina");
		k.add(kam10);
		k.get(4).egikaritu();
		assertEquals(k.get(0),mof1);
		assertEquals(k.get(1),tx1);
		assertEquals(k.get(2),kam10);
		assertEquals(k.size(),3);
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		k.add(mof1);
		k.add(h1);
		k.add(tx1);
		k.add(h1);
		k.add(kam10);
		k.get(4).egikaritu();
		assertEquals(k.get(0),mof1);
		assertEquals(k.get(1),kam10);
		assertEquals(k.size(),2);
		//tableroan mofetak bakarrik daude
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		k.add(kam10);
		k.get(0).egikaritu();
		assertEquals(k.get(0),kam10);
		assertEquals(k.size(),1);
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		k.add(mof1);
		k.add(kam10);
		k.get(1).egikaritu();
		assertEquals(k.get(0),mof1);
		assertEquals(k.get(1),kam10);
		assertEquals(k.size(),2);
		//tableroan mofetak eta beste animalia bat bakarrik 
		k.clear();
		k = Tableroa.getnTableroa().hartuKartak();
		k.add(mof1);
		k.add(lo1);
		k.add(kam10);
		k.get(2).egikaritu();
		assertEquals(k.get(0),mof1);
		assertEquals(k.get(1),kam10);
		assertEquals(k.size(),2);
	}
	
	@Test
	public void testKameleoi() {
		assertNotNull(new Kameleoi("berdea"));
	}

}
