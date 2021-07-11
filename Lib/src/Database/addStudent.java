package Database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class addStudent extends JFrame{

	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblStudentName;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addStudent window = new addStudent();
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
	public addStudent() {
		getContentPane().setBackground(new Color(255, 228, 181));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 554, 516);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("College ID");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUsername.setBounds(67, 96, 148, 41);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPassword.setBounds(67, 242, 148, 41);
		getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Serif", Font.PLAIN, 24));
		textField.setBounds(223, 96, 235, 41);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Serif", Font.PLAIN, 24));
		passwordField.setBounds(223, 242, 235, 41);
		getContentPane().add(passwordField);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBackground(new Color(240, 230, 140));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student stu = new Student();
				int id = Integer.parseInt(textField.getText());
				String password = passwordField.getText();
				String Name = textField_1.getText();
				try {
				Connection con = stu.getConnection();
				PreparedStatement posted = con.prepareStatement("INSERT INTO student (StudentID, studentName, password) VALUES ("+id+",'"+Name+"','"+password+"')");	
				posted.executeUpdate();
				JOptionPane.showMessageDialog(null,"Account Added Successfully");
				textField.setText("");
				textField_1.setText("");
				passwordField.setText("");
				}
				catch(Exception e1) {JOptionPane.showMessageDialog(null, "Account already created with College ID");}
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnSignUp.setBounds(188, 360, 153, 51);
		getContentPane().add(btnSignUp);
		
		lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblStudentName.setBounds(67, 168, 148, 41);
		getContentPane().add(lblStudentName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Serif", Font.PLAIN, 24));
		textField_1.setBounds(223, 168, 235, 41);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
