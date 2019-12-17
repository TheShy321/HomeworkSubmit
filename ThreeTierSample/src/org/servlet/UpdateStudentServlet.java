package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Student;
import org.service.IStudentService;
import org.service.impl.StudentServiceImpl;

public class UpdateStudentServlet extends HttpServlet {
	//修改
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//获取待修改的人的学号
		int no = Integer.parseInt(request.getParameter("sno"));
		//获取修改后的内容
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		
		//将修改后的字段封装到一个实体类中
		Student student = new Student(name,age,address);
		
		//调用service
		IStudentService service = new StudentServiceImpl();
		boolean result = service.updateStudentBySno(no, student);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		//显示结果
		if(result) {
			response.getWriter().println("修改成功！");
			response.sendRedirect("QueryAllStudentsServlet");//修改完毕后查询全部学生信息并显示
		}else {
			response.getWriter().println("修改失败！");
			
		}
		
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
