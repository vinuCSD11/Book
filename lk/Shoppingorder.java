//package Book.lk;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import net.proteanit.sql.DbUtils;
//
//import javax.swing.JLabel;
//import java.awt.Font;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.awt.event.ActionEvent;
//import javax.swing.JTable;
//import javax.swing.JScrollPane;
//import javax.swing.DefaultComboBoxModel;
//
//public class Shoppingorder extends JFrame {
//
//	private JPanel contentPane;
//	private JTable table;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Shoppingorder frame = new Shoppingorder();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public Shoppingorder() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 687, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel lblOrder = new JLabel("Order");
//		lblOrder.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		lblOrder.setBounds(159, 30, 66, 14);
//		contentPane.add(lblOrder);
//		
//		JLabel lblNewLabel = new JLabel("User_ID");
//		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
//		lblNewLabel.setBounds(38, 73, 66, 14);
//		contentPane.add(lblNewLabel);
//		
//		JLabel lblNewLabel_1 = new JLabel("book_ID");
//		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
//		lblNewLabel_1.setBounds(38, 109, 66, 14);
//		contentPane.add(lblNewLabel_1);
//		
//		JButton btnNewButton = new JButton("Cart");
//		btnNewButton.addActionListener(new ActionListener() {
//			
//				public void actionPerformed(ActionEvent e) {
//					Purchase frame = new Purchase();
//					frame.setVisible(true);
////				try {
////					Class.forName("com.mysql.jdbc.Driver");
////					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");
////					Statement stmt = con.createStatement();
////					String query ="SELECT * FROM shopingorder where userID= ?";
////						
////						ResultSet rs =stmt.executeQuery(query);
////						while (rs.next()) {
////								
////						}
////						table.setModel(DbUtils.resultSetToTableModel(rs));
//					
//				//} catch (Exception e2) {
//					// TODO: handle exception
//				//}
//				
//			//}
//		//});
//		btnNewButton.setBounds(235, 59, 89, 23);
//		contentPane.add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("insert");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					Class.forName("com.mysql.jdbc.Driver");
//					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");	
//					Statement stmt = con.createStatement();
//
//					String Query =" INSERT INTO shopingorder(UserID,ordertype,d_time,book_ID,Totalamount) VALUES (?,?,?,?,?,?)";
//					
//					
//					
////					
//					
//				} catch (Exception e2) {
//				
//				}
//			
//				
//				
//				
//						
//
//			
//		//});
//		btnNewButton_1.setBounds(235, 106, 89, 23);
//		contentPane.add(btnNewButton_1);
//		
//		JLabel lblNewLabel_4 = new JLabel("ordertype");
//		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
//		lblNewLabel_4.setBounds(38, 154, 66, 14);
//		contentPane.add(lblNewLabel_4);
//		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"11", "12", "13", "14", "15"}));
//		comboBox.setToolTipText("");
//		comboBox.setBounds(124, 71, 75, 20);
//		contentPane.add(comboBox);
//		
//		JComboBox comboBox_1 = new JComboBox();
//		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"001", "002", "003", "004", "005"}));
//		comboBox_1.setBounds(124, 109, 75, 20);
//		contentPane.add(comboBox_1);
//		
//		JComboBox comboBox_2 = new JComboBox();
//		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"cash", "card"}));
//		comboBox_2.setBounds(114, 152, 66, 20);
//		contentPane.add(comboBox_2);
//		
//		JButton btnNewButton_2 = new JButton("veiw");
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//				Class.forName("com.mysql.jdbc.Driver");
//				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");	
//				String query ="SELECT * FROM shopingorder where UserID=? " ;
//					PreparedStatement ps =con.prepareStatement(query);
//					ps.setString(1,comboBox.getSelectedItem().toString());
//
//					ResultSet rs = ps.executeQuery();
//					 table.setModel(DbUtils.resultSetToTableModel(rs));
//					
//				 		} catch (Exception e2) {
//				       
//				 			System.out.println(e2);	
//				}
//			}
//		});
//		btnNewButton_2.setBounds(235, 11, 89, 23);
//		contentPane.add(btnNewButton_2);
//		
//		JScrollPane scrollPane_2 = new JScrollPane();
//		scrollPane_2.setBounds(386, 30, 275, 174);
//		contentPane.add(scrollPane_2);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane_2.setViewportView(scrollPane);
//		
//		
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);
//		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane.setColumnHeaderView(scrollPane_1);
//			}
//		
//
//		}
