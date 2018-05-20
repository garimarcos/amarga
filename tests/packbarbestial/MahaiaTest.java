package packbarbestial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class MahaiaTest {
	
	@After
	public void tearDown(){
		ListaJokalariak.getNireLista().clear();
		Mahaia.getnMahaia().getZerua().clear();
	}
	
	@Test
	public void testGetnMahaia() {
		assertNotNull(Mahaia.getnMahaia());
	}

	@Test
	public void testHasieratu() {
		Mahaia.getnMahaia().hasieratu("ari@1d.com", "horia");
		assertNotNull(ListaJokalariak.getNireLista().jokLortu(1));
		assertEquals(ListaJokalariak.getNireLista().getKop(),1);
	}
	
	@Test
	public void testZerura() {
		Lehoia l = new Lehoia("berdea");
		Tximino tx1 = new Tximino("horia");
		Mahaia.getnMahaia().zerura(l);
		Mahaia.getnMahaia().zerura(tx1);
		assertNotNull(Mahaia.getnMahaia().getZerua());
		assertEquals(Mahaia.getnMahaia().getZerua().size(),2);
	}
	
	@Test
	public void testLortuPuntuak() {
		Mahaia.getnMahaia().zerura(new Lehoia("berdea"));
		Mahaia.getnMahaia().zerura(new Tximino("horia"));
		Mahaia.getnMahaia().zerura(new Tximino("urdina"));
		Mahaia.getnMahaia().zerura(new Foka("berdea"));
		Mahaia.getnMahaia().zerura(new Hipopotamo("gorria"));
		Mahaia.getnMahaia().hasieratu("pepe@tw.com", "urdina");
		assertEquals(ListaJokalariak.getNireLista().getKop(),1);
		//jokalari urdina
		int[] puntuak=Mahaia.getnMahaia().lortuPuntuak();
		assertEquals(puntuak[0],1);
		assertEquals(puntuak[1],3);
		//jokalari gorria
		ListaJokalariak.getNireLista().clear();
		Mahaia.getnMahaia().hasieratu("mari@carmen.com", "gorria");
		puntuak=Mahaia.getnMahaia().lortuPuntuak();
		assertEquals(puntuak[0],1);
		assertEquals(puntuak[1],2);
		//jokalari berdea
		ListaJokalariak.getNireLista().clear();
		Mahaia.getnMahaia().hasieratu("juan@antonio.com", "berdea");
		puntuak=Mahaia.getnMahaia().lortuPuntuak();
		assertEquals(puntuak[0],2);
		assertEquals(puntuak[1],4);
		//jokalari horia
		ListaJokalariak.getNireLista().clear();
		Mahaia.getnMahaia().hasieratu("ana@war.com", "horia");
		puntuak=Mahaia.getnMahaia().lortuPuntuak();
		assertEquals(puntuak[0],1);
		assertEquals(puntuak[1],3);
	}

}
