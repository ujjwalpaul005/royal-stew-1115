package com.app.dto;

public class StudentDTO {
	private int roll;
	private String name;
	private String age;
	private String address;
	private String email;
	private String course;
	private String duration;
	private String session;
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public StudentDTO() {
	}
	public StudentDTO(int roll, String name, String age, String address, String email, String course, String duration,
			String session) {
		this.roll = roll;
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
		this.course = course;
		this.duration = duration;
		this.session = session;
	}
	@Override
	public String toString() {
		return "StudentDTO [roll=" + roll + ", name=" + name + ", age=" + age + ", address=" + address + ", email="
				+ email + ", course=" + course + ", duration=" + duration + ", session=" + session + "]";
	}

}
