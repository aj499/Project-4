package project;

import java.util.Random;
import java.util.Vector;

/*
 * Class for holding data corresponding to a student's use of the program.
 */
public class StudentData {
	private Vector<String> countriesSeenHealth;
	private Vector<String> countriesSeenEconomic;
	private Vector<String> continentsSeenHealth;
	private Vector<String> continentsSeenEconomic;
	private String name;
	
	/**
	 * Create a new StudentData object for a student of the given name.
	 * 
	 * @param newName the name of the student whose data is stored in this object 
	 */
	public StudentData(String newName){
		name = newName;
		countriesSeenHealth = new Vector<String>();
		countriesSeenEconomic = new Vector<String>();
		continentsSeenHealth = new Vector<String>();
		continentsSeenEconomic = new Vector<String>();
	}
	
	/**
	 * Indicate that the student has looked at the info for the given country
	 * in the given mapmode.
	 * 
	 * @param country the country the student looked at
	 * @param currentMapMode the map mode in which they looked at the country
	 */
	public void addCountrySeen(String country, project.MapPanel.MapMode currentMapMode){
		if(currentMapMode == project.MapMode.HEALTH && !countriesSeenHealth.contains(country)){//deduplicate additions
			countriesSeenHealth.add(country);
		} else if(currentMapMode == project.MapMode.ECONOMIC && !countriesSeenEconomic.contains(country)){
			countriesSeenEconomic.add(country);
		}
	}
	
	/**
	 * Indicate that the student has looked at the info for the given continent
	 * in the given mapmode.
	 * 
	 * @param continent the continent the student looked at
	 * @param modeSeenIn the map mode in which they looked at the country
	 */
	public void addContinentSeen(String continent, MapMode modeSeenIn){
		if(modeSeenIn == MapMode.HEALTH && !continentsSeenHealth.contains(continent)){//deduplicate additions
			continentsSeenHealth.add(continent);
		} else if(modeSeenIn == MapMode.ECONOMIC && !continentsSeenEconomic.contains(continent)){
			continentsSeenEconomic.add(continent);
		}
	}
	
	/**
	 * Returns the name of the student.
	 * @return the name of the student
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Returns a list of the countries seen by the student in health mode.
	 * @return a list of the countries seen by the student in health mode
	 */
	public Vector<String> getCountriesSeenHealth(){
		return countriesSeenHealth;
	}
	
	/**
	 * Returns a list of the countries seen by the student in economic mode.
	 * @return a list of the countries seen by the student in economic mode
	 */
	public Vector<String> getCountriesSeenEconomic(){
		return countriesSeenEconomic;
	}
	
	/**
	 * Returns a list of the continents seen by the student in health mode.
	 * @return a list of the continents seen by the student in health mode
	 */
	public Vector<String> getContinentsSeenHealth(){
		return continentsSeenHealth;
	}
	
	/**
	 * Returns a list of the continents seen by the student in economic mode.
	 * @return a list of the continents seen by the student in economic mode
	 */
	public Vector<String> getContinentsSeenEconomic(){
		return continentsSeenEconomic;
	}
	
	/**
	 * Returns whether or not the student has looked at a given country in the indicated mode.
	 * 
	 * @param countryToCheck the country we want to know whether or not the student looked at
	 * @param modeSeenIn the mode we want to know whether or not the student viewed it
	 * @return whether or not the student looked at the given country in the given mode
	 */
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
	
<<<<<<< HEAD
=======

>>>>>>> Adam
	/**
	 * Returns whether or not the student has looked at a given continent in the indicated mode.
	 * 
	 * @param continentToCheck the continent we want to know whether or not the student looked at
	 * @param modeSeenIn the mode we want to know whether or not the student viewed it
	 * @return whether or not the student looked at the given continent in the given mode
	 */
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
<<<<<<< HEAD
=======

>>>>>>> Adam
}
