//userlogin controller

package com.cashnex.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.cashnex.dao.UserDao;
import com.cashnex.model.User;
import com.cashnex.security.Security;
import com.cashnex.service.mail;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userLogin")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected UserDao userDao = null;

	/*
	 * public UserLoginController() { super(); // TODO Auto-generated constructor
	 * stub }
	 */

	@Override
	public void init() throws ServletException {

		super.init();
		userDao = new UserDao();
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");

			String userGmail = request.getParameter("userGmail");
			String userPassword = request.getParameter("userPassword");
			String hashedPassword = null;
			String decryptedPassword = null;
			
			int userId = 0;
			List<String> storedUserGmails = new ArrayList<>();
			List<String> storedUserPasswords = new ArrayList<>();
			List<String> decryptedPasswords = new ArrayList<>();

			// MD-5
			hashedPassword = Security.doHashing(userPassword);

			try {
				storedUserGmails = userDao.checkUserGmails();
				storedUserPasswords = userDao.checkPasswords();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * if ((storedUserGmails != null && storedUserPasswords != null) &&
			 * ((storedUserGmails.contains(userGmail) &&
			 * (storedUserPasswords.contains(hashedPassword))))) {
			 * 
			 * response.sendRedirect(request.getContextPath() + "/views/userDashboard.jsp");
			 * 
			 * } else { response.getWriter().append("Bad");
			 * response.getWriter().append(hashedPassword); }
			 */

			// Validate user credentials and retrieve user ID from the database
			try {
				userId = userDao.getUserIdByEmailAndPassword(userGmail, hashedPassword);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (userId != -1) {
				// User authenticated successfully, store user ID in session
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);

				// Redirect user to dashboard or account page
				response.sendRedirect(request.getContextPath() + "/views/userDashboard.jsp");
			} else {
				// Authentication failed, display error message to user
				request.setAttribute("errorMessage", "Invalid email or password");
				// request.getRequestDispatcher("/views/userLogin.jsp").forward(request,
				// response);
				response.getWriter().append("Access Denied");
			}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
