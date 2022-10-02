package com.app.usecases;

import java.util.List;

import com.app.dao.StudentDAO;
import com.app.daoIMPL.StudentArea;
import com.app.dto.CourseDTO;
import com.app.exceptions.CourseException;

public class ShowAvilableCourse {

	public static void main(String[] args) {
		
		StudentDAO showIt = new StudentArea();
		
		try {
			List<CourseDTO> allList = showIt.availableCourse();
			for(CourseDTO a : allList) {
				System.out.println(a);
			}
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}
	}
}
