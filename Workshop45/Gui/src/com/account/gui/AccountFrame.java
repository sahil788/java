import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AccountFrame extends JFrame {
	
	public static void main(String[] args) {
    
		try {
        	/* *
        	 * Creates the frame
        	 * */
        	AccountFrame frame = new AccountFrame();
        	
        	/* *
        	 * Text label which represents the heading
        	 * */
        	JLabel textLabel = new JLabel("Add Account Information", SwingConstants.CENTER);
        	textLabel.setFont(new Font("Courier", Font.BOLD, 24));
        	frame.getContentPane().add(textLabel);        	
        	
        	/* *
        	 * Text label which represents the account field
        	 * */
        	JLabel accountLabel = new JLabel("Account Number : ");
        	accountLabel.setFont(new Font("Serif", Font.BOLD, 16));
        	frame.getContentPane().add(accountLabel);
        	
        	/* *
        	 * textField for account
        	 * */
        	JTextField accountTF = new JTextField(10);
        	frame.getContentPane().add(accountTF);
        	
        	/* *
        	 * Text label which represents the First Name field
        	 * */
        	JLabel firstNameLabel = new JLabel("First Name : ");
        	firstNameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        	frame.getContentPane().add(firstNameLabel);
        	
        	/* *
        	 * textField for first Name
        	 * */
        	JTextField firstNameTF = new JTextField(10);
        	frame.getContentPane().add(firstNameTF);
        	
        	/* *
        	 * Text label which represents the Last Name field
        	 * */
        	JLabel lastNameLabel = new JLabel("Last Name : ");
        	lastNameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        	frame.getContentPane().add(lastNameLabel);
        	
        	/* *
        	 * textField for Last Name
        	 * */
        	JTextField lastNameTF = new JTextField(10);
        	frame.getContentPane().add(lastNameTF);
        	
        	/* *
        	 * Text label which represents the Balance field
        	 * */
        	JLabel balanceLabel = new JLabel("Account Balance : ");
        	balanceLabel.setFont(new Font("Serif", Font.BOLD, 16));
        	frame.getContentPane().add(balanceLabel);
        	
        	/* *
        	 * textField for Balance
        	 * */
        	JTextField balanceTF = new JTextField(10);
        	frame.getContentPane().add(balanceTF);
        	
        	/* *
        	 * Button which will be used to save the object in file
        	 * */
        	JButton save = new JButton("Save");
        	frame.getContentPane().add(save);
        	
        	save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					try {
						
						FileOutputStream fos = new FileOutputStream(new File("Accounts.bin"));
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						
						String account = accountTF.getText();
						String firstName = firstNameTF.getText();
						String lastName = lastNameTF.getText();
						String balance = balanceTF.getText();
							
						Account acc = new Account(Integer.parseInt(account), firstName, lastName, Double.parseDouble(balance));
							
						oos.writeObject(acc);
						accountTF.setText("");
						firstNameTF.setText("");
						lastNameTF.setText("");
						balanceTF.setText("");
												
						oos.close();
						fos.close();

					} catch (FileNotFoundException e) {
						System.out.println(e.getMessage());
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
        	});
        	
        	/* *
        	 * Button which will be used to read the object from file
        	 * */
        	JButton showData = new JButton("Show Data");
        	frame.getContentPane().add(showData);
        	
        	showData.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					GetAccountFrame.read();
				}
        	});
        	
        	frame.setLayout(new GridLayout(11,11,11,11));
            frame.setVisible(true);
            
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
    }
	
    public AccountFrame() {
        setBounds(300, 100, 400, 500);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
