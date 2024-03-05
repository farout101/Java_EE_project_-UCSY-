package com.cashnex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class balanceTransferDao {

	public double getUserBalance(String username) throws SQLException, ClassNotFoundException {
	    double balance = 0.0;
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	      con = DBUtility.getConnection();

	      String sql = "SELECT balance FROM userTable WHERE username = ?";
	      pstmt = con.prepareStatement(sql);
	      pstmt.setString(1, username);

	      rs = pstmt.executeQuery();

	      if (rs.next()) {
	        balance = rs.getDouble("balance");
	      }
	    } finally {
	      
	      if (rs != null) {
	        rs.close();
	      }
	      if (pstmt != null) {
	        pstmt.close();
	      }
	      if (con != null) {
	        con.close();
	      }
	    }

	    return balance;
	  }

	  // Method to update user balance in the database
	  public void updateBalance(String username, double newBalance) throws SQLException, ClassNotFoundException {
	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	      
	      con = DBUtility.getConnection();

	      String sql = "UPDATE userTable SET balance = ? WHERE username = ?";
	      pstmt = con.prepareStatement(sql);
	      pstmt.setDouble(1, newBalance);
	      pstmt.setString(2, username);

	      int rowsAffected = pstmt.executeUpdate();
	      
	   // Check if any rows were affected by the update operation
	      if (rowsAffected > 0) {
	        System.out.println("Balance updated successfully for user: " + username);
	      } else {
	        System.out.println("No user found with username: " + username);
	      }
	    } finally {

	      if (pstmt != null) {
	        pstmt.close();
	      }
	      if (con != null) {
	        con.close();
	      }
	    }
	  }
}
