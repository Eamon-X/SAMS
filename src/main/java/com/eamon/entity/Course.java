package com.eamon.entity;

public class Course {
	private String courseName;
	private int courseHour;
	private int credit;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseHour() {
		return courseHour;
	}
	public void setCourseHour(int courseHour) {
		this.courseHour = courseHour;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public Course(String courseName , int courseHour , int credit ) {
		// TODO Auto-generated constructor stub
		this.courseName = courseName;
		this.courseHour = courseHour;
		this.credit = credit;
		
	}
	
	
}
