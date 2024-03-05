package com.cashnex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionManager {
	
    static final String URL = "jdbc:mysql://localhost/bankingdb";
    static final String USER = "root";
    static final String PASSWORD = "Lucifer";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
