package test;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Vector;
import project.ContinentData;

public class ContinentDataTest {

	/**
	 * makes sure that the constructor is actually loading in country lists
	 */
	@Test
	public void testConstructor() {
		ContinentData data = new ContinentData();
		Vector<String> testVector=data.getCountryList();
		assertNotNull(testVector);
	}//testConstructor
	
	/**
	 * tests that the addToCountryList function works correctly
	 */
	@Test
	public void addCountryTest () {
		ContinentData data = new ContinentData();
		data.addToCountryList("Spain");
		Vector<String> testVector = data.getCountryList();
		String testString = "Spain";
		assertTrue(testVector.get(0).equals(testString));
	}//addCountryTest
	
	/**
	 * tests the isPointInBounds function to see if a continent is
	 * within is determined bounds. By doing so, also tests the bound
	 * setters and getters.
	 */
	@Test
	public void inBoundsTest() {//this also tests getters and setters
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
	}//inBoundsTest

}//ContinentDataTest