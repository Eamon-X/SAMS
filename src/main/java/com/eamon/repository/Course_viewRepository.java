package com.eamon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.eamon.entity.Course_view;

public class Course_viewRepository {
	
	public List<Course_view> findAll() {
		//在这里定义，可用范围变大
		List<Course_view> list = new ArrayList<>();
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
					String sql = "select * from course_view";
					preparedStatement = connection.prepareStatement(sql);
					resultset = preparedStatement.executeQuery();
					Course_view course_view = null;
					while(resultset.next()) {
						String CourseName = resultset.getString(1);
						Integer CourseHour = resultset.getInt(2);
						Integer Credit = resultset.getInt(3);
						String TeacherName = resultset.getString(4);
						//Integer TeacherId = resultset.getInt(5);
						Integer TeacherId = null;
						//Integer Grade = (Integer)resultset.getInt(3);
						if (resultset.getObject("TeacherId") != null) {
							TeacherId = resultset.getInt("TeacherId");
	                   }
						
						
						
						course_view= new Course_view( CourseName, CourseHour, Credit,TeacherName,TeacherId);
						list.add(course_view);
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
