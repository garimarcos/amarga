package packbarbestial;

import static org.junit.Assert.*;

import org.junit.Test;

public class KartenBileraTest {

	@Test
	public void testGetnKartenBilera() {
		assertNotNull(KartenBilera.getnKartenBilera());
	}

	@Test
	public void testGetURLUrdina() {
		assertEquals(KartenBilera.getnKartenBilera().getURL(1,"urdina"),"img/urdina1.png");
	}
	
	@Test
	public void testGetURLBerdea() {
		assertEquals(KartenBilera.getnKartenBilera().getURL(3,"berdea"),"img/berdea3.png");
	}
	
	@Test
	public void testGetURLHoria() {
		assertEquals(KartenBilera.getnKartenBilera().getURL(7,"horia"),"img/horia7.png");
	}
	
	@Test
	public void testGetURLGorria() {
		assertEquals(KartenBilera.getnKartenBilera().getURL(11,"gorria"),"img/gorria11.png");
	}
	
}
