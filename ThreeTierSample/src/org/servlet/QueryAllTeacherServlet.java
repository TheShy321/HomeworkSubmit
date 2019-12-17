package org.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.entity.Teacher;
import org.service.ITeacherService;
import org.service.impl.TeacherServiceImpl;

public class QueryAllTeacherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		ITeacherService service = new TeacherServiceImpl();
		List<Teacher> teachers = service.queryAllTeachers();
		//System.out.println(students);
		request.setAttribute("teachers", teachers);
		//四个作用域
		//pageContext<request<session<application

		request.getRequestDispatcher("showallteacher.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
