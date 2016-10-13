/*Name: Taha Rangwala
 * Date: October 12, 2016
 * Purpose: The purpose of the GUI class is to allow the user to use an interface in order to
 * actually interact with the program. This class allows the user to use input fields,
 * output fields, and buttons. All the information from the other classes is relayed back to this class
 * to show to the user.
 */

import BreezySwing.*;//import more window objects

import javax.swing.*;//import more window objects

import java.awt.Color;//allows the use of more colors

//GUI class header
public class GUI extends GBFrame{
	
	//Declaring private instance variables
	private LinkedList List;//Linked List class object
	//Declaring window objects
	private JLabel firstNameLabel, lastNameLabel, yearLabel, GPALabel;
	private JTextField firstNameField, lastNameField;
	private IntegerField yearField;
	private DoubleField GPAField;
	private JTextArea outputArea;
	private JButton addFirst, addLast, getFirst, getLast, removeFirst, removeLast, printAll, deleteAll, Exit;
	
	//Constructor method for GUI class
	public GUI(){
		//Initializing private instance variables
		List = new LinkedList();//initialize linked list object
		//Initializing window objects
		firstNameLabel = addLabel("First Name",1,1,1,1);
		firstNameField = addTextField("",1,2,1,1);
		lastNameLabel = addLabel("Last Name",1,3,1,1);
		lastNameField = addTextField("",1,4,1,1);
		yearLabel = addLabel("Graduation Year",2,1,1,1);
		yearField = addIntegerField(0,2,2,1,1);
		GPALabel = addLabel("GPA",2,3,1,1);
		GPAField = addDoubleField(0,2,4,1,1);
		addFirst = addButton("Add First",3,1,1,1);
		addLast = addButton("Add Last",3,2,1,1);
		printAll = addButton("Print All",3,3,1,1);
		deleteAll = addButton("Delete All",3,4,1,1);
		outputArea = addTextArea("",4,1,4,1);
		getFirst = addButton("Get First",5,1,1,1);
		getLast = addButton("Get Last",5,2,1,1);
		removeFirst = addButton("Remove First",5,3,1,1);
		removeLast = addButton("Remove Last",5,4,1,1);
		Exit = addButton("Exit",6,4,1,1);
		firstNameField.grabFocus();
		yearField.setText("");
		GPAField.setText("");
	}
	
	/*Purpose: The purpose of this method is to allow the user to use different buttons in order
	 * to carry out functions in the program.
	 * @param buttonObj This button object allows the program to determine which button the user has 
	 * pressed and what action should be carried out.
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == addFirst){//add fist button
			if(checkNumberValues()){
				try{
					Student.checkStudentInputs(firstNameField.getText(), lastNameField.getText(), yearField.getNumber(), 
						GPAField.getNumber());
					List.addFirst(new Student(firstNameField.getText(), lastNameField.getText(), 
					yearField.getNumber(),GPAField.getNumber()));
					firstNameField.setText("");
					lastNameField.setText("");
					yearField.setText("");
					GPAField.setText("");
					firstNameField.grabFocus();
				}
				catch(Exception E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Please Input Valid Numbers", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else if(buttonObj == addLast){//add last button
			if(checkNumberValues()){
				try{
					Student.checkStudentInputs(firstNameField.getText(), lastNameField.getText(), yearField.getNumber(), 
						GPAField.getNumber());
					List.addLast(new Student(firstNameField.getText(), lastNameField.getText(), 
					yearField.getNumber(),GPAField.getNumber()));
					firstNameField.setText("");
					lastNameField.setText("");
					yearField.setText("");
					GPAField.setText("");
					firstNameField.grabFocus();
				}
				catch(Exception E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Please Input Valid Numbers", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else if(buttonObj == printAll){//print all button
			try{
				outputArea.setText(List.printAll());
				firstNameField.setText("");
				lastNameField.setText("");
				yearField.setText("");
				GPAField.setText("");
				firstNameField.grabFocus();
			}
			catch(Exception E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(buttonObj == deleteAll){//delete all button
			List = new LinkedList();
			firstNameField.setText("");
			lastNameField.setText("");
			yearField.setText("");
			GPAField.setText("");
			firstNameField.grabFocus();
			outputArea.setText("");
		}
		else if(buttonObj == getFirst){//get first button
			try{
				outputArea.setText(List.printFirst());
			}
			catch(Exception E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(buttonObj == getLast){//get last button
			try{
				outputArea.setText(List.printLast());
			}
			catch(Exception E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(buttonObj == removeFirst){//remove first button
			try{
				List.removeFirst();
				outputArea.setText("");
			}
			catch(Exception E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(buttonObj == removeLast){//remove last button
			try{
				List.removeLast();
				outputArea.setText("");
			}
			catch(Exception E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else
			this.dispose();
	}
	
	/*Purpose: The purpose of this method is to check if the year and gpa fields have valid number values
	 * @return This method returns a boolean value of whether or not both number fields hold valid numbers
	 */
	private boolean checkNumberValues(){
		return yearField.isValidNumber() && GPAField.isValidNumber();
	}
	
	//Main method to set up the GUI
	public static void main (String [] args){
		GUI theMainGUI = new GUI();//GUI object
		theMainGUI.setSize(500,500);//size of the GUI interface
		theMainGUI.setTitle("Taha's Longest Non-Decreasing Sequence Program");//title of GUI interface
		theMainGUI.setVisible(true);//visibility of interface
		theMainGUI.setLocationRelativeTo(null);//Location is in center of screen
		theMainGUI.getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
	}
	
}