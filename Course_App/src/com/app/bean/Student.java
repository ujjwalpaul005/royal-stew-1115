package com.app.bean;

public class Student {
	
	private int roll;
	private String name;
	private int age;
	private String address;
	private String email;
	private String password;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Student() {
	}
	public Student(String name, int age, String address, String email, String password) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", age=" + age + ", address=" + address + ", email=" + email
				+ ", password=" + password + "]";
	}

	
}
