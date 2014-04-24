package project;

import java.util.Random;
import java.util.Vector;

public class StudentData {
	private Vector<String> countriesSeenHealth;
	private Vector<String> countriesSeenEconomic;
	private Vector<String> continentsSeenHealth;
	private Vector<String> continentsSeenEconomic;
	private String name;
	
	public StudentData(String newName){
		name = newName;
		countriesSeenHealth = new Vector<String>();
		countriesSeenEconomic = new Vector<String>();
		continentsSeenHealth = new Vector<String>();
		continentsSeenEconomic = new Vector<String>();
	}
	
	public void addCountrySeen(String country, MapMode modeSeenIn){
		if(modeSeenIn == MapMode.HEALTH && !countriesSeenHealth.contains(country)){//deduplicate additions
			countriesSeenHealth.add(country);
		} else if(modeSeenIn == MapMode.ECONOMIC && !countriesSeenEconomic.contains(country)){
			countriesSeenEconomic.add(country);
		}
	}
	
	public void addContinentSeen(String continent, MapMode modeSeenIn){
		if(modeSeenIn == MapMode.HEALTH && !continentsSeenHealth.contains(continent)){//deduplicate additions
			continentsSeenHealth.add(continent);
		} else if(modeSeenIn == MapMode.ECONOMIC && !continentsSeenEconomic.contains(continent)){
			continentsSeenEconomic.add(continent);
		}
	}
	
	public String getName(){
		return name;
	}
	
	public Vector<String> getCountriesSeenHealth(){
		return countriesSeenHealth;
	}
	
	public Vector<String> getCountriesSeenEconomic(){
		return countriesSeenEconomic;
	}
	
	public Vector<String> getContinentsSeenHealth(){
		return continentsSeenHealth;
	}
	
	public Vector<String> getContinentsSeenEconomic(){
		return continentsSeenEconomic;
	}
	
	public boolean hasCountryBeenSeen(String countryToCheck, MapMode modeSeenIn){
		switch(modeSeenIn){
		case HEALTH:
			return countriesSeenHealth.contains(countryToCheck);
		case ECONOMIC:
			return countriesSeenEconomic.contains(countryToCheck);
		default:
			return false; //backup, unreachable; to make Eclipse happy
		}
	}
	
	public boolean hasContinentBeenSeen(String continentToCheck, MapMode modeSeenIn){
		switch(modeSeenIn){
		case HEALTH:
			return continentsSeenHealth.contains(continentToCheck);
		case ECONOMIC:
			return continentsSeenEconomic.contains(continentToCheck);
		default:
			return false; //backup, unreachable; to make Eclipse happy
		}
	}
	
	
	
	
}
