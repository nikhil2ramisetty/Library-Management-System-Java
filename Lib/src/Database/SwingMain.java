package Database;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SwingMain extends JFrame{
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingMain window = new SwingMain();
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
	public SwingMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 801, 541);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(245, 222, 179));
		
		
		JLabel lblUsername = new JLabel("Student ID");
		lblUsername.setFont(new Font("Serif", Font.PLAIN, 26));
		lblUsername.setBounds(123, 114, 116, 46);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Serif", Font.PLAIN, 26));
		lblPassword.setBounds(123, 220, 116, 46);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Serif", Font.PLAIN, 24));
		passwordField.setBounds(296, 220, 243, 46);
		getContentPane().add(passwordField);
		
		JButton btnLogInAs = new JButton("Log In as a Student");
		btnLogInAs.setBackground(new Color(240, 230, 140));
		btnLogInAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student obj = new Student();
				try {
					if(obj.login(textField.getText(), passwordField.getText())) {
						JOptionPane.showMessageDialog(null, "Logged In Successfully");
					    studentInterface stuinf = new studentInterface(textField.getText());
					    stuinf.setVisible(true);
					    dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Check Username or Password");
					}
						
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnLogInAs.setFont(new Font("Serif", Font.PLAIN, 24));
		btnLogInAs.setBounds(63, 358, 248, 46);
		getContentPane().add(btnLogInAs);
		
		JButton btnLogInAs_1 = new JButton("Log In as Librarian");
		btnLogInAs_1.setBackground(new Color(240, 230, 140));
		btnLogInAs_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("root") && passwordField.getText().equals("admin")) {
					JOptionPane.showMessageDialog(null, "Logged In Successfully!!");
					librarianInterface lib = new librarianInterface();
					lib.setVisible(true);
					dispose();
				}
			}
		});
		btnLogInAs_1.setFont(new Font("Serif", Font.PLAIN, 24));
		btnLogInAs_1.setBounds(443, 358, 243, 46);
		getContentPane().add(btnLogInAs_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Serif", Font.PLAIN, 24));
		textField.setBounds(296, 114, 243, 46);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
	}
}
