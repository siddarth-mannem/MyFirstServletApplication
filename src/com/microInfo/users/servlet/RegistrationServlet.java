package com.microInfo.users.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String uName = request.getParameter("uname");
		String password = request.getParameter("pass");
		String security_key = request.getParameter("security_key");
		
		if(password.length()<8){
			RequestDispatcher requestDipatcher = request.getRequestDispatcher("register.jsp");
			request.setAttribute("passwordErr", "Please Enter a valid password...(Not less than 8) ");
			requestDipatcher.forward(request, response);
			
		}
		else{
		
		User user = new User(fName, lName, uName, password, security_key);
		
AddUserService newUser = new AddUserService();
		
        int id=0;
        
		try {
			id = newUser.createUser(user);
			System.out.println(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(id==1){
			RequestDispatcher requestDipatcher = request.getRequestDispatcher("success.jsp");
			requestDipatcher.forward(request, response);
		}
		else{
			RequestDispatcher requestDipatcher = request.getRequestDispatcher("register.jsp");
			request.setAttribute("error", "Something is wrong");
			requestDipatcher.forward(request, response);
		}
		
	}
	}

}
