package project;


//begin summoning the forces of evil, aka the Java graphics libraries

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class WelcomeWindow extends JApplet implements ActionListener{

	private static final long serialVersionUID = 1L;
	
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
	//ImageIcon that holds the main map image
	private ImageIcon map;
	//ImageIcon that is the reference for the desired size of the window
	private ImageIcon referenceMap;
	//Textfield for user name
	private TextField username; 
	//Initial type of map/quiz
	private MapMode mapType;
	//Radio button group
	private ButtonGroup typeOptions;
	
	public void init(){
		
		window = new ImagePanel(Toolkit.getDefaultToolkit().getImage("mapImage2.png"));
		//window.setLayout(new BoxLayout(window, BoxLayout.PAGE_AXIS));
		window.setLayout(null);
		
		startButton = new JButton("Start");

		//Adds an action listener to the start button
		startButton.addActionListener(this);
		//Sets the start button's size

		startButton.setPreferredSize(new Dimension(100, 50));
		
		econButton = new JRadioButton("Economics");

		//Adds an action listener to the econ button
		econButton.addActionListener(this);
		//Sets the econ button's size

		econButton.setPreferredSize(new Dimension(200, 20));
		
		healthButton = new JRadioButton("Health");

		//Adds an action listener to the health button
		healthButton.addActionListener(this);
		//Sets the health button's size
		healthButton.setPreferredSize(new Dimension(200, 20));
		
		typeOptions = new ButtonGroup();
		typeOptions.add(econButton);
		typeOptions.add(healthButton);
		
		username = new TextField(10);
		
		map = new ImageIcon("mapImage2.png"); 
		referenceMap = new ImageIcon("lifeExpectancyEdit.png");
		setSize(referenceMap.getIconWidth(), referenceMap.getIconHeight());
		
		JLabel prompt = new JLabel("Please enter your name:");
		startButton.setBounds(referenceMap.getIconWidth()/2 - 125, 350, 75, 50);
		econButton.setBounds(referenceMap.getIconWidth()/2 - 50, 350, 125, 50);
		healthButton.setBounds(referenceMap.getIconWidth()/2 + 50, 350, 75, 50);
		prompt.setBounds((referenceMap.getIconWidth()/2) - 125, 400, 150, 20);
		username.setBounds(referenceMap.getIconWidth()/2 + 25, 400, 100, 20);
		window.add(startButton);
		window.add(econButton);
		window.add(healthButton);
		window.add(prompt);
		window.add(username);
		window.setVisible(true);
		content.add(window);
		
	}//init
	

	/**
	 * ImagePanel class
	 * 
	 * This class is a JPanel that draws a graphic onto the back of a JPanel
	 *
	 */
	private class ImagePanel extends JPanel{

		private static final long serialVersionUID = 1L;
		private Image image = null;
		//private int width;
		//private int height;

		public ImagePanel(Image image){
			this.image = image;

			//this.width = image.getWidth(this);
			//this.height = image.getHeight(this);
		}//constructor

		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if (image != null){
				int x = 0;
				int y = 0;
				g.drawImage(image,x,y,this);
			}
		}
	}
	
	private void goToMapPanel(MapMode type){
		mapPanel = new MapPanel(null, new StudentData("Dummy Student!"), type);

		mapPanel.setVisible(true);
		window.setVisible(false);
		this.setContentPane(mapPanel);
	}//goToMapPanel


	/**
	 * Respond to button events created by the user clicking on the buttons
	 * on the screen (the Economic/Health radio buttons and the Start button).
	 * 
	 * @param e the event caused by the click on the button clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(startButton)){//Start button
			if(mapType != null){//if an option was selected, go on to the main map
				goToMapPanel(mapType);
			} else {//if no option was selected, alert the user
				JLabel warning = new JLabel("Please choose a subject");
				warning.setBounds(referenceMap.getIconWidth()/2 + 25, 500, 100, 20);
				warning.setVisible(true);
				warning.setOpaque(true);
				window.requestFocus();
				window.add(warning);
				window.setVisible(true);
				window.requestFocus();
				content.add(window);
			}
		} else if(e.getSource().equals(econButton)){//Economic radio button

			mapType = MapMode.ECONOMIC;
		} else if(e.getSource().equals(healthButton)){//Health radio button
			mapType = MapMode.HEALTH;
		}
		
	}//general actionPerformed
	
}//class WelcomeWindow
