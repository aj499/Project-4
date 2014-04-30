package project;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * DataManager Class
 * 
 * This class parses through the data file that we provide and passes the necessary
 * data accordingly. DataManager holds HashMaps of countryData and continentData, which
 * are objects, like their names imply, that hold data from respective continents and countries.
 *
 */
public class DataManager {
	//HashMaps of countries and continents that pair up with their respective data
	private HashMap<String, CountryData> countryData;
	private HashMap<String, ContinentData> continentData;
	//private string that holds the file location
	private String fileLocation;

	/**
	 * DataManager
	 * 
	 * Constructor takes a String that is the filepath to the main data file
	 * @param newFileLocation the filepath to the main data file
	 */
	public DataManager(String newFileLocation){
		countryData = new HashMap<String, CountryData>();
		continentData = new HashMap<String, ContinentData>();
		
		fileLocation = newFileLocation;
		
		parseData();
	}//constructor
		
	/**
	 * parseData
	 * 
	 * This is the powerhouse function of the DataManager class. It reads in a file
	 * and then afterwards, reads the data stored in that file. It then sets the data
	 * into the respective Hashmaps.
	 * 
	 */
	private void parseData(){
		try{
			String filename = fileLocation;
			int numContinents = 6;
			int continentCounter = 1;

			FileInputStream fileInputStream = new FileInputStream(filename);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
					dataInputStream));
			String currentLine;
			while ((currentLine = bufferedReader.readLine())!=null){

				if (continentCounter <= numContinents){
					ContinentData currentContinent = new ContinentData();
					currentContinent = new ContinentData();
					currentContinent.setCountryName(currentLine);
					currentContinent.setAll(bufferedReader);
					currentContinent.setLeftBound(Integer.parseInt(bufferedReader.readLine()));
					currentContinent.setRightBound(Integer.parseInt(bufferedReader.readLine()));
					currentContinent.setTopBound(Integer.parseInt(bufferedReader.readLine()));
					currentContinent.setBottomBound(Integer.parseInt(bufferedReader.readLine()));

					//currentLine = bufferedReader.readLine();
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
				}//else
			}//while
			
			bufferedReader.close();

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * getCountryList
	 * 
	 * Returns a list of all the countries in the countryData hash.
	 * @return a list of all the countries in the countryData hash
	 */
	public String[] getCountryList(){
		return (String[]) countryData.keySet().toArray(new String[countryData.keySet().size()]);
	}//getCountryList
	
	/**
	 * getContinentList
	 * 
	 * Returns a list of all the continents in the countryData hash.
	 * @return a list of all the continents in the countryData hash
	 */
	public String[] getContinentList(){
		return (String[]) continentData.keySet().toArray(new String[continentData.keySet().size()]);
	}//getContinentList
	
	/**
	 * getDataForCountry
	 * 
	 * Returns a CountryData object for a specific country.
	 * @param countryName
	 * @return a list of all the continents in the countryData hash
	 */
	public CountryData getDataForCountry(String countryName){
		return countryData.get(countryName);
	}//getDataForCountry

	/**
	 * getDataForContinent
	 * 
	 * Returns a ContinentData object for a specific continent
	 * @param continentName
	 * @return a list of all the continents in the countryData hash
	 */
	public ContinentData getDataForContinent(String continentName){
		return continentData.get(continentName);
	}//getDataForContinent

}//DataManager class