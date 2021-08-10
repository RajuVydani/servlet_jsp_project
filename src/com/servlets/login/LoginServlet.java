package com.servlets.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlets.dao.UserDAO;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String username = request.getParameter("userName");  
	    String password = request.getParameter("userPass");
	    
	    UserDAO userDAO = new UserDAO();
	    String retrievedPassword = userDAO.getUserCredentials(username);
	          
	    if(password.equals(retrievedPassword)){  
	        RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
	        rd.forward(request, response);  
	    }  
	    else{  
	        out.print("Sorry UserName or Password Error!");  
	        RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
	        rd.include(request, response);  
	                      
	        }  
	    }
}
