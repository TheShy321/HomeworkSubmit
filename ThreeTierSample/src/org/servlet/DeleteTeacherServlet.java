package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.IStudentService;
import org.service.ITeacherService;
import org.service.impl.StudentServiceImpl;
import org.service.impl.TeacherServiceImpl;

public class DeleteTeacherServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//接受前端传来的账号
		int no =  Integer.parseInt(request.getParameter("tno"));
		
		ITeacherService service = new TeacherServiceImpl();
		boolean result = service.deleteTeacherBySno(no);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if(result) {
		//	response.getWriter().println("删除成功！");
			response.sendRedirect("QueryAllTeacherServlet");//重新查询所有学生
		}else {
			response.getWriter().println("删除失败！");
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
