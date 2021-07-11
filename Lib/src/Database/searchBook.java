package Database;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class searchBook extends JFrame {


	private JTextField textField;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchBook window = new searchBook();
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
	public searchBook() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		Student tun = new Student();
		Object[][] obj = {{"Book Id", "Book Name", "Staus", "Publisher"}};
		Connection con = tun.getConnection();
		//frame = new JFrame();
		setBounds(100, 100, 1263, 682);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 228, 181));
		
		textField = new JTextField();
		textField.setFont(new Font("Serif", Font.PLAIN, 26));
		textField.setBounds(72, 45, 1104, 56);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearchByBook = new JButton("Search By Book Name");
		btnSearchByBook.setBackground(new Color(240, 230, 140));
		btnSearchByBook.setFont(new Font("Serif", Font.PLAIN, 18));
		btnSearchByBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int count = model.getRowCount();
				while(model.getRowCount()!=1)
					model.removeRow(1);
					
				PreparedStatement statement = con.prepareStatement("SELECT * FROM books WHERE bookName='"+textField.getText()+"'");
				ResultSet result = statement.executeQuery();
				int i =0;
				
				while(result.next()) {
					DefaultTableModel model1 = (DefaultTableModel)table.getModel();
					Object[] onj = {result.getInt(1),result.getString(2),result.getString(3),result.getString(5)};
					model1.addRow(onj);
					i++;
				}
				
				
				}
				catch(Exception e1) {System.out.println(e);}
				
			}
			
		});
		btnSearchByBook.setBounds(72, 149, 243, 50);
		getContentPane().add(btnSearchByBook);
		
		JButton btnSearchByBook_1 = new JButton("Search By Book ID");
		btnSearchByBook_1.setBackground(new Color(240, 230, 140));
		btnSearchByBook_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					int count = model.getRowCount();
					while(model.getRowCount()!=1)
						model.removeRow(1);
						
					PreparedStatement statement = con.prepareStatement("SELECT * FROM books WHERE BookID='"+textField.getText()+"'");
					ResultSet result = statement.executeQuery();
					int i =0;
					
					while(result.next()) {
						DefaultTableModel model1 = (DefaultTableModel)table.getModel();
						Object[] onj = {result.getInt(1),result.getString(2),result.getString(3),result.getString(5)};
						model1.addRow(onj);
						i++;
					}

					
					}
					catch(Exception e1) {System.out.println(e);}
				
			}
		});
		btnSearchByBook_1.setFont(new Font("Serif", Font.PLAIN, 18));
		btnSearchByBook_1.setBounds(360, 149, 243, 50);
		getContentPane().add(btnSearchByBook_1);
		
		JButton btnSearchByPublisher = new JButton("Search By Publisher Name");
		btnSearchByPublisher.setBackground(new Color(240, 230, 140));
		btnSearchByPublisher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					int count = model.getRowCount();
					while(model.getRowCount()!=1)
						model.removeRow(1);
						
					PreparedStatement statement = con.prepareStatement("SELECT * FROM books WHERE PublishedBy='"+textField.getText()+"'");
					ResultSet result = statement.executeQuery();
					int i =0;
					
					while(result.next()) {
						DefaultTableModel model1 = (DefaultTableModel)table.getModel();
						Object[] onj = {result.getInt(1),result.getString(2),result.getString(3),result.getString(5)};
						model1.addRow(onj);
						i++;
					}
					
					
					}
					catch(Exception e1) {System.out.println(e);}
				
			}
		});
		btnSearchByPublisher.setFont(new Font("Serif", Font.PLAIN, 18));
		btnSearchByPublisher.setBounds(646, 149, 243, 50);
		getContentPane().add(btnSearchByPublisher);
		
		JButton btnSearchBySubject = new JButton("Search By Subject");
		btnSearchBySubject.setBackground(new Color(240, 230, 140));
		btnSearchBySubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					int count = model.getRowCount();
					while(model.getRowCount()!=1)
						model.removeRow(1);
						
					PreparedStatement statement = con.prepareStatement("SELECT * FROM books WHERE Subject='"+textField.getText()+"'");
					ResultSet result = statement.executeQuery();
					int i =0;
					
					while(result.next()) {
						DefaultTableModel model1 = (DefaultTableModel)table.getModel();
						Object[] onj = {result.getInt(1),result.getString(2),result.getString(3),result.getString(5)};
						model1.addRow(onj);
						i++;
					}
					
					
					}
					catch(Exception e1) {System.out.println(e);}
				
			}
		});
		btnSearchBySubject.setFont(new Font("Serif", Font.PLAIN, 18));
		btnSearchBySubject.setBounds(933, 149, 243, 50);
		getContentPane().add(btnSearchBySubject);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			obj,
			new String[] {
				"Book ID", "Book Name", "Publisher", "Subject"
			}
		));
		table.setFont(new Font("Serif", Font.PLAIN, 26));
		table.setBounds(72, 243, 1104, 323);
		table.setRowHeight(30);
		getContentPane().add(table);
		
		 
		
	}
}
