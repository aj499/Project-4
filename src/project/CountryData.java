package project;

/**
 * CountryData class
 * this class stores a country and the data about the country 
 */
=======
import java.util.ArrayList;
import java.util.Random;

/**
 * This class contains specific data about each country
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
	
	/**
	 * A constructor that sets default values for all variables in country
	 * CountryData()
	 */
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
	
	/**
	 * sets country name
	 * SetCountryName(newCountryName)
	 * @param newCountryName
	 */
	public void setCountryName(String newCountryName) {
		countryName=newCountryName;
	}

	/**
	 * sets gdp per capita
	 * setGpdPerCapita(newGdpPerCapita)
	 * @param newGdpPerCapita
	 */
	public void setGdpPerCapita(String newGdpPerCapita) {
		gdpPerCapita=newGdpPerCapita;
	}
	
	/**
	 * setGdpRealGrowthRate(newGdpRealGrowthRate)
	 * @param newGdpRealGrowthRate
	 */
	public void setGdpRealGrowthRate(String newGdpRealGrowthRate) {
		gdpRealGrowthRate=newGdpRealGrowthRate;
	}
	
	/**
	 *sets Agriculture Percentage
	 * setAgriculturePercentageOfGdp(newagriculturePercentageOfGdp)
	 * @param newagriculturePercentageOfGdp
	 */
	public void setAgriculturePercentageOfGdp(String newagriculturePercentageOfGdp) {
		agriculturePercentageOfGDP=newagriculturePercentageOfGdp;
	}
	
	/**
	 * sets Economic Freedom Score
	 * setEconomicFreedomScore(newEconomicFreedomScore)
	 * @param newEconomicFreedomScore
	 */
	public void setEconomicFreedomScore(String newEconomicFreedomScore) {
		economicFreedomScore=newEconomicFreedomScore;
	}
	
	/**
	 * sets Lowest ten Income
	 * setLowestTenIncome(newLowestTenIncome)
	 * @param newLowestTenIncome
	 */
	public void setLowestTenIncome(String newLowestTenIncome) {
		lowestTenIncome=newLowestTenIncome;
	}
	
	/**
	 * sets highest ten income
	 * setHighestTenIncome(newHighestTenIncome)
	 * @param newHighestTenIncome
	 */
	public void setHighestTenIncome(String newHighestTenIncome) {
		highestTenIncome=newHighestTenIncome;
	}
	
	/**
	 * sets major industries
	 * setMajorIndustries(newMajorIndustries)
	 * @param newMajorIndustries
	 */
	public void setMajorIndustries(String newMajorIndustries) {
		majorIndustries=newMajorIndustries;
	}
	
	/**
	 * Sets unemployment rate
	 * setUnemploymentRate(newUnemploymentRate)
	 * @param newUnemploymentRate
	 */
	public void setUnemploymentRate(String newUnemploymentRate) {
		unemploymentRate=newUnemploymentRate;
	}

	/**
	 * sets major economic issue
	 * setMajorEconomicIssue(newMajorEconomicIssue)
	 * @param newMajorEconomicIssue
	 */
	public void setMajorEconomicIssue(String newMajorEconomicIssue) {
		majorEconomicIssue=newMajorEconomicIssue;
	}

	/**
	 * sets the string for how one can make a difference economically
	 * setMakeADifferenceEconomic(newMakeADifferenceEconomic)
	 * @param newMakeADifferenceEconomic
	 */
	public void setMakeADifferenceEconomic(String newMakeADifferenceEconomic) {
		makeADifferenceEconomic=newMakeADifferenceEconomic;
	}

	/**
	 * sets photo path
	 * setPhotoPathEconomic(newPhotoPathEconomic)
	 * @param newPhotoPathEconomic
	 */
	public void setPhotoPathEconomic(String newPhotoPathEconomic) {
		photoPathEconomic=newPhotoPathEconomic;
	}

	/**
	 * sets life expectancy
	 * setLifeExpectancy(newLifeExpectancy)
	 * @param newLifeExpectancy
	 */
	public void setLifeExpectancy(String newLifeExpectancy) {
		lifeExpectancy=newLifeExpectancy;
	}

	/**
	 * sets maternal mortality rate
	 * setMaternalMortalityRate(newMaternalMortalityRate)
	 * @param newMaternalMortalityRate
	 */
	public void setMaternalMortalityRate(String newMaternalMortalityRate) {
		maternalMortalityRate=newMaternalMortalityRate;
	}

	/**
	 * sets infant mortality rate
	 * setInfantMortalityRate(newInfantMortalityRate)
	 * @param newInfantMortalityRate
	 */
	public void setInfantMortalityRate(String newInfantMortalityRate) {
		infantMortalityRate=newInfantMortalityRate;
	}

	/**
	 * sets underweight children percent
	 * setChildrenUnderweightPercentage(newChildrenUnderweightPercentage)
	 * @param newChildrenUnderweightPercentage
	 */
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
