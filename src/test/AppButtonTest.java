package test;

import static org.junit.Assert.*;

import org.junit.Test;
import project.AppButton;

public class AppButtonTest {
	AppButton ab;
	
	/**
	 * Make sure that the default constructor sets up the button correctly.
	 */
	@Test
	public void testDefaultConstructor(){
		ab = new AppButton();
		
		assertNotNull(ab);
		assertTrue(ab.getId().equals("null"));
	}
	
	/**
	 * Make sure that the non-default constructor sets up the buttons correctly.
	 */
	@Test
	public void testNonDefaultConstructor(){
		ab = new AppButton("TestButton");
		
		assertNotNull(ab);
		assertTrue(ab.getId().equals("TestButton"));
	}//testNonDefaultConstructor

}//AppButtonTest
