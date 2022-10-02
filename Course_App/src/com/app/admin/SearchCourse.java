package com.app.admin;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.app.dao.AdminDAO;
import com.app.daoIMPL.AdminArea;
import com.app.dto.CourseDTO;
import com.app.exceptions.CourseException;

public class SearchCourse {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		try {
			
			System.out.println("Enter Course id: ");
			int id = input.nextInt();
			
			AdminDAO admin = new AdminArea();
			
			CourseDTO course = new CourseDTO();
			
			course = admin.searchInfo(id);
			
			System.out.println(course);
			
			
		} catch (InputMismatchException e) {
			System.out.println("Wrong Input type please try again.");
			main(args);
		} catch (CourseException e) {
			System.out.println(e.getMessage());
			System.out.println("Try Agsin");
			main(args);
		}
		
		
		
		
	


	}
}
