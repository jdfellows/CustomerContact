/**
 * 
 */
package cvtc.edu.java;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Jason Friend-Fellows
 * firstName, lastName, birthDate, email, phoneNumber
 */ 
 public class CustomerContact extends JFrame{

	/**
	 * 
	 */
		private static final long serialVersionUID = -4728124078379455600L;
		
		private List<Contact> contacts = new ArrayList<>();
		
		private JTextField firstName = new JTextField(14);
		private JTextField lastName = new JTextField(15);
		private JTextField birthDate = new JTextField(8);
		private JTextField emailAddress = new JTextField(13);
		private JTextField phoneNumber = new JTextField(12);
		
		private static final JLabel FIRST_NAME_LABEL = new JLabel("First Name: ");
		private static final JLabel LAST_NAME_LABEL = new JLabel("Last Name: ");
		private static final JLabel BIRTHDATE_LABEL = new JLabel("Birthdate (MM/dd/yyyy): ");
		private static final JLabel EMAIL_ADDRESS_LABEL = new JLabel("Email Address: ");
		private static final JLabel PHONE_NUMBER_LABEL = new JLabel("Phone Number: ");
		
		private JPanel FirstNamePanel = new JPanel();
		private JPanel LastNamePanel = new JPanel();
		private JPanel BirthDatePanel = new JPanel();
		private JPanel EmailAddressPanel = new JPanel();
		private JPanel PhoneNumberPanel = new JPanel();
		private JPanel buttonPanel = new JPanel();
		
		private JButton addContact = new JButton("Add Contact");
		private JButton showContacts = new JButton("Show Contacts");
	
	public CustomerContact() {
		super("Contact Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 1)); // rows, columns
		
		FirstNamePanel.add(FIRST_NAME_LABEL);
		FirstNamePanel.add(firstName);
		
		LastNamePanel.add(LAST_NAME_LABEL);
		LastNamePanel.add(lastName);
		
		BirthDatePanel.add(BIRTHDATE_LABEL);
		BirthDatePanel.add(birthDate);
		
		EmailAddressPanel.add(EMAIL_ADDRESS_LABEL);
		EmailAddressPanel.add(emailAddress);
		
		PhoneNumberPanel.add(PHONE_NUMBER_LABEL);
		PhoneNumberPanel.add(phoneNumber);
		
		
		addContact.addActionListener(new AddContactListener());
		showContacts.addActionListener(new ShowContactsListener());
		
		buttonPanel.add(addContact);
		buttonPanel.add(showContacts);
		
		add(FirstNamePanel);
		add(LastNamePanel);
		add(BirthDatePanel);
		add(EmailAddressPanel);
		add(PhoneNumberPanel);
		add(buttonPanel);
		
		pack();
		
		setVisible(true);
	}
	
	private class AddContactListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Contact Contact = new Contact(firstName.getText(), lastName.getText(), birthDate.getText(),emailAddress.getText(), phoneNumber.getText());
			contacts.add(Contact);
			firstName.setText("");
			lastName.setText("");
			birthDate.setText("");
			emailAddress.setText("");
			phoneNumber.setText("");
		}
		
	}
	
	private class ShowContactsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(contacts.toString().replaceAll("(^\\[)", ""));
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new CustomerContact();
	}

}