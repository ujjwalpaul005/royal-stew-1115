package com.app.daoIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.bean.Course;
import com.app.bean.Student;
import com.app.dao.AdminDAO;
import com.app.dto.CourseDTO;
import com.app.dto.StudentDTO;
import com.app.exceptions.CourseException;
import com.app.exceptions.StudentException;
import com.app.utility.Connect;

public class AdminArea implements AdminDAO{

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
	public String addCourse(Course course) throws CourseException {
		String msg = "Course Add Failed";
		
		try (Connection link = Connect.getLink()){
			PreparedStatement ps = link.prepareStatement("insert into course values(?,?,?,?,?,?)");
			
			ps.setInt(1, course.getId());
			ps.setString(2, course.getName());
			ps.setString(3, course.getDuration());
			ps.setInt(4, course.getFees());
			ps.setString(5,course.getSession());
			ps.setInt(6, course.getAvailableSeat());
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				msg = "Course Add succesful";
			}
			
			
		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String updateFees(int id, int fees) throws CourseException {
		String msg = "Fees Updation Failed";
		
		try (Connection link = Connect.getLink()){
			PreparedStatement ps = link.prepareStatement("update course set fees = ? where id = ?");
			
			ps.setInt(1, fees);
			ps.setInt(2, id);
			
			int res = ps.executeUpdate();
			boolean flag = true;
			if(res > 0) {
				flag = false;
				msg = "Fees Updation succesful";
			}
			
			if(flag) {
				throw new CourseException("No course found with id " + id + " !");
			}
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
	}

	@Override
	public String deleteCourse(int id) throws CourseException {
		String msg = "Course Delete Failed";
		
		try (Connection link = Connect.getLink()){
			PreparedStatement ps = link.prepareStatement("delete from course where id = ?");
			
			ps.setInt(1, id);
			
			int res = ps.executeUpdate();
			boolean flag = true;
			if(res > 0) {
				flag = false;
				msg = "Fees Updation succesful";
			}
			if(flag) {
				throw new CourseException("No course found with id " + id + " !");
			}
			
			
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
	}

	@Override
	public CourseDTO searchInfo(int id) throws CourseException {
		CourseDTO detail = null;
		
		try (Connection link = Connect.getLink()){
			PreparedStatement ps = link.prepareStatement("select * from course where id = ?;");
			
			ps.setInt(1, id);
			
			ResultSet res = ps.executeQuery();
			
			boolean flag = true;
			
			while(res.next()) {
				flag = false;
				detail = new CourseDTO(
						res.getString("cname"), res.getString("duration"), res.getInt("fees"), res.getInt("seat"), res.getString("traing_session"));
			}
			
			if(flag) {
				throw new CourseException("No Details found!");
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return detail;
	}

	@Override
	public String createBatch(int id, int roll) throws CourseException, StudentException {
		String msg = "Student allot Failed";
		
		try (Connection link = Connect.getLink()){
			PreparedStatement ps= link.prepareStatement("select * from student where roll = ?");		 	
		 	
			ps.setInt(1, roll);
		 	
		 	ResultSet rs= ps.executeQuery();
			
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2= link.prepareStatement("select * from course where id=?");
		 		
		 		ps2.setInt(1, id);

		 		ResultSet rs2= ps2.executeQuery();
		 		
		 		if(rs2.next()) {

		 			PreparedStatement ps3= link.prepareStatement("insert into batch values(?,?)");
		 			
		 			ps3.setInt(1, id);
		 			ps3.setInt(2, roll);
		 			
		 			int x= ps3.executeUpdate();
		 			
		 			if(x > 0)
		 				msg = "Student Allot Succesful.";
		 			else
		 				throw new StudentException("Techical error..");
		 		}
		 		else
		 			throw new CourseException("Invalid Course...");
		 	}else
		 		throw new StudentException("Invalid Student...");
			
			
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String updateSeats(int id, int seats) throws CourseException {
		String msg = "Seat Updation Failed";
		
		try (Connection link = Connect.getLink()){
			PreparedStatement ps = link.prepareStatement("update course set seat = ? where id = ?");
			
			ps.setInt(1, seats);
			ps.setInt(2, id);
			
			int res = ps.executeUpdate();
			
			boolean flag = true;
			if(res > 0) {
				flag = false;
				msg = "Seats Updation succesful";
			}
			
			if(flag) {
				throw new CourseException("No course found with id " + id + " !");
			}
			
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
	}

	
	@Override
	public List<StudentDTO> showAllStudents() throws StudentException {
		List<StudentDTO> allList = new ArrayList<>();
		
		try(Connection link = Connect.getLink()){
			
			PreparedStatement ps= link.prepareStatement("select s.roll, s.name, s.age, s.address, s.email, c.cname, c.duration, c.training_session "
								+ "from  student s INNER JOIN course c INNER JOIN batch cs "
								+ "ON s.roll = cs.sid AND c.id = cs.cid");
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
			
			int r= rs.getInt("roll");
			String sn= rs.getString("name");
			int age = rs.getInt("age");
			String addr = rs.getString("address");
			String em= rs.getString("email");
			
			String cn= rs.getString("cname");
			String durat= rs.getString("duration");
			String session= rs.getString("training_session");
			
			
			StudentDTO dto = new StudentDTO(r, sn, age, addr, em, cn, durat, session);
			
			allList.add(dto);
		
		}
				
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
			
			
			
		if(allList.isEmpty())
			throw new StudentException("No Student found !");

		
		return allList;
	}

}
