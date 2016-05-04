/**
 * 
 */
package cvtc.edu.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Jason Friend-Fellows
 *
 */

public class Person{
	
	// Attributes
      protected String firstName;
      protected String lastName;
      protected String birthDate;
      
    // Constructors  
	public Person(String firstName, String lastName, String birthDate){
		
	      this.firstName = firstName;
	      this.lastName = lastName;
	      setbirthDate(birthDate);
	}
	
	public Person(){
		
		firstName = "";
		lastName = "";
		birthDate = "";
	}
	
	// Setter
	public void setbirthDate(String bDate){
		
	      if (isValidDate(bDate))
	    	  birthDate = bDate;
	      else
	    	  birthDate = "";
	}
	
	private boolean isValidDate(String birthDate){
		
		boolean status = true;
	    if (birthDate == null)
	        return false;
	    else {
	      //set the format to use as a constructor argument
	    	
	      SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

	      if (birthDate.trim().length() != dateFormat.toPattern().length())
	        return false;
	   
	      dateFormat.setLenient(false);
	      
	      try {
	        //parse the inDate parameter
	        dateFormat.parse(birthDate.trim());
	      }
	      catch (ParseException pe) {
	        return false;
	      }
	      return status;
	    }
	}

	public String toString(){
	      String str = "Person [firstName=" + firstName + ", lastName=" + lastName;
	      if(birthDate == "")
	         str += "\nBirth Date: Please enter a valid date 'MM/dd/yyyy'.";
	      else
	      str += (", birthDate=" + birthDate +"]");
		return str;
	}
}