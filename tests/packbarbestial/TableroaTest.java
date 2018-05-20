package packbarbestial;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

public class TableroaTest {
	
	private Tableroa t = Tableroa.getnTableroa();
	private ListaJokalariak l = ListaJokalariak.getNireLista();
	private Jokoa j = Jokoa.getnJokoa();
	
	@After
	public void tearDown(){
		t.clear();
		l.clear();
		Mahaia.getnMahaia().getZerua().clear();
	}

	@Test
	public void testHartuKartak() {
		t.gehituKarta(new Loro("berdea"));
		t.gehituKarta(new Foka("gorria"));
		assertNotNull(t.hartuKartak());
	}

	@Test
	public void testGetnTableroa() {
		assertNotNull(t);
	}

	@Test
	public void testGehituKarta() {
		t.gehituKarta(new Loro("berdea"));
		t.gehituKarta(new Foka("gorria"));
		assertEquals(t.getKop(),2);
	}

	@Test
	public void testAnimaladakGauzatu() {
		Foka f = new Foka("horia");
		Mofeta m = new Mofeta("gorria");
		Loro l = new Loro("horia");
		Tximino tx = new Tximino("berdea");
		t.gehituKarta(m);
		t.gehituKarta(l);
		t.gehituKarta(tx);
		t.gehituKarta(f);
		t.animaladakGauzatu(6, 2);
		ArrayList<Karta> k = t.hartuKartak();
		assertEquals(k.get(0),f);
		assertEquals(k.get(1),tx);
		assertEquals(k.get(2),l);
		assertEquals(k.get(3),m);
		Zebra z = new Zebra("berdea");
		t.gehituKarta(z);
		t.animaladakGauzatu(7, 2);
		k = t.hartuKartak();
		assertEquals(k.size(),2);
		assertEquals(k.get(0),l);
		assertEquals(k.get(1),m);
	}

	@Test
	public void testAmaituta() {
		Jokalaria jok1=new Jokalaria("ariane","zuria");
		Jokalaria jok2=new Jokalaria("amaia","marroia");
		l.add(jok1);
		l.add(jok2);
		assertEquals(t.amaituta(),true);
		jok1.setKolore("berdea");
		assertEquals(t.amaituta(),false);
	}

	@Test
	public void testKanporatu() {
		Foka f = new Foka("horia");
		Mofeta m = new Mofeta("gorria");
		Loro l = new Loro("horia");
		Tximino tx = new Tximino("berdea");
		Zebra z = new Zebra("berdea");
		t.gehituKarta(f);
		t.gehituKarta(m);
		t.gehituKarta(l);
		t.gehituKarta(tx);
		t.gehituKarta(z);
		assertEquals(t.getKop(),5);
		t.kanporatu(2);
		ArrayList<Karta> k = t.hartuKartak();
		assertEquals(t.getKop(),4);
		assertEquals(k.get(0),f);
		assertEquals(k.get(1),l);
		assertEquals(k.get(2),tx);
		assertEquals(k.get(3),z);
	}

	@Test
	public void testAurreratu() {
		Foka f = new Foka("horia");
		Mofeta m = new Mofeta("gorria");
		Loro l = new Loro("horia");
		t.gehituKarta(f);
		t.gehituKarta(m);
		t.gehituKarta(l);
		ArrayList<Karta> k = t.hartuKartak();
		assertEquals(k.get(1),m);
		assertEquals(k.get(2),l);
		t.aurreratu(1);
		k = t.hartuKartak();
		assertEquals(k.get(1),l);
		assertEquals(k.get(2),m);
		t.aurreratu(2);
		assertEquals(k.get(0),m);
		assertEquals(k.get(1),f);
		assertEquals(k.get(2),l);
		
	}

	@Test
	public void testIndarrakLortu() {
		Foka f = new Foka("horia");
		Mofeta m = new Mofeta("gorria");
		Loro l = new Loro("horia");
		t.gehituKarta(f);
		t.gehituKarta(m);
		t.gehituKarta(l);
		int[] indarrak = t.indarrakLortu();
		assertEquals(indarrak[0],6);
		assertEquals(indarrak[1],1);
		assertEquals(indarrak[2],2);
	}

}
