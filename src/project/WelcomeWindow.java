package project;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
		window.setLayout(new BoxLayout(window, BoxLayout.PAGE_AXIS));
		
		startButton = new JButton("Start");
		startButton.addActionListener(new startAction());
		startButton.setPreferredSize(new Dimension(100, 50));
		
		econButton = new JRadioButton("Economics");
		econButton.addActionListener(new econAction());
		econButton.setPreferredSize(new Dimension(200, 20));
		
		healthButton = new JRadioButton("Health");
		healthButton.addActionListener(new healthAction());
		healthButton.setPreferredSize(new Dimension(200, 20));
		
		typeOptions = new ButtonGroup();
		typeOptions.add(econButton);
		typeOptions.add(healthButton);
		
		username = new TextField(10);
		
		map = new ImageIcon("mapImage2.png"); 
		referenceMap = new ImageIcon("lifeExpectancyEdit.png");
		
		JLabel prompt = new JLabel("Please enter your name:");
		prompt.setPreferredSize(new Dimension(100,20));
		setSize(referenceMap.getIconWidth(), referenceMap.getIconHeight());
		window.add(startButton);
		window.add(econButton);
		window.add(healthButton);
		window.add(prompt);
		window.add(Box.createHorizontalGlue());
		window.add(username);
		window.setVisible(true);
		content.add(window);
		
	}//init
	
	public class ImagePanel extends JPanel{
		private static final long serialVersionUID = 1L;
		private Image image = null;
		private int width;
		private int height;

		public ImagePanel(Image image){
			this.image = image;
			this.width = image.getWidth(this);
			this.height = image.getHeight(this);
		}
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
	
	public class startAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(mapType != null){
				goToMapPanel(mapType);
			}//if an option was pressed
			else{
				JLabel warning = new JLabel();
				warning.setText("Please choose a subject");
				add(warning);
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
		}//actionPerformed
	}//class startAction

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}//general actionPerformed
	
}//class WelcomeWindow
