package com.microInfo.users.dao;

import java.util.List;

import com.microInfo.users.model.User;

public interface UserDao {

	public List<User> fetchUsers();
}
