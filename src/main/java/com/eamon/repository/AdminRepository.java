package com.eamon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eamon.entity.Admin;


public class AdminRepository {

	public static Admin findByAccount(String accountString, String passwordString) {
		//在这里定义，可用范围变大
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		Admin admin = null;
		//连接数据库
			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url ="jdbc:mysql://localhost:3306/sams?useUnicode=ture&characterEncoding=UTF-8";
					String user ="root";
					String password ="";
					connection = DriverManager.getConnection(url, user, password);
					String sql = "select * from admin where Account = ? and Password = ?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1,accountString);
					preparedStatement.setString(2,passwordString);
					resultset = preparedStatement.executeQuery();
					//查询
					while(resultset.next()) {
						String Account = resultset.getString(1);
						String Password = resultset.getString(2);
						
						admin = new Admin(Account,Password);
						
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
			return admin;
	}
}
