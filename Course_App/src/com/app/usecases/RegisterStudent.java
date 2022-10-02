package com.app.usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.app.bean.Student;
import com.app.dao.StudentDAO;
import com.app.daoIMPL.StudentArea;
import com.app.exceptions.StudentException;

public class RegisterStudent {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String msg = null;
		
		try {
			
			System.out.println("Enter Student Name:");
			String sname= sc.next();
			
			System.out.println("Enter Student Age:");
			int age= sc.nextInt();
			
			System.out.println("Enter Student Address:");
			String address= sc.next();
			
			System.out.println("Enter Student Email:");
			String email= sc.next();
			
			System.out.println("Enter Student password:");
			String password= sc.next();
			
			Student student = new Student(sname, age, address, email, password);
			
			StudentDAO reg = new StudentArea();
			
			try {
				msg = reg.registerStudent(student);
			} catch (StudentException e) {
				msg = e.getMessage();
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Wrong Input type please try again.");
			main(args);
		}
		
		
		if(msg != null)
			System.out.println(msg);
	
		
	}

}
