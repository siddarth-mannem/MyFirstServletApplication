package com.microInfo.users.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("In FirstServlet, and in goGet method *** ");
		System.out.println("Local Adress: " + request.getLocalAddr());
		System.out.println("URI:  " + request.getRequestURL().toString());
		System.out.println("PORT Number: " + request.getLocalPort());
		/*String nextJSP = "/home.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(req,resp);*/
		
		//resp.getWriter().println("Hello friend!");
		//resp.sendRedirect("/jsps/success.jsp");
		
		RequestDispatcher requestDipatcher = request.getRequestDispatcher("/WEB-INF/html/home.jsp");
		requestDipatcher.forward(request, resp);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println("Enter VAlues**: " + userName  + " & password: " + password);
		
		if (userName == null || userName.trim().equals("") ) {
			RequestDispatcher requestDipatcher = request.getRequestDispatcher("/WEB-INF/html/home.jsp");
			request.setAttribute("userNameErr", "Please Enter a valid username... ");
			requestDipatcher.forward(request, resp);
		}
		if (password == null || password.equals("") || password.length() < 8 ) {
			RequestDispatcher requestDipatcher = request.getRequestDispatcher("/WEB-INF/html/home.jsp");
			request.setAttribute("passwordErr", "Please Enter a valid Password... ");
			requestDipatcher.forward(request, resp);
		}
		
		RequestDispatcher requestDipatcher = request.getRequestDispatcher("/WEB-INF/html/success.jsp");
		requestDipatcher.forward(request, resp);		
	}

}
