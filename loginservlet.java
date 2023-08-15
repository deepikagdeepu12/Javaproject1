package com.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DB.DBConnection;
import com.Entity.User;


@WebServlet("/loginservlet1")
public class loginservlet extends HttpServlet {
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String em=request.getParameter("email");
		String ps=request.getParameter("password");
		
		UserDAO dao=new UserDAO(DBConnection.getConnection());
		User user=dao.getLogin(em, ps);
		
		if(user!=null)
		{
//			PrintWriter out=response.getWriter();
//		out.print("Login Successfully");
		
		HttpSession session=request.getSession();
			session.setAttribute("user-obj", user);
			
			response.sendRedirect("home.jsp");
//			
			
		}
		else
		{
			
//		PrintWriter out=response.getWriter();
//		out.print("invalid email and password");
			
			HttpSession session=request.getSession();
			session.setAttribute("error-msg", "Invalid email and password");
			
			response.sendRedirect("login.jsp");
			
			
		}
	}

}
