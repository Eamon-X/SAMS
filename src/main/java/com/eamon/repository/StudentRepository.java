package com.eamon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eamon.entity.Student;


public class StudentRepository {
	public List<Student> findAll() {
		//在这里定义，可用范围变大
		List<Student> list = new ArrayList<>();
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
					String sql = "select * from student";
					preparedStatement = connection.prepareStatement(sql);
					resultset = preparedStatement.executeQuery();
					Student student = null;
					while(resultset.next()) {
						String StudentId = resultset.getString("StudentId");
						String StudentName = resultset.getString(2);
						String Sex = resultset.getString(3);
						String ClassName = resultset.getString(4);
						student = new Student(StudentId,StudentName,Sex,ClassName);
						list.add(student);
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
	
	public void add(Double studentId, String studentName, String sex ,String className) {
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
					String sql = "insert into student(StudentId,StudentName,Sex,ClassName) values(?,?,?,?)";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setDouble(1,studentId);
					preparedStatement.setString(2, studentName);
					preparedStatement.setString(3, sex);
					preparedStatement.setString(4, className);
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
	
	public void deleteBystudentId(Double studentId) {
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
					String sql = "delete from student where StudentId = ?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setDouble(1,studentId);
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
	
	public Student findBystudentId(Double studentId) {
		//在这里定义，可用范围变大
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		Student student = null;
		//连接数据库
			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url ="jdbc:mysql://localhost:3306/sams?useUnicode=ture&characterEncoding=UTF-8";
					String user ="root";
					String password ="";
					connection = DriverManager.getConnection(url, user, password);
					String sql = "select * from student where StudentId = ?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setDouble(1,studentId);
					resultset = preparedStatement.executeQuery();
					//查询
					while(resultset.next()) {
						String StudentId = resultset.getString("StudentId");
						String StudentName = resultset.getString(2);
						String Sex = resultset.getString(3);
						String ClassName = resultset.getString(4);
						student = new Student(StudentId,StudentName,Sex,ClassName);
						
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
			return student;
	}
	
	public void update(double studentId, String studentName, String sex, String className) {
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
							String sql = "update student set StudentName = ?, Sex = ?, ClassName = ? where StudentId = ?";
							preparedStatement = connection.prepareStatement(sql);
							
							preparedStatement.setString(1, studentName);
							preparedStatement.setString(2, sex);
							preparedStatement.setString(3, className);
							preparedStatement.setDouble(4,studentId);
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
		StudentRepository studentRepository =new StudentRepository();
		System.out.println(studentRepository.findAll());
	}
	
}
