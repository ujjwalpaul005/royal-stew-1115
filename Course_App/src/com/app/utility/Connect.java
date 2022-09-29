package com.app.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	public static Connection getLink() {
		
		Connection myLink = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		String url = "mysql:jdbc://localhost:3306/app_data";
		
		try{
			myLink = DriverManager.getConnection(url, "root", "toor");
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return myLink;
	}

}
