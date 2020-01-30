import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class GetAccountFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void read() {
	
		GetAccountFrame frame = new GetAccountFrame();
		
		try {
			FileInputStream fis = new FileInputStream(new File("Accounts.bin"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Account acc = (Account) ois.readObject();
			
			int account = acc.getAccount();
			double balance = acc.getBalance();
					
			String accountStr = Integer.toString(account);
			String balanceStr = Double.toString(balance);
					
			JLabel textLabel = new JLabel("Account Info", SwingConstants.CENTER);
		   	textLabel.setFont(new Font("Courier", Font.BOLD, 24));
		    frame.getContentPane().add(textLabel);
					
			JTextArea textArea = new JTextArea(5, 20);
			textArea.append("Account : " + accountStr + "\n");
			textArea.append("FirstName : " + acc.getFirstName() + "\n");
			textArea.append("LastName : " + acc.getLastName() + "\n");
			textArea.append("Balance : " + balanceStr);
				
			frame.add(textArea);
			frame.setLayout(new FlowLayout());
	
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			ois.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public GetAccountFrame() {
		setBounds(700, 250, 250, 200);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
