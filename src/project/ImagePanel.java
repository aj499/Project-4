package project;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

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
	public ImagePanel(DataManager newWorldData, StudentData newStudentData, project.MapMode mapType){
	
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (image != null){
			int x = 0;
			int y = 0;
			g.drawImage(image,x,y,this);
		}//if image not null
	}//paint
}//ImagePanel
