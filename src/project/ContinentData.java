package project;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Vector;

public class ContinentData extends CountryData{
	private int topBound, bottomBound, rightBound, leftBound;
	private Vector<String> countryList;

	ContinentData() {
		//constructor	
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