package project;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class QuizRunner {
	private static final int TOTAL_QUESTIONS_TO_ASK = 10;
	private static final int MAX_ATTEMPTS_PER_QUESTION = 3;
	
	private String currentQuestion;
	private String currentCorrectAnswer;
	private int currentQuestionAttempts;
	
	private int currentQuestionNumber;
	private int questionsAnsweredCorrectly;
	private String preTestTopic;
	private String currentTopic;
	private MapMode currentMode;
	private boolean inPreTest;
	private boolean quizRunning;
	
	private Vector<String> questionsAsked;
	
	Vector<String> continentsToAskAboutByQuestion;
	
	private DataManager worldData;
	private MapPanel parent;//so we can change the continent shown when quizing across continents
	private StudentData student;
	
	public QuizRunner(MapPanel newParent, DataManager newWorldData, StudentData newStudent){
		worldData = newWorldData;
		parent = newParent;
		student = newStudent;
		
		preTestTopic = student.getPreTestTopic();
		
		//inPreTest = true;
		//TODO: fix this later!
		inPreTest = false;
		quizRunning = false;
		
		questionsAsked = new Vector<String>();
	}
	
	public void startQuiz(String topic, MapMode mode){
		currentTopic = topic;
		currentMode = mode;
		
		quizRunning = true;
		
		currentQuestionNumber = 0;
		questionsAnsweredCorrectly = 0;
		
		questionsAsked = new Vector<String>();
		
		continentsToAskAboutByQuestion = new Vector<String>();
		
		String[] continents = {"North America", "South America", "Europe", "Asia", "Africa", "Oceania"};
		
		Vector<String> continentsSeen = new Vector<String>();
		for(int i = 0; i < continents.length; i++){
			if(student.hasSeenCountriesInContinent(continents[i], currentMode)){
				continentsSeen.add(continents[i]);
			}
		}
		
		int numQuestionsPerContinent = TOTAL_QUESTIONS_TO_ASK / continentsSeen.size();
		
		for(int i = 0; i < continentsSeen.size(); i++){
			for(int j = 0; j < numQuestionsPerContinent; j++){
				continentsToAskAboutByQuestion.add(continentsSeen.get(i));
			}
		}
		
		if(continentsToAskAboutByQuestion.size() < TOTAL_QUESTIONS_TO_ASK){
			continentsToAskAboutByQuestion.add(continentsSeen.get(0));
		}
	}
	
	public void loadQuestion(){// throws IOException{
		String prospectiveQuestion;
		
		Vector<String> countriesToAskAbout;
		
		if(!currentTopic.equals("World")){//only one continent, so things is easy
			countriesToAskAbout = worldData.getDataForContinent(currentTopic).getCountryList();
			Random random = new Random();
			
			CountryData country;
			
			while(true){
				country = worldData.getDataForCountry(countriesToAskAbout.get(random.nextInt(countriesToAskAbout.size())));
				
				//spin until we get a country they've seen
				if(student.hasCountryBeenSeen(country.getCountryName(), currentMode)){
					break;
				}
			}
			
			while(true){
				prospectiveQuestion = ((currentMode == MapMode.HEALTH) ? country.generateHealthQuestion() : country.generateEconQuestion());
				
				//spin until we get a question we haven't asked yet
				if(!questionsAsked.contains(prospectiveQuestion)){
					questionsAsked.add(prospectiveQuestion);
					currentQuestion = prospectiveQuestion;
					currentCorrectAnswer = country.getCountryName();
					
					currentQuestionNumber++;
					currentQuestionAttempts = 0;
					
					break;
				}
			}
		} else {
			/*
			//run through each continent in turn
			//this is stupid hacky bullshit but who cares
			String[] continents = {"North America", "South America", "Europe", "Asia", "Africa", "Oceania"};
			
			
			
			//currentTopic = continents[(int) Math.floor(((float) currentQuestionNumber) * ((float) continents.length) / TOTAL_QUESTIONS_TO_ASK)];
			*/
			
			currentTopic = continentsToAskAboutByQuestion.get(currentQuestionNumber);
			
			try{
				parent.changeContinent(currentTopic);//make it so the user can see what's what
			} catch(IOException e){
				System.out.println("IOException in QuizRunner::loadQuestion(): " + e.getMessage());
			}
			
			loadQuestion();
			
			currentTopic = "World";
		}
		
		
	}
	
	public boolean checkAnswer(String potentialAnswer){
		currentQuestionAttempts++;
		
		boolean answerWasCorrect = potentialAnswer.equals(currentCorrectAnswer);
		
		if(answerWasCorrect){
			questionsAnsweredCorrectly++;
		}
		
		return answerWasCorrect;
	}
	
	public void endQuiz(){
		//set flags
		quizRunning = false;
		inPreTest =  false;
	}
	
	public boolean getInPreTest(){
		return inPreTest;
	}
	
	public boolean getQuizRunning(){
		return quizRunning;
	}
	
	public String getQuestion(){
		//load a question
		loadQuestion();
		
		//give it back to the user
		return currentQuestion;
	}
	
	public boolean questionsRemainToAsk(){
		System.out.println("CQN: " + currentQuestionNumber);
		return currentQuestionNumber < TOTAL_QUESTIONS_TO_ASK;
	}
	
	public boolean hasRemainingAttempts(){
		return currentQuestionAttempts < MAX_ATTEMPTS_PER_QUESTION;
	}
	
	public int getRemainingAttempts(){
		return MAX_ATTEMPTS_PER_QUESTION - currentQuestionAttempts;
	}
	
	public String getQuizEndReport(){
		String report = "You answered " + questionsAnsweredCorrectly + " out of " + TOTAL_QUESTIONS_TO_ASK + " questions correctly";
		report += " and scored " + (int) ((((float) questionsAnsweredCorrectly) / ((float) TOTAL_QUESTIONS_TO_ASK)) * 100) + "%.";
		
		return report;
	}
}
