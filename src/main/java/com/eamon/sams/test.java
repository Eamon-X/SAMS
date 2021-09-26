package com.eamon.sams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
	public static void main(String args[]) {

		//连接数据库
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/testaaa?useUnicode=ture&characterEncoding=UTF-8";
			String user ="root";
			String password ="";
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
}
