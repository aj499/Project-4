package project;

import java.util.HashMap;

public class DataManager {
	private HashMap<String, CountryData> countryData;
	
	/**
	 * Returns a list of all the countries in the countryData hash.
	 * 
	 * @return a list of all the countries in the countryData hash
	 */
	public String[] getCountryList(){
		return (String[]) countryData.keySet().toArray();
	}
}
