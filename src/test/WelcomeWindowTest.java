package test;

import static org.junit.Assert.*;

import org.junit.Test;
import project.WelcomeWindow;

public class WelcomeWindowTest {
	WelcomeWindow wm;
	
	/**
	 * Make sure that we can properly make a WelcomeWindow.
	 */
	@Test
	public void test() {
		wm = new WelcomeWindow();
		
		assertNotNull(wm);
	}
	
	//We can't test anything else, since it's all either private or UI related

}
