package project;

import java.util.HashMap;

public class DataManager {
	private HashMap<String, CountryData> countryData;
	private HashMap<String, ContinentData> continentData;
	private boolean dataLoaded;
	private String fileLocation;
	
	
	/**
	 * Constructor takes a String that is the filepath
	 * @param newFileLocation
	 */
	DataManager(String newFileLocation){
		countryData = new HashMap<String, CountryData>();
		continentData = new HashMap<String, ContinentData>();
		
		dataLoaded=false;
		setFileLocation(newFileLocation);
	}
	
	/**
	 * sets the filepath
	 * @param newFileLocation
	 */
	public void setFileLocation(String newFileLocation){
		fileLocation = newFileLocation;
	}
	
	/**
	 * 
	 */
	
	public void parseData(){
		String countryName;
		String gpdPerCapita, gdpRealGrowthRate, 
		agriculturePercentageOfGdp, economicFreedomScore, lowestTenIncome,
		highestTenIncome, majorIndustries, unemploymentRate, majorEconomicIssue,
		makeADifferenceEconomic, photoPathEconomic;
		
		String lifeExpectancy, maternalMortalityRate, infantMortalityRate,
		childrenUnderweightPercentage, physicianDensity, riskOfInfectiousDisease,
		mostCommonDiseases, majorHealthIssue, makeADifferenceHealth, photoPathHealth;
		
		
	}
	/**
	 * Returns a list of all the countries in the countryData hash.
	 * 
	 * @return a list of all the countries in the countryData hash
	 */
	public String[] getCountryList(){
		return (String[]) countryData.keySet().toArray();
	}
	
	public CountryData getDataForCountry(String countryName){
		//TODO: actually implement this function!
		return new CountryData();
	}
}
