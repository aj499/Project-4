package project;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


/**
 * CountryData class
 * this class stores a country and the data about the country 
 */

public class CountryData {

	private String countryName;
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

	
	private int buttonXPosition;
	private int buttonYPosition;
	

	CountryData() {

		countryName= "new country";
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
		childrenUnderweightPercentage="all children are eating good";
		physicianDensity="no doctors";
		riskOfInfectiousDisease="disease free";
		mostCommonDiseases="no common colds"; 
		majorHealthIssue="everyone's healthy";
		makeADifferenceHealth="can't make a health difference";
		photoPathHealth="no photi path health";
	}

	public void setCountryName(String newCountryName) {
		countryName=newCountryName;
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
	
	public void setButtonXPosition(int newButtonXPosition) {
		buttonXPosition = newButtonXPosition;
	}
	
	public void setButtonYPosition(int newButtonYPosition) {
		buttonYPosition = newButtonYPosition;
	}
	
	//GETTERS//-------------------------------------
	public String getCountryName() {
		return countryName;
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
	
	public int getButtonXPosition(){
		return buttonXPosition;
	}
	
	public int getButtonYPosition(){
		return buttonYPosition;
	}
	
	
	public void setAll(BufferedReader bufferedReader){
		try {
			setGpdPerCapita(bufferedReader.readLine());
			setGdpRealGrowthRate(bufferedReader.readLine());
			setAgriculturePercentageOfGdp(bufferedReader.readLine());
			setEconomicFreedomScore(bufferedReader.readLine());
			setLowestTenIncome(bufferedReader.readLine());
			setHighestTenIncome(bufferedReader.readLine());
			setMajorIndustries(bufferedReader.readLine());
			setUnemploymentRate(bufferedReader.readLine());
			setMajorEconomicIssue(bufferedReader.readLine());
			setMakeADifferenceEconomic(bufferedReader.readLine());
			setPhotoPathEconomic(bufferedReader.readLine());
			
			setLifeExpectancy(bufferedReader.readLine());
			setMaternalMortalityRate(bufferedReader.readLine());
			setInfantMortalityRate(bufferedReader.readLine());
			setChildrenUnderweightPercentage(bufferedReader.readLine());
			setPhysicianDensity(bufferedReader.readLine());
			setRiskOfInfectiousDisease(bufferedReader.readLine());
			setMostCommonDiseases(bufferedReader.readLine());
			setMajorHealthIssue(bufferedReader.readLine());
			setMakeADifferenceHealth(bufferedReader.readLine());
			setPhotoPathHealth(bufferedReader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	


	public String generateEconQuestion(){

		int indexToChooseQuestionRandomly;
		Random generator = new Random();
		int minimum = 0;
		int maximum = 6;
		int range = maximum - minimum + 1;
		indexToChooseQuestionRandomly =  generator.nextInt(range) + minimum;


		ArrayList<String> econQuestions = new ArrayList<String>();
		econQuestions.add("Which country has a GDP per capita of " + getGpdPerCapita() + "?");
		econQuestions.add("Which country has a real GDP growth rate of " + getGdpRealGrowthRate() + "?");
		econQuestions.add("In which country is agriculture " + getagriculturePercentageOfGdp() + " of GDP?");
		econQuestions.add("Which country has an economic freedom score of " + getEconomicFreedomScore() + "?");
		econQuestions.add("In which country is the poorest 10%'s income " + getLowestTenIncome() + " of the country's total income?");
		econQuestions.add("In which country is the wealthiest 10%'s income " + getHighestTenIncome() + " of the country's total income?");
		econQuestions.add("Which country has an unemployment rate of " + getUnemploymentRate() + "?");

		return econQuestions.get(indexToChooseQuestionRandomly);
	}


	public String generateHealthQuestion(){

		int indexToChooseQuestionRandomly;
		Random generator = new Random();
		int minimum = 0;
		int maximum = 4;
		int range = maximum - minimum + 1;
		indexToChooseQuestionRandomly =  generator.nextInt(range) + minimum;

		ArrayList<String> healthQuestions = new ArrayList<String>();
		healthQuestions.add("Which country has an average life expectancy of " + getLifeExpectancy() + "?");
		healthQuestions.add("Which country has a maternal mortality rate of " + getMaternalMortalityRate() + "?");
		healthQuestions.add("Which country has a infant mortality rate of " + getInfantMortalityRate() + "?");
		healthQuestions.add("In which country are " + getChildrenUnderweightPercentage() + " of children underweight?");
		healthQuestions.add("Which country has a physicians density of " + getPhysicianDensity() + "?");

		return healthQuestions.get(indexToChooseQuestionRandomly);

	}

}
