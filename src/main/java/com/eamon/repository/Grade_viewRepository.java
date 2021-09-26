package com.eamon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.eamon.entity.Grade_view;


public class Grade_viewRepository {

	public List<Grade_view> find(String ClassName,String CourseName,String Semester) {
		//在这里定义，可用范围变大
		List<Grade_view> list = new ArrayList<>();
		
		Grade_view grade_view =null;
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
					String sql = "SELECT grade_view.ClassName,grade_view.CourseName,grade_view.Semester,AVG(grade_view.Grade) as 平均分,MAX(grade_view.Grade) as 最高分,MIN(grade_view.Grade) as 最低分,CONCAT((ROUND(COUNT(CASE WHEN grade_view.Grade >= 60 THEN 1 ELSE NULL END) * 100 / COUNT(*),2)),'%') as 及格率\r\n"
							+ "FROM `grade_view`\r\n"
							+ "GROUP BY grade_view.ClassName,grade_view.CourseName,grade_view.Semester";
					preparedStatement = connection.prepareStatement(sql);
					
					resultset = preparedStatement.executeQuery();
					//查询
					while(resultset.next()) {
						String className = resultset.getString(1);
						String courseName = resultset.getString(2);
						String semester = resultset.getString(3);
						String avg = resultset.getString(4);
						String max = resultset.getString(5);
						String min = resultset.getString(6);
						String pass = resultset.getString(7);
						grade_view = new Grade_view(className, courseName, semester, avg, max, min, pass);
						list.add(grade_view);
						
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
	
	
	public List<Grade_view> findbyClCo(String ClassName,String CourseName) {
		//在这里定义，可用范围变大
		List<Grade_view> list = new ArrayList<>();
		String sql = null;
		Grade_view grade_view =null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		if (ClassName!=null&&CourseName!=null) {
			 sql = "SELECT grade_view.ClassName,grade_view.CourseName,AVG(grade_view.Grade) as 平均分,MAX(grade_view.Grade) as 最高分,MIN(grade_view.Grade) as 最低分,CONCAT((ROUND(COUNT(CASE WHEN grade_view.Grade >= 60 THEN 1 ELSE NULL END) * 100 / COUNT(*),2)),'%') as 及格率\r\n"
					+ "FROM `grade_view`\r\n"
					+ "GROUP BY grade_view.ClassName,grade_view.CourseName";
		}
		
		//连接数据库
			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url ="jdbc:mysql://localhost:3306/sams?useUnicode=ture&characterEncoding=UTF-8";
					String user ="root";
					String password ="";
					connection = DriverManager.getConnection(url, user, password);
					
					preparedStatement = connection.prepareStatement(sql);
					
					resultset = preparedStatement.executeQuery();
					//查询
					while(resultset.next()) {
						String className = resultset.getString(1);
						String courseName = resultset.getString(2);
						String avg = resultset.getString(3);
						String max = resultset.getString(4);
						String min = resultset.getString(5);
						String pass = resultset.getString(6);
						grade_view = new Grade_view(className, courseName, null, avg, max, min, pass);
						list.add(grade_view);
						
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
	
	public List<Grade_view> findbyClSe(String ClassName,String Semester) {
		//在这里定义，可用范围变大
		List<Grade_view> list = new ArrayList<>();
		Grade_view grade_view =null;
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
					String sql = "SELECT grade_view.ClassName,grade_view.Semester,AVG(grade_view.Grade) as 平均分,MAX(grade_view.Grade) as 最高分,MIN(grade_view.Grade) as 最低分,CONCAT((ROUND(COUNT(CASE WHEN grade_view.Grade >= 60 THEN 1 ELSE NULL END) * 100 / COUNT(*),2)),'%') as 及格率\r\n"
							+ "FROM `grade_view`\r\n"
							+ "GROUP BY grade_view.ClassName,grade_view.Semester";
					preparedStatement = connection.prepareStatement(sql);
					
					resultset = preparedStatement.executeQuery();
					//查询
					while(resultset.next()) {
						String className = resultset.getString(1);
						String semester = resultset.getString(2);
						String avg = resultset.getString(3);
						String max = resultset.getString(4);
						String min = resultset.getString(5);
						String pass = resultset.getString(6);
						grade_view = new Grade_view(className, null, semester, avg, max, min, pass);
						list.add(grade_view);
						
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
	
	public List<Grade_view> findbyCoSe(String CourseName,String Semester) {
		//在这里定义，可用范围变大
		List<Grade_view> list = new ArrayList<>();
		
		Grade_view grade_view =null;
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
					String sql = "SELECT grade_view.CourseName,grade_view.Semester,AVG(grade_view.Grade) as 平均分,MAX(grade_view.Grade) as 最高分,MIN(grade_view.Grade) as 最低分,CONCAT((ROUND(COUNT(CASE WHEN grade_view.Grade >= 60 THEN 1 ELSE NULL END) * 100 / COUNT(*),2)),'%') as 及格率\r\n"
							+ "FROM `grade_view`\r\n"
							+ "GROUP BY grade_view.CourseName,grade_view.Semester";
					preparedStatement = connection.prepareStatement(sql);
					
					resultset = preparedStatement.executeQuery();
					//查询
					while(resultset.next()) {
						
						String courseName = resultset.getString(1);
						String semester = resultset.getString(2);
						String avg = resultset.getString(3);
						String max = resultset.getString(4);
						String min = resultset.getString(5);
						String pass = resultset.getString(6);
						grade_view = new Grade_view(null, courseName, semester, avg, max, min, pass);
						list.add(grade_view);
						
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
	
	public List<Grade_view> findbyCl(String ClassName) {
		//在这里定义，可用范围变大
		List<Grade_view> list = new ArrayList<>();
		
		Grade_view grade_view =null;
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
					String sql = "SELECT grade_view.ClassName,AVG(grade_view.Grade) as 平均分,MAX(grade_view.Grade) as 最高分,MIN(grade_view.Grade) as 最低分,CONCAT((ROUND(COUNT(CASE WHEN grade_view.Grade >= 60 THEN 1 ELSE NULL END) * 100 / COUNT(*),2)),'%') as 及格率\r\n"
							+ "FROM `grade_view`\r\n"
							+ "GROUP BY grade_view.ClassName";
					preparedStatement = connection.prepareStatement(sql);
					
					resultset = preparedStatement.executeQuery();
					//查询
					while(resultset.next()) {
						String className = resultset.getString(1);
						String avg = resultset.getString(2);
						String max = resultset.getString(3);
						String min = resultset.getString(4);
						String pass = resultset.getString(5);
						grade_view = new Grade_view(className, null ,null, avg, max, min, pass);
						list.add(grade_view);
						
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
	
	public List<Grade_view> findbyCo(String CourseName) {
		//在这里定义，可用范围变大
		List<Grade_view> list = new ArrayList<>();
		
		Grade_view grade_view =null;
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
					String sql = "SELECT grade_view.CourseName,AVG(grade_view.Grade) as 平均分,MAX(grade_view.Grade) as 最高分,MIN(grade_view.Grade) as 最低分,CONCAT((ROUND(COUNT(CASE WHEN grade_view.Grade >= 60 THEN 1 ELSE NULL END) * 100 / COUNT(*),2)),'%') as 及格率\r\n"
							+ "FROM `grade_view`\r\n"
							+ "GROUP BY grade_view.CourseName";
					preparedStatement = connection.prepareStatement(sql);
					
					resultset = preparedStatement.executeQuery();
					//查询
					while(resultset.next()) {
						
						String courseName = resultset.getString(1);
						String avg = resultset.getString(2);
						String max = resultset.getString(3);
						String min = resultset.getString(4);
						String pass = resultset.getString(5);
						grade_view = new Grade_view(null, courseName,null, avg, max, min, pass);
						list.add(grade_view);
						
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
	
	public List<Grade_view> findbySe(String Semester) {
		//在这里定义，可用范围变大
		List<Grade_view> list = new ArrayList<>();
		
		Grade_view grade_view =null;
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
					String sql = "SELECT grade_view.Semester,AVG(grade_view.Grade) as 平均分,MAX(grade_view.Grade) as 最高分,MIN(grade_view.Grade) as 最低分,CONCAT((ROUND(COUNT(CASE WHEN grade_view.Grade >= 60 THEN 1 ELSE NULL END) * 100 / COUNT(*),2)),'%') as 及格率\r\n"
							+ "FROM `grade_view`\r\n"
							+ "GROUP BY grade_view.Semester";
					preparedStatement = connection.prepareStatement(sql);
					
					resultset = preparedStatement.executeQuery();
					//查询
					while(resultset.next()) {
						
						String semester = resultset.getString(1);
						String avg = resultset.getString(2);
						String max = resultset.getString(3);
						String min = resultset.getString(4);
						String pass = resultset.getString(5);
						grade_view = new Grade_view(null,null, semester, avg, max, min, pass);
						list.add(grade_view);
						
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
}
