package project;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class ContinentDataTest {

	@Test
	public void testConstructor() {
		ContinentData data = new ContinentData();
		Vector<String> testVector=data.getCountryList();
		assertNotNull(testVector);
	}
	
	@Test
	public void addCountryTest () {
		ContinentData data=new ContinentData();
		data.addToCountryList("Spain");
		Vector<String> testVector=data.getCountryList();
		String testString= "Spain";
		assertEquals(testVector.get(0), testString,0);
		
	}
	
	@Test
	public void inBoundsTest() {
		ContinentData data= new ContinentData();
		data.setLeftBound(0);
		data.setRightBound(200);
		data.setTopBound(0);
		data.setBottomBound(200);
		
		int testLeftAndTop=0;
		int testRightAndBottom=200;
		
		assertEquals(data.getLeftBound(),testLeftAndTop);
		assertEquals(data.getRightBound(),testRightAndBottom);
		assertEquals(data.getTopBound(),testLeftAndTop);
		assertEquals(data.getBottomBound(),testRightAndBottom);
		
		boolean inBounds= data.isPointInBounds(5, 10);
		assertTrue(inBounds);
	}

}
