package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DB.DBConnection;
import com.Entity.User;

@WebServlet("/servlet1")
public class servlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		
		String name=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		User us=new User();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		
		UserDAO dao=new  UserDAO(DBConnection.getConnection());
		boolean f=dao.userRegister(us);
		
		if(true)
		{

			HttpSession session=request.getSession();
			session.setAttribute("reg-msg", "Registration Successfully");
			response.sendRedirect("register.jsp");

		}
		else
		{

			HttpSession session=request.getSession();
			session.setAttribute("error-msg", "Something wents wrong on server");
			response.sendRedirect("register.jsp");
		}
	}

}
