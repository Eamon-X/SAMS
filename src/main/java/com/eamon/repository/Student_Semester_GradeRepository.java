package com.eamon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.eamon.entity.Student_Semester_Grade;

public class Student_Semester_GradeRepository {
	
	public List<Student_Semester_Grade> find(String StudentId,String Semester) {
		//在这里定义，可用范围变大
		List<Student_Semester_Grade> list = new ArrayList<>();
	
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
					String sql = "SELECT\r\n"
							+ "	`student`.`StudentId`,\r\n"
							+ "	`student`.`StudentName`,\r\n"
							+ "	`grade`.`Semester`,\r\n"
							+ "	avg( `grade`.`Grade` )\r\n"
							+ "FROM\r\n"
							+ "	(\r\n"
							+ "		`student` \r\n"
							+ "		JOIN `grade` ON ((\r\n"
							+ "				`student`.`StudentId` = `grade`.`StudentId` \r\n"
							+ "			)) ) where student.StudentId = ? AND Semester = ?\r\n"
							+ "GROUP BY\r\n"
							+ "	`student`.`StudentId`,\r\n"
							+ "	`student`.`StudentName`,\r\n"
							+ "	`grade`.`Semester`";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1,StudentId);
					preparedStatement.setString(2,Semester);
					resultset = preparedStatement.executeQuery();
					Student_Semester_Grade student_Semester_Grade =null;
					//查询
					while(resultset.next()) {
						String studentId = resultset.getString(1);
						String studentName = resultset.getString(2);
						String semester = resultset.getString(3);
						String avg = resultset.getString(4);
						
						student_Semester_Grade = new Student_Semester_Grade(studentId,studentName, semester, avg);
						list.add(student_Semester_Grade);
						
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
