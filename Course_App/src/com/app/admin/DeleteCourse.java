package com.app.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.app.dao.AdminDAO;
import com.app.daoIMPL.AdminArea;
import com.app.exceptions.CourseException;
import com.app.utility.Connect;

public class DeleteCourse {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String msg = null;
		int id;
		
		try {
			
			System.out.println("Enter name of the training_session:");
			String session = sc.next();
			
			System.out.println("Enter name of the course:");
			String name = sc.next();
			
			try(Connection myLink = Connect.getLink()){
				
				PreparedStatement ps = myLink.prepareStatement("select id from course where cname = ? AND training_session = ?");
				ps.setString(1, name);
				ps.setString(2, session);
				
				ResultSet res = ps.executeQuery();
				if(res.next()) {
					id = res.getInt("id");
					
					PreparedStatement ps2 = myLink.prepareStatement("delete from batch where cid = ?");
					ps2.setInt(1, id);
					int res2 = ps2.executeUpdate();
					
					
					AdminDAO admin = new AdminArea();
					
					try {
						msg = admin.deleteCourse(id);
						System.out.println(msg);
					} catch (CourseException e) {
						System.out.println(e.getMessage());
						System.out.println("Try Again.");
					}
				}else {
					System.out.println("No course found with this name " + name + " in session " + session + " !");
					System.out.println("Try Again.");
				}
				
				
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
			}
			
			
			
		} catch (InputMismatchException e) {
			System.out.println("Wrong Input type please try again.");
			main(args);
		}
		
		
		if(msg != null)
			System.out.println(msg);
		
	

	}

}
