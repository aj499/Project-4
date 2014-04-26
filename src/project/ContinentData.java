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
	private String gpdPerCapita;
	private String gdpRealGrowthRate; 
	private String agriculturePercentageOfGDP;
	private String economicFreedomScore;
	private String lowestTenIncome;
	private String highestTenIncome;
	private String majorIndustries;
	private String unemploymentRate;
	private String majorEconomicIssue;
	private String makeADifferenceEconomic;
	private String photoPathEconomic;
	private String lifeExpectancy;
	private String maternalMortalityRate;
	private String infantMortalityRate;
	private String childrenUnderweightPercentage;
	private String physicianDensity;
	private String riskOfInfectiousDisease;
	private String mostCommonDiseases; 
	private String majorHealthIssue;
	private String makeADifferenceHealth;
	private String photoPathHealth;
	
	private ArrayList<String> countryList;
	
ContinentData() {
		
		continentName= "new continent";
		gpdPerCapita= "no money";
		gdpRealGrowthRate="doesn't grow"; 
		agriculturePercentageOfGDP="no agriculture percentage";
		economicFreedomScore= "no economic freedom";
		lowestTenIncome="no lowest ten income";
		highestTenIncome="no highest ten income";
		majorIndustries="no major industries";
		unemploymentRate="everyone has a job";
		majorEconomicIssue="no money problems";
		makeADifferenceEconomic="can't make an economic difference";
		photoPathEconomic="no photo path economic";
		lifeExpectancy="nobody lives";
		maternalMortalityRate="all mothers live";
		infantMortalityRate="all infants live";
		childrenUnderweightPercentage="all children are eating well";
		physicianDensity="no doctors";
		riskOfInfectiousDisease="disease free";
		mostCommonDiseases="no common colds"; 
		majorHealthIssue="everyone's healthy";
		makeADifferenceHealth="can't make a health difference";
		photoPathHealth="no photo path health";
	}

public void setContinentName(String newContinentName) {
	continentName=newContinentName;
}

public void setGpdPerCapita(String newGpdPerCapita) {
	gpdPerCapita=newGpdPerCapita;
}

public void setGdpRealGrowthRate(String newGdpRealGrowthRate) {
	gdpRealGrowthRate=newGdpRealGrowthRate;
}

public void setAgriculturePercentageOfGdp(String newagriculturePercentageOfGdp) {
	agriculturePercentageOfGDP=newagriculturePercentageOfGdp;
}

public void setEconomicFreedomScore(String newEconomicFreedomScore) {
	economicFreedomScore=newEconomicFreedomScore;
}

public void setLowestTenIncome(String newLowestTenIncome) {
	lowestTenIncome=newLowestTenIncome;
}

public void setHighestTenIncome(String newHighestTenIncome) {
	highestTenIncome=newHighestTenIncome;
}

public void setMajorIndustries(String newMajorIndustries) {
	majorIndustries=newMajorIndustries;
}

public void setUnemploymentRate(String newUnemploymentRate) {
	unemploymentRate=newUnemploymentRate;
}

public void setMajorEconomicIssue(String newMajorEconomicIssue) {
	majorEconomicIssue=newMajorEconomicIssue;
}

public void setMakeADifferenceEconomic(String newMakeADifferenceEconomic) {
	makeADifferenceEconomic=newMakeADifferenceEconomic;
}

public void setPhotoPathEconomic(String newPhotoPathEconomic) {
	photoPathEconomic=newPhotoPathEconomic;
}

public void setLifeExpectancy(String newLifeExpectancy) {
	lifeExpectancy=newLifeExpectancy;
}

public void setMaternalMortalityRate(String newMaternalMortalityRate) {
	maternalMortalityRate=newMaternalMortalityRate;
}

public void setInfantMortalityRate(String newInfantMortalityRate) {
	infantMortalityRate=newInfantMortalityRate;
}

public void setChildrenUnderweightPercentage(String newChildrenUnderweightPercentage) {
	childrenUnderweightPercentage=newChildrenUnderweightPercentage;
}

public void setPhysicianDensity(String newPhysicianDensity) {
	physicianDensity=newPhysicianDensity;
}

public void setRiskOfInfectiousDisease(String newRiskOfInfectiousDisease) {
	riskOfInfectiousDisease=newRiskOfInfectiousDisease;
}

public void setMostCommonDiseases(String newMostCommonDiseases) {
	mostCommonDiseases=newMostCommonDiseases;
}

public void setMajorHealthIssue(String newMajorHealthIssue) {
	majorHealthIssue=newMajorHealthIssue;
}

public void setMakeADifferenceHealth(String newMakeADifferenceHealth) {
	makeADifferenceHealth=newMakeADifferenceHealth;
}

public void setPhotoPathHealth(String newPhotoPathHealth) {
	photoPathHealth=newPhotoPathHealth;
}

public String getContinentName() {
	return continentName;
}

public String getGpdPerCapita() {
	return gpdPerCapita;
}

public String getGdpRealGrowthRate() {
	return gdpRealGrowthRate;
}

public String getagriculturePercentageOfGdp() {
	return agriculturePercentageOfGDP;
}

public String getEconomicFreedomScore() {
	return economicFreedomScore;
}

public String getLowestTenIncome() {
	return lowestTenIncome;
}

public String getHighestTenIncome() {
	return highestTenIncome;
}

public String getMajorIndustries() {
	return majorIndustries;
}

public String getUnemploymentRate() {
	return unemploymentRate;
}

public String getMajorEconomicIssue() {
	return majorEconomicIssue;
}

public String getMakeADifferenceEconomic() {
	return makeADifferenceEconomic;
}

public String getPhotoPathEconomic() {
	return photoPathEconomic;
}

public String getLifeExpectancy() {
	return lifeExpectancy;
}

public String getMaternalMortalityRate() {
	return maternalMortalityRate;
}

public String getInfantMortalityRate() {
	return infantMortalityRate;
}

public String getChildrenUnderweightPercentage() {
	return childrenUnderweightPercentage;
}

public String getPhysicianDensity() {
	return physicianDensity;
}

public String getRiskOfInfectiousDisease() {
	return riskOfInfectiousDisease;
}

public String getMostCommonDiseases() {
	return mostCommonDiseases;
}

public String getMajorHealthIssue() {
	return majorHealthIssue;
}

public String getMakeADifferenceHealth() {
	return makeADifferenceHealth;
}

public String getPhotoPathHealth() {
	return photoPathHealth;
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
