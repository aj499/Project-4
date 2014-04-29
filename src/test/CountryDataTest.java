package test;

import static org.junit.Assert.*;

import org.junit.Test;

import project.CountryData;


public class CountryDataTest {
	
	@Test
	public void testConstructor() {
		CountryData data;
		data = new CountryData();
		assertNotNull(data);
	}
	
	@Test
	public void setCountryNameTest(){
		CountryData data= new CountryData();
		data.setCountryName("USA");
		
		String result;
		String expectedResult = "USA";
		
		result= data.getCountryName();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getCountryNameTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "new country";
		
		result= data.getCountryName();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setGdpPerCapitaTest(){
		CountryData data= new CountryData();
		data.setGdpPerCapita("40");
		
		String result;
		String expectedResult = "40";
		
		result= data.getGpdPerCapita();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getGpdPerCapitaTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "no money";
		
		result= data.getGpdPerCapita();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setgdpRealGrowthRateTest(){
		CountryData data= new CountryData();
		data.setGdpRealGrowthRate("4");
		
		String result;
		String expectedResult = "4";
		
		result= data.getGdpRealGrowthRate();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getgdpRealGrowthRateTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "doesn't grow";
		
		result= data.getGdpRealGrowthRate();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setagriculturePercentageOfGDPTest(){
		CountryData data= new CountryData();
		data.setAgriculturePercentageOfGdp("4");
		
		String result;
		String expectedResult = "4";
		
		result= data.getagriculturePercentageOfGdp();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getagriculturePercentageOfGDPTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "no agriculture percentage";
		
		result= data.getagriculturePercentageOfGdp();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void seteconomicFreedomScoreTest(){
		CountryData data= new CountryData();
		data.setEconomicFreedomScore("4");
		
		String result;
		String expectedResult = "4";
		
		result= data.getEconomicFreedomScore();
		
		assertEquals(expectedResult, result, 0);
	}
	
	
	@Test
	public void geteconomicFreedomScoreTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "no economic freedom";
		
		result= data.getEconomicFreedomScore();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setlowestTenIncomeTest(){
		CountryData data= new CountryData();
		data.setLowestTenIncome("4");
		
		String result;
		String expectedResult = "4";
		
		result= data.getLowestTenIncome();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getlowestTenIncomeTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "no lowest ten income";
		
		result= data.getLowestTenIncome();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void sethighestTenIncomeTest(){
		CountryData data= new CountryData();
		data.setHighestTenIncome("4");
		
		String result;
		String expectedResult = "4";
		
		result= data.getHighestTenIncome();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void gethighestTenIncomeTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "no lowest ten income";
		
		result= data.getHighestTenIncome();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setmajorIndustriesTest(){
		CountryData data= new CountryData();
		data.setMajorIndustries("oil");
		
		String result;
		String expectedResult = "oil";
		
		result= data.getMajorIndustries();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getmajorIndustriesTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "no major industries";
		
		result= data.getMajorIndustries();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setunemploymentRateTest(){
		CountryData data= new CountryData();
		data.setUnemploymentRate("7");
		
		String result;
		String expectedResult = "7";
		
		result= data.getUnemploymentRate();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getunemploymentRateTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "everyone has a job";
		
		result= data.getUnemploymentRate();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setmajorEconomicIssueTest(){
		CountryData data= new CountryData();
		data.setMajorEconomicIssue("everything");
		
		String result;
		String expectedResult = "everything";
		
		result= data.getMajorEconomicIssue();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getmajorEconomicIssueTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "no money problems";
		
		result= data.getMajorEconomicIssue();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setmakeADifferenceEconomicTest(){
		CountryData data= new CountryData();
		data.setMakeADifferenceEconomic("7");
		
		String result;
		String expectedResult = "7";
		
		result= data.getMakeADifferenceEconomic();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getmakeADifferenceEconomicTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "can't make an economic difference";
		
		result= data.getMakeADifferenceEconomic();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setphotoPathEconomicTest(){
		CountryData data= new CountryData();
		data.setPhotoPathEconomic("7");
		
		String result;
		String expectedResult = "7";
		
		result= data.getPhotoPathEconomic();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getphotoPathEconomicTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "can't make an economic difference";
		
		result= data.getPhotoPathEconomic();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setlifeExpectancyTest(){
		CountryData data= new CountryData();
		data.setLifeExpectancy("70");
		
		String result;
		String expectedResult = "70";
		
		result= data.getLifeExpectancy();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getlifeExpectancyTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "nobody lives";
		
		result= data.getLifeExpectancy();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setmaternalMortalityRateTest(){
		CountryData data= new CountryData();
		data.setMaternalMortalityRate("70");
		
		String result;
		String expectedResult = "70";
		
		result= data.getMaternalMortalityRate();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getmaternalMortalityRateTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "all mothers live";
		
		result= data.getMaternalMortalityRate();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setinfantMortalityRateTest(){
		CountryData data= new CountryData();
		data.setInfantMortalityRate("70");
		
		String result;
		String expectedResult = "70";
		
		result= data.getInfantMortalityRate();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getinfantMortalityRateTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "all infants live";
		
		result= data.getInfantMortalityRate();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setchildrenUnderweightPercentageTest(){
		CountryData data= new CountryData();
		data.setChildrenUnderweightPercentage("70");
		
		String result;
		String expectedResult = "70";
		
		result= data.getChildrenUnderweightPercentage();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getchildrenUnderweightPercentageTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "all children are eating good";
		
		result= data.getChildrenUnderweightPercentage();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setphysicianDensityTest(){
		CountryData data= new CountryData();
		data.setPhysicianDensity("70");
		
		String result;
		String expectedResult = "70";
		
		result= data.getPhysicianDensity();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getphysicianDensityTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "no doctors";
		
		result= data.getPhysicianDensity();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setriskOfInfectiousDiseaseTest(){
		CountryData data= new CountryData();
		data.setRiskOfInfectiousDisease("High");
		
		String result;
		String expectedResult = "High";
		
		result= data.getRiskOfInfectiousDisease();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getriskOfInfectiousDiseaseTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "disease free";
		
		result= data.getRiskOfInfectiousDisease();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setmostCommonDiseasesTest(){
		CountryData data= new CountryData();
		data.setMostCommonDiseases("malaria");
		
		String result;
		String expectedResult = "malaria";
		
		result= data.getMostCommonDiseases();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getmostCommonDiseasesTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "no common colds";
		
		result= data.getMostCommonDiseases();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setmakeADifferenceHealthTest(){
		CountryData data= new CountryData();
		data.setMakeADifferenceHealth("malaria");
		
		String result;
		String expectedResult = "malaria";
		
		result= data.getMakeADifferenceHealth();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getmakeADifferenceHealthTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "can't make a health difference";
		
		result= data.getMakeADifferenceHealth();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void setphotoPathHealthTest(){
		CountryData data= new CountryData();
		data.setPhotoPathHealth("malaria");
		
		String result;
		String expectedResult = "malaria";
		
		result= data.getPhotoPathHealth();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void getphotoPathHealthTest(){
		CountryData data= new CountryData();
		String result;
		String expectedResult = "no photi path health";
		
		result= data.getPhotoPathHealth();
		
		assertEquals(expectedResult, result, 0);
	}
	
	@Test
	public void generateEconQuestionTest(){
		CountryData data= new CountryData();
		//test to see if the question that it generates matches any of the choices i put
	}
	
	@Test
	public void generateHealthQuestionTest(){
		//test to see if the question that it generates matches any of the choices i put
	}

}
