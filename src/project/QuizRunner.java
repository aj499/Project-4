package project;

import java.util.Random;
import java.util.Vector;

public class QuizRunner {
	private static final int TOTAL_QUESTIONS_TO_ASK = 20;
	
	private String currentQuestion;
	private String currentCorrectAnswer;
	
	private int currentQuestionNumber;
	private String preTestTopic;
	private String currentTopic;
	private MapMode currentMode;
	private boolean inPreTest;
	private boolean quizRunning;
	
	private Vector<String> questionsAsked;
	
	private DataManager worldData;
	private MapPanel parent;//so we can change the continent shown when quizing across continents
	
	public QuizRunner(MapPanel newParent, DataManager newWorldData, String newPreTestTopic){
		worldData = newWorldData;
		preTestTopic = newPreTestTopic;
		parent = newParent;
		
		inPreTest = true;
		quizRunning = false;
		
		questionsAsked = new Vector<String>();
	}
	
	public void startQuiz(String topic, MapMode mode){
		currentTopic = topic;
		currentMode = mode;
		
		currentQuestionNumber = 0;
	}
	
	public void loadQuestion(){
		String prospectiveQuestion;
		
		Vector<String> countriesToAskAbout;
		
		if(!currentTopic.equals("World")){//only one continent, so things is easy
			countriesToAskAbout = worldData.getDataForContinent(currentTopic).getCountryList();
			Random random = new Random();
			
			CountryData country = worldData.getDataForCountry(countriesToAskAbout.get(random.nextInt(countriesToAskAbout.size())));
			
			while(true){
				prospectiveQuestion = ((currentMode == MapMode.HEALTH) ? country.generateHealthQuestion() : country.generateEconQuestion());
				
				if(!questionsAsked.contains(prospectiveQuestion)){
					questionsAsked.add(prospectiveQuestion);
					currentQuestion = prospectiveQuestion;
					currentCorrectAnswer = country.getCountryName();
					
					//TODO: increment cuurentQuestionNumber here?
					
					break;
				}
			}
		} else {
			//run through each continent in turn
			//this is stupid hacky bullshit but who cares
			String[] continents = {"North America", "South America", "Europe", "Asia", "Africa"};
			
			currentTopic = continents[(int) Math.floor(((float) currentQuestionNumber) / 2.0)];
			
			parent.changeContinent(currentTopic);//make it so the user can see what's what
			
			loadQuestion();
			
			currentTopic = "World";
		}
		
		
	}
	
	public boolean checkAnswer(String potentialAnswer){
		return potentialAnswer.equals(currentCorrectAnswer);
	}
	
	public void endQuiz(){
		//TODO: write this function
	}
	
	public boolean getInPreTest(){
		return inPreTest;
	}
	
	public boolean getQuizRunning(){
		return quizRunning;
	}
	
	public String getQuestion(){
		return currentQuestion;
	}
	
	public int getCurrentQuestionNumber(){
		return currentQuestionNumber;
	}
}
