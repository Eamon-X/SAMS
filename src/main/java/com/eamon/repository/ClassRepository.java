package com.eamon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eamon.entity.Classroom;


public class ClassRepository {
	
		public List<Classroom> findAll() {
			//在这里定义，可用范围变大
			List<Classroom> list = new ArrayList<>();
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
						String sql = "select * from class";
						preparedStatement = connection.prepareStatement(sql);
						resultset = preparedStatement.executeQuery();
						Classroom classroom = null;
						while(resultset.next()) {
							String ClassName = resultset.getString(1);
							int StudentNum = resultset.getInt(2);
							
							classroom = new Classroom(ClassName,StudentNum);
							list.add(classroom);
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
		
		
		public void add(String className) {
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
						String sql = "insert into class(ClassName,StudentNum) values(?,0)";
						preparedStatement = connection.prepareStatement(sql);
						
						preparedStatement.setString(1,className);
						
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
		
		
		public void deleteByclassName(String className) {
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
						String sql = "delete from class where ClassName = ?";
						preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setString(1,className);
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
		
		public static void main(String[] args) {
			ClassRepository classRepository =new ClassRepository();
			System.out.println(classRepository.findAll());
		}
}
