import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GetAccount {
	
	@SuppressWarnings("null")
	public static void read() {
		
		try {
			
			/* *
			 * FileInputStream is used to read file
			 * fis created as file descriptor to represent this file connection
			 * */
			FileInputStream fis = new FileInputStream("Accounts.bin");
			/* *
			 * ObjectInputStream is used to read Java Objects
			 * */
			ObjectInputStream ois = new ObjectInputStream(fis);

			/* *
			 * Number of objects
			 * */
			int count = 0;
			
			while(ois != null) {
				
				/* *
				 * instance of object got created to read perticular data from file
				 * */
				Account acc = (Account) ois.readObject();
				
				count++;
				
				/* *
				 * Information of Account in Perticualr Format
				 * */
				System.out.println("\nAccount " + count);
				System.out.println("=========");
				System.out.println("Account: " + acc.getAccount());
				System.out.println("First Name: " + acc.getFirstName());
				System.out.println("Last Name: " + acc.getLastName());
				System.out.println("Balance: " + acc.getBalance());
			}
			
			ois.close();
			fis.close();
			
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage()); 
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
