package com.cashnex.model;

public class User {

	private int userId;
	private String username;
	private String nrcNumber;
	private String career;
	private String email;
	private String password;
	private Double balance;
	private String accountNumber;

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public int getId() {
		return this.userId;
	}

	public String getNrcNumber() {
		return nrcNumber;
	}

	public void setNrcNumber(String nrcNumber) {
		this.nrcNumber = nrcNumber;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
