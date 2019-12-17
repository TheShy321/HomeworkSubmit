package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Student;
import org.service.IStudentService;
import org.service.impl.StudentServiceImpl;

public class StudentLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int id =Integer.parseInt( request.getParameter("userid")) ;
		IStudentService service = new StudentServiceImpl();
		Student student = service.queryStudentBySno(id);
		//System.out.println(student);
		
		//将此人的信息通过前台jsp显示success.jsp
		request.setAttribute("student", student);
		//如果request域没有数据，使用重定向response.sendRedirect();
		//如果request域有数据，(request.setAttribute()),使用请求转发跳转;
		request.getRequestDispatcher("success.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
