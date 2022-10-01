package com.app.daoIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.bean.Student;
import com.app.dao.StudentDAO;
import com.app.dto.CourseDTO;
import com.app.exceptions.CourseException;
import com.app.exceptions.StudentException;
import com.app.utility.Connect;

public class StudentArea implements StudentDAO{

	@Override
	public String registerStudent(Student student) throws StudentException {
		String msg = "Student Registration Failed";
		
		try (Connection link = Connect.getLink()){
			PreparedStatement ps = link.prepareStatement("insert into student(name, age, address, email, password) values(?,?,?,?,?);");
			
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getPassword());
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				msg = "Student registration succesful";
			}
			
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
	}

	@Override
	public String updateDetails(int roll) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseDTO> availableCourse() {
		List<CourseDTO> courseList = new ArrayList<>();
		
		try (Connection link = Connect.getLink()){
			PreparedStatement ps = link.prepareStatement("select * from course where seats >= 1");
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				courseList.add(new CourseDTO(res.getString("cname"), res.getString("duration"), res.getInt("fees"), res.getInt("seat"), res.getString("traing_session")));
			}
			
		} catch (SQLException e) {
			System.out.println("Error in StudentArea : availableCourse. Message is " + e.getMessage() );
		}
		
		return courseList;
	}

	@Override
	public String registerInACourse() throws CourseException {
		// TODO Auto-generated method stub
		return null;
	}

}
