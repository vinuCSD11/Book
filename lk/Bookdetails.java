package Book.lk;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class Bookdetails extends JFrame {

	protected static final int BookID = 0;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookdetails frame = new Bookdetails();
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
	public Bookdetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 354);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookDetails = new JLabel("Book Details");
		lblBookDetails.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBookDetails.setBounds(217, 11, 98, 24);
		contentPane.add(lblBookDetails);
		
		JLabel lblNewLabel = new JLabel("BookID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 35, 51, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("book_name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 60, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Publisher");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 85, 69, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 110, 61, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Author_name");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 135, 76, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Price");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 160, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(85, 33, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(85, 58, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(85, 83, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(85, 108, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(85, 133, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(85, 160, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");	
					Statement stmt = con.createStatement();
					String  BookID=textField.getText();
					String 	book_name=textField_1.getText();
					String 	Publisher=textField_2.getText();
					String Quantity=textField_3.getText();
					String Author_name=textField_4.getText();
					String Price=textField_5.getText();
					String ISBN=textField_6.getText();
					   
					
					
					//String Query =" INSERT INTO customerdetails(user_ID, user_name, Address, tp, Email, Password) VALUES (?,?,?,?,?,?)";
					String Query =" INSERT INTO bookdetail values('"+BookID+"','"+book_name+"','"+Publisher+"','"+Quantity+"','"+ Author_name+"','"+Price+"','"+ISBN+"')";
					stmt.executeUpdate(Query);
					
					
//					
					
				} catch (Exception e2) {
				
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 247, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "delete from bookdetail where BookID= ?";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");	
					Statement stmt = con.createStatement();
					
					PreparedStatement preparedStmt = con.prepareStatement(query);
				      preparedStmt.setString(1,textField.getText());

				      // execute the preparedstatement
				      preparedStmt.execute();
				      
				      con.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(111, 247, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("next");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
//				Shoppingorder jframe =new Shoppingorder();
//				jframe.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_2.setBounds(10, 281, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnVeiw = new JButton("Veiw");
		btnVeiw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			try {
	  		   Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");	
				String query ="SELECT * FROM bookdetail  where BookID= ?";
					PreparedStatement ps =con.prepareStatement(query);
					ps.setString(1,textField.getText());

					ResultSet rs = ps.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					
				 		} catch (Exception e2) {
				       
				 			System.out.println(e2);	
				}
				

		 


		      }
		    
				
				
			
		});
		btnVeiw.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnVeiw.setBounds(111, 281, 89, 23);
		contentPane.add(btnVeiw);
		
		JLabel lblNewLabel_6 = new JLabel("ISBN");
		lblNewLabel_6.setBounds(10, 185, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(85, 182, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(181, 46, 439, 141);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setColumnHeaderView(scrollBar);
		
		JButton btnColse = new JButton("Colse");
		btnColse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainLogin  jframe =new MainLogin ();
				jframe.setVisible(true);
			}
		});
		btnColse.setBounds(226, 282, 89, 23);
		contentPane.add(btnColse);
	}
}
