package Database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddBook extends JFrame{

	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblBookCount;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook window = new AddBook();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public AddBook() throws Exception {
		getContentPane().setBackground(new Color(255, 228, 196));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		Student stu = new Student();
		Connection con = stu.getConnection();
		setBounds(100, 100, 628, 483);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblBookName.setBounds(68, 59, 122, 38);
		getContentPane().add(lblBookName);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblPublisher.setBounds(68, 126, 122, 38);
		getContentPane().add(lblPublisher);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblSubject.setBounds(68, 192, 122, 38);
		getContentPane().add(lblSubject);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Serif", Font.PLAIN, 24));
		textField_1.setBounds(198, 59, 272, 38);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Serif", Font.PLAIN, 24));
		textField_2.setBounds(198, 126, 272, 38);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Serif", Font.PLAIN, 24));
		textField_3.setBounds(198, 192, 272, 38);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBackground(new Color(240, 230, 140));
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = Integer.parseInt(textField_4.getText());
				try {
					PreparedStatement total = con.prepareStatement("SELECT COUNT(*) FROM books");
					ResultSet result = total.executeQuery();
					int num=0;
					while (result.next()) {
						 num = result.getInt(1);
						 }
					for(int i=1;i<=count;i++) {
						num++;
						PreparedStatement add = con.prepareStatement("INSERT INTO books (BookID, bookName, Status, PublishedBy, Subject) VALUES ("+num+",'"+textField_1.getText()+"','Available','"+textField_2.getText()+"','"+textField_3.getText()+"')");
						add.executeUpdate();
					}
					JOptionPane.showMessageDialog(null, "Books Added Successfully");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				
				
			
		});
		btnAddBook.setFont(new Font("Serif", Font.PLAIN, 24));
		btnAddBook.setBounds(258, 348, 173, 47);
		getContentPane().add(btnAddBook);
		
		lblBookCount = new JLabel("Book Count");
		lblBookCount.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblBookCount.setBounds(66, 266, 124, 38);
		getContentPane().add(lblBookCount);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Serif", Font.PLAIN, 24));
		textField_4.setBounds(198, 266, 272, 38);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
	}
}
