package project;

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
	private final static int height = 700;
	
	private final String WELCOME_MESSAGE = "Welcome to the World Map";
	private MapPanel mapPanel;
	private JPanel window; 
	private JButton startButton;
	
	public void init(){
		setSize(width, height);
		
		/*ImageIcon icon = new ImageIcon("mapImage2.png");
		JLabel icon2 = new JLabel();
		icon2.setIcon(icon);
		window.add(icon2);*/
		
		window = new JPanel();
		window.setLayout(new BoxLayout(window, BoxLayout.LINE_AXIS));
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		startButton.setSize(200, 200);
		
		startButton.setAlignmentX(CENTER_ALIGNMENT);
		startButton.setAlignmentY(CENTER_ALIGNMENT);
		window.add(startButton);
		getContentPane().add(window);
	}//init
	
	private void drawScreen(){
		
	}//drawScreen
	
	private void goToMapPanel(){
		
		mapPanel = new MapPanel();
		mapPanel.setVisible(true);
		
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