package packbarbestial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class JokalariaTest {
	
	private Jokalaria j1=new Jokalaria("Ariane","berdea");
	
	@After
	public void tearDown(){
		j1.addEskuan(0, null);
		j1.addEskuan(1, null);
		j1.addEskuan(2, null);
		j1.addEskuan(3, null);
	}

	@Test
	public void testJokalaria() {
		assertNotNull(j1);
	}

	@Test
	public void testMahaiaPrestatu() {
		Foka f = new Foka("berdea");
		Mofeta m = new Mofeta("berdea");
		Loro l = new Loro("berdea");
		Tximino tx = new Tximino("berdea");
		j1.addEskuan(0, f);
		j1.addEskuan(1, m);
		j1.addEskuan(2, l);
		j1.addEskuan(3, tx);
		String[] urlak = j1.mahaiaPrestatu();
		assertEquals(urlak[0],"img/berdea6.png");
		assertEquals(urlak[1],"img/berdea1.png");
		assertEquals(urlak[2],"img/berdea2.png");
		assertEquals(urlak[3],"img/berdea4.png");
	}

	@Test
	public void testHartu() {
		int[] proba = j1.hartu(); //mazoa hutsik
		assertEquals(proba[0],3);
		Foka f = new Foka("horia");
		Mofeta m = new Mofeta("gorria");
		Loro l = new Loro("horia");
		Tximino tx = new Tximino("berdea");
		Hipopotamo h = new Hipopotamo("urdina");
		Krokodiloa kr = new Krokodiloa("gorria");
		j1.getHartzeke().add(f);
		j1.getHartzeke().add(m);
		j1.addEskuan(0, l);
		j1.addEskuan(1, tx);
		j1.addEskuan(2, h);
		j1.addEskuan(3, kr);
		j1.bota(1);
		Karta[] esku = j1.getEskuan();
		proba = j1.hartu(); // 1 bota du eta berriz hartu behar du
		assertEquals(esku[0],m);
		assertEquals(proba[0],1);
		assertEquals(proba[2],1);
		proba = j1.hartu(); //jada 4 ditu eskuan
		assertEquals(proba[0],0);
		j1.getHartzeke().pop();
	}
	
	@Test
	public void testBota() {
		int zenb = j1.bota(1); //mazoa eta eskua hutsik
		assertEquals(zenb,-2);
		Loro l = new Loro("horia");
		Tximino tx = new Tximino("berdea");
		Hipopotamo h = new Hipopotamo("urdina");
		Krokodiloa kr = new Krokodiloa("gorria");
		j1.addEskuan(0, l);
		j1.addEskuan(1, tx);
		j1.addEskuan(2, h);
		j1.addEskuan(3, kr);
		zenb = j1.bota(1); //Eskuan 4 karta edo mazoa hutsik
		assertEquals(zenb,2);
		zenb = j1.bota(1); //eskuan 4 karta baino gutxiago eta mazoa ez dago hutsik
		assertEquals(zenb,-1);
	}
	
	@Test
	public void testAmaituDu() {
		boolean amaitu = j1.amaituDu();
		assertEquals(amaitu, true);
		Tximino tx = new Tximino("berdea");
		j1.addEskuan(0, tx);
		amaitu = j1.amaituDu();
		assertEquals(amaitu, false);
	}
}
