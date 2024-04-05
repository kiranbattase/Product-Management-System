package com.sathya.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ProductDB {
	
	public static Connection dbconnect() {
		
		Connection connection = null;
		
		try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		connection = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe" , "kiran" , "welcome");
		}
		catch(ClassNotFoundException | SQLException cs) {
			cs.printStackTrace();
		}
		return connection;
	}
}