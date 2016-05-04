/**
 * 
 */
package cvtc.edu.java;

/**
 * @author Jason Friend-Fellows
 *
 */

public class Contact extends Person{
	
	
		// Attributes
	      private String email;
	      private String phoneNumber;
	      
	      // Constructors
	public Contact(String firstName, String lastName, String birthDate, String email, String phoneNumber){
		
	      super(firstName, lastName, birthDate);
	      setEmail(email);
	      setPhoneNumber(phoneNumber);
	}
	
	// Get Methods
	public String getEmail(){
		
	      return email;
	}
	
	public String getPhoneNumber(){
		
	      return phoneNumber;
	}
	
	// Set Methods
	public void setEmail(String e){
		
	      if (isValidEmail(e))
	    	  email = e;
	      else
	    	  email = "";
	}
	
	public void setPhoneNumber(String empPhone){
		
	      if (isValidPhoneNumber(empPhone))
	    	  phoneNumber = empPhone;
	      else
	    	  phoneNumber = "";
	}
	
	// Validate phoneNumber is in correct format
	private boolean isValidPhoneNumber(String phoneNumber){
		
	      boolean status = true;
	      if (phoneNumber.length() != 12)
	         status = false;
	      else
	      {
	         if ((!Character.isDigit(phoneNumber.charAt(0)))  ||
	             (!Character.isDigit(phoneNumber.charAt(1)))  ||
	             (!Character.isDigit(phoneNumber.charAt(2)))  ||
	             (phoneNumber.charAt (3) != '-')  ||
	             (!Character.isDigit(phoneNumber.charAt(4)))  ||
	             (!Character.isDigit(phoneNumber.charAt(5)))  ||
	             (!Character.isDigit(phoneNumber.charAt(6)))  ||
	             (phoneNumber.charAt (7) != '-')  ||
	             (!Character.isDigit(phoneNumber.charAt(8)))  ||
	             (!Character.isDigit(phoneNumber.charAt(9)))  ||
	             (!Character.isDigit(phoneNumber.charAt(10))))
	                status = false;
	      }
	      return status;
	}
	
	// Validate email is in correct format
	private boolean isValidEmail(String email){
		
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      Boolean status = email.matches(EMAIL_REGEX);
	      return status;
	}
	
	// To String Method
	@Override
	public String toString(){

	      String str = "Contact";
		if (email == "")
	    	  str += "\nEmail: Please enter a valid Email address.";
	      else
	    	  str += " [emailAddress=" + email;
	      if (phoneNumber == "")
	         str += "\nPhone Number: Please enter a valid Phone Number, Format is: XXX-XXX-XXXX.";
	      else
	         str += ", phoneNumber=" + phoneNumber ;
		return str + " " + super.toString();
	   }

}