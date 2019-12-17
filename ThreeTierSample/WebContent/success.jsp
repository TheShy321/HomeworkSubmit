<%@page import="java.io.PrintWriter"%>
<%@page import="org.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<%
		//Student	student = (Student)request.getAttribute("student");
		Student	student = (Student)request.getAttribute("student");
		%>
		欢迎登录！<%
		String name = student.getSname();
		out.print(name);
		%>同学，以下是您的个人信息<br/>
		<!-- 通过表单展示此人信息 -->
		<form action="UpdateStudentServlet">
			学号：<input type="text" name="sno" value="<%=student.getSno() %>"  readonly = "readonly"/></br>
			姓名：<input type="text" name="sname" value="<%=student.getSname() %>"  readonly = "readonly"/></br>
			年龄：<input type="text" name="sage" value="<%=student.getSage()%>"  readonly = "readonly"/></br>
			地址：<input type="text" name="saddress" value="<%=student.getSaddress()%>"   readonly = "readonly"/></br>
			修改个人信息<input type="submit" value="修改"/>
			<a href="UpdateStudentServlet"></a></br>	
		</form>
		<form action="UploadServet" method="post"  enctype="multipart/form-data">
			上传作业: <input type="file"  name="homework"/>
			<br/>
			<input type="submit" value="提交"/>
		</form>
		
</body>
</html>