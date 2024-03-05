package com.cashnex.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userToDatabase")
public class UserToDatabaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the values of userName and nrcNumber from the request parameters
        String userName = request.getParameter("userName");
        String nrcNumber = request.getParameter("nrcNumber");

        // Redirect the user to a confirmation page or any other appropriate page
//        response.sendRedirect("registrationSuccess.jsp");
        response.getWriter().append("Hello" + userName + nrcNumber);
        System.out.println("Received userName: " + userName);
        System.out.println("Received nrcNumber: " + nrcNumber);
    }
}
