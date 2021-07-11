package Database;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class studentInterface extends JFrame {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public studentInterface(String Username) {
		initialize(Username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(String Username) {
		Object[][] obj = {{"Book Id", "Book Name", "Date Issued"}};
		setBounds(100, 100, 797, 672);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 222, 173));
		
		JButton btnSearchBooks = new JButton("Search Books");
		btnSearchBooks.setBackground(new Color(238, 232, 170));
		btnSearchBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBook search;
				try {
					search = new searchBook();
					search.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSearchBooks.setFont(new Font("Serif", Font.PLAIN, 24));
		btnSearchBooks.setBounds(112, 34, 228, 55);
		getContentPane().add(btnSearchBooks);
		
		JButton btnCheckFine = new JButton("Books Issued");
		btnCheckFine.setBackground(new Color(238, 232, 170));
		btnCheckFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					int count = model.getRowCount();
					while(model.getRowCount()!=1)
						model.removeRow(1);
					
					int roll = Integer.parseInt(Username);
					Student stu = new Student();
					Connection con = stu.getConnection();
					PreparedStatement statement = con.prepareStatement("SELECT * FROM borrowed WHERE StudentID="+roll);
					ResultSet result = statement.executeQuery();
					while(result.next()) {
						DefaultTableModel model1 = (DefaultTableModel)table.getModel();
						Object[] onj = {result.getInt(2),result.getString(4),result.getString(3)};
						model.addRow(onj);
					}
					
				}catch(Exception e1) {System.out.println(e);}
				
			}
		});
		btnCheckFine.setFont(new Font("Serif", Font.PLAIN, 24));
		btnCheckFine.setBounds(436, 34, 228, 55);
		getContentPane().add(btnCheckFine);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBackground(new Color(238, 232, 170));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword pass = new changePassword(Username);
				pass.setVisible(true);
			}
		});
		btnChangePassword.setFont(new Font("Serif", Font.PLAIN, 24));
		btnChangePassword.setBounds(436, 127, 228, 55);
		getContentPane().add(btnChangePassword);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(new Color(238, 232, 170));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingMain swm = new SwingMain();
				swm.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setFont(new Font("Serif", Font.PLAIN, 24));
		btnLogOut.setBounds(112, 127, 228, 55);
		getContentPane().add(btnLogOut);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 21));
		table.setModel(new DefaultTableModel(
			obj,
			new String[] {
				"Date Issued", "Book Name", "Book ID"
			}
		));
		table.setBounds(49, 238, 678, 326);
		table.setRowHeight(30);
		getContentPane().add(table);
	}

}
