package org.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取需要下载的文件名
		String fileName = request.getParameter("filename") ;//form  、a  href、 ...Server?a=b
		
		
		//下载文件：需要设置 消息头
		response.addHeader("content-Type","application/octet-stream" );//作业类型:二进制文件（任意文件）
		response.addHeader("content-Disposition","attachement;filename="+fileName );//fileName包含了文件后缀：abc.txt
		
		//Servlet通过文件的地址  将文件转为输入流 读到Servlet中
		//InputStream in = getServletContext().getResourceAsStream("/res/MIME.png") ;
		InputStream in = getServletContext().getResourceAsStream("/res/work.docx") ;
		
		//通过输出流 将 刚才已经转为输入流的文件  输出给用户
		ServletOutputStream out = response.getOutputStream() ;
		byte[] bs = new byte[20480];
		int len=-1 ;
		while(  (len=in.read(bs)) != -1) {
			out.write(bs,0,len);
		}
		out.close();
		in.close();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
