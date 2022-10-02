package com.app.dao;

import java.util.List;

import com.app.bean.Student;
import com.app.dto.CourseDTO;
import com.app.dto.StudentDTO;
import com.app.exceptions.*;

public interface StudentDAO {
	
	public String registerStudent(Student student) throws StudentException;
	
	public String updateDetails(int roll, String column, String detail) throws StudentException;
	
	public List<CourseDTO> availableCourse() throws CourseException;
	
	public String registerInACourse(int roll, int cid) throws CourseException;
	
	public StudentDTO showDetails(int roll) throws CourseException;

}
