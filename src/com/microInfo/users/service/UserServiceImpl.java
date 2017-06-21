package com.microInfo.users.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.microInfo.users.dao.UserDao;
import com.microInfo.users.dao.UserDaoImpl;
import com.microInfo.users.model.User;

public class UserServiceImpl implements UserService {

	@Override
	public List<User> fetchAllUsers() {

		UserDao userDao = new UserDaoImpl();
		
								// # hashcode # 7653
		//List<User> usersList = new ArrayList<>();
		
		// stack memory			// Heap memory
		List<User> usersList =  userDao.fetchUsers();
		// userList ---> //7654 memory
		
		Collections.sort(usersList);
		
		return usersList;
	}

}
