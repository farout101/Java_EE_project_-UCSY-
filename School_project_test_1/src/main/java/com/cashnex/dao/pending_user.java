package com.cashnex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cashnex.model.UserRegistration;

public class pending_user {
	private Connection connection;

	public pending_user() {
		try {
			connection = DBUtility.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method to insert user registration data into the database
	public void addUserRegistration(UserRegistration userRegistration) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO pending_user(username, nrc_number, user_email, career, hashed_password, account_number, otp) VALUES (?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, userRegistration.getUsername());
			preparedStatement.setString(2, userRegistration.getNrcNumber());
			preparedStatement.setString(3, userRegistration.getUserEmail());
			preparedStatement.setString(4, userRegistration.getCareer());
			preparedStatement.setString(5, userRegistration.getHashedPassword());
			preparedStatement.setString(6, userRegistration.getAccountNumber());
			preparedStatement.setString(7, userRegistration.getOtp());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Method to retrieve all user registration data from the database
	public List<UserRegistration> getAllUserRegistrations() {
		List<UserRegistration> userRegistrations = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pending_user");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				UserRegistration userRegistration = new UserRegistration();
				userRegistration.setId(rs.getInt("id"));
				userRegistration.setUsername(rs.getString("username"));
				userRegistration.setNrcNumber(rs.getString("nrc_number"));
				userRegistration.setUserEmail(rs.getString("user_email"));
				userRegistration.setCareer(rs.getString("career"));
				userRegistration.setHashedPassword(rs.getString("hashed_password"));
				userRegistration.setAccountNumber(rs.getString("account_number"));
				userRegistration.setOtp(rs.getString("otp"));
				userRegistrations.add(userRegistration);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userRegistrations;
	}

	public UserRegistration getFirstUser() {
		UserRegistration userRegistration = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pending_user LIMIT 1");
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				userRegistration = new UserRegistration();
				userRegistration.setId(rs.getInt("id"));
				userRegistration.setUsername(rs.getString("username"));
				userRegistration.setNrcNumber(rs.getString("nrc_number"));
				userRegistration.setUserEmail(rs.getString("user_email"));
				userRegistration.setCareer(rs.getString("career"));
				userRegistration.setHashedPassword(rs.getString("hashed_password"));
				userRegistration.setAccountNumber(rs.getString("account_number"));
				userRegistration.setOtp(rs.getString("otp"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userRegistration;
	}

	public void deletePendingUser() {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM pending_user");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
