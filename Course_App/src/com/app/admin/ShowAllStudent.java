package com.app.admin;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.AdminDAO;
import com.app.daoIMPL.AdminArea;
import com.app.dto.StudentDTO;
import com.app.exceptions.StudentException;

public class ShowAllStudent {

	public static void main(String[] args) {
		List<StudentDTO> myList = new ArrayList<>();
		
		AdminDAO admin = new AdminArea();
		
		try {
			myList = admin.showAllStudents();
			for(StudentDTO a: myList) {
				System.out.println(a);
			}
			
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
