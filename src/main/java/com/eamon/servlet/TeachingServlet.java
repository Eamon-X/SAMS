package com.eamon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eamon.entity.Course;
import com.eamon.entity.Teacher;
import com.eamon.entity.Teaching;
import com.eamon.repository.CourseRepository;
import com.eamon.repository.TeacherRepository;
import com.eamon.repository.TeachingRepository;

/**
 * Servlet implementation class TeachingServlet
 */
@WebServlet("/TeachingServlet")
public class TeachingServlet extends HttpServlet {
	private CourseRepository courseRepository =new CourseRepository();
	private TeacherRepository teacherRepository =new TeacherRepository();
	private TeachingRepository teachingRepository =new TeachingRepository();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachingServlet() {
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
			List<Teaching> list = teachingRepository.findAll();
			System.out.println(list);
			//数据
			request.setAttribute("list", list);
			//视图
			request.getRequestDispatcher("teachingManage.jsp").forward(request, response);
			break;
		
		case "add": {
			
			List<Course> courselist = courseRepository.findAll();
			List<Teacher> teacherlist = teacherRepository.findAll();
			request.setAttribute("courselist", courselist);
			request.setAttribute("teacherlist", teacherlist);
			request.getRequestDispatcher("teachingAdd.jsp").forward(request, response);
					
			break;
		}
		
		case "deleteBycourseNameandteacherId" :{

			String courseName = request.getParameter("courseName");
			
			String teacherIdString = request.getParameter("teacherId");
			Integer teacherId = Integer.parseInt(teacherIdString);
			
			
			teachingRepository.deleteBycourseNameandteacherId(courseName,teacherId);
			response.sendRedirect("CourseServlet");
			break;
		}
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
		
		
		case "add" :{
		
		//获取数据
		request.setCharacterEncoding("UTF-8");
		String courseName = request.getParameter("courseName");
		String teacherIdString =request.getParameter("teacherId");
		Integer teacherId = Integer.parseInt(teacherIdString);
		
		
		
		
		teachingRepository.add( courseName, teacherId);
		
		response.sendRedirect("CourseServlet");
	}
		}
	}

}
