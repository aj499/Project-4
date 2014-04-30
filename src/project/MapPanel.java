package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * MapPanel
 * 
 * The MapPanel class holds all of the main program functionality. It loads images
 * based on what continent you want to view, or simply shows the world from an
 * economic or health-based view. It also generates buttons so that the user can
 * click on a country within a continent view. There is also an information box 
 * at the bottom that displays relevant information to whatever the user is looking 
 * at the time.
 *
 */
public class MapPanel extends JPanel implements ActionListener, MouseListener{
	
	/* --||-- BEGIN VARIABLES --||-- */

	//to make Eclipse shut up
	private static final long serialVersionUID = 1l;
	
	private DataManager worldData;
	private QuizRunner quizRunner;

	//state variables
	private String currentView;//which continent are we looking at?	
	private String currentCountry;//what country are we looking at right now?
	private MapMode currentMapMode;//what mode is the map in?
	private StudentData currentStudent;//who is the user and what have they seen?
	
	//the image for the main world map
	private Image map;

	//buttons for the countries
	private HashMap<String, AppButton> buttons;//a hash of all the buttons for the countries
	
	//buttons for the UI
	//NB: these must be AppButtons or actionPerformed will break!
	private AppButton quizButton;//start/end a quiz
	private AppButton backButton;//go back to world view from continentView
	
	//JPanel holding all of the country information
	private JPanel infoBox;
	//JPanel showing how you can make a difference
	private JPanel infoBox2;
	//JPanel holding country photo
	private JPanel photoBox;
	
	//images
	private JLabel imageLabel;
	private Image photoImage;
	private ImageIcon imageIcon;
	
	//labels
	private JLabel currentModeLabel;//quiz mode or explore mode
	
	/* --||-- END VARIABLES --||-- */
	
	/**
	 * Creates a new MapPanel based on data from the given DataManager.
	 * 
	 * @param newWorldData the DataManager to load data from
	 */
	public MapPanel(DataManager newWorldData, StudentData newStudentData, MapMode mapType){
		//handle passed-in data
		worldData = newWorldData;
		currentStudent = newStudentData;
		currentMapMode = mapType; 
		
		//make a HashMap for the buttons
		buttons = new HashMap<String, AppButton>();
		
		//create a button for each country
		String[] countryButtonList = worldData.getCountryList();
		for(int i = 0; i < countryButtonList.length; i++){
			//create a button
			buttons.put(countryButtonList[i], new AppButton(countryButtonList[i]));
			//add the ActionListener to the button
			buttons.get(countryButtonList[i]).addActionListener(this);
		}//for
		
		//set up a QuizRunner and basic state
		quizRunner = new QuizRunner(this, worldData, currentStudent);
		
		//call helper function for the heavy-duty UI setup
		setUp(currentMapMode);
	}//mapPanel
	
	/**
	 * Does Swing set up for a MapPanel.
	 * Helper function for the constructor.
	 * <p>
	 * (Assumes that worldData has been set previously.)
	 */
	private void setUp(MapMode mapMode){
		//set up variables for images
		imageIcon = new ImageIcon();
		imageLabel = new JLabel();
	
		//Checks to see which mode the user selected to choose which map image to display
		try{
			if(mapMode == MapMode.ECONOMIC){
				map = ImageIO.read(new File("EconMap.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if MapMode type is economic
			else{
				map = ImageIO.read(new File("HealthMap.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//else
		} catch(IOException e){
			System.out.println("Loading map failed! Sorry.");
		}//try
		
		repaint();
		
		//initializes the quiz button
		quizButton = new AppButton();
		quizButton.setText("Start Quiz");
		quizButton.setBounds(800, 25, 100, 50);
		quizButton.addActionListener(this);

		//initializes the back button
		backButton = new AppButton();
		backButton.setText("Back");
		backButton.setBounds(350, 25, 100, 50);
		backButton.addActionListener(this);
		
		//allows for coordinate layout control
		setLayout(null);
		//set default values for what we're looking at
		currentView = "World";
		currentCountry = "none";
		setBackground(Color.black);
		setSize(1600, 500);
		
		//makes the panel itself a mouse listener
		addMouseListener(this);
		
		//initializes the info and photobox
		infoBox = new JPanel();
		infoBox2 = new JPanel();
		photoBox = new JPanel();
		//adds everything to the panel
		add(infoBox);
		add(infoBox2);
		add(photoBox);
		add(quizButton);
		add(backButton);
		
		//initializes instructions to display in the infobox
		String instructionString = "Welcome to the World Map Explorer! Please press a continent to view its data and countries. If you wish to be quizzed on the information you have learned, press start quiz while looking at a specific continent. Once you have finished the quiz, feel free to explore other countries and take new quizzes.";
		JTextArea instructions = new JTextArea();
		instructions.setText(instructionString);
	    instructions.setEditable(false);
	    instructions.setWrapStyleWord(true);
	    instructions.setLineWrap(true);
	    instructions.setForeground(new Color(0,0,0));
	    instructions.setOpaque(false);
	    instructions.setVisible(true);
	    instructions.setFont(instructions.getFont().deriveFont(23f));
	    JScrollPane scrollPane = new JScrollPane(instructions);
	    scrollPane.setPreferredSize(new Dimension(700, 200));
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    scrollPane.setBorder(BorderFactory.createEmptyBorder());
	    
	    //infoBox.setBounds(0, 500, 800, 300);
	    infoBox.add(scrollPane);
	    scrollPane.setVisible(true);
		revalidate();
		
		infoBox.setBounds(0, 500, 1200, 200);
		infoBox.setBackground(Color.WHITE);
		infoBox.setOpaque(true);
		infoBox2.setBounds(0, 700, 1200, 50);
		
		currentModeLabel = new JLabel("EXPLORE MODE");
		currentModeLabel.setForeground(Color.RED);
		currentModeLabel.setFont(getFont().deriveFont(24f));//set font size
		currentModeLabel.setBounds(10, 10, 250, 30);
		add(currentModeLabel);
		
		infoBox2.setBounds(0, 650, 1200, 150);
		infoBox2.setBackground(Color.WHITE);
		infoBox2.setOpaque(true);

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
		
		//set currentView
		currentView = continentToChangeTo;
		
		//note that we've now seen this new continent
		currentStudent.addContinentSeen(continentToChangeTo, currentMapMode);
		
		//grab the correct file - apologies for ugly
		if(currentMapMode == MapMode.ECONOMIC){
			if(continentToChangeTo.equals("World")){
				map = ImageIO.read(new File("EconMap.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if going back to World
			if(continentToChangeTo.equals("Africa")){
				map = ImageIO.read(new File("EconAfrica.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if EconAfrica
			if(continentToChangeTo.equals("Asia")){
				map = ImageIO.read(new File("EconAsia.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if EconAsia
			if(continentToChangeTo.equals("Europe")){
				map = ImageIO.read(new File("EconEurope.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if EconEurope
			if(continentToChangeTo.equals("North America")){
				map = ImageIO.read(new File("EconNorthAmerica.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if EconNorthAmerica
			if(continentToChangeTo.equals("Oceania")){
				map = ImageIO.read(new File("EconOceania.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if EconAsia
			if(continentToChangeTo.equals("South America")){
				map = ImageIO.read(new File("EconSouthAmerica.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if EconSouthAmerica
		}//if MapMode is economic
		else{
			if(continentToChangeTo.equals("World")){
				map = ImageIO.read(new File("HealthMap.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if going back to World
			if(continentToChangeTo.equals("Africa")){
				map = ImageIO.read(new File("HealthAfrica.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if HealthAfrica
			if(continentToChangeTo.equals("Asia")){
				map = ImageIO.read(new File("HealthAsia.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if HealthAsia
			if(continentToChangeTo.equals("Europe")){ 
				map = ImageIO.read(new File("HealthEurope.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if HealthEurope
			if(continentToChangeTo.equals("North America")){
				map = ImageIO.read(new File("HealthNorthAmerica.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if HealthNorthAmerica
			if(continentToChangeTo.equals("Oceania")){
				map = ImageIO.read(new File("HealthOceania.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if HealthAsia
			if(continentToChangeTo.equals("South America")){
				map = ImageIO.read(new File("HealthSouthAmerica.png")).getScaledInstance(1200, 500, Image.SCALE_SMOOTH);
			}//if HealthSouthAmerica
		}//if MapMode is Health
		
		//clear the info box at the bottom
		writeInfoOnBottom("");
		writeInfo2OnBottom("");
		//repaint
		repaint();
		//set up new buttons
		layoutButtons();
	}
	
	/**
	 * Draws this panel.
	 */
	@Override
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
			}//for
		}//if
	}//sweepButtons
	
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
				//make it visible
				buttons.get(countriesToLoad.get(i)).setVisible(true);
			}//for
			//force repaint, so as to display the buttons
			repaint();
		}//if
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
		updateInfoBox(worldData.getDataForCountry(currentCountry));
		updateInfoBox2(worldData.getDataForCountry(currentCountry));
		
		//note that we've seen this new country
		currentStudent.addCountrySeen(currentCountry, currentView, currentMapMode);
	}//changeCountry
	
	public void writeInfoOnBottom(String stringToDisplay){
		//remove the old TextArea, so we can add the new one below to a clean slate
		infoBox.removeAll();
		
		JTextArea textArea = new JTextArea();
		textArea.setText(stringToDisplay);
	    textArea.setEditable(false);
	    textArea.setWrapStyleWord(true);
	    textArea.setLineWrap(true);
	    textArea.setForeground(new Color(0,0,0));
	    textArea.setOpaque(false);
	    textArea.setVisible(true);
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    scrollPane.setPreferredSize(new Dimension(700, 195));
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    scrollPane.setBorder(BorderFactory.createEmptyBorder());
	    infoBox.setBounds(0, 500, 800, 200);
	    infoBox.add(scrollPane);
	    scrollPane.setVisible(true);
		revalidate();
	}//writeInfoOnButtom
	
	public void writeInfo2OnBottom(String stringToDisplay){
		//remove the old TextArea, so we can add the new one below to a clean slate
		infoBox2.removeAll();
		
		JTextArea textArea = new JTextArea();
		textArea.setText(stringToDisplay);
	    textArea.setEditable(false);
	    textArea.setWrapStyleWord(true);
	    textArea.setLineWrap(true);
	    textArea.setForeground(new Color(0,0,0));
	    textArea.setOpaque(false);
	    textArea.setVisible(true);
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    scrollPane.setPreferredSize(new Dimension(700, 95));
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    scrollPane.setBorder(BorderFactory.createEmptyBorder());
	    infoBox2.setBounds(0, 700, 800, 100);
	    infoBox2.add(scrollPane);
	    scrollPane.setVisible(true);
		revalidate();
	}//writeInfoOnButtom
	
	public void showPicture(String stringPath){
		try {
			photoImage = ImageIO.read(new File(stringPath)).getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}//catch
		imageIcon = new ImageIcon(photoImage);
		imageLabel.setIcon(imageIcon);
		imageLabel.setVisible(true);
		imageLabel.setBounds(900, 500, 250, 250);
		
		photoBox.setBounds(800,500,400,300);
		photoBox.add(imageLabel);
	}//showPicture
	
	/**
	 * Fill the InfoBox with the given data on a country.
	 * 
	 * @param newCountry the data to display about the given country
	 */
	private void updateInfoBox(CountryData newCountry){

		infoBox.removeAll();

		if(currentMapMode == MapMode.ECONOMIC){

			String stringToDisplay = newCountry.getCountryName() + "\n\nGDP Per Capita:  " +
					newCountry.getGdpPerCapita() + "\n\nGDP Real Growth Rate:  " + 
					newCountry.getGdpRealGrowthRate() + "\n\nAgriculture as a percentage of GDP:  " + 
					newCountry.getAgriculturePercentageOfGdp() + "\n\nEconomic Freedom Score:  " +
					newCountry.getEconomicFreedomScore() + "\n\nLowest Ten Percent's Income as Percentage of National Income:  " +
					newCountry.getLowestTenIncome() + "\n\nHighest Ten Percent's Income as Percentage of National Income:  " + 
					newCountry.getHighestTenIncome() + "\n\nMajor Industries:  " + newCountry.getMajorIndustries() + 
					"\n\nUnemployment Rate:  " + newCountry.getUnemploymentRate() +
					"\n\nMajor Economic Issue:  " + newCountry.getMajorEconomicIssue();
			writeInfoOnBottom(stringToDisplay);
			showPicture(newCountry.getPhotoPathEconomic());

		}//if Economic mode

		if(currentMapMode == MapMode.HEALTH){

			String stringToDisplay = newCountry.getCountryName() + "\n\n" +
					"Life Expectancy:  " + newCountry.getLifeExpectancy() +
					"\n\nMaternal Mortality Rate:  " + newCountry.getMaternalMortalityRate() +
					"\n\nInfant Mortality Rate:  " + newCountry.getInfantMortalityRate() +
					"\n\nPercentage of Children Underweight:  " + newCountry.getChildrenUnderweightPercentage() +
					"\n\nPhysician Density:  " + newCountry.getPhysicianDensity() +
					"\n\nMost Common Diseases:  " + newCountry.getMajorHealthIssue();
			writeInfoOnBottom(stringToDisplay);
			showPicture(newCountry.getPhotoPathHealth());

		}//if Health mode
	}//updateInfoBox
	
	private void updateInfoBox2(CountryData newCountry){

		infoBox2.removeAll();

		if(currentMapMode == MapMode.ECONOMIC){

			String stringToDisplay = "How you can make a difference:  "+ newCountry.getMakeADifferenceEconomic();
			writeInfo2OnBottom(stringToDisplay);

		} else if(currentMapMode == MapMode.HEALTH){

			String stringToDisplay = "How you can make a difference:  " + newCountry.getMakeADifferenceHealth();
			writeInfo2OnBottom(stringToDisplay);

		}//if Health mode
	}//updateInfoBox
	
	/**
	 * Sets up the UI for the next question in the quiz.
	 * 
	 * @throws IOException
	 */
	private void setUpNextQuestion() throws IOException{
		if(quizRunner.questionsRemainToAsk()){//if there are more questions to ask
			//get the question to display
			String question = quizRunner.getQuestion();
			
			//clear the UI
			infoBox.removeAll();
			infoBox2.removeAll();
			photoBox.removeAll();
			
			//display the question
			writeInfoOnBottom(question);
			repaint();
		} else {//the quiz is over
			endQuiz("You have successfully completed the quiz!");
		}//else
	}//setUpNextQuestion
	
	/**
	 * Ends the currently running quiz and shows the given message to the user.
	 * 
	 * @param quizEndMessage the message to show to the user.
	 * @throws IOException
	 */
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
		currentModeLabel.setText("EXPLORE MODE");
		writeInfoOnBottom("Your results on the quiz:\n" + quizRunner.getQuizEndReport());
	}//endQuiz
	
	/**
	 * Respond to misc. events generated by the UI.
	 * 
	 * @param e the ActionEvent that represents the event that occurred
	 */
	@Override
	public void actionPerformed(ActionEvent e){
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
					//System.out.println("Next question pre");
					setUpNextQuestion();
					//System.out.println("Next question post");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {//they got it wrong, so tell them they screwed up
				String outputMessage = "Incorrect answer!\n\n(You have " + quizRunner.getRemainingAttempts() + " remaining attempts.)";
				JOptionPane.showMessageDialog(this, outputMessage, "Incorrect", JOptionPane.WARNING_MESSAGE);
				
				if(!quizRunner.hasRemainingAttempts()){//if they've run out of attempts on this question
					//alert the user
					JOptionPane.showMessageDialog(this, "You've run out of attempts to answer this question.\nThe quiz will now move onto the next question.", "No more attempts", JOptionPane.INFORMATION_MESSAGE);
					
					//move onto the next question
					try {
						setUpNextQuestion();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();//see what happened
					}//catch
				}//if
			}//else
		} else if(e.getSource().equals(backButton)){//back button
			if(!quizRunner.getQuizRunning()){//the back button should only work if the user's not in a quiz
				if(!currentView.equals("World")){//we only need to change things if we're not in world view
					//update appropriately
					try {
						changeContinent("World");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//catch
				}//if
			}//if
		} else if(e.getSource().equals(quizButton)){
			if(quizRunner.getQuizRunning()){//if they're in a quiz
				try {
					endQuiz("Thanks for playing!");
				} catch (IOException e1) {
					e1.printStackTrace();
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
					
					//set the mode label in the top corner of the string
					currentModeLabel.setText("QUIZ MODE");

					//start the quiz
					quizRunner.startQuiz(currentView, currentMapMode);

					//load the first question
					try {
						setUpNextQuestion();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//catch
				}//else
			}//else if
		}//else if
	}//actionPerformed

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
						try {
							changeContinent(continentNames[i]);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}//catch
						//stop checking by terminating the for loop
						break;
					}//if
				}//if
			}//for
		}//if
	}//mouseClicked

	/**
	 * Respond to the mouse entering this component.
	 * 
	 * @param e a MouseEvent that represents a movement of the mouse
	 */
	@Override
	public void mouseEntered(MouseEvent e){
		//Auto-generated method stub
		//Does nothing; required by interface
	}//mouseEntered

	/**
	 * Respond to the mouse exiting this component.
	 * 
	 * @param e a MouseEvent that represents a movement of the mouse
	 */
	@Override
	public void mouseExited(MouseEvent e){
		//Auto-generated method stub
		//Does nothing; required by interface
	}//mouseExited

	/**
	 * Respond to mouse presses.
	 * 
	 * @param e a MouseEvent that represents a mouse press
	 */
	@Override
	public void mousePressed(MouseEvent e){
		//Auto-generated method stub
		//Does nothing; required by interface		
	}//mousePressed

	/**
	 * Respond to mouse releases.
	 * 
	 * @param e a MouseEvent that represents a mouse release
	 */
	@Override
	public void mouseReleased(MouseEvent e){
		//Auto-generated method stub
		//Does nothing; required by interface
	}//mouseReleased
	
}//class MapPanel