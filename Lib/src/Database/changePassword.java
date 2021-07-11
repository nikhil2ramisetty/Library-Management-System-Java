package Database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class changePassword extends JFrame{

	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public changePassword(String Username) {
		getContentPane().setBackground(new Color(255, 228, 181));
		initialize(Username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String Username) {
		setBounds(100, 100, 668, 535);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblPreviousPassword = new JLabel("Previous Password");
		lblPreviousPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPreviousPassword.setBounds(66, 118, 183, 44);
		getContentPane().add(lblPreviousPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewPassword.setBounds(66, 196, 183, 44);
		getContentPane().add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(66, 283, 183, 44);
		getContentPane().add(lblConfirmPassword);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBackground(new Color(240, 230, 140));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student stu = new Student();
				try {
				Connection con = stu.getConnection();
				PreparedStatement statement = con.prepareStatement("SELECT password FROM student WHERE StudentID='"+Username+"'");
				ResultSet result = statement.executeQuery();
				String ppswd;
				while(result.next()) {
					ppswd = result.getString(1);
					if(ppswd.equals(passwordField.getText()) && passwordField_1.getText().equals(passwordField_2.getText())) {
						PreparedStatement st2 = con.prepareStatement("UPDATE student SET password='"+passwordField_1.getText()+"' WHERE StudentID='"+Username+"'");
						st2.executeUpdate();
						JOptionPane.showMessageDialog(null, "Password Updated Successfully");
						dispose();
					}
					else if(ppswd.equals(passwordField.getText()) ) {
						JOptionPane.showMessageDialog(null, "Passwords Don't Match");
					}
					else if(passwordField_1.getText().equals(passwordField_2.getText())) {
						JOptionPane.showMessageDialog(null, "Previous Password Incorrect");
					}
				}
				
				}
				catch(Exception e2) {System.out.println(e2);}
				
			}
		});
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChangePassword.setBounds(273, 365, 216, 44);
		getContentPane().add(btnChangePassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Serif", Font.PLAIN, 24));
		passwordField.setBounds(273, 118, 285, 44);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Serif", Font.PLAIN, 24));
		passwordField_1.setBounds(273, 196, 285, 44);
		getContentPane().add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Serif", Font.PLAIN, 24));
		passwordField_2.setBounds(273, 283, 285, 44);
		getContentPane().add(passwordField_2);
	}

}
