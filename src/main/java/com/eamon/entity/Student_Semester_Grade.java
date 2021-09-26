package com.eamon.entity;

public class Student_Semester_Grade {
	private String studentId;
	private String studentName;
	private String semester;
	private String avg;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	
	public Student_Semester_Grade(String StudentId, String StudentName, String Semester, String Avg) {
		this.studentId = StudentId;
		this.studentName = StudentName;
		this.semester = Semester;
		this.avg = Avg;
	}
}
