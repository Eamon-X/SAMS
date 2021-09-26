package com.eamon.entity;

public class Grade {
	private String studentId;
	private String courseName;
	private Integer grade;
	private String semester;
	

	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	public Grade(String StudentId,String CourseName,Integer Grade,String Semester) {
		this.studentId=StudentId;
		this.courseName=CourseName;
		this.grade=Grade;
		this.semester=Semester;
	}
	
}
