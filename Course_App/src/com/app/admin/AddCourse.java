package com.app.admin;


import java.util.InputMismatchException;
import java.util.Scanner;

import com.app.bean.Course;
import com.app.dao.AdminDAO;
import com.app.daoIMPL.AdminArea;
import com.app.exceptions.CourseException;


public class AddCourse {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String msg = null;
		
		try {
			
			System.out.println("Enter Course name: ");
			String name = input.next();
			
			System.out.println("Enter id of the course: ");
			int id = input.nextInt();
			
			System.out.println("Enter fees of the course: ");
			int fees = input.nextInt();
			
			System.out.println("Enter seats of the course: ");
			int seat = input.nextInt();
			
			System.out.println("Enter duration of the course: ");
			String duration = input.next();
			
			System.out.println("Enter session of the course: ");
			String session = input.next();
			
			Course course = new Course(id, name, duration, fees, session, seat);
			
			AdminDAO admin = new AdminArea();
			
			try {
				msg = admin.addCourse(course);
			} catch (CourseException e) {
				System.out.println(e.getMessage());
				System.out.println("Try Again.");
				main(args);
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Wrong Input type please try again.");
			main(args);
		}
		
		
		
		System.out.println(msg);
	
	}
}
