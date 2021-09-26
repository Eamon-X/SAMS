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
import com.eamon.entity.Teacher;

import com.eamon.repository.TeacherRepository;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private TeacherRepository teacherRepository =new TeacherRepository();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
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
					List<Teacher> list = teacherRepository.findAll();
					System.out.println(list);
					//数据
					request.setAttribute("list", list);
					//视图
					request.getRequestDispatcher("teacherManage.jsp").forward(request, response);
					break;
				
				case "deleteByteacherId" :
					
					String teacherIdString = request.getParameter("teacherId");
					System.out.println(teacherIdString);
					Integer teacherId = Integer.parseInt(teacherIdString);
					
					
					teacherRepository.deleteByteacherId(teacherId);
					response.sendRedirect("TeacherServlet");
					break;
				}
				
			}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String TeacherName = request.getParameter("teacherName");
		String TeacherSex = request.getParameter("teacherSex");
		String teacherIdstString = request.getParameter("teacherId");
		Integer TeacherId = Integer.parseInt(teacherIdstString);
		
		
		teacherRepository.add(TeacherName,TeacherSex,TeacherId);
		response.sendRedirect("TeacherServlet");
	}

}
