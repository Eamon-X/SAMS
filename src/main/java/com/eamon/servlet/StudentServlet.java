package com.eamon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eamon.entity.Classroom;
import com.eamon.entity.Student;
import com.eamon.repository.ClassRepository;
import com.eamon.repository.StudentRepository;


/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	
	private StudentRepository studentRepository =new StudentRepository();
	private ClassRepository classRepository =new ClassRepository();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
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
			List<Student> studentlist = studentRepository.findAll();
			System.out.println(studentlist);
			//数据
			request.setAttribute("studentlist", studentlist);
			//视图
			request.getRequestDispatcher("studentManage.jsp").forward(request, response);
			break;
		
		case "add": {
			List<Classroom> classroomlist = classRepository.findAll();
			
			request.setAttribute("classroomlist", classroomlist);
			request.getRequestDispatcher("studentAdd.jsp").forward(request, response);
			break;
		}
		
		case "deleteBystudentId" :
			
			String studentIdString = request.getParameter("studentId");
			
			Double studentId = Double.parseDouble(studentIdString);
			
			
			studentRepository.deleteBystudentId(studentId);
			response.sendRedirect("StudentServlet");
			break;
		
			
		case "findBystudentId" :
			List<Classroom> classroomlist = classRepository.findAll();
			
			request.setAttribute("classroomlist", classroomlist);
			
			
			studentIdString = request.getParameter("studentId");
			System.out.println(studentIdString);
			studentId = Double.parseDouble(studentIdString);
			System.out.println(studentId);
			request.setAttribute("student", studentRepository.findBystudentId(studentId));
			request.getRequestDispatcher("studentUpdate.jsp").forward(request, response);
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
			String studentIdString = request.getParameter("studentId");
			Double studentId = Double.parseDouble(studentIdString);
			String studentName = request.getParameter("studentName");
			String sex = request.getParameter("sex");
			String className = request.getParameter("className");
			
			studentRepository.add(studentId, studentName, sex, className);
			response.sendRedirect("StudentServlet");
			break;
		}
		case "update": {
			
			
			String studentIdString = request.getParameter("studentId");
			double studentId = Double.parseDouble(studentIdString);
			String studentName = request.getParameter("studentName");
			String sex = request.getParameter("sex");
			String className = request.getParameter("className");
			studentRepository.update(studentId, studentName, sex, className);
			response.sendRedirect("StudentServlet");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + method);
		}
		
		
		
	}

}
