/**
 * AppButton
 * @author Min Lee
 * @version 1.0
 * 
 * The AppButton class implements a JButton that
 * allows the program to get the IDs of certain 
 * countries.
 * 
 */
package project;
import javax.swing.JButton;

public class AppButton extends JButton{

	private static final long serialVersionUID = 1L;
	private String id = "null";//default value
	
	/**
	 * Default constructor that creates a new AppButton with default parameters.
	 */
	public AppButton(){
		super();//call JButton constructor, since that probably does something important
	}
	
	/**
	 * Creates a new AppButton with the given id.
	 * 
	 * @param newId the id for the new AppButton
	 */
	public AppButton(String newId){
		super();//call JButton constructor, since that probably does something important
		
		id = newId;
	}
	
	/**
	 * setId(String newId)
	 * 
	 * setter method for private data member id
	 * 
	 * @param newId
	 * @return void
	 */
	public void setId(String newId){
		
		id = newId;
		
	}//setId
	
	/**
	 * getId()
	 * 
	 * getter method for private data member id
	 * 
	 * @param void
	 * @return void
	 */
	public String getId(){
		
		return id;
		
	}//getId
	
}//class AppButton
