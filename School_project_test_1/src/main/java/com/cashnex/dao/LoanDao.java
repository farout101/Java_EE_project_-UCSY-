package com.cashnex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cashnex.model.Loan;

public class LoanDao {

	public boolean insertLoan(String applicantName, String applicantEmail, double loanAmount, double interestRate,
			String startDate, String endDate) throws SQLException, ClassNotFoundException {

		Connection con = DBUtility.getConnection();

		String sql = "INSERT INTO LOAN_TABLE (applicant_name, applicant_email, loan_amount, interest_rate, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, applicantName);
		pstmt.setString(2, applicantEmail);
		pstmt.setDouble(3, loanAmount);
		pstmt.setDouble(4, interestRate);
		pstmt.setString(5, startDate);
		pstmt.setString(6, endDate);

		int rowsAffected = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return rowsAffected > 0;
	}

	public List<Loan> getAllLoans() throws SQLException, ClassNotFoundException {

		List<Loan> loanApp = new ArrayList<>();

		Connection con = DBUtility.getConnection();

		String sql = "SELECT * FROM loan_applications";

		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			
			Loan loan = new Loan();
			loan.setLoanId(rs.getInt("loan_id"));
			loan.setApplicantName(rs.getString("applicant_name"));
			loan.setApplicantEmail(rs.getString("applicant_email"));
			loan.setLoanAmount(rs.getDouble("loan_amount"));
			loan.setInterestRate(rs.getDouble("interest_rate"));
			loan.setApplicationDate(LocalDate.parse(rs.getString("application_date")));
			loan.setStartDate(LocalDate.parse(rs.getString("start_date")));
			loan.setEndDate(LocalDate.parse(rs.getString("end_date")));
			loanApp.add(loan);
		}

		rs.close();
		pstmt.close();
		con.close();

		return loanApp;
	}

	public boolean processLoanApplication(String applicantName, String applicantEmail, double loanAmount)
			throws SQLException, ClassNotFoundException {

		// Calculate interest rate and set start and end dates
		double interestRate = calculateInterestRate(loanAmount);
		LocalDate startDate = LocalDate.now();
		LocalDate endDate = startDate.plusMonths(6); // Example: Loan duration of 6 months

		// Insert the loan application into the database
		return insertLoan(applicantName, applicantEmail, loanAmount, interestRate, startDate.toString(),
				endDate.toString());
	}

	private double calculateInterestRate(double loanAmount) {
		// Example calculation: 5% interest rate for loans below 1000, 7% for loans
		// between 1000 and 5000
		if (loanAmount < 1000) {
			return 0.05;
		} else if (loanAmount >= 1000 && loanAmount < 5000) {
			return 0.07;
		} else {
			return 0.1; // Default interest rate for higher loan amounts
		}
	}

}