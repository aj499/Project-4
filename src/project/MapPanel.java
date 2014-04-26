package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class MapPanel extends JPanel implements ActionListener, MouseListener{


	public enum Continent{
		WORLD, NORTH_AMERICA, SOUTH_AMERICA, EUROPE, AFRICA, ASIA;
	}
	
	public enum MapMode{
		ECONOMIC, HEALTH; //TODO: rename later as appropriate to content?
	}
	
	/* --||-- BEGIN VARIABLES --||-- */
	
	//to make Eclipse shut up
	private static final long serialVersionUID = 1l;
	
	private DataManager worldData;
	private QuizRunner quizRunner;
	
	//Width of the window
	private final static int width = 600;
	//Height of the window
	private final static int height = 700;
	

	//state variables
	private String currentView;//which continent are we looking at?	
	private String currentCountry;//what country are we looking at right now?
	private MapMode currentMapMode;//what mode is the map in?
	//private boolean quizRunning;//is the user in a quiz right now?
	private StudentData currentStudent;//who is the user and what have they seen?
	private boolean inPreTest;//are they taking the pretest

	//private boolean inPreTest;//are they taking the pretest


	
	//buttons for the countries
	private HashMap<String, AppButton> buttons;//a hash of all the buttons for the countries
	
	//images for the Maps
	//and so on for each continent
	
	//buttons for the UI
	//NB: these must be AppButtons or actionPerformed will break!
	private AppButton mapModeChangeButton;
	private AppButton quizButton;
	private AppButton backButton;//go back to world view from continentView
	
	/* --||-- END VARIABLES --||-- */
	
	/**
	 * Creates a new MapPanel based on data from the given DataManager.
	 * 
	 * @param newWorldData the DataManager to load data from
	 */


	public MapPanel(DataManager newWorldData, StudentData newStudentData, project.MapMode mapType){
		//handle passed-in data
		worldData = newWorldData;
		currentStudent = newStudentData;
		
		//create a button for each country
		String[] countryButtonList = worldData.getCountryList();
		for(int i = 0; i < countryButtonList.length; i++){
			buttons.put(countryButtonList[i], new AppButton(countryButtonList[i]));
		}
		
		//set up a QuizRunner and basic state
		String initialQuizTopic = "NULL"; //TODO:= something derived from StudentData
		
		quizRunner = new QuizRunner(worldData, initialQuizTopic);
		quizRunner.startQuiz(initialQuizTopic, currentMapMode);
		//TODO: get and set the rest of the data on the subject of the pre-test from currentStudent
		
		//delegate to helper function for UI setup

		setUp(type);

	public MapPanel(DataManager newWorldData, StudentData newStudentData){
		//TODO: do Swing set up here as necessary
		//ie width, height setting, etc
		
		//handle passed-in data
		worldData = newWorldData;
		currentStudent = newStudentData;
		
		//delegate to helper function for rest of setup
		setUp();
		setUp(mapType);

	}
	
	/**
	 * Does Swing set up for a MapPanel.
	 * Helper function for the constructor.
	 * <p>
	 * (Assumes that worldData has been set previously.)
	 */

	private void setUp(MapMode type){
		//TODO: set text on all buttons correctly, including setting up the quiz button for being in-quiz
		
		quizButton = new AppButton();
		quizButton.setText("End Quiz");
		

	private void setUp(){

		setLayout(new BorderLayout());
		//set default values for what we're looking at
		currentView = "World";
		currentCountry = "none";
		currentMapMode = MapMode.ECONOMIC;
		
		setBackground(Color.black);
		ImageIcon map = new ImageIcon("lifeExpectancyEdit.png"); 
		setSize(map.getIconWidth(), map.getIconHeight());

		
		JLabel mapLabel = new JLabel();
		JPanel infoBox = new JPanel();
		infoBox.setPreferredSize(new Dimension(100, map.getIconHeight()));
		infoBox.setLocation(200,200);
		infoBox.setBackground(Color.RED);
		infoBox.setOpaque(true);


		
		JLabel mapLabel = new JLabel();
		JLabel infoBox = new JLabel();
		infoBox.setSize(200,map.getIconHeight());
		infoBox.setBackground(Color.RED);
		infoBox.setVisible(true);
		
		infoBox.setText("INFOBOX");
		

		mapLabel.setIcon(map);

		add(mapLabel, BorderLayout.WEST);	
		add(infoBox, BorderLayout.EAST);


		mapLabel.validate();
		mapLabel.repaint();

		
		//layoutButtons();//set up buttons for the current view
	}
	
	/**
	 * Helper function that performs all the work (UI, etc.) to change the view
	 * to a given continent.
	 * 
	 * @param continentToChangeTo the new continent to view
	 */
	private void changeContinent(String continentToChangeTo){
		//clear screen of buttons
		sweepButtons();
		
		currentView = continentToChangeTo;
		
		//note that we've now seen this new continent
		currentStudent.addContinentSeen(continentToChangeTo, currentMapMode);
		
		//TODO: load new image here as appropriate
		//TODO: update the InfoBox here as well
		
		//set up new buttons
		layoutButtons();
	}
	
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
				buttons.get(countriesToLoad.get(i)).setLocation(xPositionForButton, yPositionForButton);
				
				//add it to the panel
				add(buttons.get(countriesToLoad.get(i)));
			}
		} 
	}
	
	/**
	 * Helper function that performs all the work (UI, etc.) to change the view
	 * to the given county.
	 * 
	 * @param countryToChangeTo the new country to view
	 */
	private void changeCountry(String countryToChangeTo){
		currentCountry = countryToChangeTo;
		
		//update the info displayed in the info box
		updateInfoBox(worldData.getDataForCountry(currentCountry));
		
		//note that we've seen this new country
		currentStudent.addCountrySeen(currentCountry, currentMapMode);
		


		mapLabel.validate();
		mapLabel.repaint();

	}
	
	/**
	 * Fill the InfoBox with the given data on a country.
	 * 
	 * @param newCountry the data to display about the given country
	 */
	private void updateInfoBox(CountryData newCountry){
		//TODO: implement this once layout is done
		
		//clear the infobox
		
		//extract data from the CountryData and format it appropriately
		//then add it
		
		if(currentMapMode == MapMode.ECONOMIC){
			JLabel gdpPerCapita = new JLabel();
			JLabel gdpRealGrowthRate = new JLabel();
			JLabel agriculturePercentageOfGdp = new JLabel();
			JLabel economicFreedomScore= new JLabel();
			JLabel lowestTenIncome = new JLabel();
			JLabel highestTenIncome = new JLabel();
			JLabel majorIndustries = new JLabel();
			JLabel unemploymentRate = new JLabel();
			JLabel majorEconomicIssue = new JLabel();
			JLabel makeADifferenceEconomic = new JLabel();
			
			//CountryData workingCountry = worldData.getDataForCountry(currentCountry);
			gdpPerCapita.setText(newCountry.getGpdPerCapita());
			gdpRealGrowthRate.setText(newCountry.getGdpRealGrowthRate());
			agriculturePercentageOfGdp.setText(newCountry.getagriculturePercentageOfGdp());
			economicFreedomScore.setText(newCountry.getEconomicFreedomScore());
			lowestTenIncome.setText(newCountry.getLowestTenIncome());
			highestTenIncome.setText(newCountry.getHighestTenIncome());
			majorIndustries.setText(newCountry.getMajorIndustries());
			unemploymentRate.setText(newCountry.getUnemploymentRate());
			majorEconomicIssue.setText(newCountry.getMajorEconomicIssue());
			makeADifferenceEconomic.setText(newCountry.getMakeADifferenceEconomic());
			
		}//if Economic mode
		
		
	}
	
	/**
	 * Respond to misc. events generated by the UI.
	 * 
	 * @param e the ActionEvent that represents the event that occurred
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Event " + e.toString() + " did the thing!");
		
		//TODO: URGENT work out how to use buttons for selection of answers on the quiz!
		//have the runQuiz function just ask a question at a time and check answer, jumping back via the button clicks each time?
		//Éseems like it'll have to be that way, unless we go multithreadÉ
		
		//if the button clicked was the button for a country and we're not in a quiz
		//change the view to that country
		if(!quizRunner.getQuizRunning() && buttons.containsKey(((AppButton) e.getSource()).getId())){//hopefully this cast worksÉmake all buttons AppButtons to ensure that
			String countryClicked = ((AppButton) e.getSource()).getId();
			

			//change currentCountry appropriately
			currentCountry = countryClicked;
			
			//update the StudentData
			currentStudent.addCountrySeen(currentCountry, currentMapMode);
			
			//update the info box
			//updateInfoBox(worldData.getDataForCountry(countryClicked));

			//update appropriately
			changeCountry(countryClicked);

		} else if(e.getSource().equals(backButton)){//back button
			if(!currentView.equals("World")){//we only need to change things if we're not in world view
				//update appropriately
				changeContinent("World");
			}
		} else if(e.getSource().equals(quizButton)){//start/stop quiz

			if(quizRunning){//if they're in a quiz

				if(inPreTest){//don't let people bail on the pre-test

			if(quizRunner.getQuizRunning()){//if they're in a quiz
				if(quizRunner.getInPreTest()){//don't let people bail on the pre-test

					JOptionPane.showMessageDialog(this, "You must finish the pre-test first!", "Cannot leave pre-test", JOptionPane.WARNING_MESSAGE);
				} else {
					//show a message to the user
					JOptionPane.showMessageDialog(this, "Thanks for playing!", "Quiz ended", JOptionPane.INFORMATION_MESSAGE);
					
					//end the quiz
					quizRunner.endQuiz();
					
					//change the label on the button
					quizButton.setText("Start Quiz");
				}

			} else if(!quizRunning){//they're not in a quiz, so let's start one!

				//show a message to the user
				JOptionPane.showMessageDialog(this, "Thanks for playing!", "Quiz ended", JOptionPane.INFORMATION_MESSAGE);
				
				//flip the bool
				quizRunning = false;
				
				//change the label on the button
				quizButton.setText("Start Quiz");
			} else if(!quizRunning && currentView != "World"){//they're in a continent but not in a quiz, so let's start one!

				//flip the bool
				quizRunning = true;
				

			} else if(!quizRunner.getQuizRunning()){//they're not in a quiz, so let's start one!

				//change the label on the button
				quizButton.setText("End Quiz");
				
				//start the quiz

				runQuiz();

			} else if(currentView.equals("World")){//you can't start a quiz from the world view
				JOptionPane.showMessageDialog(this, "You must select a continent to take a quiz!", "Error", JOptionPane.ERROR_MESSAGE);

				quizRunner.startQuiz(currentView, currentMapMode);

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
		if(currentView.equals("World")){
			//get the locations of the click
			int mouseX = e.getX();
			int mouseY = e.getY();
			
			//check it against the bounding box of each country
			String continentNames[] = worldData.getContinentList();
			for(int i = 0; i < continentNames.length; i++){
				if(!continentNames[i].equals("World")){//don't check against the world's bounding box
					//get data on the continent
					ContinentData continentData = worldData.getDataForContinent(continentNames[i]);
					
					if(continentData.isPointInBounds(mouseX, mouseY)){//if we're inside this continent

						//note that we've changed continent
						currentView = continentNames[i];

						
						//update StudentData
						currentStudent.addContinentSeen(currentView, currentMapMode);
						
						//TODO: change layout appropriately here
						

						
						//update StudentData
						currentStudent.addContinentSeen(currentView, currentMapMode);
						
						//TODO: change layout appropriately here

						//update appropriately
						changeContinent(continentNames[i]);

						

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
