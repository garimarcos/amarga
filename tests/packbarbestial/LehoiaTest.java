package packbarbestial;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LehoiaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEgikaritu() {
		//badago beste lehoi bat tableroan
		Tableroa.getnTableroa().setKartak(new ArrayList<Karta>());
		ArrayList<Karta> k =Tableroa.getnTableroa().hartuKartak();
		Lehoia leh1=new Lehoia("berdea");
		k.add(leh1);
		Loro lo1=new Loro("urdina");
		k.add(lo1);
		Foka fok1=new Foka("berdea");
		k.add(fok1);
		Lehoia lehberria=new Lehoia("urdina");
		k.add(lehberria);
		k.get(3).egikaritu();
		assertEquals(k.get(0),leh1);
		assertEquals(k.get(1),lo1);
		assertEquals(k.get(2),fok1);
		assertEquals(k.size(),3);
		
		//lehoi bakarra, ez dago tximinorik
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		k.add(lo1);
		k.add(fok1);
		k.add(leh1);
		k.get(2).egikaritu();
		assertEquals(k.get(0),leh1);
		assertEquals(k.get(1),lo1);
		assertEquals(k.get(2),fok1);
		assertEquals(k.size(),3);
		
		//lehoi bakarra, tximinoak daude
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		k.add(lo1);
		k.add(fok1);
		Tximino tx=new Tximino("berdea");
		k.add(tx);
		k.add(leh1);
		k.get(3).egikaritu();
		assertEquals(k.get(0),leh1);
		assertEquals(k.get(1),lo1);
		assertEquals(k.get(2),fok1);
		assertEquals(k.size(),3);
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		k.add(lo1);
		k.add(fok1);
		Tximino tx2=new Tximino("berdea");
		k.add(tx);
		k.add(tx2);
		k.add(leh1);
		k.get(4).egikaritu();
		assertEquals(k.get(0),leh1);
		assertEquals(k.get(1),lo1);
		assertEquals(k.get(2),fok1);
		assertEquals(k.size(),3);
		
	}
	
	@Test
	public void testLehoia() {
		assertNotNull(new Lehoia("berdea"));
	}

}
