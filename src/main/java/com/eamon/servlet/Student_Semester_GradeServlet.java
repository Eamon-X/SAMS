package com.eamon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eamon.entity.Student_Semester_Grade;
import com.eamon.repository.Student_Semester_GradeRepository;

/**
 * Servlet implementation class Student_Semester_GradeServlet
 */
@WebServlet("/Student_Semester_GradeServlet")
public class Student_Semester_GradeServlet extends HttpServlet {
	private Student_Semester_GradeRepository student_Semester_GradeRepository =new Student_Semester_GradeRepository();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_Semester_GradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String StudentId = request.getParameter("studentId");
		String Semester = request.getParameter("semester");
		
		List<Student_Semester_Grade> list = student_Semester_GradeRepository.find(StudentId,Semester);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("student_semester_grade.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
