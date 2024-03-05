package com.cashnex.model;

import java.time.LocalDate;

public class Loan {
	private int loanId;
	private String applicantName;
	private String applicantEmail;
	private double loanAmount;
	private double interestRate;
	private LocalDate applicationDate;
	private LocalDate startDate;
	private LocalDate endDate;

	public Loan() {
	}

	public Loan(int loanId, String applicantName, String applicantEmail, double loanAmount, double interestRate,
			LocalDate applicationDate, LocalDate startDate, LocalDate endDate) {
		this.loanId = loanId;
		this.applicantName = applicantName;
		this.applicantEmail = applicantEmail;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.applicationDate = applicationDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantEmail() {
		return applicantEmail;
	}

	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}

// UPDATED LOAN STRUCTURE