package project;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
<<<<<<< HEAD
<<<<<<< HEAD
import java.io.FileReader;

=======
>>>>>>> Min
import java.io.FileReader;
=======
>>>>>>> Adam
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class DataManager {
	private HashMap<String, CountryData> countryData;
	private HashMap<String, ContinentData> continentData;
	private boolean dataLoaded;
	private String fileLocation;

	/**
	 * Constructor takes a String that is the filepath
	 * @param newFileLocation
	 */
	public DataManager(String newFileLocation){
		countryData = new HashMap<String, CountryData>();
		continentData = new HashMap<String, ContinentData>();
		dataLoaded=false;
		
		fileLocation = "src/" + newFileLocation;
		parseData();
	}//constructor
		
	private void parseData(){
		try{
<<<<<<< HEAD
			String filename ="/Users/josephblackwell/Documents/Java/exampleData.txt";
=======
			String filename = fileLocation;
			int numContinents = 6;
			int continentCounter = 1;

>>>>>>> Adam
			FileInputStream fileInputStream = new FileInputStream(filename);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
					dataInputStream));
			String currentLine;
			while ((currentLine = bufferedReader.readLine())!=null){
<<<<<<< HEAD
<<<<<<< HEAD
				CountryData currentCountry = new CountryData();
				currentCountry.setCountryName(currentLine);
				
				currentCountry.setGdpPerCapita(bufferedReader.readLine());
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
=======
				CountryData currentCountry;
				ContinentData currentContinent;
=======

>>>>>>> Adam
				if (continentCounter <= numContinents){
					ContinentData currentContinent = new ContinentData();
					currentContinent = new ContinentData();
					currentContinent.setCountryName(currentLine);
					currentContinent.setAll(bufferedReader);
					currentContinent.setLeftBound(Integer.parseInt(bufferedReader.readLine()));
					currentContinent.setRightBound(Integer.parseInt(bufferedReader.readLine()));
					currentContinent.setTopBound(Integer.parseInt(bufferedReader.readLine()));
					currentContinent.setBottomBound(Integer.parseInt(bufferedReader.readLine()));

					currentLine = bufferedReader.readLine();
					while ((currentLine = bufferedReader.readLine()).length() > 0){
						currentContinent.addToCountryList(currentLine);
					}//while
					
					continentData.put(currentContinent.getCountryName(), currentContinent);
					continentCounter++;	
				}//if
				else{
					CountryData currentCountry = new CountryData();
					currentCountry = new CountryData();
					
					currentCountry.setCountryName(currentLine);
					currentCountry.setAll(bufferedReader);
					currentCountry.setButtonXPosition(Integer.parseInt(bufferedReader.readLine()));
					currentCountry.setButtonYPosition(Integer.parseInt(bufferedReader.readLine()));
					countryData.put(currentCountry.getCountryName(), currentCountry);
					
					bufferedReader.readLine();
<<<<<<< HEAD
				}
>>>>>>> Adam
			}
=======
				}//else
			}//while
>>>>>>> Adam
			
			bufferedReader.close();
			dataLoaded = true;

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
<<<<<<< HEAD
	

<<<<<<< HEAD
	
	
		
=======
>>>>>>> Min
	
=======


>>>>>>> Adam
=======
>>>>>>> Adam
	/**
	 * Returns a list of all the countries in the countryData hash.
	 * 
	 * @return a list of all the countries in the countryData hash
	 */
	public String[] getCountryList(){
		return (String[]) countryData.keySet().toArray(new String[countryData.keySet().size()]);
	}//getCountryList
	
	/**
	 * Returns a list of all the continents in the countryData hash.
	 * 
	 * @return a list of all the continents in the countryData hash
	 */
	public String[] getContinentList(){
		return (String[]) continentData.keySet().toArray(new String[continentData.keySet().size()]);
	}//getContinentList
	
	public CountryData getDataForCountry(String countryName){

		return countryData.get(countryName);
	}//getDataForCountry


	public ContinentData getDataForContinent(String continentName){
<<<<<<< HEAD
<<<<<<< HEAD
		//TODO: actually implement this function!
		return new ContinentData();
	}
	
	public static void main(String args[]){

		/*DataManager dm = new DataManager("hello");
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
		System.out.println(dm.countryData.size());*/
	}
=======
		//TODO: implement error checking here!
=======
>>>>>>> Adam
		return continentData.get(continentName);
	}//getDataForContinent
	
	public String getRandomlyChosenVariableForSuperlativeQuestion(){
		ArrayList<String> econVariableList = new ArrayList<String>();
		econVariableList.add("gpdPerCapita");
		econVariableList.add("gdpRealGrowthRate");
		econVariableList.add("gdpRealGrowthRate");
		econVariableList.add("agriculturePercentageOfGDP");
		econVariableList.add("economicFreedomScore");
		econVariableList.add("majorIndustries");
		econVariableList.add("unemploymentRate");
		
		Random generator = new Random();
		return econVariableList.get(generator.nextInt(econVariableList.size()));
	}
		

<<<<<<< HEAD
}
>>>>>>> Adam

}//class
=======
}//class
>>>>>>> Adam
