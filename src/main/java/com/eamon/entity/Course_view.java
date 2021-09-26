package com.eamon.entity;

public class Course_view {
	private String courseName;
	private int courseHour;
	private int credit;
	private String teacherName;
	private Integer teacherId;
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
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public Course_view(String courseName , int courseHour , int credit, String teacherName, Integer teacherId) {
		// TODO Auto-generated constructor stub
		this.courseName = courseName;
		this.courseHour = courseHour;
		this.credit = credit;
		this.teacherName=teacherName;
		this.teacherId=teacherId;
		
	}
}
