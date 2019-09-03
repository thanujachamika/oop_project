package com.nops.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static Connection con;
	public static Connection getDBConnection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nationalonlinepollingsystem", "root", "");
			
		}
		catch(Exception e) {
			System.out.println(e);;
		}
		
		return con;
	}
}
