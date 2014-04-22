package project;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
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
	
	//Width of the window
	private final static int width = 600;
	//Height of the window
	private final static int height = 300;
	
	private final String WELCOME_MESSAGE = "Welcome to the World Map";
	
	private JPanel cards;
	private JPanel window;
	private MapPanel mapPanel;
	private JButton startButton;
	private Container content = getContentPane();
	
	public void init(){
		/*setSize(width, height);
		
		ImageIcon icon = new ImageIcon("mapImage2.png");
		JLabel icon2 = new JLabel();
		icon2.setIcon(icon);
		window.add(icon2);
		
		window = new JPanel();
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		startButton.setSize(200, 50);
		
		ImageIcon map = new ImageIcon("mapImage2.png"); 
		ImageIcon map2 = new ImageIcon("lifeExpectancyEdit.png"); 
		setSize(map2.getIconWidth() + 200, map2.getIconHeight());
		//setSize(map.getIconWidth(), map.getIconHeight());
		JLabel mapLabel = new JLabel();
		mapLabel.setIcon(map);
		mapLabel.add(startButton);
		startButton.setLocation(200, 200);

		window.add(mapLabel);
		window.setVisible(true);
		content.add(window);
		
		startButton.setAlignmentX(CENTER_ALIGNMENT);
		startButton.setAlignmentY(CENTER_ALIGNMENT);
		window.add(startButton);
		getContentPane().add(window);*/

	}//init
	
	private void drawScreen(Graphics g){
		
	}//drawScreen
	
	private void goToMapPanel(){
		System.out.print("OK");
		mapPanel = new MapPanel(null);
		mapPanel.setVisible(true);
		this.setContentPane(mapPanel);
	}//goToMapPanel

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		goToMapPanel();
	}//actionPerformed
	
}//class WelcomeWindow

/**
-WELCOME_MESSAGE : final String
-startButton : JButton
------------
-drawScreen() : void
-goToMapPanel() : void
-actionPerformed(e : ActionEvent) : void
**/