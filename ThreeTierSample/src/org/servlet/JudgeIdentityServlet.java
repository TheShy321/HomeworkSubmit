package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Student;
import org.entity.Teacher;
import org.service.IStudentService;
import org.service.ITeacherService;
import org.service.impl.StudentServiceImpl;
import org.service.impl.TeacherServiceImpl;


public class JudgeIdentityServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String role = request.getParameter("role");
		
		if( role.equals("学生") ) {
			int no =Integer.parseInt( request.getParameter("userid")) ;
			IStudentService service = new StudentServiceImpl();
			
			if( service.isExist(no)) {
				Student student = service.queryStudentBySno(no);
				request.setAttribute("student", student);
				//如果request域没有数据，使用重定向response.sendRedirect();
				//如果request域有数据，(request.setAttribute()),使用请求转发跳转;
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}else {
				response.sendRedirect("userlogin.jsp");
			}
			
		}else if(role.equals("教师")){
			int no = Integer.parseInt( request.getParameter("userid"));
			ITeacherService service = new TeacherServiceImpl();

			if( service.isExist(no)) {
				Teacher teacher = service.queryTeacherBySno(no);
				request.setAttribute("teacher", teacher);
				//如果request域没有数据，使用重定向response.sendRedirect();
				//如果request域有数据，(request.setAttribute()),使用请求转发跳转;
				request.getRequestDispatcher("teacherInfo.jsp").forward(request, response);
			}else {
				response.sendRedirect("userlogin.jsp");
			}
			//System.out.println(student);
			
			//将此人的信息通过前台jsp显示teacherInfo.jsp
			
			//response.sendRedirect("teacherLogin.jsp");
			//response.sendRedirect("teacherInfo.jsp");
		}else {
			response.sendRedirect("userlogin.jsp");
		}
		//如果request域没有数据，使用重定向response.sendRedirect();
		//如果request域有数据，(request.setAttribute()),使用请求转发跳转;

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
