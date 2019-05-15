package Book.lk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class Purchase extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	
	public JTable table;
	private JTextField textField_2;
	public JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase frame = new Purchase();
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
	public Purchase() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
		} catch (Exception e2) {

			// System.out.println(e2);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setText(list.getSelectedValue().toString());
			}
		});
		
		list.setBounds(25, 45, 227, 200);
		contentPane.add(list);
		
		JButton btnPurches = new JButton("purches");
		btnPurches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel model = new DefaultListModel();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
					Statement stmt = con.createStatement();
					String sql = "SELECT BookID,book_name,Price FROM bookdetail  ";
					ResultSet rs = stmt.executeQuery(sql);
					int row = 0;
					while (rs.next())
						// model.addElement(rs.getString("book_title"));
						// model.addElement(rs.getObject(1).toString() +"-"+
						// rs.getObject(2).toString());
						model.addElement(rs.getObject(1).toString() + "-" + rs.getObject(2).toString()+ " of the price is Rs " + rs.getObject(3).toString());
						
					
					System.out.println(model);
					list.setModel(model);
					rs.close();

				} catch (Exception e1) {

					e1.printStackTrace();

				}
			}

		
			
		});
		btnPurches.setBounds(161, 11, 89, 23);
		contentPane.add(btnPurches);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {textField_1 .getText() });
				double total = 0;
				for (int i = 0; i < table.getRowCount(); i++) {
					double price = Double.parseDouble((String) table.getValueAt(i, 0));
					total += price;
				}
				textField.setText(String.valueOf(total));
			}
		});
		btnNewButton.setBounds(294, 208, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblTotal = new JLabel("Total");
		
		lblTotal.setBounds(252, 275, 46, 14);
		contentPane.add(lblTotal);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 14, 141, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		table.setBounds(265, 62, 136, 123);
		contentPane.add(table);
		
		JButton btnNewButton_1 = new JButton("calculate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { textField_2.getText() });
				double total = 0;
				for (int i = 0; i <table.getRowCount(); i++) {
					double price = Double.parseDouble((String) table.getValueAt(i, 0));
					total += price;
				}
				textField.setText(String.valueOf(total));

			
				
				
			JTable tbbill = new JTable();
			tbbill.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "price" }) {
				Class[] columnTypes = new Class[] { Double.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			tbbill.setBounds(842, 247, 2, 5);
			contentPane.add(tbbill);	
			}
		});
		btnNewButton_1.setBounds(457, 271, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JList list_1 = new JList();
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_2.setText(list_1.getSelectedValue().toString());
			}
		});
		list_1.setBounds(470, 61, 136, 184);
		contentPane.add(list_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(470, 30, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("bill");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultListModel model = new DefaultListModel();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
					

					Statement s = con.createStatement();
					
					
					String sql = "SELECT Price  FROM bookdetail ";
					ResultSet rs = s.executeQuery(sql);
					int row = 0;
					while (rs.next())
						// model.addElement(rs.getString("book_title"));
						// model.addElement(rs.getObject(1).toString() +"-"+
						// rs.getObject(2).toString());
						model.addElement(rs.getObject(1).toString());

					System.out.println(model);
					list_1.setModel(model);
					rs.close();

				} catch (Exception e1) {

					e1.printStackTrace();

				}
			}
			
		});
		btnNewButton_2.setBounds(557, 271, 89, 23);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		
		textField.setBounds(308, 272, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		}

		
		}

	

