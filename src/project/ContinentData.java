package project;

import java.util.Vector;

public class ContinentData extends CountryData{
	private int topBound, bottomBound, rightBound, leftBound;
	private Vector<String> countryList;

	ContinentData() {
		countryList = new Vector<String>();
	}
	
	public void addToCountryList(String countryName){
		countryList.add(countryName);
	}
	
	
	public void setLeftBound(int newLeftBound){
		leftBound = newLeftBound;
	}
	
	public void setTopBound(int newTopBound){
		topBound = newTopBound;
	}
	
	public void setRightBound(int newRightBound){
		rightBound = newRightBound;
	}
	
	public void setBottomBound(int newBottomBound){
		bottomBound = newBottomBound;
	}
	

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
			}
		}

		return false;
	}

	public Vector<String> getCountryList(){
		return countryList;
	}


	public void loadData(){
		//something here


	}



}