package com.app.dto;

import com.app.bean.Student;
import com.app.dao.StudentDAO;
import com.app.daoIMPL.StudentArea;
import com.app.exceptions.StudentException;

public class Main {

	public static void main(String[] args) {
		StudentDAO s1 = new StudentArea();
		try {
			System.out.println(s1.registerStudent(new Student()));
		} catch (StudentException e) {
			
		}

	}

}
