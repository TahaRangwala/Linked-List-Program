/*Name: Taha Rangwala
 * Date: October 12, 2016
 * Purpose: The purpose of this class is to hold the information for the student which is the first name,
 * last name, graduation year, and GPA. It also holds a to string method and it error checks for the student as well
 */

import BreezySwing.Format;//import more formatting options

//Student class header
public class Student {

	//Declaring private instance variables
	private String firstName;//student's first name
	private String lastName;//student's last name
	private int gradYear;//student's graduation year
	private double GPA;//student's grade point average
	
	/*Purpose: This is the constructor method for this class which initializes each private
	 * instance variable
	 * @param firstName Student's first name
	 * @param lastName Student's last name
	 * @param gradYear Student's graduation year
	 * @param GPA Student's grade point average
	 */
	public Student(String firstName, String lastName, int gradYear, double GPA){
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradYear = gradYear;
		this.GPA = GPA;
	}
	
	/*Purpose: The purpose of this method is to return all of the information for the student including
	 * first name, last name, graduation year, and GPA.
	 * @return This method returns a string value of all of the student's information
	 */
	public String toString(){
		return Format.justify('l', lastName + ", " + firstName, 15) + Format.justify('l', gradYear, 15) + 
		Format.justify('l', GPA, 15,2) + "\n";
	}
	
	/*Purpose: The purpose of this method is to error check for all of the student values
	 * @param firstName Student's first name
	 * @param lastName Student's last name
	 * @param gradYear Student's graduation year
	 * @param GPA Student's grade point average
	 */
	public static void checkStudentInputs(String firstName, String lastName, int gradYear, double GPA){
		if(firstName.equals(""))
			throw new IllegalArgumentException("Please Input A Student's First Name");
		else if(lastName.equals(""))
			throw new IllegalArgumentException("Please Input A Student's Last Name");
		else if(gradYear < 0)
			throw new IllegalArgumentException("Make Sure The Graduation Year Is Greater Than 0");
		else if(GPA < 0 || GPA > 5)
			throw new IllegalArgumentException("Make Sure The GPA Is Greater Than 0 and Less Than or Equal to 5.0");
	}
	
}