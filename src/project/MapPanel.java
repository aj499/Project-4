package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MapPanel extends JPanel implements ActionListener, MouseListener{


	public enum Continent{
		WORLD, NORTH_AMERICA, SOUTH_AMERICA, EUROPE, AFRICA, ASIA;
	}
	
	/*public enum MapMode{
		ECONOMIC, HEALTH; //TODO: rename later as appropriate to content?
	}*/
	
	/* --||-- BEGIN VARIABLES --||-- */
	
	//to make Eclipse shut up
	private static final long serialVersionUID = 1l;
	
	private DataManager worldData;
	private QuizRunner quizRunner;

	//state variables
	private String currentView;//which continent are we looking at?	
	private String currentCountry;//what country are we looking at right now?
	private MapMode currentMapMode;//what mode is the map in?
	//private boolean quizRunning;//is the user in a quiz right now?
	private StudentData currentStudent;//who is the user and what have they seen?

	//private boolean inPreTest;//are they taking the pretest
	
	//the image for the main world map
	private Image map;

	//buttons for the countries
	private HashMap<String, AppButton> buttons;//a hash of all the buttons for the countries
	
	//images for the Maps
	//and so on for each continent
	
	//buttons for the UI
	//NB: these must be AppButtons or actionPerformed will break!
	private AppButton mapModeChangeButton;
	private AppButton quizButton;
	private AppButton backButton;//go back to world view from continentView
	
	//JLabels for the infoBox
	//Economic topics
	private JLabel gdpPerCapita;
	private JLabel gdpRealGrowthRate;
	private JLabel agriculturePercentageOfGdp;
	private JLabel economicFreedomScore;
	private JLabel lowestTenIncome;
	private JLabel highestTenIncome;
	private JLabel majorIndustries;
	private JLabel unemploymentRate;
	private JLabel majorEconomicIssue;
	private JLabel makeADifferenceEconomic;
	//Health Topics
	private JLabel lifeExpectancy;
	private JLabel maternalMortalityRate;
	private JLabel infantMortalityRate;
	private JLabel childrenUnderweightPercentage;
	private JLabel physicianDensity;
	private JLabel riskOfInfectiousDisease;
	private JLabel mostCommonDiseases;
	private JLabel majorHealthIssue;
	private JLabel makeADifferenceHealth;
	
	//JLabel holding map images
	JLabel mapLabel;
	//JPanel holding all of the country information
	JPanel infoBox;
	
	/* --||-- END VARIABLES --||-- */
	
	/**
	 * Creates a new MapPanel based on data from the given DataManager.
	 * 
	 * @param newWorldData the DataManager to load data from
	 * @throws IOException 
	 */

	public MapPanel(DataManager newWorldData, StudentData newStudentData, MapMode mapType) throws IOException{
		//handle passed-in data
		worldData = newWorldData;
		currentStudent = newStudentData;
		currentMapMode = mapType; 
		buttons = new HashMap<String, AppButton>();
		
		//make a HashMap for the buttons
		buttons = new HashMap<String, AppButton>();
		
		//create a button for each country
		String[] countryButtonList = worldData.getCountryList();
		for(int i = 0; i < countryButtonList.length; i++){
			//create a button
			buttons.put(countryButtonList[i], new AppButton(countryButtonList[i]));
			//add the ActionListener to the button
			buttons.get(countryButtonList[i]).addActionListener(this);
		}
		
		//set up a QuizRunner and basic state
		String initialQuizTopic = "NULL"; //TODO:= something derived from StudentData
		
		quizRunner = new QuizRunner(this, worldData, initialQuizTopic);
		quizRunner.startQuiz(initialQuizTopic, currentMapMode);
		//TODO: get and set the rest of the data on the subject of the pre-test from currentStudent
		
		//delegate to helper function for UI setup
		setUp(currentMapMode);
	}
	
	/**
	 * Does Swing set up for a MapPanel.
	 * Helper function for the constructor.
	 * <p>
	 * (Assumes that worldData has been set previously.)
	 * @throws IOException 
	 */
	private void setUp(MapMode mapMode) throws IOException{
		
		//TODO: set text on all buttons correctly, including setting up the quiz button for being in-quiz
		if(mapMode == MapMode.ECONOMIC){
			map = ImageIO.read(new File("EconMap.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			repaint();
		}//if MapMode type is economic
		else{
			map = ImageIO.read(new File("HealthMap.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			repaint();
		}//else
		quizButton = new AppButton();
		quizButton.setText("End Quiz");
		
		setLayout(null);
		//set default values for what we're looking at
		currentView = "World";
		currentCountry = "none";
		
		setBackground(Color.black);
		setSize(1600, 500);
		
		addMouseListener(this);
		infoBox = new JPanel();
		/*JLabel test = new JLabel("HI");
		test.setSize(400, 10);*/
		add(infoBox);
		//infoBox.add(test);
		infoBox.setBounds(1200, 0, 400, 500);
		infoBox.setBackground(Color.CYAN);
		infoBox.setOpaque(true);
		repaint();
	}//setUp
	
	/**
	 * Helper function that performs all the work (UI, etc.) to change the view
	 * to a given continent.
	 * 
	 * @param continentToChangeTo the new continent to view
	 * @throws IOException 
	 */
	public void changeContinent(String continentToChangeTo) throws IOException{
		//clear screen of buttons
		sweepButtons();
		System.out.println("In change continent");
		System.out.println("Should be Africa: " + continentToChangeTo);
		currentView = continentToChangeTo;
		
		//note that we've now seen this new continent
		currentStudent.addContinentSeen(continentToChangeTo, currentMapMode);
		
		if(currentMapMode == MapMode.ECONOMIC){
			if(continentToChangeTo.equals("World")){
				map = ImageIO.read(new File("EconMap.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if going back to World
			if(continentToChangeTo.equals("Africa")){
				map = ImageIO.read(new File("EconAfrica.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if EconAfrica
			if(continentToChangeTo.equals("Asia")){
				map = ImageIO.read(new File("EconAsia.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if EconAsia
			if(continentToChangeTo.equals("Europe")){
				map = ImageIO.read(new File("EconEurope.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if EconEurope
			if(continentToChangeTo.equals("North America")){
				map = ImageIO.read(new File("EconNorthAmerica.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if EconNorthAmerica
			if(continentToChangeTo.equals("Oceania")){
				map = ImageIO.read(new File("EconOceania.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if EconAsia
			if(continentToChangeTo.equals("South America")){
				map = ImageIO.read(new File("EconSouthAmerica.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if EconSouthAmerica
		}//if MapMode is economic
		else{
			if(continentToChangeTo.equals("World")){
				map = ImageIO.read(new File("HealthMap.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if going back to World
			if(continentToChangeTo.equals("Africa")){
				map = ImageIO.read(new File("HealthAfrica.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if HealthAfrica
			if(continentToChangeTo.equals("Asia")){
				map = ImageIO.read(new File("HealthAsia.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if HealthAsia
			if(continentToChangeTo.equals("Europe")){ 
				map = ImageIO.read(new File("HealthEurope.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if HealthEurope
			if(continentToChangeTo.equals("North America")){
				map = ImageIO.read(new File("HealthNorthAmerica.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if HealthNorthAmerica
			if(continentToChangeTo.equals("Oceania")){
				map = ImageIO.read(new File("HealthOceania.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if HealthAsia
			if(continentToChangeTo.equals("South America")){
				map = ImageIO.read(new File("HealthSouthAmerica.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
				repaint();
			}//if HealthSouthAmerica
		}//if MapMode is Health
		//TODO: update the InfoBox here as well
		
		//set up new buttons
		layoutButtons();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (map != null){
			int x = 0;
			int y = 0;
			g.drawImage(map,x,y,this);
		}//if image not null
	}//paint
	
	/**
	 * Remove all the country buttons currently on the screen.
	 */
	private void sweepButtons(){
		if(currentView != "World"){//if it's in world view, there's no need to sweep buttons
			//get a list of buttons to cull
			Vector<String> countriesToSweep = worldData.getDataForContinent(currentView).getCountryList();
			
			//remove each one from the panel
			for(int i = 0; i < countriesToSweep.size(); i++){
				remove(buttons.get(countriesToSweep.get(i)));	
			}
		}
	}
	
	/**
	 * Lays out the buttons for the currently visible continent's countries.
	 */
	private void layoutButtons(){
		if(currentView != "World"){//if it's in world view, there's no buttons to layout
			//get a list of buttons to add to the layout
			Vector<String> countriesToLoad = worldData.getDataForContinent(currentView).getCountryList();
			
			CountryData countryToLayOut;
			
			//add each one to the panel
			for(int i = 0; i < countriesToLoad.size(); i++){
				//get the country data for the country
				countryToLayOut = worldData.getDataForCountry(countriesToLoad.get(i));
				
				//get coordinates of button
				int xPositionForButton = countryToLayOut.getButtonXPosition();
				int yPositionForButton = countryToLayOut.getButtonYPosition();
				
				//set coordinate of button
				buttons.get(countriesToLoad.get(i)).setSize(20, 20);
				buttons.get(countriesToLoad.get(i)).setLocation(xPositionForButton, yPositionForButton);
				
				//add it to the panel
				add(buttons.get(countriesToLoad.get(i)));
				buttons.get(countriesToLoad.get(i)).setVisible(true);
				repaint();
			}
		} 
	}//layoutButtons
	
	/**
	 * Helper function that performs all the work (UI, etc.) to change the view
	 * to the given county.
	 * 
	 * @param countryToChangeTo the new country to view
	 */
	private void changeCountry(String countryToChangeTo){
		currentCountry = countryToChangeTo;
		
		//update the info displayed in the info box
		System.out.println("in changecountry");
		updateInfoBox(worldData.getDataForCountry(currentCountry));
		
		//note that we've seen this new country
		currentStudent.addCountrySeen(currentCountry, currentView, currentMapMode);
	}
	
	/**
	 * Fill the InfoBox with the given data on a country.
	 * 
	 * @param newCountry the data to display about the given country
	 */
	private void updateInfoBox(CountryData newCountry){

		infoBox.removeAll();
		
		if(currentMapMode == MapMode.ECONOMIC){
			gdpPerCapita = new JLabel();
			gdpRealGrowthRate = new JLabel();
			agriculturePercentageOfGdp = new JLabel();
			economicFreedomScore= new JLabel();
			lowestTenIncome = new JLabel();
			highestTenIncome = new JLabel();
			majorIndustries = new JLabel();
			unemploymentRate = new JLabel();
			majorEconomicIssue = new JLabel();
			makeADifferenceEconomic = new JLabel();
			
			gdpPerCapita.setSize(400,50);
			gdpPerCapita.setText("HI");
			//gdpPerCapita.setText(newCountry.getGpdPerCapita());
			gdpRealGrowthRate.setText(newCountry.getGdpRealGrowthRate());
			agriculturePercentageOfGdp.setText(newCountry.getagriculturePercentageOfGdp());
			economicFreedomScore.setText(newCountry.getEconomicFreedomScore());
			lowestTenIncome.setText(newCountry.getLowestTenIncome());
			highestTenIncome.setText(newCountry.getHighestTenIncome());
			majorIndustries.setText(newCountry.getMajorIndustries());
			unemploymentRate.setText(newCountry.getUnemploymentRate());
			majorEconomicIssue.setText(newCountry.getMajorEconomicIssue());
			makeADifferenceEconomic.setText(newCountry.getMakeADifferenceEconomic());
			
			infoBox.add(gdpPerCapita);
			repaint();
			
		}//if Economic mode
		
		if(currentMapMode == MapMode.HEALTH){
			lifeExpectancy = new JLabel();
			maternalMortalityRate = new JLabel();
			infantMortalityRate = new JLabel();
			childrenUnderweightPercentage = new JLabel();
			physicianDensity = new JLabel();
			riskOfInfectiousDisease = new JLabel();
			mostCommonDiseases = new JLabel();
			majorHealthIssue = new JLabel();
			makeADifferenceHealth = new JLabel();

			lifeExpectancy.setSize(400,50);
			lifeExpectancy.setText("HI");
			//lifeExpectancy.setText(newCountry.getLifeExpectancy());
			maternalMortalityRate.setText(newCountry.getMaternalMortalityRate());
			infantMortalityRate.setText(newCountry.getInfantMortalityRate());
			childrenUnderweightPercentage.setText(newCountry.getChildrenUnderweightPercentage());
			physicianDensity.setText(newCountry.getPhysicianDensity());
			riskOfInfectiousDisease.setText(newCountry.getRiskOfInfectiousDisease());
			mostCommonDiseases.setText(newCountry.getMostCommonDiseases());
			majorHealthIssue.setText(newCountry.getMajorHealthIssue());
			makeADifferenceHealth.setText(newCountry.getMakeADifferenceEconomic());
			
			infoBox.add(lifeExpectancy);
			repaint();
			
		}//if Health mode
	}//updateInfoBox
	
	private void setUpNextQuestion() throws IOException{
		if(quizRunner.questionsRemainToAsk()){//if there are more questions to ask
			//get the question
			String question = quizRunner.getQuestion();
			//TODO: display the question in the UI
			
			
		} else {//the quiz is over
			endQuiz("You have successfully completed the quiz!");
		}
	}
	
	private void endQuiz(String quizEndMessage) throws IOException{
		//show a message to the user
		JOptionPane.showMessageDialog(this, quizEndMessage, "Quiz ended", JOptionPane.INFORMATION_MESSAGE);
		
		//end the quiz
		quizRunner.endQuiz();
		
		//change the label on the button
		quizButton.setText("Start Quiz");
		
		//show the user their results
		JOptionPane.showMessageDialog(this, quizRunner.getQuizEndReport(), "Your results", JOptionPane.INFORMATION_MESSAGE);
		
		//reset the UI and put it back in explore mode
		changeContinent(currentView);
	}
	
	/**
	 * Respond to misc. events generated by the UI.
	 * 
	 * @param e the ActionEvent that represents the event that occurred
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Event " + e.toString() + " did the thing!");
		
		//if the button clicked was the button for a country and we're not in a quiz
		//change the view to that country
		if(!quizRunner.getQuizRunning() && buttons.containsKey(((AppButton) e.getSource()).getId())){//hopefully this cast worksÉmake all buttons AppButtons to ensure that
			String countryClicked = ((AppButton) e.getSource()).getId();

			//update things appropriately
			changeCountry(countryClicked);
		} else if(quizRunner.getQuizRunning() && buttons.containsKey(((AppButton) e.getSource()).getId())){//country button clicked during a quiz
			//check the answer
			boolean answerWasCorrect = quizRunner.checkAnswer(((AppButton) e.getSource()).getId());
			
			//update UI appropriately
			if(answerWasCorrect){
				//congratulate user
				JOptionPane.showMessageDialog(this, "Correct answer!", "Correct", JOptionPane.INFORMATION_MESSAGE);
				
				//now move on to the next question
				try {
					setUpNextQuestion();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {//tell them they screwed up
				JOptionPane.showMessageDialog(this, "Incorrect answer!", "Incorrect", JOptionPane.WARNING_MESSAGE);
				
				if(!quizRunner.hasRemainingAttempts()){//if they've run out of attempts on this question
					//alert the user
					JOptionPane.showMessageDialog(this, "You've run out of attempts to answer this question.\nThe quiz will now move onto the next question.", "No more attempts", JOptionPane.INFORMATION_MESSAGE);
					
					//move onto the next question
					try {
						setUpNextQuestion();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();//see what happened
					}
				}
			}
		} else if(e.getSource().equals(backButton)){//back button
			if(!quizRunner.getQuizRunning()){//the back button should only work if the user's not in a quiz
				if(!currentView.equals("World")){//we only need to change things if we're not in world view
					//update appropriately
					try {
						changeContinent("World");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		} else if(e.getSource().equals(quizButton)){
			if(quizRunner.getQuizRunning()){//if they're in a quiz
				if(quizRunner.getInPreTest()){//don't let people bail on the pre-test
					JOptionPane.showMessageDialog(this, "You must finish the pre-test first!", "Cannot leave pre-test", JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						endQuiz("Thanks for playing!");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} else if(!quizRunner.getQuizRunning()){//they're not in a quiz, so let's start one!
				//first check to make sure they've actually looked at countries, so we have something to test them on
				if(currentView != "World" && !currentStudent.hasSeenCountriesInContinent(currentView, currentMapMode)){//if they're looking at a continent
					String outputMessage = "You haven't studied any countries in " + currentView + ",\nso you can't take a quiz on it yet!";
					JOptionPane.showMessageDialog(this, outputMessage, "Warning!", JOptionPane.WARNING_MESSAGE);
				} else if(currentView == "World" && !currentStudent.hasSeenCountriesInContinent("World", currentMapMode)){//if they're looking at the world
					String outputMessage = "You haven't studied any countries,\nso you can't take a quiz yet!";
					JOptionPane.showMessageDialog(this, outputMessage, "Warning!", JOptionPane.WARNING_MESSAGE);
				} else {//they've looked at countries so we can start a quix
					//change the label on the button
					quizButton.setText("End Quiz");

					//start the quiz
					quizRunner.startQuiz(currentView, currentMapMode);

					//load the first question
					try {
						setUpNextQuestion();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Respond to mouse clicks.
	 * 
	 * @param e a MouseEvent that represents a mouse click
	 */
	@Override
	public void mouseClicked(MouseEvent e){
		//only check for clicks on continents if we're looking at the whole world
		System.out.print("Clicked");
		if(currentView.equals("World")){
			//get the locations of the click
			int mouseX = e.getX();
			int mouseY = e.getY();
			//check it against the bounding box of each country
			String continentNames[] = worldData.getContinentList();
			
			for(int i = 0; i < continentNames.length; i++){
				System.out.print("ContinentNames: " + continentNames[i]);
				if(!continentNames[i].equals("World")){//don't check against the world's bounding box
					//get data on the continent
					//ContinentData continentData = worldData.getDataForContinent(continentNames[i]);
					ContinentData continentData = worldData.getDataForContinent(continentNames[i]);
					System.out.println("Continent name: " + continentNames[i]);
					System.out.println("Continent name (econFree): " + continentData.getEconomicFreedomScore());
					System.out.println("X-Coord: " + mouseX + " Y-Coord: " + mouseY);
					System.out.println("TopBound: " + worldData.getDataForContinent(continentNames[i]).getTopBound());
					System.out.println("BottomBound: " + worldData.getDataForContinent(continentNames[i]).getBottomBound());
					System.out.println("LeftBound: " + worldData.getDataForContinent(continentNames[i]).getLeftBound());
					System.out.println("RightBound: " + worldData.getDataForContinent(continentNames[i]).getRightBound());
					
					if(continentData.isPointInBounds(mouseX, mouseY)){//if we're inside this continent
						//note that we've changed continent
						currentView = continentNames[i];
						
						//update StudentData
						currentStudent.addContinentSeen(currentView, currentMapMode);
						
						//TODO: change layout appropriately here

						//update appropriately
						try {
							changeContinent(continentNames[i]);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//stop checking by terminating the for loop
						break;
					}
				}
			}
		}
	}

	/**
	 * Respond to the mouse entering this component.
	 * 
	 * @param e a MouseEvent that represents a movement of the mouse
	 */
	@Override
	public void mouseEntered(MouseEvent e){
		//Auto-generated method stub
		//Does nothing; required by interface
	}

	/**
	 * Respond to the mouse exiting this component.
	 * 
	 * @param e a MouseEvent that represents a movement of the mouse
	 */
	@Override
	public void mouseExited(MouseEvent e){
		//Auto-generated method stub
		//Does nothing; required by interface
	}

	/**
	 * Respond to mouse presses.
	 * 
	 * @param e a MouseEvent that represents a mouse press
	 */
	@Override
	public void mousePressed(MouseEvent e){
		//Auto-generated method stub
		//Does nothing; required by interface		
	}

	/**
	 * Respond to mouse releases.
	 * 
	 * @param e a MouseEvent that represents a mouse release
	 */
	@Override
	public void mouseReleased(MouseEvent e){
		//Auto-generated method stub
		//Does nothing; required by interface
	}
	
}//class MapPanel