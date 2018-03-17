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
		assertEquals(KartenBilera.getnKartenBilera().getURL(1,"urdina"),"https://i.imgur.com/VFYH0nl.png");
	}
	

}
