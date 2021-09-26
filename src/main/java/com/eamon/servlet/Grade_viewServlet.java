package com.eamon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eamon.entity.Grade;
import com.eamon.entity.Grade_view;
import com.eamon.repository.ClassRepository;
import com.eamon.repository.Grade_viewRepository;

/**
 * Servlet implementation class Grade_viewServlet
 */
@WebServlet("/Grade_viewServlet")
public class Grade_viewServlet extends HttpServlet {
	private Grade_viewRepository grade_viewRepository =new Grade_viewRepository();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Grade_viewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String className = request.getParameter("className");
		String courseName = request.getParameter("courseName");
		String semester = request.getParameter("semester");
		List<Grade_view> list =null;
		if (className!=null&&courseName!=null&&semester!=null) {
			list = grade_viewRepository.find(className,courseName,semester);
		}
		else if (className!=null&&courseName!=null&&semester==null) {
			list = grade_viewRepository.findbyClCo(className,courseName);
		}
		else if (className!=null&&courseName==null&&semester!=null) {
			list = grade_viewRepository.findbyClSe(className,semester);
		}
		else if (className==null&&courseName!=null&&semester!=null) {
			list = grade_viewRepository.findbyCoSe(courseName,semester);
		}
		else if (className!=null&&courseName==null&&semester==null) {
			list = grade_viewRepository.findbyCl(className);
		}
		else if (className==null&&courseName!=null&&semester==null) {
			list = grade_viewRepository.findbyCo(courseName);
		}
		else if (className==null&&courseName==null&&semester!=null) {
			list = grade_viewRepository.findbySe(semester);
		}
		
		//数据
		
		request.setAttribute("list", list);
		//视图
		request.getRequestDispatcher("grade_viewManage.jsp").forward(request, response);
	}

}
