package project;

import java.util.Random;
import java.util.Vector;

public class QuizRunner {
	private static final int TOTAL_QUESTIONS_TO_ASK = 20;
	private static final int MAX_ATTEMPTS_PER_QUESTION = 3;
	
	private String currentQuestion;
	private String currentCorrectAnswer;
	private int currentQuestionAttempts;
	
	private int currentQuestionNumber;
	private int questionsAnsweredCorrectly;
	private String currentTopic;
	private MapMode currentMode;
	private boolean inPreTest;
	private boolean quizRunning;
	
	private Vector<String> questionsAsked;
	
	private DataManager worldData;
	private MapPanel parent;//so we can change the continent shown when quizing across continents
	
	/**
	 * Creates a new QuizRunner.
	 * 
	 * @param newParent the parent of the new QuizRunner, who will handle UI for it
	 * @param newWorldData the source of data to draw upon in generating questions
	 * @param newPreTestTopic the topic for the pre-test
	 */
	public QuizRunner(MapPanel newParent, DataManager newWorldData, String newPreTestTopic){
		worldData = newWorldData;
		parent = newParent;
		
		inPreTest = true;
		quizRunning = false;
		
		questionsAsked = new Vector<String>();
	}
	
	/**
	 * Starts a new quiz on the given topic (ie area of the world)
	 * in the given mode (economic or health)
	 * @param topic the area of the world the quiz should be on
	 * @param mode whether the quiz should cover economic or health issues
	 */
	public void startQuiz(String topic, MapMode mode){
		currentTopic = topic;
		currentMode = mode;
		
		currentQuestionNumber = 0;
		questionsAnsweredCorrectly = 0;
	}
	
	/**
	 * Gets a new question for the current quiz according to the
	 * quiz's topic and mode.
	 */
	//TODO: MAKE SURE TO CHECK WHAT THEY'VE SEEN ESP. ON WORLD, BEFORE PICKING QUESTIONS!
	//Done; refine?
	public void loadQuestion(){
		String prospectiveQuestion;
		
		Vector<String> countriesToAskAbout;
		Random random = new Random();
		
		if(!currentTopic.equals("World")){//only one continent, so things is easy
			countriesToAskAbout = worldData.getDataForContinent(currentTopic).getCountryList();
			
			CountryData country;
			
			//keep picking countries randomly until we get one the user has actually looked at
			while(true){
				String countryToLoad = countriesToAskAbout.get(random.nextInt(countriesToAskAbout.size()));
				country = worldData.getDataForCountry(countryToLoad);
				if(parent.getCurrentStudent().hasCountryBeenSeen(countryToLoad, currentMode)){
					break;
				}
			}
			
			
			while(true){
				prospectiveQuestion = ((currentMode == MapMode.HEALTH) ? country.generateHealthQuestion() : country.generateEconQuestion());
				
				//only keep the question if it hasn't been asked before
				//and the user has looked at the country it asks about
				if(!questionsAsked.contains(prospectiveQuestion) && parent.getCurrentStudent().hasCountryBeenSeen(country.getCountryName(), currentMode)){
					questionsAsked.add(prospectiveQuestion);
					currentQuestion = prospectiveQuestion;
					currentCorrectAnswer = country.getCountryName();
					
					//increment counters
					currentQuestionNumber++;
					currentQuestionAttempts = 0;
					
					break;
				}
			}
		} else {
			//run through each continent in turn
			//this is stupid hacky bullshit but who cares
			String[] continents = {"North America", "South America", "Europe", "Asia", "Africa", "Oceania"};
			
			//currentTopic = continents[(int) Math.floor(((float) currentQuestionNumber) / 2.0)];
			//pick a continent to ask about randomly until we get one where the user has actually looked at a country within it
			while(true){
				currentTopic = continents[random.nextInt(continents.length)];
				if(parent.getCurrentStudent().hasSeenCountriesInContinent(currentTopic, currentMode)){
					break;
				}
			}
			
			parent.changeContinent(currentTopic);//make it so the user can see what's what
			
			loadQuestion();//get a question
			
			currentTopic = "World";
		}
		
		
	}
	
	/**
	 * Checks whether the given answer is the correct answer to the current question.
	 * 
	 * @param potentialAnswer the answer to be checked for correctness
	 * @return whether or not the given answer was correct
	 */
	public boolean checkAnswer(String potentialAnswer){
		currentQuestionAttempts++;
		
		boolean answerWasCorrect = potentialAnswer.equals(currentCorrectAnswer);
		
		if(answerWasCorrect){
			questionsAnsweredCorrectly++;
		}
		
		return answerWasCorrect;
	}
	
	/**
	 * Ends the current quiz.
	 */
	public void endQuiz(){
		//set flags
		quizRunning = false;
		inPreTest =  false;
	}
	
	/**
	 * Returns whether or not a pre-test is being run.
	 * @return whether or not a pre-test is being run
	 */
	public boolean getInPreTest(){
		return inPreTest;
	}
	
	/**
	 * Returns whether or not a quiz is being run.
	 * @return whether or not a quiz is being run
	 */
	public boolean getQuizRunning(){
		return quizRunning;
	}
	
	/**
	 * Returns the current question being asked by the quiz.
	 * @return the current question being asked by the quiz
	 */
	public String getQuestion(){
		return currentQuestion;
	}
	
	/**
	 * Returns whether or not there are questions left to ask in the current quiz.
	 * @return whether or not there are questions left to ask in the current quiz
	 */
	public boolean questionsRemainToAsk(){
		return currentQuestionNumber < TOTAL_QUESTIONS_TO_ASK;
	}
	
	/**
	 * Returns whether or not the user may make further attempts at answering the current question.
	 * @return whether or not the user may make further attempts at answering the current question
	 */
	public boolean hasRemainingAttempts(){
		return currentQuestionAttempts < MAX_ATTEMPTS_PER_QUESTION;
	}
	
	/**
	 * Returns a report of the user's performance on the most recently taken quiz.
	 * @return a report of the user's performance on the most recently taken quiz
	 */
	public String getQuizEndReport(){
		String report = "You answered " + questionsAnsweredCorrectly + " out of " + TOTAL_QUESTIONS_TO_ASK + " correctly";
		report += "\nand scored " + (int) ((((float) questionsAnsweredCorrectly) / ((float) TOTAL_QUESTIONS_TO_ASK)) * 100) + " percent.";
		
		return report;
	}
}
