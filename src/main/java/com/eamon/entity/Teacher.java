package com.eamon.entity;

public class Teacher {
	private String teacherName;
	private String teacherSex;
	private int teacherId;
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherSex() {
		return teacherSex;
	}
	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	public Teacher(String TeacherName,String TeacherSex,int TeacherId) {
		this.teacherName=TeacherName;
		this.teacherSex=TeacherSex;
		this.teacherId=TeacherId;
	}
}
