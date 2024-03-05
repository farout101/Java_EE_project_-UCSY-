package com.cashnex.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.cashnex.dao.UserDao;
import com.cashnex.dao.pending_user;
import com.cashnex.model.UserRegistration;
import com.cashnex.security.Security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class resetPassword
 */
public class resetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserRegistration ur = null;
	pending_user p_user = null;
	UserDao duser = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetPassword() {
        super();
        ur = new UserRegistration();
        p_user = new pending_user();
        duser = new UserDao();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get session object
		
		String pass1 = request.getParameter("userPassword1");
		String pass2 = request.getParameter("userPassword2");
		
		System.out.println("Pass 1 : " + pass1 + " and Pass 2 " + pass2);
		
		if(pass1.equals(pass2)) {
			
			ur =  p_user.getFirstUser();
			
			String userName = ur.getUsername();
			String nrcNumber = ur.getNrcNumber();
			String userGmail = ur.getUserEmail();
			String career = ur.getCareer();
			String hashedPassword = ur.getHashedPassword();
			String accountNumber = ur.getAccountNumber();
			
			System.out.println("Obtained the user");
			
			try {
				String new_pass = Security.doHashing(pass2);
				
				p_user.deletePendingUser();
				
				System.out.println("Deleted the temp data");
				
				boolean complete = duser.changePassword(userGmail, hashedPassword);
				
				if(complete) {
					response.sendRedirect(request.getContextPath() + "/views/success.jsp");
					System.out.println("updated the user Data");
				} else {
					response.sendRedirect(request.getContextPath() + "/views/resetPassword.jsp?resetError=true");
					System.out.println("Cannot update");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			response.sendRedirect(request.getContextPath() + "/views/resetPassword.jsp?passError=true");
		}
		
		
		
	}

}
