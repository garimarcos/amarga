package packbarbestial;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TableroaTest {
	
	private Tableroa t = Tableroa.getnTableroa();
	private ListaJokalariak l = ListaJokalariak.getNireLista();
	private Jokoa j = Jokoa.getnJokoa();

	@Test
	public void testHartuKartak() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetnTableroa() {
		assertNotNull(t);
	}

	@Test
	public void testGehituKarta() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetKop() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnimaladakGauzatu() {
		l.add(new Jokalaria("gari","berdea"));
		j.ordenagailuaSortu();
		l.jokLortu(2).addEskuan(0,new Tximino("urdina"));
		ArrayList<Karta> k =new ArrayList<Karta>();
		k.add(new Tximino("berdea"));
		t.setKartak(k);
		j.botaOrdenagailua();
		t.animaladakGauzatu(4, 2);
	}

	@Test
	public void testAmaituta() {
		fail("Not yet implemented");
	}

	@Test
	public void testKanporatu() {
		fail("Not yet implemented");
	}

	@Test
	public void testAurreratu() {
		fail("Not yet implemented");
	}

	@Test
	public void testIndarrakLortu() {
		fail("Not yet implemented");
	}

}
