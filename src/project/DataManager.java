
package project;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;

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
			int numContinents = 1;
			int continentCounter = 1;
			FileInputStream fileInputStream = new FileInputStream(filename);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
					dataInputStream));
			String currentLine;
			while ((currentLine = bufferedReader.readLine())!=null){
				
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
					while ((currentLine = bufferedReader.readLine()).length() > 0)
						currentContinent.addToCountryList(currentLine);

					
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
			}
			
			bufferedReader.close();
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
		return countryData.get(countryName);
	}



	public ContinentData getDataForContinent(String continentName){
		
		return continentData.get(continentName);
	}
	

}
	
