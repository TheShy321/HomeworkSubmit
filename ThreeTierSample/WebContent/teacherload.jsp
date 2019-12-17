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
		Teacher	teacher = (Teacher)request.getAttribute("teacher");
		%>
		欢迎登录！<%
		String name = teacher.getTname();
		out.print(name);
		%>老师，以下是您的个人信息<br/>
		<!-- 通过表单展示此人信息 -->
		<form action="UpdateTeacherServlet">
			账号：<input type="text" name="tno" value="<%=teacher.getTno() %>"  readonly = "readonly"/></br>
			姓名：<input type="text" name="tname" value="<%=teacher.getTname()%>"  readonly = "readonly"/></br>
			年龄：<input type="text" name="tage" value="<%=teacher.getTage()%>"  readonly = "readonly"/></br>
			院系：<input type="text" name="depart" value="<%=teacher.getDepart()%>"   readonly = "readonly"/></br>
			修改个人信息<input type="submit" value="修改"/>
			<a href="UpdateTeacherServlet"></a></br>	
		</form>
		<a href="DownloadServlet?filename=MIME.png">MIME</a>

</body>
</html>