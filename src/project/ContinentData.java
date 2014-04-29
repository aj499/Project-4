package project;

import java.util.Vector;

/**
 * ContinentData
 * 
 * ContinentData is an object that extends CountryData and holds the data for a continent.
 */
public class ContinentData extends CountryData{
	//private integers that hold the coordinate bounds for a continent
	private int topBound, bottomBound, rightBound, leftBound;
	//private vector that holds a list of the countries found in a continent
	private Vector<String> countryList;

	public ContinentData() {
		countryList = new Vector<String>();
	}//constructor
	
	//Setters and Getters
	public void addToCountryList(String countryName){
		countryList.add(countryName);
	}//addToCountryList
	
	public void setLeftBound(int newLeftBound){
		leftBound = newLeftBound;
	}//setLeftBound
	
	public void setTopBound(int newTopBound){
		topBound = newTopBound;
	}//setTopBound
	
	public void setRightBound(int newRightBound){
		rightBound = newRightBound;
	}//setRightBound
	
	public void setBottomBound(int newBottomBound){
		bottomBound = newBottomBound;
	}//setBottomBound
	
	public int getLeftBound(){
		return leftBound;
	}//getLeftBound
	
	public int getTopBound(){
		return topBound;
	}//getTopBound
	
	public int getRightBound(){
		return rightBound;
	}//getRightBound
	
	public int getBottomBound(){
		return bottomBound;
	}//getBottomBound
	

	/**
	 * Check if the given point is inside this continent's bounding box.
	 * 
	 * @param pointX the x coordinate of the given point
	 * @param pointY the y coordinate of the given point
	 * @return whether or not the given point is inside this continent
	 */
	public boolean isPointInBounds(int pointX, int pointY){
		if(pointX > leftBound && pointX < rightBound){
			if(pointY > topBound && pointY < bottomBound){
				return true;
			}//inner if
		}//outer if
		return false;
	}//isPointinBounds

	public Vector<String> getCountryList(){
		return countryList;
	}//getCountryList

}//ContinentData class