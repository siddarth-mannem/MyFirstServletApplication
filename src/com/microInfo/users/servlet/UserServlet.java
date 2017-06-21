package com.microInfo.users.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microInfo.users.model.User;
import com.microInfo.users.service.UserService;
import com.microInfo.users.service.UserServiceImpl;

@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("In UserServlet and doGet() method... ");
		
		UserService userService = new UserServiceImpl();
		List<User>  usersList = userService.fetchAllUsers();
		
		for(User user: usersList) {
			System.out.println(user.getUsername());
		}
		
		request.setAttribute("usersList", usersList);
		
		RequestDispatcher requestDipatcher = request.getRequestDispatcher("/WEB-INF/html/displayUsers.jsp");
		requestDipatcher.forward(request, resp);
		
	}


}
