package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.entity.Teacher;
import org.service.ITeacherService;
import org.service.impl.TeacherServiceImpl;

public class UpdateTeacherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//获取待修改的人的账号
		int no = Integer.parseInt(request.getParameter("tno"));
		//获取修改后的内容
		String name = request.getParameter("tname");
		int age = Integer.parseInt(request.getParameter("tage"));
		String depart = request.getParameter("depart");
		
		//将修改后的字段封装到一个实体类中
		Teacher teacher = new Teacher(name,age,depart);
		
		//调用service
		ITeacherService service = new TeacherServiceImpl();
		
		boolean result = service.updateTeacherBySno(no, teacher);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		//显示结果
		if(result) {
			response.getWriter().println("修改成功！");
			response.sendRedirect("QueryAllTeacherServlet");//修改完毕后查询全部老师信息并显示
		}else {
			response.getWriter().println("修改失败！");
			
		}
		
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
