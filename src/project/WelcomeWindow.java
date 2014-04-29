package project;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * WelcomeWindow class
 * 
 * This class is the main screen of our applet. It sets its size
 * based off of a reference map, which happens to be one of the 
 * two later maps used in the program. It also produces a radio button
 * so that the user can choose between learning about economics or 
 * health first. Also, they can enter their name so that the program 
 * will remember the student data. The start button will not start
 * the program until either economics or health is selected.
 *
 */
public class WelcomeWindow extends JApplet implements ActionListener{

	private static final long serialVersionUID = 1L;
	//width and height of applet
	private int width;
	private int height;
	//Initial JPanel that will be presented on the applet
	private JPanel window;
	//MapPanel object that is the main JPanel that will be presented on the applet
	private MapPanel mapPanel;
	//Button that starts the program
	private JButton startButton;
	//Button that starts the program
	private JRadioButton econButton;
	//Button that starts the program
	private JRadioButton healthButton;
	//Variable for the content pane
	private Container content = getContentPane();
	//ImageIcon that is the reference for the desired size of the window
	private ImageIcon referenceMap;
	//Textfield for user name
	private TextField username; 
	//Initial type of map/quiz
	private MapMode mapType;
	//Radio button group
	private ButtonGroup typeOptions;
	
	public void init(){
		
		//Sets the width and height
		width = 1600;
		height = 500;
		//Sets the background of the window
		window = new ImagePanel(Toolkit.getDefaultToolkit().getImage("mapImage.png").getScaledInstance(1200, 500, Image.SCALE_SMOOTH));
		//Sets the layout to null so that we can use coordinates
		window.setLayout(null);
		//Takes one of the maps we'll use later as a reference to size the applet
		referenceMap = new ImageIcon("HealthMap.png");
		//Sets the size of the applet to the reference map size
		//setSize(referenceMap.getIconWidth(), referenceMap.getIconHeight());
		setSize(width - 400, height);
		
		//Creates the start button
		startButton = new JButton("Start");
		//Adds an action listener to the start button
		startButton.addActionListener(new startAction());
		//Sets the start button's size
		startButton.setPreferredSize(new Dimension(100, 50));
		
		//Creates one of the two radio buttons for the economics option
		econButton = new JRadioButton("Economics");
		//Adds an action listener to the econ button
		econButton.addActionListener(new econAction());
		//Sets the econ button's size
		econButton.setPreferredSize(new Dimension(200, 20));
		
		//Creates the other of the two radio buttons for the health option
		healthButton = new JRadioButton("Health");
		//Adds an action listener to the health button
		healthButton.addActionListener(new healthAction());
		//Sets the health button's size
		healthButton.setPreferredSize(new Dimension(200, 20));
		
		//Creates a button group for the radio buttons
		typeOptions = new ButtonGroup();
		//Adds the two radio buttons to the group
		typeOptions.add(econButton);
		typeOptions.add(healthButton);
		
		//Creates a JLabel that displays the prompt for the student name
		JLabel prompt = new JLabel("Please enter your name:");
		//Creates a new text field for the student to enter their name
		username = new TextField(10);
		//Create a JLabel that displays the instructions on the screen
		JLabel instructions = new JLabel("Please select either economics or health before pressing the start button.");
		
		//Organizes the assorted components
		startButton.setBounds(475, 350, 75, 50);
		econButton.setBounds(550, 350, 100, 50);
		healthButton.setBounds(650, 350, 75, 50);
		prompt.setBounds(475, 400, 150, 20);
		username.setBounds(625, 400, 100, 20);
		instructions.setBounds(350, 450, 500, 20);
		
		//Adds the components to the JPanel before adding those to the content pane
		window.add(startButton);
		window.add(econButton);
		window.add(healthButton);
		window.add(prompt);
		window.add(username);
		window.add(instructions);
		window.setVisible(true);
		content.add(window);
		
	}//init
	
	/**
	 * ImagePanel class
	 * 
	 * This class is a JPanel that draws a graphic onto the back of a JPanel
	 *
	 */
	public class ImagePanel extends JPanel{
		private static final long serialVersionUID = 1L;
		private Image image = null;
		private int width;
		private int height;

		public ImagePanel(Image image){
			this.image = image;
			this.width = image.getWidth(this);
			this.height = image.getHeight(this);
		}//constructor
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if (image != null){
				int x = 0;
				int y = 0;
				g.drawImage(image,x,y,this);
			}//if image not null
		}//paint
	}//ImagePanel
	
	/**
	 * goToMapPanel
	 * 
	 * goToMapPanel switches the visibility of the window, which is currently 
	 * the prominent window, to the mapPanel, which holds the main program
	 * functionality.
	 * 
	 * @param mapType
	 * @throws IOException 
	 */
	private void goToMapPanel(MapMode mapType) throws IOException{
		//Creates a new MapPanel
		mapPanel = new MapPanel(new DataManager("/Users/Lee/Desktop/CountryData.txt"), new StudentData("Dummy Student!"), mapType);
		//Switches the visibility of the existing JPanels
		mapPanel.setVisible(true);
		window.setVisible(false);
		this.setContentPane(mapPanel);
	}//goToMapPanel
	
	/**
	 * startAction
	 *
	 */
	public class startAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(mapType != null){
				try {
					setSize(width, height);
					if(mapType == mapType.HEALTH){
						System.out.println("YAY");
					}
					goToMapPanel(mapType);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}//if an option was pressed
			else{
				JLabel warning = new JLabel("Please choose a subject");
				warning.setBounds(referenceMap.getIconWidth()/2 + 25, 500, 100, 20);
				warning.setVisible(true);
				warning.setOpaque(true);
				window.requestFocus();
				window.add(warning);
				window.setVisible(true);
				window.requestFocus();
				content.add(window);
			}//else
		}//actionPerformed
	}//class startAction
	
	public class econAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mapType = MapMode.ECONOMIC;
		}//actionPerformed
	}//class startAction
	
	public class healthAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mapType = MapMode.HEALTH;
			System.out.print("changed to health");
		}//actionPerformed
	}//class startAction

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}//general actionPerformed
	
}//class WelcomeWindow
