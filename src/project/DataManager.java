package project;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
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
	

	
	public void parseData(){

		
		
		try{
			String filename ="/Users/michaelmcaneny/Desktop/exampleData.txt";
			FileInputStream fileInputStream = new FileInputStream(filename);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
					dataInputStream));
			String currentLine;
			while ((currentLine = bufferedReader.readLine())!=null){
				CountryData currentCountry = new CountryData();
				currentCountry.setCountryName(currentLine);
				
				currentCountry.setGpdPerCapita(bufferedReader.readLine());
				currentCountry.setGdpRealGrowthRate(bufferedReader.readLine());
				currentCountry.setAgriculturePercentageOfGdp(bufferedReader.readLine());
				currentCountry.setEconomicFreedomScore(bufferedReader.readLine());
				currentCountry.setLowestTenIncome(bufferedReader.readLine());
				currentCountry.setHighestTenIncome(bufferedReader.readLine());
				currentCountry.setMajorIndustries(bufferedReader.readLine());
				currentCountry.setUnemploymentRate(bufferedReader.readLine());
				currentCountry.setMajorEconomicIssue(bufferedReader.readLine());
				currentCountry.setMakeADifferenceEconomic(bufferedReader.readLine());
				currentCountry.setPhotoPathEconomic(bufferedReader.readLine());
				
				currentCountry.setLifeExpectancy(bufferedReader.readLine());
				currentCountry.setMaternalMortalityRate(bufferedReader.readLine());
				currentCountry.setInfantMortalityRate(bufferedReader.readLine());
				currentCountry.setChildrenUnderweightPercentage(bufferedReader.readLine());
				currentCountry.setPhysicianDensity(bufferedReader.readLine());
				currentCountry.setRiskOfInfectiousDisease(bufferedReader.readLine());
				currentCountry.setMostCommonDiseases(bufferedReader.readLine());
				currentCountry.setMajorHealthIssue(bufferedReader.readLine());
				currentCountry.setMakeADifferenceHealth(bufferedReader.readLine());
				currentCountry.setPhotoPathHealth(bufferedReader.readLine());
				
				countryData.put(currentCountry.getCountryName(), currentCountry);
				System.out.println("key was " + currentCountry.getCountryName());
				bufferedReader.readLine();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
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
	
	public static void main(String args[]){
		DataManager dm = new DataManager("hello");
		dm.parseData();
		CountryData peru = new CountryData();
		CountryData mongolia = new CountryData();
		CountryData usa = new CountryData();
		usa = dm.countryData.get("USA");
		peru = dm.countryData.get("Peru");
		mongolia = dm.countryData.get("Mongolia");
		System.out.println("Peru: " + peru.getMajorHealthIssue());
		System.out.println("Mongolia: " + mongolia.getMajorHealthIssue());
		System.out.println("USA: " + usa.getMajorHealthIssue());
		System.out.println(dm.countryData.size());
		
	}
}
