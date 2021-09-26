package com.eamon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eamon.entity.Classroom;
import com.eamon.entity.Course;
import com.eamon.entity.Course_view;
import com.eamon.entity.Teaching;
import com.eamon.entity.Teaching_view;
import com.eamon.repository.CourseRepository;
import com.eamon.repository.Course_viewRepository;
import com.eamon.repository.Teaching_viewRepository;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private CourseRepository courseRepository =new CourseRepository();
	private Teaching_viewRepository teaching_viewRepository = new Teaching_viewRepository();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String method = request.getParameter("method");
		if (method == null) {
			method = "findAll";
		}
		switch (method){
		case "findAll": 
			//返回视图+数据
			List<Course> courselist = courseRepository.findAll();
			//数据
			request.setAttribute("courselist", courselist);
			//视图
			List<Teaching_view> teaching_viewlist = teaching_viewRepository.findAll();
			request.setAttribute("teaching_viewlist", teaching_viewlist);
			request.getRequestDispatcher("courseManage.jsp").forward(request, response);
			break;
		
		
		case "deleteBycourseName" :
			
			String courseName = request.getParameter("courseName");
			courseRepository.deleteBycourseName(courseName);
			response.sendRedirect("CourseServlet");
			break;
		
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + method);
		}
		
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String method = request.getParameter("method");
		switch (method){
		case "add": {
			//获取数据
			String courseName = request.getParameter("courseName");
			
			String courseHourString = request.getParameter("courseHour");
			Integer courseHour = Integer.parseInt(courseHourString);
			
			String credirString = request.getParameter("credit");
			Integer credit = Integer.parseInt(credirString);
			
			courseRepository.add(courseName,courseHour,credit);
			response.sendRedirect("CourseServlet");
			break;
		}
		/*case "update": {
			String studentIdString = request.getParameter("studentId");
			double studentId = Double.parseDouble(studentIdString);
			String studentName = request.getParameter("studentName");
			String sex = request.getParameter("sex");
			String className = request.getParameter("className");
			studentRepository.update(studentId, studentName, sex, className);
			response.sendRedirect("StudentServlet");
			break;
		}*/
		default:
			throw new IllegalArgumentException("Unexpected value: " + method);
		}
		
		
		
	}
	

}
