package packbarbestial;

import static org.junit.Assert.*;

import org.junit.Test;

public class JokalariaTest {
	
	private Jokalaria j1=new Jokalaria("Ariane","beltza");

	@Test
	public void testJokalaria() {
		assertNotNull(j1);
	}

	@Test
	public void testHasieratu() {
		j1.hasieratu();
		String[] kartak=j1.mahaiaPrestatu();
		for(int i=0;i<kartak.length;i++){
			System.out.println(kartak[i]);
		}
	}
	
	@Test
	public void testGetHartzeke(){
		j1.hasieratu();
		assertTrue(j1.getHartzeke().size()==8);
	}
	
	@Test
	public void testEskuan(){
		j1.hasieratu();
		assertTrue(j1.getEskuan().length==4);
	}

}
