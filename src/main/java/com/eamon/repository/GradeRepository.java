package com.eamon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.eamon.entity.Grade;


public class GradeRepository {
	public List<Grade> findAll() {
		//在这里定义，可用范围变大
		List<Grade> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		//连接数据库
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url ="jdbc:mysql://localhost:3306/sams?useUnicode=ture&characterEncoding=UTF-8";
					String user ="root";
					String password ="";
					connection = DriverManager.getConnection(url, user, password);
					String sql = "select * from grade";
					preparedStatement = connection.prepareStatement(sql);
					resultset = preparedStatement.executeQuery();
					Grade grade = null;
					while(resultset.next()) {
						String StudentId = resultset.getString(1);
						String CourseName = resultset.getString(2);
						Integer Grade = null;
						//Integer Grade = (Integer)resultset.getInt(3);
						if (resultset.getObject("Grade") != null) {
	                            Grade = resultset.getInt("Grade");
	                   }
						String Semester = resultset.getString(4);
						
						
						grade = new Grade(StudentId, CourseName, Grade, Semester);
						list.add(grade);
					}
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						resultset.close();
						preparedStatement.close();
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				return list;
	}
	
	public Grade findBystudentIdandCourseName(String studentId , String courseName) {
		//在这里定义，可用范围变大
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		Grade grade = null;
		//连接数据库
			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url ="jdbc:mysql://localhost:3306/sams?useUnicode=ture&characterEncoding=UTF-8";
					String user ="root";
					String password ="";
					connection = DriverManager.getConnection(url, user, password);
					String sql = "select * from grade where StudentId = ? and CourseName = ?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1,studentId);
					preparedStatement.setString(2, courseName);
					resultset = preparedStatement.executeQuery();
					//查询
					while(resultset.next()) {
						String StudentId = resultset.getString(1);
						String CourseName = resultset.getString(2);
						Integer Grade  = resultset.getInt(3);
						String Semester = resultset.getString(4);
						grade = new Grade(StudentId,CourseName,Grade,Semester);
						
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						resultset.close();
						preparedStatement.close();
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
									
			} 
			return grade;
	}
	
	
	public void update(String studentId, String courseName ,int grade) {
		//在这里定义，可用范围变大
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				//连接数据库
					try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							String url ="jdbc:mysql://localhost:3306/sams?useUnicode=ture&characterEncoding=UTF-8";
							String user ="root";
							String password ="";
							connection = DriverManager.getConnection(url, user, password);
							String sql = "update grade set Grade=? where StudentId=? AND CourseName=?";
							preparedStatement = connection.prepareStatement(sql);
							
						
							preparedStatement.setInt(1, grade);
							preparedStatement.setString(2, studentId);
							preparedStatement.setString(3, courseName);
							
							preparedStatement.executeUpdate();
							
							
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						try {
							
							preparedStatement.close();
							connection.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	}
	
	public void deleteBystudentIdandcourseName(String studentId,String courseName) {
		//在这里定义，可用范围变大
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		//连接数据库
			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url ="jdbc:mysql://localhost:3306/sams?useUnicode=ture&characterEncoding=UTF-8";
					String user ="root";
					String password ="";
					connection = DriverManager.getConnection(url, user, password);
					String sql = "delete from grade where StudentId = ? and CourseName = ?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1,studentId);
					preparedStatement.setString(2,courseName);
					preparedStatement.executeUpdate();
						
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						
						preparedStatement.close();
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
									
			} 
		
	}
	
	public void add(Double studentId, String courseName, String semester) {
		//在这里定义，可用范围变大
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		//连接数据库
			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url ="jdbc:mysql://localhost:3306/sams?useUnicode=ture&characterEncoding=UTF-8";
					String user ="root";
					String password ="";
					connection = DriverManager.getConnection(url, user, password);
					String sql = "insert into grade(StudentId,CourseName,Semester) values(?,?,?)";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setDouble(1,studentId);
					preparedStatement.setString(2, courseName);
					preparedStatement.setString(3, semester);
					preparedStatement.executeUpdate();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
							
			} 
	}
	
}
