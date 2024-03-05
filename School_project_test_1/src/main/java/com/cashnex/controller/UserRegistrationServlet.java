package com.cashnex.controller;

import java.io.IOException;
import java.util.Random;

import javax.mail.MessagingException;

import com.cashnex.dao.UserDao;
import com.cashnex.security.Security;
import com.cashnex.service.AccountNumberGenerator;
import com.cashnex.service.mail;
import com.cashnex.dao.pending_user;
import com.cashnex.model.UserRegistration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserRegistration")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserDao userDao;

	public UserRegistrationServlet() {
		super();
		userDao = new UserDao();
	}

	 public static String generateOTP(int length) {
	        // Define characters allowed in the OTP code
	        String chars = "0123456789";
	        // Initialize a random object
	        Random random = new Random();
	        // Initialize a StringBuilder to store the OTP code
	        StringBuilder otp = new StringBuilder();

	        // Generate the OTP code by randomly selecting characters from the 'chars' string
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(chars.length());
	            otp.append(chars.charAt(index));
	        }

	        // Return the OTP code as a string
	        return otp.toString();
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/views/userRegistration.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String userName = request.getParameter("username");
	    String nrcNumber = request.getParameter("nrcNumber");
	    String userGmail = request.getParameter("userGmail");
	    String career = request.getParameter("career");
	    String userPassword = request.getParameter("userPassword");
	    
	    String hashedPassword = Security.doHashing(userPassword);
	    String accountNumber = AccountNumberGenerator.generateAccountNumber();
	    
	    pending_user storeUser = new pending_user();
	    UserRegistration ur = new UserRegistration();
	    
	    try {
	        
	        String verificationToken = generateOTP(6);
	        
	        storeUser.deletePendingUser();
	        
	        ur.setUsername(userName);
	        ur.setNrcNumber(nrcNumber);
	        ur.setUserEmail(userGmail);
	        ur.setCareer(career);
	        ur.setHashedPassword(hashedPassword);
	        ur.setAccountNumber(accountNumber);
	        ur.setOtp(verificationToken);
	        
	        storeUser.addUserRegistration(ur);
	        
	        String content = "<div style=\"max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ccc; border-radius: 10px;\">" +
	                        "<h1 style=\"color: #333;\">Hello!</h1>" +
	                        "<h5 style=\"color: #555;\">Welcome to CashNex.com</h5>" +
	                        "<p style=\"color: #555;\"> User Name         :  "+ userName + "</p>" +
	                        "<p style=\"color: #555;\"> Verification code :  "+ verificationToken + "</p>" +
	                        "<p style=\"color: #555;\">Thank you!</p>" +
	                        "</div>";

	        mail.sendEmail(userGmail, "Email Verification", content);
	        
	        request.getRequestDispatcher("/views/OTP.jsp").forward(request, response);
	    } catch (MessagingException e) {
	        e.printStackTrace();
	        // If an error occurs, handle it accordingly
	        // You may want to redirect the user to an error page
	        response.sendRedirect(request.getContextPath() + "/error.jsp");
	    }
	}

}