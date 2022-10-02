package com.app.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.app.dao.StudentDAO;
import com.app.daoIMPL.StudentArea;
import com.app.exceptions.StudentException;

public class UpdateStudent {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String msg = null;
		
		try {
			
			System.out.println("Enter your roll:");
			int roll = sc.nextInt();
			
			System.out.println("For updating : \n"
					+ "	Address, press - 1\n"
					+ "	email, press - 2\n"
					+ "	password, press - 3\n");
			int count = sc.nextInt();
			
			StudentDAO updater = new StudentArea();
			
			String column = null;
			String detail = null;
			
			if(count == 1) {
				System.out.println("Enter your new address: ");
				detail = sc.next();
				column = "address";				
				
			}else if(count == 2) {
				System.out.println("Enter your new email: ");
				detail = sc.next();
				column = "email";
				
			}else if(count == 3) {
				System.out.println("Enter your new password: ");
				detail = sc.next();
				column = "password";
			}
			

			try {
				msg = updater.updateDetails(roll, column, detail);
			} catch (StudentException e) {
				System.out.println(e.getMessage());
				System.out.println("Try Again");
			}
			
			
		} catch (InputMismatchException e) {
			System.out.println("Wrong Input type please try again.");
			main(args);
		}
		
		
		if(msg != null)
			System.out.println(msg);
	
	}

}
