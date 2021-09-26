package com.eamon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eamon.entity.Classroom;

import com.eamon.repository.ClassRepository;


/**
 * Servlet implementation class ClassroonSerlvet
 */
@WebServlet("/ClassroomServlet")
public class ClassroomSerlvet extends HttpServlet {
	private ClassRepository classRepository =new ClassRepository();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassroomSerlvet() {
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
			List<Classroom> list = classRepository.findAll();
			System.out.println(list);
			//数据
			request.setAttribute("list", list);
			//视图
			request.getRequestDispatcher("classManage.jsp").forward(request, response);
			break;
		
		
		case "deleteByclassName" :
			
			String className = request.getParameter("className");
			System.out.println(className);
			classRepository.deleteByclassName(className);
			response.sendRedirect("ClassroomServlet");
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
			String className = request.getParameter("className");
			
			classRepository.add(className);
			response.sendRedirect("ClassroomServlet");
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
