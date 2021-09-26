package com.eamon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eamon.entity.Teacher;


public class TeacherRepository {
	public List<Teacher> findAll() {
		//在这里定义，可用范围变大
		List<Teacher> list = new ArrayList<>();
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
					String sql = "select * from teacher";
					preparedStatement = connection.prepareStatement(sql);
					resultset = preparedStatement.executeQuery();
					Teacher teacher =null;
					while(resultset.next()) {
						String TeacherName = resultset.getString(1);
						String TeacherSex = resultset.getString(2);
						int TeacherId = resultset.getInt(3);
						
						teacher = new Teacher(TeacherName,TeacherSex,TeacherId);
						list.add(teacher);
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
	
	public void add( String teacherName, String teacherSex ,int teacherId) {
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
					String sql = "insert into teacher(TeacherName,TeacherSex,TeacherId) values(?,?,?)";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1,teacherName);
					preparedStatement.setString(2, teacherSex);
					preparedStatement.setInt(3, teacherId);
					
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
	
	public void deleteByteacherId(int teacherId) {
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
					String sql = "delete from teacher where TeacherId = ?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1,teacherId);
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
