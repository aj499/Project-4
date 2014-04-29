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


		fileLocation = newFileLocation;
=======
>>>>>>> origin/Adam
		
		fileLocation = newFileLocation;
		parseData();
	}//constructor
		
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

<<<<<<< HEAD
				CountryData currentCountry;
				ContinentData currentContinent;
=======
>>>>>>> origin/Adam
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
					//System.out.println("Loading: " + currentCountry.getCountryName());
					currentCountry.setButtonYPosition(Integer.parseInt(bufferedReader.readLine()));
					countryData.put(currentCountry.getCountryName(), currentCountry);
					
					bufferedReader.readLine();
<<<<<<< HEAD
				}

			}
			
			bufferedReader.close();
=======
				}//else
			}//while
			
			bufferedReader.close();
			dataLoaded = true;

>>>>>>> origin/Adam
		}
		catch(Exception e){
			e.printStackTrace();
		}
<<<<<<< HEAD
		
	}




=======
	}

>>>>>>> origin/Adam
	/**
	 * Returns a list of all the countries in the countryData hash.
	 * 
	 * @return a list of all the countries in the countryData hash
	 */
	public String[] getCountryList(){
<<<<<<< HEAD

		//pass String Array to get correct return type (see API doc for Set<T>::toArray(T[] a))
		return (String[]) countryData.keySet().toArray(new String[countryData.keySet().size()]);

	}
=======
		return (String[]) countryData.keySet().toArray(new String[countryData.keySet().size()]);
	}//getCountryList
>>>>>>> origin/Adam
	
	/**
	 * Returns a list of all the continents in the countryData hash.
	 * 
	 * @return a list of all the continents in the countryData hash
	 */
	public String[] getContinentList(){
<<<<<<< HEAD

		//pass String Array to get correct return type (see API doc for Set<T>::toArray(T[] a))
=======
>>>>>>> origin/Adam
		return (String[]) continentData.keySet().toArray(new String[continentData.keySet().size()]);
	}//getContinentList
	
	public CountryData getDataForCountry(String countryName){

		return countryData.get(countryName);
<<<<<<< HEAD

	}
	
=======
	}//getDataForCountry

>>>>>>> origin/Adam


	public ContinentData getDataForContinent(String continentName){
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

=======
}//class
>>>>>>> origin/Adam
