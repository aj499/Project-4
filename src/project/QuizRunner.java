package project;

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
	
	private DataManager worldData;
	
	public QuizRunner(DataManager newWorldData, String newPreTestTopic){
		worldData = newWorldData;
		preTestTopic = newPreTestTopic;
		
		inPreTest = true;
		quizRunning = false;
	}
	
	public void startQuiz(String topic, MapMode mode){
		currentTopic = topic;
		currentMode = mode;
		
		currentQuestionNumber = 0;
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
