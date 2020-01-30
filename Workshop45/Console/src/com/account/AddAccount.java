import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/* *
 * This class is used,
 * 		to Add Some Account information,
 * 		to Add those objects in file.
 * This class contains the main method.
 * */
public class AddAccount {
	
	public static void main(String[] args) {
		
		try {
			
			/* *
			 * FileOutputStream is used to write file as Accounts.txt
			 * fos created as file descriptor to represent this file connection
			 * */
			FileOutputStream fos = new FileOutputStream(new File("Accounts.bin"));
			/* *
			 * ObjectOutputStream is used to write Java Objects
			 * */
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			System.out.println("------->JAC 444 Workshop 2<--------");
			System.out.println("------------->Task 1 <-------------");
			
			/* *
			 * Scanner is used to read various types of Values
			 * */
			Scanner in = new Scanner(System.in);
			
			int option;
			int account = 0;
			String firstName = null;
			String lastName = null;
			double balance = 0;
			Boolean error = false;
			
			/* *
			 * This do While loop will execute until user will enter 0 as an option.
			 * */
			do {
				System.out.println("\n1. Add Account");
				System.out.println("2. Show Data");
				System.out.println("0. Exit\n");
				System.out.print("Enter the Number : ");
				option = in.nextInt();
				
				switch(option) {
					case 1 :
						System.out.println("\nEnter Account Details");
						System.out.println("---------------------");
						
						/* *
						 * This loop make sure that user enters a positive account number
						 * */
						do {
							System.out.print("Account : ");
							account = in.nextInt();
							if(account <= 0) {
								error = true;
								System.out.println("Invalid Account Number! It Should be Positive.");
							} else {
								error = false;
							}
						} while(error == true);
						
						/* *
						 * This loop make sure that use enters 5 character long first name
						 * */
						do {
							System.out.print("First Name : ");
							firstName = in.next();
							if(firstName.length() < 5) {
								error = true;
								System.out.println("First Name should be atleast 5 Character long! Try Again.");
							} else {
								error = false;
							}
						} while(error == true);
						
						/* *
						 * This loop make sure that use enters 5 character long last name
						 * */
						do {
							System.out.print("Last Name : ");
							lastName = in.next();
							if(lastName.length() < 5) {
								error = true;
								System.out.println("Last Name should be atleast 5 Character long! Try Again.");
							} else {
								error = false;
							}
						} while(error == true);
						
						System.out.print("Balance : ");
						balance = in.nextDouble();
						
						/* *
						 * creates an object of class Account
						 * */
						Account acc = new Account(account, firstName, lastName, balance);
						
						/* *
						 * Write that object to File
						 * */
						oos.writeObject(acc);
						
						break;
						
					case 2 :
						
						/* *
						 * This method is used to read the object from file
						 * */
						GetAccount.read();
						break;
						
					case 0 :
						System.out.println("\nThank You!\n");
						break;
						
					default :
						System.out.println("Please Enter Valid Number From Given Options!\n");
						break;
				}
				
			} while(option != 0);
			
			in.close();
			oos.close();
			fos.close();
			
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage()); 
		}
	}
}
