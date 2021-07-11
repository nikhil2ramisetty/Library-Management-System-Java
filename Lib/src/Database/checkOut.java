package Database;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;

public class checkOut extends JFrame{


	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkOut window = new checkOut();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public checkOut() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBounds(100, 100, 589, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 228, 181));
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblStudentId.setBounds(60, 80, 150, 40);
		getContentPane().add(lblStudentId);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBookId.setBounds(60, 166, 150, 40);
		getContentPane().add(lblBookId);
		
		textField = new JTextField();
		textField.setFont(new Font("Serif", Font.PLAIN, 24));
		textField.setBounds(219, 80, 219, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_1.setBounds(218, 166, 219, 40);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCheckOutBook = new JButton("Check Out Book");
		btnCheckOutBook.setBackground(new Color(240, 230, 140));
		btnCheckOutBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int student = Integer.parseInt(textField.getText());
				int book = Integer.parseInt(textField_1.getText());
				Student stu = new Student();
				try {
					Connection con = stu.getConnection();
					PreparedStatement statement = con.prepareStatement("SELECT * FROM books WHERE BookID = "+book);
					ResultSet result = statement.executeQuery();
					while(result.next()) {
						if(result.getString(3).contentEquals("Available")) {
							Date date = new Date();
							java.sql.Date sqldate = new java.sql.Date(date.getTime());
							PreparedStatement statement1 = con.prepareStatement("INSERT INTO borrowed (StudentID, BookID, DateIssued, BookName) VALUES ("+student+","+book+",?,'"+result.getString(2)+"')");
							statement1.setDate(1, sqldate);
							statement1.executeUpdate();
							PreparedStatement statement2 = con.prepareStatement("UPDATE books SET Status = 'Reserved', StudentID="+student+" WHERE BookID = "+book);
							statement2.executeUpdate();
							JOptionPane.showMessageDialog(null, "CheckOut Successful!!");
							textField.setText("");
							textField_1.setText("");
							break;
						}
						else {
							JOptionPane.showMessageDialog(null, "Book Not Available");
						}
					}
				}catch(Exception e1) {System.out.println(e1);}
				
				
			}
		});
		btnCheckOutBook.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnCheckOutBook.setBounds(162, 271, 201, 40);
		getContentPane().add(btnCheckOutBook);
	}
}
