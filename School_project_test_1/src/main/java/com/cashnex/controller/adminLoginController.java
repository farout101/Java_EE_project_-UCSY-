package com.cashnex.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.cashnex.dao.AdminDao;
import com.cashnex.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminController
 */
@WebServlet("/adminLogin")
public class adminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  public AdminDao adminDao; // Declare AdminDao variable
	  public UserDao userDao; // Declare UserDao variable
	    
	    // Initialize AdminDao instance in servlet's init() method
	    @Override
	    public void init() throws ServletException {
	        super.init();
	        adminDao = new AdminDao(); // Initialize AdminDao
	        userDao = new UserDao();
	    }
	
//    public adminController() {
//        super();
//        this.adminDao = new AdminDao(ConnectionManager.getInstance());
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        String adminUsername = request.getParameter("adminUsername");
        String adminPassword = request.getParameter("adminPassword");
        String storedAdminUsername = null;
        String storedAdminPassword = null;
        
		try {
			storedAdminUsername = adminDao.checkAdminUsername();
			storedAdminPassword = adminDao.checkAdminPassword();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        if ((storedAdminUsername != null && storedAdminUsername.equals(adminUsername)) && 
        		(storedAdminPassword != null && storedAdminPassword.equals(adminPassword))) {
        	
        	request.setAttribute("test", 1);
            //request.getRequestDispatcher("adminDashboardController").forward(request, response);
        	response.sendRedirect(request.getContextPath() + "/adminDashboardController");

        } else {
            response.getWriter().append("Access Denied");
        }
        
     // Retrieve attributes set in the previous request
		/*
		 * String userName = (String) request.getAttribute("userName"); String nrcNumber
		 * = (String) request.getAttribute("nrcNumber"); String userGmail = (String)
		 * request.getAttribute("userGmail"); String career = (String)
		 * request.getAttribute("career"); String userPassword = (String)
		 * request.getAttribute("userPassword"); Float userBalance = (float)
		 * request.getAttribute("userBalance");
		 * 
		 * int test = (int) request.getAttribute("test");
		 * 
		 * String numberInput = request.getParameter("numberInput"); //from
		 * adminDashboard -- Balance amount
		 * 
		 * if (test == 1) { // Logic to handle approval or denial of user registration
		 * if (request.getParameter("approveBtn") != null) { // Handle approval if
		 * (userName != null && nrcNumber != null && userGmail != null && career != null
		 * && userPassword != null && userBalance != null) {
		 * 
		 * try { userDao.insertUserData(userName, nrcNumber, userGmail, career ,
		 * userPassword); } catch (ClassNotFoundException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * response.getWriter().append("User data inserted successfully"); } else {
		 * response.getWriter().append("Incomplete user data"); } } else if
		 * (request.getParameter("denyBtn") != null) { // Handle denial // You can add
		 * logic here if needed response.getWriter().append("User registration denied");
		 * } }
		 */
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
