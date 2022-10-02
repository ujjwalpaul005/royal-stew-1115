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
import com.app.dto.StudentDTO;
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
	public String updateDetails(int roll, String column, String detail) throws StudentException {
	String msg = "Student Detail update Failed";
			
			try (Connection link = Connect.getLink()){
				
				
				PreparedStatement ps1 = link.prepareStatement("Select * from student where roll = ?");
				ps1.setInt(1, roll);
				
				ResultSet res1 = ps1.executeQuery();
				
				if(res1.next()) {
					
					PreparedStatement ps = null;
					
					if(column.equals("address")) {
						ps = link.prepareStatement("update student set address = ? where roll = ?;");
						ps.setString(1, detail);
						ps.setInt(2, roll);
						
					}else if (column.equals("email")) {
						ps = link.prepareStatement("update student set email = ? where roll = ?;");
						ps.setString(1, detail);
						ps.setInt(2, roll);
						
					}else if (column.equals("password")) {
						ps = link.prepareStatement("update student set password = ? where roll = ?;");
						ps.setString(1, detail);
						ps.setInt(2, roll);
					}
					
					
					
					int res = ps.executeUpdate();
					
					if(res > 0) {
						msg = "Student Detail update succesful";
					}
					
				}else {
					throw new StudentException("No student found with roll " + roll);
				}
				
				
				
			} catch (SQLException e) {
				msg = e.getMessage();
			}
			
			return msg;
	}

	@Override
	public List<CourseDTO> availableCourse() throws CourseException {
		List<CourseDTO> courseList = new ArrayList<>();
		
		try (Connection link = Connect.getLink()){
			PreparedStatement ps = link.prepareStatement("select * from course where seat >= 1");
			
			ResultSet res = ps.executeQuery();
			
			boolean flag = true;
			
			while(res.next()){
				flag = false;
				courseList.add(new CourseDTO(res.getString("cname"), res.getString("duration"), res.getInt("fees"), res.getInt("seat"), res.getString("training_session")));
			}
			
			if(flag) {
				throw new CourseException("No available course found!");
			}
			
		} catch (SQLException e) {
			throw new CourseException("Error in StudentArea : availableCourse. Message is " + e.getMessage() );
		}
		
		return courseList;
	}

	@Override
	public String registerInACourse(int roll, int cid) throws CourseException {
	String msg = "Registration in Course Failed";
			
			try (Connection link = Connect.getLink()){
				PreparedStatement ps = link.prepareStatement("insert into batch values(?,?);");
				
				
				ps.setInt(1, cid);
				ps.setInt(2, roll);
				
				int res = ps.executeUpdate();
				
				if(res > 0) {
					msg = "Registration in Course succesful";
				}
				
				
			} catch (SQLException e) {
				msg = e.getMessage();
			}
			
			return msg;
	}

	
	@Override
	public StudentDTO showDetails(int roll) throws CourseException {
		StudentDTO detail = null;
			
			try (Connection link = Connect.getLink()){
				PreparedStatement ps = link.prepareStatement("select * from student where roll = ?;");
				
				ps.setInt(1, roll);
				
				ResultSet res = ps.executeQuery();
				
				if(res.next()) {
					PreparedStatement ps2 = link.prepareStatement("select * from course where id = (select cid from batch where sid = ?);");
					
					ps2.setInt(1, roll);
					
					ResultSet res2 = ps2.executeQuery();
					
					boolean flag = true;
					
					if(res2.next()) {
						flag = false;
						detail = new StudentDTO(res.getInt("roll"),
								res.getString("name"), res.getInt("age"), res.getString("address"), res.getString("email"), res2.getString("cname"), res2.getString("duration"), res2.getString("training_session"));
					}
					
					if(flag) {
						detail = new StudentDTO();
						detail.setRoll(res.getInt("roll"));
						detail.setName(res.getString("name"));
						detail.setAge(res.getInt("age"));
						detail.setAddress(res.getString("address"));
						detail.setEmail(res.getString("email"));
					}
				}else {
					throw new CourseException("No student found with roll " + roll);
				}
				
				
				
				
			} catch (SQLException e) {
				throw new CourseException(e.getMessage());
			}
			
			return detail;
	}

}
