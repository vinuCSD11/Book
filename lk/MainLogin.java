package Book.lk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JToggleButton;

public class MainLogin extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	PreparedStatement pst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					MainLogin frame = new MainLogin();
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
	public MainLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(30, 60, 72, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 106, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usertype");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(30, 145, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(124, 57, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 103, 86, 20);
		contentPane.add(passwordField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Admin", "Customer"}));
		comboBox.setBounds(124, 142, 86, 20);
		contentPane.add(comboBox);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String uname=textField.getText();
					String upass=passwordField.getText();
					String option=comboBox.getSelectedItem().toString();
					if(uname.equals("")|| upass.equals("")||option.equals("Select")) {
						JOptionPane.showMessageDialog(rootPane,"not Select type", "error",1);
					}
					else {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
							//Statement stmt = con.createStatement();
							pst=con.prepareStatement("Select * from main_login where user_name=? and  password=? ");
							pst.setString(1,uname);
							pst.setString(2,upass);
							ResultSet rs = pst.executeQuery();
							
							if(rs.next()) {
								String S1=rs.getString("options");
								String un=rs.getString("user_name");
								
								if(option.equalsIgnoreCase("Admin") && S1.equalsIgnoreCase("Admin")) {
									Bookdetails jframe =new Bookdetails();
									jframe.setVisible(true);
									setVisible(false);
								}
								if(option.equalsIgnoreCase("Customer") &&S1.equalsIgnoreCase("Customer")) {
									Customerlogin jframe =new Customerlogin();
									jframe.setVisible(true);
									setVisible(false);
								}
								else {
									//JOptionPane.showMessageDialog(rootPane," message", "loginerror",1);
								}
								
							}
							
							
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}			}

			private void setvisible() {
				// TODO Auto-generated method stub
				
			}
		});
		btnLogin.setBounds(93, 207, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_3 = new JLabel("Main_login");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(178, 11, 72, 35);
		contentPane.add(lblNewLabel_3);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(229, 207, 89, 23);
		contentPane.add(btnCancel);
	}
}
