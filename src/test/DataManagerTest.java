package test;

import static org.junit.Assert.*;

import org.junit.Test;
import project.DataManager;

public class DataManagerTest {
	final String DATA_FILE_LOCATION = "dummy";//TODO: put the actual value here!
	DataManager dm;
	
	/**
	 * Make sure that we can build a new DataManager appropriately.
	 */
	@Test
	public void testConstructor() {
		dm = new DataManager(DATA_FILE_LOCATION);
		
		assertNotNull(dm);
		//make sure that it loaded some actual data
		assertTrue(dm.getContinentList().length > 0);
		assertTrue(dm.getCountryList().length > 0);
	}
	
	/**
	 * Make sure that a sensible String (ie one that refers to a variable that actually exists) is returned.
	 */
	@Test
	public void testGetRandomlyChosenVariableForSuperlativeQuestion(){
		dm = new DataManager(DATA_FILE_LOCATION);
		
		String returnedValue = dm.getRandomlyChosenVariableForSuperlativeQuestion();
		
		//ugly, but it works, I guess?
		assertTrue(returnedValue.equals("gdpPerCapita")
				|| (returnedValue.equals("gdpRealGrowthRate"))
				|| (returnedValue.equals("agriculturePercentageOfGDP"))
				|| (returnedValue.equals("economicFreedomScore"))
				|| (returnedValue.equals("majorIndustries"))
				|| (returnedValue.equals("unemploymentRate")));
	}
	
	

}
