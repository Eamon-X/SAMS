package com.eamon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eamon.entity.Course;


public class CourseRepository {
	
	public List<Course> findAll() {
		//在这里定义，可用范围变大
		List<Course> list = new ArrayList<>();
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
					String sql = "select * from course";
					preparedStatement = connection.prepareStatement(sql);
					resultset = preparedStatement.executeQuery();
					Course course = null;
					while(resultset.next()) {
						String CourseName = resultset.getString(1);
						Integer CourseHour = resultset.getInt(2);
						Integer Credit = resultset.getInt(3);
						
						
						
						course= new Course( CourseName, CourseHour, Credit);
						list.add(course);
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
	
	public void deleteBycourseName(String courseName) {
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
					String sql = "delete from course where CourseName = ?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, courseName);
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
	
	public void add(String courseName ,int courseHour, int credit) {
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
					String sql = "insert into course(CourseName,CourseHour,Credit) values(?,?,?)";
					preparedStatement = connection.prepareStatement(sql);
					
					preparedStatement.setString(1, courseName);
					preparedStatement.setInt(2, courseHour);
					preparedStatement.setInt(3, credit);
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
