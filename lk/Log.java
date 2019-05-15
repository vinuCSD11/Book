package Book.lk;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java .sql.*;
import java.awt.Color;
import java.awt.Font;


public class Log extends JFrame {

	protected static final JLabel Uid = null;
	protected static final Component frame = null;
	protected static final String[] String = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	protected JLabel username;
	protected JLabel password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log frame = new Log();
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
	public Log() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUserid.setBounds(78, 47, 46, 14);
		contentPane.add(lblUserid);
		
		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Username.setBounds(78, 96, 65, 14);
		contentPane.add(Username);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPassword.setBounds(78, 154, 65, 14);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Declare variables
				//String  id = textField.getText(); 
				String  uname  =textField_1.getText();
				String pass=passwordField_3.getText();
				
				//Database connection code
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
					Statement stmt = con.createStatement();
					//  Username & Password Using in  SQL
					ResultSet rs = stmt.executeQuery("select Username,Password from login ");
					while (rs.next()) {
					String dusername =rs.getString(1);
					String dPassword=rs.getString(2);
					//int did=rs.getInt(3);
					//check database username and password
					if(uname.equals(dusername) && pass.equals(dPassword)) {
						
						
						
						Bookdetails jframe =new Bookdetails();
						jframe.setVisible(true);
						
						Customerdetails jframe1=new Customerdetails();
						jframe.setVisible(true);
								
											}
					
					else 
					{
						ResultSet rs1 = stmt.executeQuery("select Username,Password from login ");
						while (rs1.next()) {
							
						String dusername1 =rs1.getString(1);
						String dPassword2=rs1.getString(2);
						if(uname.equals(dusername1) && pass.equals(dPassword2)) {
							Customerlogin jframe =new Customerlogin();
							jframe.setVisible(true);
							//JOptionPane.showMessageDialog(jframe,"message sucess");
							
						
						}
						//username password error message
						//System.exit(0);
						}
						
						}
					
					}
					
				} catch (Exception e2) {
					//JOptionPane.showMessageDialog(frame,"message sucess");
					
				}
				
			
				
				
	}

		
			
			});
			
		
		btnNewButton.setBounds(35, 210, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(167, 210, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Signup");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setBounds(291, 210, 89, 23);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(186, 44, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 94, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(320, 154, -80, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(269, 151, -29, 20);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(276, 166, -44, 20);
		contentPane.add(passwordField_2);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setBounds(186, 152, 86, 17);
		contentPane.add(passwordField_3);
		
		JLabel lblNewLabel = new JLabel("mainLogin");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(167, 19, 114, 14);
		contentPane.add(lblNewLabel);
	}
}
