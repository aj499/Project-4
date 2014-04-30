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
	private String gdpPerCapita;
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
	
	/**
	 * A constructor that sets default values for all variables in country
	 * CountryData()
	 */
	public CountryData() {
		countryName= "new country";
		gdpPerCapita= "no money";
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
		photoPathHealth="no photo path health";
	}//constructor

	//SETTERS//----------------------------------------
	/**
	 * sets country name
	 * SetCountryName(String)
	 * @param newCountryName
	 */
	public void setCountryName(String newCountryName) {
		countryName=newCountryName;
	}//setCountryName

	/**
	 * sets gdp per capita
	 * setGpdPerCapita(String)
	 * @param newGdpPerCapita
	 */
	public void setGdpPerCapita(String newGdpPerCapita) {
		gdpPerCapita=newGdpPerCapita;
	}//setGdpPerCapita
	
	/**
	 * setGdpRealGrowthRate(String)
	 * @param newGdpRealGrowthRate
	 */
	public void setGdpRealGrowthRate(String newGdpRealGrowthRate) {
		gdpRealGrowthRate=newGdpRealGrowthRate;
	}//setGdpRealGrowthRate

	/**
	 *sets Agriculture Percentage
	 * setAgriculturePercentageOfGdp(String)
	 * @param newagriculturePercentageOfGdp
	 */
	public void setAgriculturePercentageOfGdp(String newagriculturePercentageOfGdp) {
		agriculturePercentageOfGDP=newagriculturePercentageOfGdp;
	}//setAgriculturePercentageOfGdp
	
	/**
	 * sets Economic Freedom Score
	 * setEconomicFreedomScore(String)
	 * @param newEconomicFreedomScore
	 */
	public void setEconomicFreedomScore(String newEconomicFreedomScore) {
		economicFreedomScore=newEconomicFreedomScore;
	}//setEconomicFreedomScore
	
	/**
	 * sets Lowest ten Income
	 * setLowestTenIncome(String)
	 * @param newLowestTenIncome
	 */
	public void setLowestTenIncome(String newLowestTenIncome) {
		lowestTenIncome=newLowestTenIncome;
	}//setLowestTenIncome
	
	/**
	 * sets highest ten income
	 * setHighestTenIncome(String)
	 * @param newHighestTenIncome
	 */
	public void setHighestTenIncome(String newHighestTenIncome) {
		highestTenIncome=newHighestTenIncome;
	}//setHighestTenIncome
	
	/**
	 * sets major industries
	 * setMajorIndustries(String)
	 * @param newMajorIndustries
	 */
	public void setMajorIndustries(String newMajorIndustries) {
		majorIndustries=newMajorIndustries;
	}//setMajorIndustries
	
	/**
	 * Sets unemployment rate
	 * setUnemploymentRate(String)
	 * @param newUnemploymentRate
	 */
	public void setUnemploymentRate(String newUnemploymentRate) {
		unemploymentRate=newUnemploymentRate;
	}//setUnemploymentRate

	/**
	 * sets major economic issue
	 * setMajorEconomicIssue(String)
	 * @param newMajorEconomicIssue
	 */
	public void setMajorEconomicIssue(String newMajorEconomicIssue) {
		majorEconomicIssue=newMajorEconomicIssue;
	}//setMajorEconomicIssue

	/**
	 * sets the string for how one can make a difference economically
	 * setMakeADifferenceEconomic(String)
	 * @param newMakeADifferenceEconomic
	 */
	public void setMakeADifferenceEconomic(String newMakeADifferenceEconomic) {
		makeADifferenceEconomic=newMakeADifferenceEconomic;
	}//setMakeADifferenceEconomic

	/**
	 * sets photo path
	 * setPhotoPathEconomic(String)
	 * @param newPhotoPathEconomic
	 */
	public void setPhotoPathEconomic(String newPhotoPathEconomic) {
		photoPathEconomic=newPhotoPathEconomic;
	}//setPhotoPathEconomic

	/**
	 * sets life expectancy
	 * setLifeExpectancy(String)
	 * @param newLifeExpectancy
	 */
	public void setLifeExpectancy(String newLifeExpectancy) {
		lifeExpectancy=newLifeExpectancy;
	}//setLifeExpectancy

	/**
	 * sets maternal mortality rate
	 * setMaternalMortalityRate(String)
	 * @param newMaternalMortalityRate
	 */
	public void setMaternalMortalityRate(String newMaternalMortalityRate) {
		maternalMortalityRate=newMaternalMortalityRate;
	}//setMaternalMortalityRate

	/**
	 * sets infant mortality rate
	 * setInfantMortalityRate(String)
	 * @param newInfantMortalityRate
	 */
	public void setInfantMortalityRate(String newInfantMortalityRate) {
		infantMortalityRate=newInfantMortalityRate;
	}//setInfantMortalityRate

	/**
	 * sets underweight children percent
	 * setChildrenUnderweightPercentage(String)
	 * @param newChildrenUnderweightPercentage
	 */
	public void setChildrenUnderweightPercentage(String newChildrenUnderweightPercentage) {
		childrenUnderweightPercentage=newChildrenUnderweightPercentage;
	}//setChildrenUnderweightPercentage

	/**
	 * sets physician density
	 * setPhysicianDensity(String)
	 * @param newPhysicianDensity
	 */
	public void setPhysicianDensity(String newPhysicianDensity) {
		physicianDensity=newPhysicianDensity;
	}//setPhysicianDensity

	/**
	 * sets risk of infectious disease
	 * setRiskOfInfectiousDisease(String)
	 * @param newRiskOfInfectiousDisease
	 */
	public void setRiskOfInfectiousDisease(String newRiskOfInfectiousDisease) {
		riskOfInfectiousDisease=newRiskOfInfectiousDisease;
	}//setRiskOfInfectiousDisease

	/**
	 * sets most common disease
	 * setMostCommonDiseases(String)
	 * @param newMostCommonDiseases
	 */
	public void setMostCommonDiseases(String newMostCommonDiseases) {
		mostCommonDiseases=newMostCommonDiseases;
	}//setMostCommonDiseases

	/**
	 * sets major health issue
	 * setMajorHealthIssue(String)
	 * @param newMajorHealthIssue
	 */
	public void setMajorHealthIssue(String newMajorHealthIssue) {
		majorHealthIssue=newMajorHealthIssue;
	}//setMajorHealthIssue

	/**
	 * sets make a difference health
	 * setMakeADifferenceHealth(String)
	 * @param newMakeADifferenceHealth
	 */
	public void setMakeADifferenceHealth(String newMakeADifferenceHealth) {
		makeADifferenceHealth=newMakeADifferenceHealth;
	}//setMakeADifferenceHealth

	/**
	 * sets photo path for health
	 * setPhotoPathHealth(String)
	 * @param newPhotoPathHealth
	 */
	public void setPhotoPathHealth(String newPhotoPathHealth) {
		photoPathHealth=newPhotoPathHealth;
	}//setPhotoPathHealth
	
	/**
	 * sets X coordinate of button
	 * setButtonXPosition(String)
	 * @param newButtonXPosition
	 */
	public void setButtonXPosition(int newButtonXPosition) {
		buttonXPosition = newButtonXPosition;
	}//setButtonXPosition
	
	/**
	 * sets Y coordinate of button
	 * setButtonYPosition(String)
	 * @param newButtonYPosition
	 */
	public void setButtonYPosition(int newButtonYPosition) {
		buttonYPosition = newButtonYPosition;
	}//setButtonYPosition
	
	//GETTERS//-------------------------------------
	/**
	 * gets country name
	 * getCountryName
	 * @return countryName
	 */
	public String getCountryName() {
		return countryName;
	}//getCountryName

	/**
	 * gets GDP per capita
	 * getGdpPerCapita
	 * @return gdpPerCapita
	 */
	public String getGdpPerCapita() {
		return gdpPerCapita;
	}//getGdpPerCapita

	/**
	 * gets GDP real growth rate
	 * getGdpRealGrowthRate
	 * @return gdpRealGrowthRate
	 */
	public String getGdpRealGrowthRate() {
		return gdpRealGrowthRate;
	}//getGdpRealGrowthRate

	/**
	 * gets agricultural percentage of gdp
	 * getAgriculturePercentageOfGdp
	 * @return agriculturePercentageOfGdp
	 */
	public String getAgriculturePercentageOfGdp() {
		return agriculturePercentageOfGDP;
	}//getAgriculturePercentageOfGdp

	/**
	 * gets economic freedom score
	 * getEconomicFreedomScore
	 * @return economicFreedomScore
	 */
	public String getEconomicFreedomScore() {
		return economicFreedomScore;
	}//getEconomicFreedomScore

	/**
	 * gets the lowest ten percent income
	 * getLowestTenIncome
	 * @return lowestTenIncome
	 */
	public String getLowestTenIncome() {
		return lowestTenIncome;
	}//getLowestTenIncome

	/**
	 * gets the highest ten percent income
	 * getHighestTenIncome
	 * @return highestTenIncome
	 */
	public String getHighestTenIncome() {
		return highestTenIncome;
	}//getHighestTenIncome

	/**
	 * gets the country's major industries
	 * getMajorIndustries
	 * @return majorIndustries
	 */
	public String getMajorIndustries() {
		return majorIndustries;
	}//getMajorIndustries

	/**
	 * gets the country's unemployment rate
	 * getUnemploymentRate
	 * @return unemploymentRate
	 */
	public String getUnemploymentRate() {
		return unemploymentRate;
	}//getUnemploymentRate

	/**
	 * gets the country's major economic issue
	 * getMajorEconomicIssue
	 * @return majorEconomicIssue
	 */
	public String getMajorEconomicIssue() {
		return majorEconomicIssue;
	}//getMajorEconomicIssue

	/**
	 * gets how you can make a difference economically
	 * getMakeADifferenceEconomic
	 * @return makeADifferenceEconomic
	 */
	public String getMakeADifferenceEconomic() {
		return makeADifferenceEconomic;
	}//getMakeADifferenceEconomic

	/**
	 * gets the photo path of the economic photo
	 * getPhotoPathEconomic
	 * @return photoPathEconomic
	 */
	public String getPhotoPathEconomic() {
		return photoPathEconomic;
	}//getPhotoPathEconomic

	/**
	 * gets the life expectancy
	 * getLifeExpectancy
	 * @return lifeExpectancy
	 */
	public String getLifeExpectancy() {
		return lifeExpectancy;
	}//getLifeExpectancy

	/**
	 * gets the maternal mortality rate
	 * getMaternalMortalityRate
	 * @return maternalMortalityRate
	 */
	public String getMaternalMortalityRate() {
		return maternalMortalityRate;
	}//getMaternalMortalityRate

	/**
	 * gets the infant mortality rate
	 * getInfantMortalityRate
	 * @return infantMortalityRate
	 */
	public String getInfantMortalityRate() {
		return infantMortalityRate;
	}//getInfantMortalityRate

	/**
	 * gets the percentage of children underweight
	 * getChildrenUnderweightPercentage
	 * @return childrenUnderweightPercentage
	 */
	public String getChildrenUnderweightPercentage() {
		return childrenUnderweightPercentage;
	}//getChildrenUnderweightPercentage

	/**
	 * gets the physician density
	 * getPhysicianDensity
	 * @return physicianDensity
	 */
	public String getPhysicianDensity() {
		return physicianDensity;
	}//getPhysicianDensity

	/**
	 * gets the risk of infectious disease
	 * getRiskOfInfectiousDisease
	 * @return riskOfInfectiousDisease
	 */
	public String getRiskOfInfectiousDisease() {
		return riskOfInfectiousDisease;
	}//getRiskOfInfectiousDisease

	/**
	 * gets the most common diseases
	 * getMostCommonDiseases
	 * @return mostCommonDiseases
	 */
	public String getMostCommonDiseases() {
		return mostCommonDiseases;
	}//getMostCommonDiseases

	/**
	 * gets the major health issue
	 * getMajorHealthIssue
	 * @return majorHealthIssue
	 */
	public String getMajorHealthIssue() {
		return majorHealthIssue;
	}//getMajorHealthIssue

	/**
	 * gets how you can make a difference in health
	 * getMakeADifferenceHealth
	 * @return makeADifferenceHealth
	 */
	public String getMakeADifferenceHealth() {
		return makeADifferenceHealth;
	}//getMakeADifferenceHealth

	/**
	 * gets the photo path for the health photo
	 * getPhotoPathHealth
	 * @return photoPathHealth
	 */
	public String getPhotoPathHealth() {
		return photoPathHealth;
	}//getPhotoPathHealth
	
	/**
	 * gets the x coordinate of the button
	 * getButtonXPosition
	 * @return buttonXPosition
	 */
	public int getButtonXPosition(){
		return buttonXPosition;
	}//getButtonXPosition
	
	/**
	 * gets the y coordinate of the button
	 * getButtonYPosition
	 * @return buttonYPosition
	 */
	public int getButtonYPosition(){
		return buttonYPosition;
	}//getButtonYPosition
	
	/**
	 * sets all of the variables from the buffered reader
	 * setAll
	 */
	public void setAll(BufferedReader bufferedReader){
		try {
			setGdpPerCapita(bufferedReader.readLine());
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
			e.printStackTrace();
		}//catch
	}//setAll
	
	/**
	 * generateEconQuestion
	 * 
	 * randomly generates a question to quiz the user on 
	 * economic facts.
	 * 
	 * @return a randomly generated economic question
	 */
	public String generateEconQuestion(){

		int indexToChooseQuestionRandomly;
		Random generator = new Random();
		int minimum = 0;
		int maximum = 6;
		int range = maximum - minimum + 1;
		indexToChooseQuestionRandomly =  generator.nextInt(range) + minimum;

		ArrayList<String> econQuestions = new ArrayList<String>();
		econQuestions.add("Which country has a GDP per capita of " + getGdpPerCapita() + "?");
		econQuestions.add("Which country has a real GDP growth rate of " + getGdpRealGrowthRate() + "?");
		econQuestions.add("In which country is agriculture " + getAgriculturePercentageOfGdp() + " of GDP?");
		econQuestions.add("Which country has an economic freedom score of " + getEconomicFreedomScore() + "?");
		econQuestions.add("In which country is the poorest 10%'s income " + getLowestTenIncome() + " of the country's total income?");
		econQuestions.add("In which country is the wealthiest 10%'s income " + getHighestTenIncome() + " of the country's total income?");
		econQuestions.add("Which country has an unemployment rate of " + getUnemploymentRate() + "?");
		econQuestions.add("In which country is the average income of its citizens " + getGdpPerCapita() +"?");
		econQuestions.add("In which country are " + getUnemploymentRate() +" of citizens unemployed?");
		econQuestions.add("Which country's overall income grew at a rate of " + getGdpRealGrowthRate() + " last year?");

		return econQuestions.get(indexToChooseQuestionRandomly);
	}//generateEconQuestion

	/**
	 * generateHealthQuestion
	 * 
	 * randomly generates a question to quiz the user on 
	 * health facts.
	 * 
	 * @return a randomly generated health question
	 */
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
		healthQuestions.add("In which country are there " + getMaternalMortalityRate() + " among mothers during childbirth?");
		healthQuestions.add("In which country are there " + getInfantMortalityRate() + " among children during the first year of life?");
		healthQuestions.add("In which country are " + getChildrenUnderweightPercentage() + " of children clinically malnourished?");
		healthQuestions.add("In which country are there " + getPhysicianDensity() + "?");
		healthQuestions.add("In which country are citizens born this year expected to live " + getLifeExpectancy() + "?");

		return healthQuestions.get(indexToChooseQuestionRandomly);
	}//generateHealthQuestion

}//CountryData class
