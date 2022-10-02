package com.app.usecases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.app.dao.StudentDAO;
import com.app.daoIMPL.StudentArea;
import com.app.exceptions.CourseException;
import com.app.utility.Connect;

public class RegisterInACourse {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String msg = null;
		
		try {
			
			System.out.println("Enter Course Name: ");
			String name= sc.next();
			
			System.out.println("Enter Your Roll No: ");
			int roll = sc.nextInt();
			
			try(Connection mylink = Connect.getLink()){
				PreparedStatement ps = mylink.prepareStatement("select id from course where cname = ?");
				ps.setString(1, name);
				ResultSet res = ps.executeQuery();
				if(res.next()) {
					StudentDAO allocater = new StudentArea();
					try {
						msg = allocater.registerInACourse(roll, res.getInt("id"));
					} catch (CourseException e) {
						System.out.println(e.getMessage());
						System.out.println("Try Again");
						main(args);
					}
				}else {
					System.out.println("No course found with name " + name);
					System.out.println("Try Again");
					main(args);
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Try Again");
				main(args);
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Wrong Input type please try again.");
			main(args);
		}
		
		
		if(msg != null)
			System.out.println(msg);
		
	}
}
