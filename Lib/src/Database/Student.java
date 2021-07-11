package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbs.Driver";
			String url = "jdbc:mysql://localhost:3306/library";
			String username = "Nikhil";
			String password = "HelloWorld";
			//Class.forName(driver);
			
			
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return con;
		}
		catch(Exception e){
			System.out.println("Not Connected:\t"+e);
		}
		
		return null;
	}
	public static boolean login(String username, String password) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM student WHERE StudentID='"+username+"'");
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				if(result.getString(3).equals(password)) {
					return true;
				}
				else
					return false;
			}
		}
		catch(Exception e) {System.out.println(e);}
		
		
		
		
		
		return false;
	}
	
}
