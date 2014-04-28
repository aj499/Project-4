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
	public void checkAnswerWithIncorrectAnswer(){
		String incorrectAnswer = "Soviet Russia";
		qr = new QuizRunner(mp, dm, "World");
		qr.startQuiz("World", MapMode.HEALTH);
		qr.loadQuestion();
		
		boolean answerWasCorrect = qr.checkAnswer(incorrectAnswer);
		
		assertFalse(answerWasCorrect);
	}

}
