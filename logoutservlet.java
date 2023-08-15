package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutservlet1")
public class logoutservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session=request.getSession();
		session.removeAttribute("user-obj");
		
		HttpSession session2=request.getSession();
		session.setAttribute("logout-msg", "Logout Successfull");
	
		response.sendRedirect("login.jsp");
	
	}

}
