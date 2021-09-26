package com.eamon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.eamon.entity.Teaching_view;

public class Teaching_viewRepository {
	public List<Teaching_view> findAll() {
		//在这里定义，可用范围变大
		List<Teaching_view> list = new ArrayList<>();
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
					String sql = "select * from teaching_view";
					preparedStatement = connection.prepareStatement(sql);
					resultset = preparedStatement.executeQuery();
					Teaching_view teaching_view=null;
					while(resultset.next()) {
						String CourseName = resultset.getString(1);
						String TeacherName = resultset.getString(2);
						int TeacherId = resultset.getInt(3);
						
						teaching_view = new Teaching_view(CourseName,TeacherName,TeacherId);
						list.add(teaching_view);
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
