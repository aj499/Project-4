package project;

import java.util.Random;
import java.util.Vector;

public class QuizRunner {
	private static final int TOTAL_QUESTIONS_TO_ASK = 20;
	
	private String currentQuestion;
	private String currentCorrectAnswer;
	private String currentAttempt;
	
	private int currentQuestionNumber;
	private String preTestTopic;
	private String currentTopic;
	private MapMode currentMode;
	private boolean inPreTest;
	private boolean quizRunning;
	
	private Vector<String> questionsAsked;
	
	private DataManager worldData;
	
	public QuizRunner(DataManager newWorldData, String newPreTestTopic){
		worldData = newWorldData;
		preTestTopic = newPreTestTopic;
		
		inPreTest = true;
		quizRunning = false;
		
		questionsAsked = new Vector<String>();
	}
	
	public void startQuiz(String topic, MapMode mode){
		currentTopic = topic;
		currentMode = mode;
		
		currentQuestionNumber = 0;
	}
	
	private void loadQuestion(){
		String prospectiveQuestion;
		
		Vector<String> countriesToAskAbout = worldData.getDataForContinent(currentTopic).getCountryList();
		Random random = new Random();
		
		CountryData country = worldData.getDataForCountry(countriesToAskAbout.get(random.nextInt(countriesToAskAbout.size())));
		
		prospectiveQuestion = ((currentMode == MapMode.HEALTH) ? country.generateHealthQuestion() : country.generateEconQuestion());
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
}
