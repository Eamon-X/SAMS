package com.eamon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.eamon.entity.Course;
import com.eamon.entity.Grade;
import com.eamon.entity.Student;

import com.eamon.repository.CourseRepository;
import com.eamon.repository.GradeRepository;
import com.eamon.repository.StudentRepository;


/**
 * Servlet implementation class GradeServlet
 */
@WebServlet("/GradeServlet")
public class GradeServlet extends HttpServlet {
	private GradeRepository gradeRepository =new GradeRepository();
	private StudentRepository studentRepository =new StudentRepository();
	private CourseRepository courseRepository =new CourseRepository();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Student> studentlist = null;
		List<Grade> gradelist = null;
		
				String method = request.getParameter("method");
				if (method == null) {
					method = "findAll";
				}
				switch (method){
				case "findAll": 
					List<Grade> list = gradeRepository.findAll();
					
					studentlist = studentRepository.findAll();
					gradelist = gradeRepository.findAll();
					request.setAttribute("studentlist", studentlist);
					request.setAttribute("gradelist", gradelist);
					//数据
					
					request.setAttribute("list", list);
					//视图
					request.getRequestDispatcher("gradeManage.jsp").forward(request, response);
					break;
				
				case "add": {
					
					List<Course> courselist = courseRepository.findAll();
					studentlist = studentRepository.findAll();
					request.setAttribute("courselist", courselist);
					request.setAttribute("studentlist", studentlist);
					request.getRequestDispatcher("courseSelection.jsp").forward(request, response);
					
					
					break;
				}
				
				case "findBystudentIdandcourseName" :
					
					
				
					String studentId = request.getParameter("studentId");
					
					
					String courseName = request.getParameter("courseName");
					
					request.setAttribute("grade", gradeRepository.findBystudentIdandCourseName(studentId,courseName));
					request.getRequestDispatcher("gradeUpdate.jsp").forward(request, response);
					break;
				
				case "deleteBystudentIdandcourseName" :{
					
					studentId = request.getParameter("studentId");
					
					courseName = request.getParameter("courseName");
					
					
					gradeRepository.deleteBystudentIdandcourseName(studentId,courseName);
					response.sendRedirect("GradeServlet");
					break;
				}
					
				
					
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
		case "update" : {
			String studentId = request.getParameter("studentId");
			
			String courseName = request.getParameter("courseName");
			String gradeString = request.getParameter("grade");
			int grade = Integer.parseInt(gradeString);
			
			gradeRepository.update(studentId, courseName, grade);
			response.sendRedirect("GradeServlet");
			break;
		}
		
		case "add" :{
		
		//获取数据
		request.setCharacterEncoding("UTF-8");
		String studentIdString =request.getParameter("studentId");
		Double studentId = Double.parseDouble(studentIdString);
		String courseName = request.getParameter("courseName");
		String semester = request.getParameter("semester");
		
		
		gradeRepository.add(studentId, courseName, semester);
		
		response.sendRedirect("GradeServlet");
	}
		}}	
}
