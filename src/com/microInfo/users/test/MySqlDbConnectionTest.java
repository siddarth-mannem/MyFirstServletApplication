package com.microInfo.users.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class MySqlDbConnectionTest {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/microinfo_users";
	
	static Connection con;
	static Statement stmt;
	
	public static void main(String[] args) {

		// Select * from users;
		try {
			con = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
			String select_users = "SELECT * from user";

			stmt = (Statement) con.createStatement();
			ResultSet  resultsSet = stmt.executeQuery(select_users);
			
			int count = 1;
			while (resultsSet.next()) {
				System.out.println("FirtName is: " + resultsSet.getString("first_name"));
				System.out.println("Username is: " + resultsSet.getString("username"));
				Date date = resultsSet.getDate("create_date");
				if(date != null )
				System.out.println("Create Date is: " + date.toString());
				
				System.out.println("Count --- " + count);
				count ++;
				
				// null
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
