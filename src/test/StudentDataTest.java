package test;

import static org.junit.Assert.*;

import org.junit.Test;
import project.MapMode;
import project.StudentData;

public class StudentDataTest {
	public static final String STUDENT_NAME = "Taiga";
	
	StudentData sd;
	
	/**
	 * Make sure that the constructor sets the student's name correctly
	 * and initializes the other data members correctly.
	 */
	@Test
	public void testConstructor() {
		sd = new StudentData(STUDENT_NAME);
		
		assertTrue(STUDENT_NAME.equals(sd.getName()));
		assertEquals(sd.getContinentsSeenHealth().size(), 0);
		assertEquals(sd.getContinentsSeenEconomic().size(), 0);
		assertEquals(sd.getCountriesSeenHealth().size(), 0);
		assertEquals(sd.getCountriesSeenEconomic().size(), 0);
	}
	
	/**
	 * Make sure that we can add a country to the list of countries seen by the user.
	 */
	@Test
	public void testAddCountrySeen(){
		sd = new StudentData(STUDENT_NAME);
		
		assertEquals(sd.getCountriesSeenHealth().size(), 0);
		
		sd.addCountrySeen("Ghana", MapMode.HEALTH);
		
		assertTrue(sd.getCountriesSeenHealth().contains("Ghana"));
	}

	/**
	 * Make sure that we can add a country to the list of continents seen by the user.
	 */
	@Test
	public void testAddContinentSeen(){
		sd = new StudentData(STUDENT_NAME);
		
		assertEquals(sd.getContinentsSeenEconomic().size(), 0);
		
		sd.addCountrySeen("Australia", MapMode.HEALTH);
		
		assertTrue(sd.getContinentsSeenEconomic().contains("Ghana"));
	}
	
	/**
	 * Make sure that we can check whether or not a country has been seen when that country was seen.
	 */
	@Test
	public void testHasCountryBeenSeenWithSeenCountry(){
		sd = new StudentData(STUDENT_NAME);
		
		assertEquals(sd.getCountriesSeenHealth().size(), 0);
		
		sd.addCountrySeen("Ghana", MapMode.HEALTH);
		
		assertTrue(sd.hasCountryBeenSeen("Ghana", MapMode.HEALTH));
	}
	
	/**
	 * Make sure that we can check whether or not a country has been seen when that country was not seen.
	 */
	@Test
	public void testHasCountryBeenSeenWithUnseenCountry(){
		sd = new StudentData(STUDENT_NAME);
		
		assertEquals(sd.getCountriesSeenHealth().size(), 0);
		
		assertTrue(sd.hasCountryBeenSeen("Ghana", MapMode.HEALTH));
	}
	
	/**
	 * Make sure that we can check whether or not a continent has been seen when that continent was seen.
	 */
	@Test
	public void testHasContinentBeenSeenWithSeenContinent(){
		sd = new StudentData(STUDENT_NAME);
		
		assertEquals(sd.getContinentsSeenHealth().size(), 0);
		
		sd.addCountrySeen("Ghana", MapMode.HEALTH);
		
		assertTrue(sd.hasContinentBeenSeen("Ghana", MapMode.HEALTH));
	}
	
	/**
	 * Make sure that we can check whether or not a continent has been seen when that continent was not seen.
	 */
	@Test
	public void testHasContinentBeenSeenWithUnseenContinent(){
		sd = new StudentData(STUDENT_NAME);
		
		assertEquals(sd.getContinentsSeenHealth().size(), 0);
		
		assertTrue(sd.hasContinentBeenSeen("Ghana", MapMode.HEALTH));
	}
}
