package com.cashnex.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao {

	public String checkAdminUsername() throws ClassNotFoundException, SQLException {
		
		Connection con = DBUtility.getConnection(); 
		
		Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery("select * from adminTable"); 
		
		String userName = null;
		while (rs.next()) {
			userName = rs.getString("userName");
		}

		stmt.close(); 
		con.close(); 
		return userName;
	}
	public String checkAdminPassword() throws ClassNotFoundException, SQLException {
		
		Connection con = DBUtility.getConnection(); 
		
		Statement stmt = con.createStatement(); 
		ResultSet rs = stmt.executeQuery("select * from adminTable"); 
		
		String adminPassword = null;
		while (rs.next()) {
			adminPassword = rs.getString("password");
		}
		
		stmt.close(); 
		con.close(); 
		return adminPassword;
	}
}
