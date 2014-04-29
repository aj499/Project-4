package test;

import static org.junit.Assert.*;

import org.junit.Test;
import project.DataManager;
import project.MapMode;
import project.MapPanel;
import project.QuizRunner;
import project.StudentData;

public class QuizRunnerTest {
	DataManager dm = null;//TODO: load an actual dummy data manager here!
	MapPanel mp = new MapPanel(dm, new StudentData("TEST"), MapMode.HEALTH);
	QuizRunner qr;
	
	/**
	 * Make sure that the constructor works.
	 */
	@Test
	public void testConstructor() {
		qr = new QuizRunner(mp, dm, "World");
		assertNotNull(qr);
	}
	
	/**
	 * Make sure that starting a quiz sets variables appropriately.
	 */
	@Test
	public void testStartQuiz(){
		qr = new QuizRunner(mp, null, "World");
		qr.startQuiz("World", MapMode.HEALTH);
		
		assertTrue(qr.getQuizRunning());
		assertTrue(qr.questionsRemainToAsk());
	}
	
	/**
	 * Make sure that loading a question actually loads a question.
	 */
	@Test
	public void testLoadQuestion(){
		qr = new QuizRunner(mp, dm, "World");
		qr.startQuiz("World", MapMode.HEALTH);
		qr.loadQuestion();
		
		assertNotNull(qr.getQuestion());
	}
	
	/**
	 * Make sure that incorrect answers are marked as incorrect.
	 */
	@Test
	public void testCheckAnswerWithIncorrectAnswer(){
		String incorrectAnswer = "Soviet Russia";
		qr = new QuizRunner(mp, dm, "World");
		qr.startQuiz("World", MapMode.HEALTH);
		qr.loadQuestion();
		
		boolean answerWasCorrect = qr.checkAnswer(incorrectAnswer);
		
		assertFalse(answerWasCorrect);
	}
	
	//we don't have a test for correct answer, since no one outside
	//the QuizRunner can check for what the correct answer is
	
	/**
	 * Make sure that ending the quiz sets variables appropriately.
	 */
	@Test
	public void testEndQuiz(){
		qr = new QuizRunner(mp, dm, "World");
		qr.startQuiz("World", MapMode.HEALTH);
		qr.endQuiz();
		
		assertFalse(qr.getQuizRunning());
		assertFalse(qr.getInPreTest());
	}
	
	/**
	 * Make sure that the performance report is generate correctly.
	 */
	@Test
	public void testGetQuizEndReport(){
		String expectedReport = "You answered 0 out of 10 questions correctly\nand scored 0 percent.";
		qr = new QuizRunner(mp, dm, "World");
		qr.startQuiz("World", MapMode.HEALTH);
		qr.endQuiz();
		
		assertTrue(expectedReport.equals(qr.getQuizEndReport()));
	}

}
