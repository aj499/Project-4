package project;

import java.util.Vector;

public class StudentData {
	private Vector<String> countriesSeen;
	private Vector<String> continentsSeen;
	private String name;
	
	public StudentData(String newName){
		name = newName;
		countriesSeen = new Vector<String>();
		continentsSeen = new Vector<String>();
	}
	
	public void addCountrySeen(String country){
		if(!countriesSeen.contains(country)){//deduplicate additions
			countriesSeen.add(country);
		}
	}
	
	public void addContinentSeen(String continent){
		if(!continentsSeen.contains(continent)){//deduplicate additions
			continentsSeen.add(continent);
		}
	}
	
	public String getName(){
		return name;
	}
	
	public Vector<String> getCountriesSeen(){
		return countriesSeen;
	}
	
	public Vector<String> getContinentsSeen(){
		return continentsSeen;
	}
	
	public boolean hasCountryBeenSeen(String countryToCheck){
		return countriesSeen.contains(countryToCheck);
	}
}
