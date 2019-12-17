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

public class AddStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt( request.getParameter("sno"));
		String name =  request.getParameter("sname");
		int age = Integer.parseInt( request.getParameter("sage") );
		String address = request.getParameter("saddress");
		String password = request.getParameter("spassword");
		Student student = new Student(no,name,age,address,password);
		
		//接口 x = new 实现类（）;
		IStudentService studentService = new StudentServiceImpl();
		
		boolean result = studentService.addStudent(student);
		
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
		request.getRequestDispatcher("QueryAllStudentsServlet").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
