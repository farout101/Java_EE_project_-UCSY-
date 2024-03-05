package com.cashnex.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.cashnex.dao.UserDao;
import com.cashnex.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserDashboardController
 */
public class UserDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected UserDao userDao;
    
    public UserDashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	userDao = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        
        // Retrieve user data from the database based on user ID
        User user = null;
		try {
			user = userDao.getUserById(userId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if (user != null) {
            // User data retrieved successfully, forward to dashboard with user data
            request.setAttribute("user", user);
            request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
        } else {
            // User data not found, handle error
            // You can redirect to an error page or display an error message
        }
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
