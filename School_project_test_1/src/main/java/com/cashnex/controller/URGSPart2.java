package com.cashnex.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.cashnex.dao.UserDao;
import com.cashnex.dao.pending_user;
import com.cashnex.model.UserRegistration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/URGSPart2")

public class URGSPart2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get session object

		String inpOTP = request.getParameter("OTP");


		pending_user storeUser = new pending_user();

		UserRegistration firstUserRegistration = storeUser.getFirstUser();

		String userName = firstUserRegistration.getUsername();
		String nrcNumber = firstUserRegistration.getNrcNumber();
		String userGmail = firstUserRegistration.getUserEmail();
		String career = firstUserRegistration.getCareer();
		String hashedPassword = firstUserRegistration.getHashedPassword();
		String accountNumber = firstUserRegistration.getAccountNumber();
		String OTP = firstUserRegistration.getOtp();

		UserDao userDao = new UserDao(); // Assuming you have a UserDao class

		if (OTP.equals(inpOTP)) {
			try {
				userDao.insertUserData(userName, nrcNumber, userGmail, career, hashedPassword, accountNumber);
				response.sendRedirect(request.getContextPath() + "/views/userRegistration.jsp");
				
				storeUser.deletePendingUser();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace(); // Handle exception appropriately
				// You may want to redirect the user to an error page
				response.sendRedirect(request.getContextPath() + "/error.jsp");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/views/OTP.jsp?otpError=true");

		}
	}
}
