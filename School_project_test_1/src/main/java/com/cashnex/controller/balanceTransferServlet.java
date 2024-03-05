package com.cashnex.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cashnex.dao.DBUtility;
import com.cashnex.dao.balanceTransferDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/transfer")
public class balanceTransferServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	balanceTransferDao balanceTransferDao;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		balanceTransferDao = new balanceTransferDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String senderUsername = (String) request.getSession().getAttribute("username");
		String recipientUsername = request.getParameter("recipientUsername");
		double amount = Double.parseDouble(request.getParameter("amount"));

		// Retrieve user balances from the database
		double senderBalance = 0;
		try {
			senderBalance = balanceTransferDao.getUserBalance(senderUsername);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double recipientBalance = 0;
		try {
			recipientBalance = balanceTransferDao.getUserBalance(recipientUsername);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		// Check if sender has sufficient balance
		if (senderBalance >= amount) {
			// Update balances in the database
			try {
				balanceTransferDao.updateBalance(senderUsername, senderBalance - amount);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			try {
				balanceTransferDao.updateBalance(recipientUsername, recipientBalance + amount);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			response.getWriter().println("Transfer successful!");
		} else {
			response.getWriter().println("Insufficient balance!");
		}
	}

	// Just a Test
	// Method to retrieve user balance from the database

}

//TransferServlet