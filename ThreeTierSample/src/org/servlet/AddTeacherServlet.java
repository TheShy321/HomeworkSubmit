package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.entity.Teacher;
import org.service.ITeacherService;
import org.service.impl.TeacherServiceImpl;

public class AddTeacherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt( request.getParameter("tno"));
		String name =  request.getParameter("tname");
		int age = Integer.parseInt( request.getParameter("tage") );
		String depart = request.getParameter("depart");
		String password = request.getParameter("password");
		Teacher teacher = new Teacher(no,name,age,depart,password);
		
		//接口 x = new 实现类（）;
		ITeacherService teacherService = new TeacherServiceImpl();
		
		boolean result = teacherService.addTeacher(teacher);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		/*
		if(result) {
			out.println("增加成功!");
			response.sendRedirect("QueryAllStudentsServlet");
			
		}else {
			out.println("增加失败!");
			response.sendRedirect("QueryAllStudentsServlet");
		}*/
		if(!result) {//增加失败，给request放入一条error字段
			request.setAttribute("error", "addError");
		}else {//增加成功
			request.setAttribute("error","success");
		}
		//response.sendRedirect("QueryAllStudentsServlet");
		request.getRequestDispatcher("QueryAllTeacherServlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
