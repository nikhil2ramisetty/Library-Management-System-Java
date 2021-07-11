package Database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class librarianInterface extends JFrame{


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					librarianInterface window = new librarianInterface();
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
	public librarianInterface() {
		getContentPane().setBackground(new Color(255, 228, 181));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 674, 433);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBackground(new Color(240, 230, 140));
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudent add = new addStudent();
				add.setVisible(true);
			}
		});
		btnAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAddStudent.setBounds(76, 71, 188, 48);
		getContentPane().add(btnAddStudent);
		
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.setBackground(new Color(240, 230, 140));
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBook adb;
				try {
					adb = new AddBook();
					adb.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAddBooks.setBounds(76, 191, 188, 48);
		getContentPane().add(btnAddBooks);
		
		JButton btnRenewBooks = new JButton("Return Books");
		btnRenewBooks.setBackground(new Color(240, 230, 140));
		btnRenewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBook ret = new returnBook();
				ret.setVisible(true);
			}
		});
		btnRenewBooks.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnRenewBooks.setBounds(389, 71, 188, 48);
		getContentPane().add(btnRenewBooks);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(new Color(240, 230, 140));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingMain swin = new SwingMain();
				swin.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLogOut.setBounds(224, 295, 188, 48);
		getContentPane().add(btnLogOut);
		
		JButton btnCheckOutBook = new JButton("Check Out Book");
		btnCheckOutBook.setBackground(new Color(240, 230, 140));
		btnCheckOutBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkOut check = new checkOut();
				check.setVisible(true);
			}
		});
		btnCheckOutBook.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCheckOutBook.setBounds(389, 191, 188, 48);
		getContentPane().add(btnCheckOutBook);
	}

}
