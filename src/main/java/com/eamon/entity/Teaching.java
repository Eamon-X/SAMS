package com.eamon.entity;

public class Teaching {
	
	private String courseName;
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

	public Teaching(String courseName,int teacherId) {
		// TODO Auto-generated constructor stub
		this.courseName=courseName;
		this.teacherId=teacherId;
	}
}
