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
	


	
<<<<<<< HEAD
	public void parseData(){		
=======
	public void parseData(){

		
		
>>>>>>> origin/Lauren
		try{
			FileInputStream fileInputStream = new FileInputStream(fileLocation);
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
<<<<<<< HEAD
				bufferedReader.readLine();
			}
			bufferedReader.close();
			dataLoaded = true;
=======
				System.out.println("key was " + currentCountry.getCountryName());
				bufferedReader.readLine();
			}
			
			bufferedReader.close();
>>>>>>> origin/Lauren
		}
		catch(Exception e){
			System.out.println(e.toString());
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
	
	/**
	 * Returns a list of all the continents in the countryData hash.
	 * 
	 * @return a list of all the continents in the countryData hash
	 */
	public String[] getContinentList(){
		return (String[]) continentData.keySet().toArray();
	}
	
	public CountryData getDataForCountry(String countryName){
		//TODO: actually implement this function!
		return new CountryData();
	}
	
<<<<<<< HEAD
	public static void main(String args[]){
		DataManager dm = new DataManager("/Users/michaelmcaneny/Desktop/exampleData.txt");
=======


	public ContinentData getDataForContinent(String continentName){
		//TODO: actually implement this function!
		return new ContinentData();
	}
	}
	
	/*public static void main(String args[]){
		DataManager dm = new DataManager("hello");
>>>>>>> origin/Lauren
		dm.parseData();
		CountryData peru = new CountryData();
		CountryData mongolia = new CountryData();
		CountryData usa = new CountryData();
		usa = dm.countryData.get("USA");
		peru = dm.countryData.get("Peru");
		mongolia = dm.countryData.get("Mongolia");
<<<<<<< HEAD
		usa.getCountryName();
		
		System.out.println("Peru: " + peru.getMajorHealthIssue());
		System.out.println("Mongolia: " + mongolia.getMajorHealthIssue());
		System.out.println("USA: " + usa.getMajorHealthIssue());
=======
		System.out.println("Peru: " + peru.getMajorHealthIssue());
		System.out.println("Mongolia: " + mongolia.getMajorHealthIssue());
		System.out.println("USA: " + usa.getMajorHealthIssue());
		System.out.println(dm.countryData.size());
>>>>>>> origin/Lauren
		
	}*/


