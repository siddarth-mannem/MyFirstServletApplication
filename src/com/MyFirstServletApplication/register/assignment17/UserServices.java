package com.MyFirstServletApplication.register.assignment17;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserServices {
	
	private static final String url = "jdbc:mysql://localhost:3306/microinfo_users";
	private static final String username  = "root";
	private static final String password = "root";
	
	public static int createUser(User user) throws SQLException, ClassNotFoundException{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		//Connecting to Database
		Connection conn = (Connection) DriverManager.getConnection(url, username, password);
		
		//Query
		String sql = "INSERT INTO user(first_name,last_name,username,password) VALUES(?, ?, ?, ?)";
		
		//PreparedStatement
		PreparedStatement stmnt = (PreparedStatement) conn.prepareStatement(sql);
        
		stmnt.setString(1, user.getFirstName());
		stmnt.setString(2, user.getLastName());
		stmnt.setString(3, user.getUserName());
		stmnt.setString(4, user.getPassword());
		
		int id = stmnt.executeUpdate();
		
		return id;
		

     }
}
