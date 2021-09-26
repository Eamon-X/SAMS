package com.eamon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eamon.entity.Teaching;

public class TeachingRepository {
	
		
		public List<Teaching> findAll() {
			//在这里定义，可用范围变大
			List<Teaching> list = new ArrayList<>();
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
						String sql = "select * from teaching";
						preparedStatement = connection.prepareStatement(sql);
						resultset = preparedStatement.executeQuery();
						Teaching teaching =null;
						while(resultset.next()) {
							String CourseName = resultset.getString(1);
							int TeacherId = resultset.getInt(2);
							
							teaching = new Teaching(CourseName,TeacherId);
							list.add(teaching);
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
		
		public void add(String courseName, int teacherId) {
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
						String sql = "insert into teaching(CourseName,TeacherId) values(?,?)";
						preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setString(1, courseName);
						preparedStatement.setInt(2,teacherId);
					
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
		
		public void deleteBycourseNameandteacherId(String courseName,int teacherId) {
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
						String sql = "delete from teaching where CourseName = ? and TeacherId = ?";
						preparedStatement = connection.prepareStatement(sql);
						
						preparedStatement.setString(1,courseName);
						preparedStatement.setInt(2,teacherId);
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
