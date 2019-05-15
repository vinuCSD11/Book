package Book.lk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;

public class Bill extends JFrame {

	private JPanel contentPane;
	private final JButton button = new JButton("");
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
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
	public Bill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header=new MessageFormat("bill print");
				MessageFormat footer=new MessageFormat("bill print");
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					String sql = "SELECT book_name,Price FROM bookdetail  ";
					PreparedStatement ps = con.prepareStatement(sql);
					//ps.setString(1,textField.getText());
					//model.addRow(new Object[] { textField.getText() });
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					table.print(JTable.PrintMode.NORMAL,header,footer);
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		button.setBounds(10, 11, 120, 31);
		contentPane.add(button);
		
		table = new JTable();
		table.setBounds(20, 50, 302, 147);
		contentPane.add(table);
		
		textField = new JTextField();
		textField.setBounds(276, 230, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}

