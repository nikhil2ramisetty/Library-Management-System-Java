package Database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class returnBook extends JFrame{

	
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnBook window = new returnBook();
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
	public returnBook() {
		getContentPane().setBackground(new Color(255, 228, 181));
		getContentPane().setForeground(new Color(255, 228, 181));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 24));
		setBounds(100, 100, 697, 457);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBookId.setBounds(86, 89, 157, 43);
		getContentPane().add(lblBookId);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblStudentId.setBounds(86, 196, 157, 43);
		getContentPane().add(lblStudentId);
		
		textField = new JTextField();
		textField.setFont(new Font("Serif", Font.PLAIN, 24));
		textField.setBounds(276, 89, 225, 43);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Serif", Font.PLAIN, 24));
		textField_1.setBounds(276, 196, 225, 43);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		Student stu = new Student();
		
		
		JButton btnCheckFine = new JButton("Check Fine");
		btnCheckFine.setBackground(new Color(240, 230, 140));
		btnCheckFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = stu.getConnection();
					int BookID = Integer.parseInt(textField.getText());
					int StudentID = Integer.parseInt(textField_1.getText());
					PreparedStatement statement = con.prepareStatement("SELECT * FROM borrowed WHERE BookID="+BookID);
					ResultSet result = statement.executeQuery();
					if(result.next()) {
							if(Integer.parseInt(result.getString(1)) == StudentID) {
							System.out.print("HelloWorld");
							Date date = new Date();
							java.sql.Date sqldate = new java.sql.Date(date.getTime());
							java.sql.Date sqldate1 = result.getDate(3);
							long difference =  (sqldate.getTime()-sqldate1.getTime())/86400000;
					        long days=  Math.abs(difference);
							JOptionPane.showMessageDialog(null, "Fine : Rs. "+days*2);
							}
							else {
								JOptionPane.showMessageDialog(null, "Book Not Taken By This Student");
							}
					}
					else {
						JOptionPane.showMessageDialog(null, "Book not Taken at all");
					}
				}catch(Exception e1) {System.out.println(e1);}
			}
		});
		btnCheckFine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCheckFine.setBounds(134, 307, 148, 43);
		getContentPane().add(btnCheckFine);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setBackground(new Color(240, 230, 140));
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection con = stu.getConnection();
					int BookID = Integer.parseInt(textField.getText());
					int StudentID = Integer.parseInt(textField_1.getText());
					PreparedStatement statement = con.prepareStatement("DELETE FROM borrowed WHERE BookID="+BookID);
					statement.executeUpdate();
					PreparedStatement statement1 = con.prepareStatement("UPDATE books SET Status='Available', StudentID = NULL WHERE BookID="+BookID);
					statement1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Book returned Successfully!");
					textField.setText("");
					textField_1.setText("");
				}catch(Exception e1) {System.out.println(e1);}
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReturnBook.setBounds(348, 307, 153, 43);
		getContentPane().add(btnReturnBook);
	}

}
