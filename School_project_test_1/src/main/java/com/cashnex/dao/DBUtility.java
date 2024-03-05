package com.cashnex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {

    private static final String URL = "jdbc:mysql://localhost/bankingdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver"); 

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
