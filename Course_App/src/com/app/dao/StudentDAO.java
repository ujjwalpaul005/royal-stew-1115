package com.app.dao;

import java.util.List;

import com.app.bean.Student;
import com.app.dto.CourseDTO;
import com.app.exceptions.*;

public interface StudentDAO {
	
	public String registerStudent(Student student) throws StudentException;
	
	public String updateDetails(int roll) throws StudentException;
	
	public List<CourseDTO> availableCourse();
	
	public String registerInACourse() throws CourseException;

}
