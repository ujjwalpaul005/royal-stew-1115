package com.app.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.app.usecases.RegisterInACourse;
import com.app.usecases.SelfDetail;
import com.app.usecases.ShowAvilableCourse;
import com.app.usecases.UpdateStudent;
import com.app.utility.Connect;

public class StudentLogin {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		try {
			System.out.println("Enter username: ");
			String user = input.next();
			
			System.out.println("Enter password: ");
			String pass = input.next();
			
			try(Connection myLink = Connect.getLink()){
				PreparedStatement ps = myLink.prepareStatement("select roll,name,password from student where email = ?");
				ps.setString(1, user);
				
				ResultSet res = ps.executeQuery();
				boolean flag = true;
				
				if(res.next()) {
					flag = false;
					if(res.getString("password").equals(pass)) {
						System.out.println("Welcome " + res.getString("name"));
						student(res.getInt("roll"));
					}else {
						
						System.out.println("Wrong Password. Try Again.");
						System.out.println("Press 1 for Exit. \n"
											+ "Press any other key for continue.\n");
						
						String choice = input.next();
						
						if(choice.equals("1")) {
							
						}else {
							main(args);
						}
					}
				}
				
				if(flag) {
					System.out.println("Wrong Email. Try Again.");
					System.out.println("Press 1 for Exit. \n"
										+ "Press any other key for continue.\n");
					
					String choice = input.next();
					
					if(choice.equals("1")) {
						
					}else {
						main(args);
					}
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
			
		} catch (InputMismatchException e) {
			System.out.println("Please Enter correct Input");
			main(args);
		}
		
		input.close();
	}
	
	public static void student(int roll) {
		System.out.println("\n==============================\n");
		System.out.println("Choose any option: \n"
				+ "Select 1 - for Register in a Course\n"
				+ "Select 2 - for Update Details\n"
				+ "Select 3 - for Show Available Course\n"
				+ "Select 4 - for Show Self Detail\n"
				+ "Select 5 - for Exit\n");
		
		Scanner input = new Scanner(System.in);
		
		try {
			int choice = input.nextInt();
			
			if(choice == 1) {
				RegisterInACourse.main(null);
				student(roll);
			}else if(choice == 2) {
				UpdateStudent.main(null);
				student(roll);
			}else if(choice == 3) {
				ShowAvilableCourse.main(null);
				student(roll);
			}else if(choice == 4) {
				SelfDetail.main(null, roll);
				student(roll);
			}else if(choice == 5) {
			}
			
			
			
		} catch (InputMismatchException e) {
			System.out.println("Please Enter correct Input");
			student(roll);
		}
		
		input.close();

	}
}
