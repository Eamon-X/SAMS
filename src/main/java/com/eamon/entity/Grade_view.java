package com.eamon.entity;

public class Grade_view {
	private String className;
	private String courseName;
	private String semester;
	private String avg;
	private String max;
	private String min;
	private String pass;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	public Grade_view(String ClassName,String CourseName,String Semester, String Avg, String Max, String Min,String Pass) {
		// TODO Auto-generated constructor stub
		this.className=ClassName;
		this.courseName=CourseName;
		this.semester=Semester;
		this.avg=Avg;
		this.max=Max;
		this.min=Min;
		this.pass=Pass;
		
	}
}
