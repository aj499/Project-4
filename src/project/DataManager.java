package project;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
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
<<<<<<< HEAD
		setFileLocation(newFileLocation);
	}
	

	/**
	 * sets the filepath
	 * @param newFileLocation
	 */
	public void setFileLocation(String newFileLocation){
=======
>>>>>>> origin/Adam
		fileLocation = newFileLocation;
		
		parseData();
	}
	
	private void parseData(){
		try{
<<<<<<< HEAD
			String filename ="/Users/michaelmcaneny/Desktop/exampleData.txt";
=======
			String filename = fileLocation;
			int numContinents = 6;
			int continentCounter = 1;

>>>>>>> origin/Adam
			FileInputStream fileInputStream = new FileInputStream(filename);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
					dataInputStream));
			String currentLine;
			while ((currentLine = bufferedReader.readLine())!=null){
<<<<<<< HEAD
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
=======
				CountryData currentCountry;
				ContinentData currentContinent;
				if (continentCounter <= numContinents){
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
					}
					
					continentData.put(currentContinent.getCountryName(), currentContinent);
					continentCounter++;	
				}
				else{
					
					currentCountry = new CountryData();
					
					currentCountry.setCountryName(currentLine);
					currentCountry.setAll(bufferedReader);
					currentCountry.setButtonXPosition(Integer.parseInt(bufferedReader.readLine()));
					currentCountry.setButtonYPosition(Integer.parseInt(bufferedReader.readLine()));
					countryData.put(currentCountry.getCountryName(), currentCountry);
					
					bufferedReader.readLine();
				}
>>>>>>> origin/Adam
			}
			
			bufferedReader.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

<<<<<<< HEAD
	
	
		
	
=======

>>>>>>> origin/Adam
	/**
	 * Returns a list of all the countries in the countryData hash.
	 * 
	 * @return a list of all the countries in the countryData hash
	 */
	public String[] getCountryList(){
<<<<<<< HEAD
		return (String[]) countryData.keySet().toArray();
=======
		//pass String Array to get correct return type (see API doc for Set<T>::toArray(T[] a))
		return (String[]) countryData.keySet().toArray(new String[countryData.keySet().size()]);
>>>>>>> origin/Adam
	}
	
	/**
	 * Returns a list of all the continents in the countryData hash.
	 * 
	 * @return a list of all the continents in the countryData hash
	 */
	public String[] getContinentList(){
<<<<<<< HEAD
		return (String[]) continentData.keySet().toArray();
	}
	
	public CountryData getDataForCountry(String countryName){
		//TODO: actually implement this function!
		return new CountryData();
=======
		//pass String Array to get correct return type (see API doc for Set<T>::toArray(T[] a))
		return (String[]) continentData.keySet().toArray(new String[continentData.keySet().size()]);
	}
	
	public CountryData getDataForCountry(String countryName){
		return countryData.get(countryName);
>>>>>>> origin/Adam
	}
	


	public ContinentData getDataForContinent(String continentName){
		//TODO: implement error checking here!
		return continentData.get(continentName);
	}
	
	public String getRandomlyChosenVariableForSuperlativeQuestion(){
		ArrayList<String> econVariableList = new ArrayList<String>();
		econVariableList.add("gpdPerCapita");
		econVariableList.add("gdpRealGrowthRate");
		econVariableList.add("agriculturePercentageOfGDP");
		econVariableList.add("economicFreedomScore");
		econVariableList.add("majorIndustries");
		econVariableList.add("unemploymentRate");
		
		
		Random generator = new Random();
		/*int minimum = 0;
		int maximum = econVariableList.size()-1;
		int range = maximum - minimum + 1;
		int indexToChooseVariableToAskAbout =  generator.nextInt(range) + minimum;*/
		return econVariableList.get(generator.nextInt(econVariableList.size()));
	}
<<<<<<< HEAD
	
	/*public String[] generateEconSuperlativeQuestion(String continentName, String dataVariable){
		//continentName= getCurrentView();
			switch (dataVariable){	
				case "gpdPerCapita":
					return new String[] {"Which is the poorest country in " + continentName + " ?",
							gdpPerCapitaSortedAfrica.get(0).getCountryName()};
					}
					
		}
			
		}
*/
		
	}
	
	//}
	
	
	/*public static void main(String args[]){
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
		
	}*/
=======
>>>>>>> origin/Adam

}

