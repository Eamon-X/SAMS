package com.eamon.entity;


public class Student {
	private String studentId;
	private String studentName;
	private String sex;
	private String className;
	
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	 public Student(String StudentId,String StudentName,String Sex,String ClassName) {
		// TODO Auto-generated constructor stub
		 this.studentId = StudentId;
		 this.studentName = StudentName;
		 this.sex = Sex;
		 this.className =ClassName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student{"+
				"StudentId="+studentId+
				",StudentName='"+studentName+'\''+
				",Sex="+sex+
				",ClassName="+className+
				"}";
	}
	
	
	
}
