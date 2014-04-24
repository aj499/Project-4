package project;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WelcomeWindow extends JApplet implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	//Initial JPanel that will be presented on the applet
	private JPanel window;
	//JLabel that displays the map image
	private JLabel mapLabel;
	//MapPanel object that is the main JPanel that will be presented on the applet
	private MapPanel mapPanel;
	//Button that starts the program
	private JButton startButton;
	//Button that starts the program
	private JButton econButton;
	//Button that starts the program
	private JButton healthButton;
	//Variable for the content pane
	private Container content = getContentPane();
	//ImageIcon that holds the main map image
	private ImageIcon map;
	//ImageIcon that is the reference for the desired size of the window
	private ImageIcon referenceMap;
	//Textfield for user name
	private TextField username; 
	
	public void init(){
		
		window = new JPanel();
		window.setLayout(new BoxLayout(window, BoxLayout.PAGE_AXIS));
		
		startButton = new JButton("Start");
		startButton.addActionListener(new startAction());
		startButton.setPreferredSize(new Dimension(500, 100));
		
		econButton = new JButton("Economics");
		econButton.addActionListener(new econAction());
		econButton.setPreferredSize(new Dimension(200, 100));
		
		healthButton = new JButton("Health");
		healthButton.addActionListener(new healthAction());
		healthButton.setPreferredSize(new Dimension(200, 100));
		
		username = new TextField(20);
		
		mapLabel = new JLabel();
		
		map = new ImageIcon("mapImage2.png"); 
		referenceMap = new ImageIcon("lifeExpectancyEdit.png"); 
		
		mapLabel.setIcon(map);
		
		JLabel prompt = new JLabel("Please enter your name:");
		prompt.setSize(500,20);
		setSize(referenceMap.getIconWidth() + 200, referenceMap.getIconHeight() + 400);
		window.add(mapLabel);
		window.add(startButton);
		window.add(econButton);
		window.add(healthButton);
		window.add(prompt);
		window.add(username);
		mapLabel.setAlignmentX(CENTER_ALIGNMENT);
		mapLabel.setAlignmentY(CENTER_ALIGNMENT);
		window.setVisible(true);
		content.add(window);
		
	}//init
	
	private void goToMapPanel(){
		
		mapPanel = new MapPanel(null, null);
		mapPanel.setVisible(true);
		window.setVisible(false);
		this.setContentPane(mapPanel);
		
	}//goToMapPanel
	
	public class startAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			goToMapPanel();
		}//actionPerformed
	}//class startAction
	
	public class econAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}//actionPerformed
	}//class startAction
	
	public class healthAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}//actionPerformed
	}//class startAction

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}//general actionPerformed
	
}//class WelcomeWindow