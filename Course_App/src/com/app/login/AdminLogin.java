package com.app.login;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.app.admin.AddCourse;
import com.app.admin.AllocateStudent;
import com.app.admin.DeleteCourse;
import com.app.admin.RegisterStudent;
import com.app.admin.SearchCourse;
import com.app.admin.ShowAllStudent;
import com.app.admin.UpdateFees;
import com.app.admin.UpdateSeat;


public class AdminLogin {

	public static void main(String[] args) {


		Scanner input = new Scanner(System.in);
		
		try {
			System.out.println("Enter admin username: ");
			String user = input.next();
			
			System.out.println("Enter admin password: ");
			String pass = input.next();
			
			if(user.equals("admin") && pass.equals("1234")) {
				System.out.println("\nWelcome Admin \n");
				admin();
			}else {
				System.out.println("Wrong Credentials. Try Again.");
				System.out.println("Press 1 for Exit. \n"
									+ "Press any other key for continue.\n");
				
				String choice = input.next();
				
				if(choice.equals("1")) {
					
				}else {
					main(args);
				}
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Please Enter correct Input");
			main(args);
		}
		
		input.close();
	}
	
	public static void admin() {
		System.out.println("Choose any option: \n"
				+ "Select 1 - for Register new Student\n"
				+ "Select 2 - for Add a Course\n"
				+ "Select 3 - for Delete a Course\n"
				+ "Select 4 - for Update fees of a course\n"
				+ "Select 5 - for Update seats of a course\n"
				+ "Select 6 - for Allocate a student in a course\n"
				+ "Select 7 - for Search info of a course\n"
				+ "Select 8 - for Show All Students with their course\n"
				+ "Select 9 - for Exit\n");
		
		
		Scanner input = new Scanner(System.in);
		
		try {
			int choice = input.nextInt();
			
			if(choice == 1) {
				RegisterStudent.main(null);
				admin();
			}else if(choice == 2) {
				AddCourse.main(null);
				admin();
			}else if(choice == 3) {
				DeleteCourse.main(null);
				admin();
			}else if(choice == 4) {
				UpdateFees.main(null);
				admin();
			}else if(choice == 5) {
				UpdateSeat.main(null);
				admin();
			}else if(choice == 6) {
				AllocateStudent.main(null);
				admin();
			}else if(choice == 7) {
				SearchCourse.main(null);
				admin();
			}else if(choice == 8) {
				ShowAllStudent.main(null);
				admin();
			}else if(choice == 9) {
			}
			
			
			
		} catch (InputMismatchException e) {
			System.out.println("Please Enter correct Input");
			admin();
		}
		
		input.close();
		
	}

}
