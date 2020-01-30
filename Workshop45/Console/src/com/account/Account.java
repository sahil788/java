import java.io.*;

/* *
 * This class is the main Account class which is Serializable
 * 
 * This class contains following,
 * 		basic variable declarations,
 * 		constructors, 
 * 		and getter functions.
 * */
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	
	/* *
	 * Default constructor
	 * */
	public Account() {
	}
	
	/* *
	 * Parameterized constructor
	 * */
	public Account(int account, String firstName, String lastName, double balance) {
		this.account = account;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	
	/* *
	 * Getters functions
	 * */
	public int getAccount() {
		return account;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public double getBalance() {
		return balance;
	}
}
