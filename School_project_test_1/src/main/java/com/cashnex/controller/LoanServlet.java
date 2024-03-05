package com.cashnex.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cashnex.dao.LoanDao;
import com.cashnex.model.Loan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loan")
public class LoanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private LoanDao loanDao;

    @Override
    public void init() throws ServletException {
        super.init();
        loanDao = new LoanDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve all loan applications from the database
            List<Loan> loanApplications = loanDao.getAllLoans();

            // Set the loan applications as request attribute
            request.setAttribute("loanApplications", loanApplications);

            // Forward the request to the loan applications view
            request.getRequestDispatcher("loanApplications.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred while retrieving loan applications.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get loan application data from request parameters
        String applicantName = request.getParameter("applicantName");
        String applicantEmail = request.getParameter("applicantEmail");
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));

        try {
            // Process loan application
            boolean applicationApproved = loanDao.processLoanApplication(applicantName, applicantEmail, loanAmount);

            if (applicationApproved) {
                // If loan application is approved
                response.getWriter().println("Congratulations! Your loan application has been approved.");
            } else {
                // If loan application is rejected
                response.getWriter().println("Sorry, your loan application has been rejected.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Handle database errors or class loading errors
            e.printStackTrace();
            response.getWriter().println("An error occurred while processing your loan application.");
        }
    }
}
