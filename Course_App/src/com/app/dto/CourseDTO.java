package com.app.dto;

public class CourseDTO {
	private String name;
	private String duration;
	private int fees;
	private int seat;
	private String session;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public CourseDTO() {
	}
	public CourseDTO(String name, String duration, int fees, int seat, String session) {
		this.name = name;
		this.duration = duration;
		this.fees = fees;
		this.seat = seat;
		this.session = session;
	}
	@Override
	public String toString() {
		return "CourseDTO [name=" + name + ", duration=" + duration + ", fees=" + fees + ", seat=" + seat + ", session="
				+ session + "]";
	}
	
}
