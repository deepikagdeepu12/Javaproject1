package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Entity.*;
import com.mysql.cj.protocol.Resultset;

public class UserDAO {
	private Connection con = null;

	public UserDAO(Connection con) {
		super();
		this.con = con;
	}

	public boolean userRegister(User us) {
		boolean f = false;

		try {

			String query = "insert into us(name,email,password) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPassword());

			ps.executeUpdate();
			f = true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return f;

	}

	
	
	public User getLogin(String em, String ps)
	{
		User us=null;
		try {
			
			String query1 = "select * from us where email=? and password=?";
			PreparedStatement pst = con.prepareStatement(query1);
			pst.setString(1, em);
			pst.setString(2, ps);

			ResultSet res = pst.executeQuery();

			if (res.next()) {
				us = new User( res.getString(1), res.getString(2),res.getString(3),res.getInt(4));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;
	}

}
