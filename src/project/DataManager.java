package project;

import java.util.HashMap;
import java.util.Set;

public class DataManager {
	private HashMap<String, CountryData> countryData;
	
	/**
	 * Returns a list of all the countries in the countryData hash.
	 * 
	 * @return a list of all the countries in the countryData hash
	 */
	public Set<String> getCountryList(){
		return countryData.keySet();
	}
}
