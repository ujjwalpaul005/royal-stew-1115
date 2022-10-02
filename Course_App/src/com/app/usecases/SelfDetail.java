package com.app.usecases;

import java.util.Scanner;

import com.app.dao.StudentDAO;
import com.app.daoIMPL.StudentArea;
import com.app.dto.StudentDTO;
import com.app.exceptions.CourseException;

public class SelfDetail {

	public static void main(String[] args, int roll) {
		StudentDTO student = new StudentDTO();
		
		StudentDAO showIt = new StudentArea();
		
		System.out.println("Enter Roll No: ");
		
		try {
			System.out.println(roll);
			student = showIt.showDetails(roll);
			System.out.println(student);
		} catch (CourseException e) {
			System.out.println(e.getMessage());
			System.out.println("Try Again");
		}
	}
}
