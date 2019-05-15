package Book.lk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class Customerdetails extends JFrame {
	
   
//   Connection con =null;
//   PreparedStatement pst=null;
//   ResultSet rs =null;
   
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JTable aaa;
	protected JLabel user_ID;
	protected JLabel tp;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customerdetails frame = new Customerdetails();
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
	public Customerdetails() {
		setTitle("Customerdetails");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 335);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerDetails = new JLabel("Customer Details");
		lblCustomerDetails.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCustomerDetails.setBackground(Color.BLUE);
		lblCustomerDetails.setBounds(157, 24, 119, 26);
		contentPane.add(lblCustomerDetails);
		
		JLabel lblNewLabel = new JLabel("User_id");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(52, 72, 59, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("user_name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(52, 107, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(50, 132, 61, 14);
		contentPane.add(lblNewLabel_2);
		

		
		JLabel lblNewLabel_4 = new JLabel("Telephone_Number");
		lblNewLabel_4.setBounds(52, 157, 108, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(52, 183, 59, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(52, 209, 80, 14);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(190, 80, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 105, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(190, 130, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(190, 154, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(190, 181, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 207, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("insert");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
					
//				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");	
					Statement stmt = con.createStatement();
					String user_ID=textField.getText();
					String user_name=textField_1.getText();
					String Address=textField_2.getText();
					String tp=textField_3.getText();
					String Email=textField_4.getText();
					String Password=passwordField.getText();
					
					//String Query =" INSERT INTO customerdetails(user_ID, user_name, Address, tp, Email, Password) VALUES (?,?,?,?,?,?)";
					String Query =" INSERT INTO customerdetails values('"+user_ID+"','"+ user_name +"','"+ Address+"', '"+ tp +"','"+ Email+"', '"+Password+"')" ;
					stmt.executeUpdate(Query);
//					
					
				} catch (Exception e2) {
				
				}
						
               
				} 
				
//			
	
			
				
			}
		);
		btnNewButton.setBounds(322, 59, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("veiw");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");	
				String query ="SELECT * FROM customerdetails  where userID= ?";
					PreparedStatement ps =con.prepareStatement(query);
					ps.setString(1,textField.getText());
					ResultSet rs = ps.executeQuery();
					 aaa.setModel(DbUtils.resultSetToTableModel(rs));
					
				 		} catch (Exception e2) {
				       
				 			System.out.println(e2);	
				}
				
		
	}
		});
		btnNewButton_1.setBounds(432, 59, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");	
					String query ="update customerdetails set user_name=?, Address=? ,Email=? ,Password=?  where userID= ?";
						PreparedStatement ps =con.prepareStatement(query);
						ps.setString(1,textField.getText());
						ps.setString(2,textField_1.getText());
						ps.setString(3,textField_2.getText());
						ps.setString(4,textField_3.getText());
						ps.setString(5,textField_4.getText());
						ps.setString(6,passwordField.getText());
						ResultSet rs = ps.executeQuery();
						 aaa.setModel(DbUtils.resultSetToTableModel(rs));

					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_2.setBounds(322, 104, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("next");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Log frame = new Log();
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(432, 104, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(357, 157, 314, 111);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		aaa = new JTable();
		scrollPane.setViewportView(aaa);
		aaa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		aaa.setToolTipText("user_ID\r\n");
		aaa.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		aaa.setBackground(new Color(255, 255, 255));
	}
}
