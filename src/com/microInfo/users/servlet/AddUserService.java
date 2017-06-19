package com.microInfo.users.servlet;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AddUserService {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/microinfo_users";
	
	public int createUser(User user) throws ClassNotFoundException {
		
		// Create DB connection
		// Create INSERT query
		// Create Prepared STatemnt
		//  Insert values in to Prepared Statement object dynamically from user object.
		// Ex: prepStmt.setString(2, user.getLastName());
		// Insert Date in to DB
		
		// return created ID
		
      Class.forName("com.mysql.jdbc.Driver");
		
		int id=0;
		
		
				
		try {
			Connection conn = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
			
			String insert_query = "INSERT INTO user (first_name, last_name, username, password, "
					+ " security_key)" +
			        " VALUES (?, ?, ?, ?, ?)";
			PreparedStatement prepStmnt = (PreparedStatement) conn.prepareStatement(insert_query);
			
			prepStmnt.setString(1, user.getFirstName());
			prepStmnt.setString(2, user.getLastName());
			prepStmnt.setString(3, user.getUsername());
			prepStmnt.setString(4, user.getPassword());
			prepStmnt.setString(5, user.getSecurityKey());
			
			
			id = prepStmnt.executeUpdate();
			
			
		}
		catch (Exception e){
		e.printStackTrace();
		}			

		return id;

	}
	
}
