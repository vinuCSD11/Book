package Book.lk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

public class Welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setBounds(111, 21, 0, 0);
		
		JLabel lblBookShopping = new JLabel("Book shopping");
		lblBookShopping.setForeground(Color.DARK_GRAY);
		lblBookShopping.setBounds(124, 11, 158, 23);
		lblBookShopping.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBookShopping.setBackground(Color.CYAN);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(116, 21, 0, 0);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(121, 21, 0, 0);
		
		JButton btnNewButton = new JButton("YES");
		btnNewButton.setBounds(320, 103, 111, 32);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainLogin  jframe =new MainLogin ();
				jframe.setVisible(true);
				
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(lblBookShopping);
		contentPane.add(btnNewButton);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 1, 1);
		contentPane.add(layeredPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon("E:\\New folder\\stack-old-books-library_23-2147711453.jpg"));
		lblNewLabel.setBounds(0, 60, 310, 201);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("NO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(320, 163, 111, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblPurchesing = new JLabel("purchesing");
		lblPurchesing.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPurchesing.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPurchesing.setBackground(Color.WHITE);
		lblPurchesing.setBounds(335, 60, 72, 32);
		contentPane.add(lblPurchesing);
	}

	public void setWelcomeMessage1(String string, int id) {
		// TODO Auto-generated method stub
		
	}

	public void setWelcomeMessage(String string, int id) {
		// TODO Auto-generated method stub
		
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}
}
