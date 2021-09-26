package com.eamon.entity;

public class Classroom {
	
	private String className;
	private int studentNum;
	
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	
	public Classroom(String className , int studentNum) {
		// TODO Auto-generated constructor stub
		this.className = className;
		this.studentNum = studentNum;
		
	}
	
}
