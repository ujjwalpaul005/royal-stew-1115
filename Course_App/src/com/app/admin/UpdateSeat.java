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

public class UpdateSeat {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String msg = null;
		int id;
		
		try {
			
			System.out.println("Enter Course name: ");
			String name = input.next();
			
			try(Connection myLink = Connect.getLink()){
				
				PreparedStatement ps = myLink.prepareStatement("select id from course where cname = ?");
				ps.setString(1, name);
				
				ResultSet res = ps.executeQuery();
				if(res.next()) {
					id = res.getInt("id");
					
					System.out.println("Enter new seats for the course: ");
					int seats = input.nextInt();
					
					AdminDAO admin = new AdminArea();
					
					try {
						msg = admin.updateSeats(id, seats);
						System.out.println(msg);
					} catch (CourseException e) {
						System.out.println(e.getMessage());
						System.out.println("Try Again.");
						main(args);
					}
				}else {
					System.out.println("No course found with this name " + name + " !");
					main(args);
				}
				
				
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
			}
			
			
			
		} catch (InputMismatchException e) {
			System.out.println("Wrong Input type please try again.");
			main(args);
		}
	


	}

}
