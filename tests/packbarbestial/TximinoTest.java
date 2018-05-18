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
		/** 2 tximino, hipo edo kroko daude */
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
		assertEquals(k.size(),2);
		
		/** 2 tximino, hipo edo kroko ez daude */
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		k.add(tx1);
		Loro l=new Loro("berdea");
		k.add(l);
		k.add(tx2);
		k.get(2).egikaritu();
		assertEquals(k.get(0),tx2);
		assertEquals(k.get(1),tx1);
		assertEquals(k.get(2),l);
		assertEquals(k.size(),3);
		
		/**tximino bakarra*/
		k.clear();
		k =Tableroa.getnTableroa().hartuKartak();
		k.add(l);
		k.add(tx2);
		k.get(1).egikaritu();
		assertEquals(k.get(0),l);
		assertEquals(k.get(1),tx2);
		assertEquals(k.size(),2);
	}

	@Test
	public void testTximino() {
		assertNotNull(new Tximino("berdea"));
	}

}
