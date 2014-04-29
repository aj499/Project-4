package test;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Vector;
import project.ContinentData;

public class ContinentDataTest {

	@Test
	public void testConstructor() {
		ContinentData data = new ContinentData();
		Vector<String> testVector=data.getCountryList();
		assertNotNull(testVector);
	}
	
	@Test
	public void addCountryTest () {
		ContinentData data = new ContinentData();
		data.addToCountryList("Spain");
		Vector<String> testVector = data.getCountryList();
		String testString = "Spain";
		assertTrue(testVector.get(0).equals(testString));
		
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