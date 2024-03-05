//userlogin controller

package com.cashnex.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;

import com.cashnex.dao.UserDao;
import com.cashnex.dao.pending_user;
import com.cashnex.model.User;
import com.cashnex.model.UserRegistration;
import com.cashnex.service.mail;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/passwordRecovery")
public class passwordRecovery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected UserDao userDao = null;
	protected pending_user p_user = null;
	protected UserRegistration ur = null;
	/*
	 * public UserLoginController() { super(); // TODO Auto-generated constructor
	 * stub }
	 */

	@Override
	public void init() throws ServletException {

		super.init();
		userDao = new UserDao();
		p_user = new pending_user();
		ur = new UserRegistration();
	}

	public static String generateOTP(int length) {
		// Define characters allowed in the OTP code
		String chars = "0123456789";
		// Initialize a random object
		Random random = new Random();
		// Initialize a StringBuilder to store the OTP code
		StringBuilder otp = new StringBuilder();

		// Generate the OTP code by randomly selecting characters from the 'chars'
		// string
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(chars.length());
			otp.append(chars.charAt(index));
		}

		// Return the OTP code as a string
		return otp.toString();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		System.out.println(action);
		
		if ("recovery".equals(action)) {

			System.out.println("Loading for the mail...");
			
			String recoveryGmail = request.getParameter("recoveryGmail");
			boolean emailFound = false;

			List<String> storedUserGmails = new ArrayList<>();

			try {
				storedUserGmails = userDao.checkUserGmails();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (String userEmail : storedUserGmails) {
				if (userEmail.equals(recoveryGmail)) {

					String OTP = generateOTP(10);

					String content = "<div style=\"max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ccc; border-radius: 10px;\">"
							+ "<h3 style=\"color: #333;\">Welcome to CashNex.com</h3>"
							+ "<h5 style=\"color: #555;\">Password Reset</h5>"
							+ "<p style=\"color: #555;\"> User Email         :  " + recoveryGmail + "</p>"
							+ "<p style=\"color: #555;\"> Verification code :  " + OTP + "</p>"
							+ "<p style=\"color: #555;\">Thank you!</p>" + "</div>";

					try {
						mail.sendEmail(recoveryGmail, "Cashnex.com.passwordRecovery", content);
						
						System.out.println("Mail has sent to the user");
						
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					p_user.deletePendingUser();

					try {
						User user = userDao.getUserByGmail(recoveryGmail);

						ur.setAccountNumber(user.getAccountNumber());
						ur.setCareer(user.getCareer());
						ur.setHashedPassword(user.getPassword());
						ur.setOtp(OTP);
						ur.setUserEmail(user.getEmail());
						ur.setNrcNumber(user.getNrcNumber());
						ur.setUsername(user.getUsername());

					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					p_user.addUserRegistration(ur);

					emailFound = true;
					break;
				}
			}

			if (emailFound) {
				// Redirect if recovery email was found
				response.sendRedirect(request.getContextPath() + "/views/passwordRecovery.jsp?emailError=false");
			} else {
				// Redirect with error message if recovery email was not found
				response.sendRedirect(request.getContextPath() + "/views/passwordRecovery.jsp?emailError=true");
			}
		} else {

			String userName = ur.getUsername();
			String nrcNumber = ur.getNrcNumber();
			String userGmail = ur.getUserEmail();
			String career = ur.getCareer();
			String hashedPassword = ur.getHashedPassword();
			String accountNumber = ur.getAccountNumber();
			String dbOTP = ur.getOtp();

			String OTP = request.getParameter("otp");

			if (dbOTP.equals(OTP)) {
				response.sendRedirect(request.getContextPath() + "/views/resetPassword.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + "/views/passwordRecovery.jsp?otpError=true");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
