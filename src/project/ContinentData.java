package project;



import java.awt.Image;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ContinentData extends CountryData{
	private int topBound, bottomBound, rightBound, leftBound;
	private String continentName;
	private ArrayList<String> countryList;

	ContinentData() {
		continentName= "new continent";
		countryList = new ArrayList<String>();
	}
	
	public void addToCountryList(String countryName){

		countryList.add(countryName);
	}

	public void setContinentName(String newContinentName) {
		continentName=newContinentName;
	}

	public void setLeftBound(int newLeftBound){
		leftBound = newLeftBound;
	}
	
	public void setRightBound(int newRightBound){
		rightBound = newRightBound;
	}

	public void setTopBound(int newTopBound){
		topBound = newTopBound;
	}
	
	public void setBottomBound(int newBottomBound){
		bottomBound = newBottomBound;
	}
	
	public ArrayList<String> getCountryList(){
		return countryList;
	}
	
	public String getContinentName(){
		return continentName;
	}
	
	public int getLeftBound(){
		return leftBound;
	}

	public int getRightBound(){
		return rightBound;
	}
	
	public int getTopBound(){
		return topBound;
	}
	
	public int getBottomBound(){
		return bottomBound;
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
			if(pointY > topBound && pointY < leftBound){
				return true;
			}
		}

		return false;
	}



	public void loadData(){
		//something here


	}


		
}
