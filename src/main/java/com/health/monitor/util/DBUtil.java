package com.health.monitor.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection connection;

	private static String jdbcUrl = "jdbc:mysql://virtual-healthcare-assistant.c7uqpxjx0w5i.us-east-2.rds.amazonaws.com/temp";
	private static String username = "admin";
	private static String password = "admin123";

	public static Connection getDBConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(jdbcUrl, username, password);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		
		return connection;
	}

	public static void closeDBConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
