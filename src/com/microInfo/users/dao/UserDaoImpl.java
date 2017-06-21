package com.microInfo.users.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.microInfo.users.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class UserDaoImpl implements UserDao {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/microinfo_users?autoReconnect=true&useSSL=false";
	
	static Connection con;
	static Statement stmt;
	
	@Override
	public List<User> fetchUsers() {

		List<User> listOfUsers = new ArrayList<>(); // hashcode #7654
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
			String select_users = "SELECT * from user";

			stmt = (Statement) con.createStatement();
			ResultSet  resultsSet = stmt.executeQuery(select_users);
			
			User user;
			
			int count = 1;
			while (resultsSet.next()) {
				System.out.println("Username is: " + resultsSet.getString("username"));

				user = new User();
				user.setUserId(resultsSet.getInt("user_id"));
				user.setFirstName(resultsSet.getString("first_name"));
				user.setLastName(resultsSet.getString("last_name"));
				user.setUsername(resultsSet.getString("username"));
				
				Date date = resultsSet.getDate("create_date");
				if(date != null ) {
					user.setCreateDate(resultsSet.getDate("create_date"));

				System.out.println("Create Date is: " + date.toString());
				}
				
				if(resultsSet.getDate("updated_date") != null) {
					user.setUpdatedDate(resultsSet.getDate("updated_date"));
				}
				
				System.out.println("Count --- " + count);
				count ++;
				
				listOfUsers.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listOfUsers;
	}

}
