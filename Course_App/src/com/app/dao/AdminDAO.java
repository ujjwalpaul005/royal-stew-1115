package com.app.dao;

import java.util.List;

import com.app.bean.Course;
import com.app.bean.Student;
import com.app.dto.StudentDTO;
import com.app.exceptions.*;

public interface AdminDAO {

	
	public String registerStudent(Student student) throws StudentException;
	
	public String addCourse(Course course) throws CourseException;
	
	public String updateFees(int fees) throws CourseException;
	
	public String deleteCourse(int id) throws CourseException;
	
	public String searchInfo(int id) throws CourseException;
	
	public String createBatch(int id, int roll) throws CourseException;
	
	public String updateSeats(int id, int seats) throws CourseException;
	
	public List<StudentDTO> showAllStudents() throws StudentException;
}
