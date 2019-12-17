<%@page import="org.entity.UserInfo"%>
<%@page import="org.entity.Teacher"%>
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
//		Teacher	teacher = (Teacher)request.getAttribute("teacher");
		Teacher	teacher = (Teacher)request.getAttribute("teacher");
		%>
		欢迎登录！<%
		String name = teacher.getTname();
		out.print(name);
		%>老师，以下是您的个人信息<br/>
		<!-- 通过表单展示老师信息 -->
		<form action="UpdateTeacherServlet">
			账号：<input type="text" name="tno" value="<%=teacher.getTno()%>"  readonly = "readonly"/></br>
			姓名：<input type="text" name="tname" value="<%=teacher.getTname() %> " readonly = "readonly"/></br>
			年龄：<input type="text" name="tage" value="<%=teacher.getTage()%>" readonly = "readonly"/></br>
			院系：<input type="text" name="depart" value="<%=teacher.getDepart()%>" readonly = "readonly"/></br>
			<input type="submit" value="修改"/>
			<a href="QueryAllTeacherServlet">返回</a>
		</form>
		
		下载作业:<a href="DownloadServlet?filename=work.docx">作业</a>

</body>
</html>