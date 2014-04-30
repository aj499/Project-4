package test;

import static org.junit.Assert.*;

import org.junit.Test;
import project.ContinentData;
import project.CountryData;
import project.DataManager;

public class DataManagerTest {
	//NB: this filepath works for us, but if it fails for you you may
	//need to play around with it a bit
	final String DATA_FILE_LOCATION = "src/CountryData.txt";
	
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
	
	//everything else is either private or a getter…
	
	//so let's make sure that all our getters work
	@Test
	public void testGetDataForCountry(){
		dm = new DataManager(DATA_FILE_LOCATION);
		
		CountryData cd = dm.getDataForCountry("UK");
		
		assertNotNull(cd);
		assertTrue(cd.getCountryName().equals("UK"));
	}
	
	@Test
	public void testGetDataForContinent(){
		dm = new DataManager(DATA_FILE_LOCATION);
		
		ContinentData cd = dm.getDataForContinent("Asia");
		
		assertNotNull(cd);
		assertTrue(cd.getCountryName().equals("Asia"));
	}

}
