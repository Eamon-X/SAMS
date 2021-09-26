package com.eamon.entity;

public class Teaching_view {

	private String courseName;
	private String teacherName;
	private int teacherId;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public Teaching_view(String courseName,String teacherName,int teacherId) {
		// TODO Auto-generated constructor stub
		this.courseName=courseName;
		this.teacherName=teacherName;
		this.teacherId=teacherId;
	}
}
