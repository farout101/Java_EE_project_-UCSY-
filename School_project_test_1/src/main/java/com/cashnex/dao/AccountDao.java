package com.cashnex.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {

	 public List<String> checkUsername() throws ClassNotFoundException, SQLException {
	      List<String> usernames = new ArrayList<>();
	      
	      Connection con = DBUtility.getConnection();
	      
	      Statement stmt = con.createStatement();
	      ResultSet rs = stmt.executeQuery("SELECT userName from userTable");
	      
	      while(rs.next()) {
	          String username = rs.getString("userName");
	          usernames.add(username);
	      }
	      
	      // Close resources
	      rs.close();
	      stmt.close();
	      con.close();
	      
	      return usernames;
	  }

	  public List<String> checkUserPassword() throws ClassNotFoundException, SQLException {
		  
	      List<String> passwords = new ArrayList<>();
	      
	      Connection con = DBUtility.getConnection();
	      
	      Statement stmt = con.createStatement();
	      ResultSet rs = stmt.executeQuery("SELECT password from userTable");
	      
	      while(rs.next()) {
	          String password = rs.getString("password");
	          passwords.add(password);
	      }
	      
	      // Close resources
	      rs.close();
	      stmt.close();
	      con.close();
	      
	      return passwords;
	  }
}
