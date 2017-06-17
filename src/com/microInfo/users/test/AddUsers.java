package com.microInfo.users.test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class AddUsers {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/microinfo_users";
	
	static Connection con;
	static Statement stmt;
	static PreparedStatement prepStmt;
	
	public static void main(String[] args) {

		Date date = Calendar.getInstance().getTime();
		System.out.println("Current DAte: " + date.toString());
		try {
			con = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
			
			String insert_query = "INSERT INTO user (first_name, last_name, username, password, "
					+ " security_key, create_date, updated_date)" +
			        " VALUES (?, ?, ?, ?, ?, ?, ?)";
			System.out.println("Query:  " + insert_query);
			
			prepStmt = (PreparedStatement) con.prepareStatement(insert_query);
			
			prepStmt.setString(1, "Banner");
			prepStmt.setString(2, "Bruice");
			prepStmt.setString(3, "bruice_banner2");
			prepStmt.setString(4, "3333333333333");
			prepStmt.setString(5, "8888");
			prepStmt.setDate(6, new java.sql.Date(date.getTime()));
			prepStmt.setDate(7, new java.sql.Date(date.getTime()));
			
			
			int id = prepStmt.executeUpdate();
			
			System.out.println("ID: " + id);
			
			//prepStmt.setS
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}

}
