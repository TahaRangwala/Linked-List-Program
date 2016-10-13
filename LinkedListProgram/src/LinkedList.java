/*Name: Taha Rangwala
 * Date: October 12, 2016
 * Purpose: The purpose of this class is to take all the information from all the other classes
 * and do some calculations and relay them back to the gui class for the user to see. This class essentially
 * holds all the information that the user wants to see and does necessary calculations as well.
 */

import BreezySwing.Format;//imports more formatting options

//LinkedList class header
public class LinkedList <T>{
	
	//Declaring private instance variables
	private ListNode Head;//Head of the list node
	
	/*Purpose: This is the constructor method which initializes all of the instance variables in this class
	 */
	public LinkedList(){
		Head = null;
	}
	
	/*Purpose: The purpose of this method is to add the value of the first node of the list node
	 * @param newValue This is the value added to the first node of the list node
	 */
	public void addFirst(T newValue){
		ListNode Temp = Head;
		Head = new ListNode(newValue, Temp);
	}
	
	/*Purpose: The purpose of this method is to add the value of the last node of the list node
	 * @param newValue This is the value added to the last node of the list node
	 */
	public void addLast(T newValue){
		if(Head != null){
			ListNode Temp = Head;
			while(Temp.hasNext()){
				Temp = Temp.getNext();
			}
			Temp.setNext(new ListNode(newValue, null));
		}
		else addFirst(newValue);
	}
	
	/*Purpose: This method prints all of the information from the list node
	 * @return This returns a string value of all of the information in the list node
	 */
	public String printAll(){
		if(Head == null)
			throw new IllegalArgumentException("No Students Have Been Inputted");
		String Output = Format.justify('l', "Name", 15) + Format.justify('l', "Grad Year", 15) + 
		Format.justify('l', "GPA", 15) + "\n";
		Output += Head.getValue().toString();
		ListNode Temp = Head;
		while(Temp.hasNext()){
			Temp = Temp.getNext();
			Output += Temp.getValue().toString();
		}
		return Output;
	}
	
	/*Purpose: This method prints all of the information of the first node
	 * @return This returns a string value of all of the information of the first node
	 */
	public String printFirst(){
		if(Head == null)
			throw new IllegalArgumentException("No Students Have Been Inputted");
		String Output = Format.justify('l', "Name", 15) + Format.justify('l', "Grad Year", 15) + 
		Format.justify('l', "GPA", 15) + "\n";
		return Output + Head.getValue();
	}
	
	/*Purpose: This method prints all of the information of the last node
	 * @return This returns a string value of all of the information of the last node
	 */
	public String printLast(){
		if(Head == null)
			throw new IllegalArgumentException("No Students Have Been Inputted");
		String Output = Format.justify('l', "Name", 15) + Format.justify('l', "Grad Year", 15) + 
		Format.justify('l', "GPA", 15) + "\n";
		ListNode Temp = Head;
		while(Temp.hasNext()){
			Temp = Temp.getNext();
		}
		return Output + Temp.getValue();
	}
	
	/*Purpose: This method removes the first node in the list node
	 */
	public void removeFirst(){
		if(Head == null)
			throw new IllegalArgumentException("No Students Have Been Inputted");
		if(Head.hasNext())
			Head = Head.getNext();
		else Head = null;
	}
	
	/*Purpose: This method removes the last node in the list node
	 */
	public void removeLast(){
		if(Head == null)
			throw new IllegalArgumentException("No Students Have Been Inputted");
		else if(Head.hasNext()){
			ListNode Temp = Head;
			while(Temp.hasNext() && Temp.getNext().hasNext()){
				Temp = Temp.getNext();
			}
			Temp.setNext(null);
		}
		else 
			Head = null;
	}
}