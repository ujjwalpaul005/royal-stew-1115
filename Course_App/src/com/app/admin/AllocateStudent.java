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
import com.app.exceptions.StudentException;
import com.app.utility.Connect;

public class AllocateStudent {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String msg = null;
		
		try {
			
			System.out.println("Enter Course id: ");
			int id = input.nextInt();
			
			System.out.println("Enter roll of the Student: ");
			int roll = input.nextInt();
			
			
			try(Connection myLink = Connect.getLink()){
				PreparedStatement ps = myLink.prepareStatement("select seat from course where id = ?");
				ps.setInt(1, id);
				
				ResultSet res = ps.executeQuery();
				boolean flag = true;
				if(res.next()) {
					flag = false;
					int seat = res.getInt("seat");
					
					PreparedStatement ps2 = myLink.prepareStatement("update course set seat = ? where id = ?");
					
					ps2.setInt(1, (seat-1));
					ps2.setInt(2, id);
					
					int res2 = ps2.executeUpdate();
					
				}
				
				if(flag) {
					System.out.println("here");
				}else {
					AdminDAO admin = new AdminArea();
					msg = admin.createBatch(id, roll);
					System.out.println(msg);
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
			
			
		} catch (InputMismatchException e) {
			System.out.println("Wrong Input type please try again.");
			main(args);
		} catch (CourseException e) {
			System.out.println(e.getMessage());
			System.out.println("Try Again");
			main(args);
		} catch (StudentException e) {
			System.out.println(e.getMessage());
			System.out.println("Try Again");
			main(args);
		}
	
		

	}
}
