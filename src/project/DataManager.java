package project;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
<<<<<<< HEAD
import java.io.FileReader;
=======
<<<<<<< HEAD
import java.io.FileReader;
=======
>>>>>>> origin/Min
>>>>>>> Joe
import java.io.InputStreamReader;
import java.util.ArrayList;
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
=======
<<<<<<< HEAD
=======
>>>>>>> Joe
	
	public void parseData(){
		int numContinents = 1;
		int continentCounter = 1;
		try{
			FileInputStream fileInputStream = new FileInputStream(fileLocation);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
					dataInputStream));
			String currentLine;
			while ((currentLine = bufferedReader.readLine())!=null){
				CountryData currentCountry;
				ContinentData currentContinent;
				if (continentCounter <= numContinents){
					currentContinent = new ContinentData();
					currentContinent.setContinentName(currentLine);
					currentContinent.setAll(bufferedReader);
					currentContinent.setLeftBound(Integer.parseInt(bufferedReader.readLine()));
					currentContinent.setRightBound(Integer.parseInt(bufferedReader.readLine()));
					currentContinent.setTopBound(Integer.parseInt(bufferedReader.readLine()));
					currentContinent.setBottomBound(Integer.parseInt(bufferedReader.readLine()));

					
					currentLine = bufferedReader.readLine();
					while (currentLine.length() > 0){
						currentContinent.addToCountryList(currentLine);
						currentLine = bufferedReader.readLine();
					}
					
					continentData.put(currentContinent.getContinentName(), currentContinent);
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
			dataLoaded = true;
		}
		catch(Exception e){
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
	}
<<<<<<< HEAD
=======
>>>>>>> origin/Min
>>>>>>> Joe
	

	
	
	
	
	
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
	
<<<<<<< HEAD
	public static void main(String args[]){
		DataManager dm = new DataManager("/Users/michaelmcaneny/Desktop/exampleData.txt");
		
=======
<<<<<<< HEAD
	public static void main(String args[]){
=======
	public ContinentData getDataForContinent(String continentName){
		//TODO: actually implement this function!
		return new ContinentData();
	}
	
	/*public static void main(String args[]){
>>>>>>> origin/Min
		DataManager dm = new DataManager("hello");
>>>>>>> Joe
		dm.parseData();
		
		ArrayList<String> countriesInAfrica = new ArrayList<String>();
		countriesInAfrica = dm.continentData.get("Africa").getCountryList();
		System.out.println("Countries in africa:");
		for (int i=0; i<countriesInAfrica.size();i++){
			System.out.println(countriesInAfrica.get(i));
		}
		System.out.println("done");
		
		CountryData peru = new CountryData();
		ContinentData africa = new ContinentData();
		CountryData mongolia = new CountryData();
		CountryData usa = new CountryData();
		usa = dm.countryData.get("USA");
		peru = dm.countryData.get("Peru");
		mongolia = dm.countryData.get("Mongolia");
		africa = dm.continentData.get("Africa");
		System.out.println("Peru: " + peru.getMajorHealthIssue());
		System.out.println("Mongolia: " + mongolia.getMajorHealthIssue());
		System.out.println("USA: " + usa.getMajorHealthIssue());
		System.out.println("Africa: " + africa.getContinentName());
		
<<<<<<< HEAD
	}
=======
<<<<<<< HEAD
	}
=======
	}*/

>>>>>>> origin/Min
>>>>>>> Joe
}
