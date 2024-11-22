package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
 private static Connection connection;

	public static Connection getConnection() throws SQLException{
	 String url="jdbc:mysql://localhost:3306/lalit";
	 try {
		if(connection==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,"root","lalit");
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO: handle exception
		System.err.println("Error connecting to database: " + e.getMessage());
        throw new SQLException("Failed to connect to database.", e);
	}
	 return connection;
 }
}

