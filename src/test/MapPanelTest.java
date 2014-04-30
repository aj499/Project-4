package test;

import static org.junit.Assert.*;

import org.junit.Test;

import project.DataManager;
import project.MapMode;
import project.MapPanel;
import project.StudentData;

public class MapPanelTest {
	final String DATA_FILE_LOCATION = "src/CountryData.txt";//see note on filepath in DataManagerTest
	
	MapPanel mp;
	DataManager dm;
	StudentData sd;
	
	
	/**
	 * Make sure that we can actually make a MapPanel.
	 */
	@Test
	public void testConstructor() {
		dm = new DataManager(DATA_FILE_LOCATION);
		sd = new StudentData("Tasha");
		
		mp = new MapPanel(dm, sd, MapMode.ECONOMIC);
		
		
		assertNotNull(mp);
	}
	
	//Can't really test anything else for the MapPanel, since all the other methods are private or UI related

}
