package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Teacher;
import org.service.ITeacherService;
import org.service.impl.TeacherServiceImpl;

public class TeacherLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt( request.getParameter("tno"));
		ITeacherService service = new TeacherServiceImpl();
		Teacher teacher = service.queryTeacherBySno(no);
		//System.out.println(student);
		
		//将此人的信息通过前台jsp显示success.jsp
		request.setAttribute("teacher", teacher);
		//如果request域没有数据，使用重定向response.sendRedirect();
		//如果request域有数据，(request.setAttribute()),使用请求转发跳转;
		request.getRequestDispatcher("teacherInfo.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
