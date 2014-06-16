import static org.junit.Assert.*;


import org.junit.Test;


public class StarTest {

	@Test
	public void test() {
	
		fail("Not yet implemented");
	}
	
	@Test
	//test to check the method to set bv colour index
	//creates new star object, uses setBV() to set colout index, then compares value using getcolourIndex() 
	public void testsetBV(){
		Star test = new Star();
		test.setBV(0.1);
		assertTrue(test.getcolourIndex() == 0.1);
	}
	
	@Test
	//test to chech method setTemp() which calculates stellar temperature from bv colour index
	public void testsetTemp(){
		Star test = new Star();
		test.setBV(10.867);
		test.setTemp();
		//System.out.println(test.getTemp());
		assertTrue(test.getTemp() <= 10.00000000001 && test.getTemp()>= 0.9999999999);
		
		
		//fail("ssg");
		
	}
	
	@Test
	//test of set abMag()
	public void testsetAbMag(){
		Star test = new Star();
		test.setParallax(0.1);
		test.setAbsMag();
		System.out.println(test.getAbMag());
		assertTrue(test.getAbMag() <= -69.0 && test.getAbMag() >= -69.1);
		
	}

}
