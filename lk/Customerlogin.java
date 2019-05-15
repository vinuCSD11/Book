package Book.lk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Customerlogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customerlogin frame = new Customerlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public Customerlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerLogin = new JLabel("Customer login");
		lblCustomerLogin.setBounds(149, 11, 124, 14);
		contentPane.add(lblCustomerLogin);
		
		JLabel lblNewLabel = new JLabel("User_ID");
		lblNewLabel.setBounds(58, 62, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User_name");
		lblNewLabel_1.setBounds(58, 105, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(58, 144, 69, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(143, 102, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 141, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  uname  =textField.getText();
				String pass=passwordField.getText();
				
				//Database connection code
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
					Statement stmt = con.createStatement();
					//  Username & Password Using in  SQL
					ResultSet rs = stmt.executeQuery("select Username,Password from customerlogin ");
					while (rs.next()) {
					String dusername =rs.getString(1);
					String dPassword=rs.getString(2);
					//int did=rs.getInt(3);
					//check database username and password
					if(uname.equals(dusername) && pass.equals(dPassword)) {
						
						
						
					
						
						Bookdetails jframe =new Bookdetails();
						jframe.setVisible(true);
								
											}
					
					else 
					{
						
						
						//System.exit(0);
						}
						
						}
					
					}
					
				 catch (Exception e2) {
					
					
				}
				
			
				
				
	

		
			}
		});
		btnLogin.setBounds(77, 231, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customerdetails frame = new Customerdetails();
				frame.setVisible(true);
			}
		});
		btnSignup.setBounds(221, 231, 89, 23);
		contentPane.add(btnSignup);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 59, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
