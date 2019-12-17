<%@page import="org.service.impl.StudentServiceImpl"%>
<%@page import="org.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示全部信息</title>
</head>
<body>
	<%
		//error:adderror 失败
		//否则：1.确实执行力增加，2.第一次访问
		String error = (String) request.getAttribute("error");
		if(error!=null){
			if(error.equals("addError")){
				out.print("增加失败");
			}else if(error.equals("success")){
				out.print("增加成功");
			}else{//根本没有执行增加
				
			}
		}
	%>
	<table border="1px">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>地址</th>
			<th>操作</th>
		</tr>
			<%
				//获取request域中的数据
				List<Student> students = (List<Student>)request.getAttribute("students") ;
				for(Student student:students){
			%>
					<tr>
						<td><a href="QueryStudentBySnoServlet?sno=<%=student.getSno() %>"><%=student.getSno() %></a> </td>
						<td><%=student.getSname() %></td>
						<td><%=student.getSage() %></td>
						<td><%=student.getSaddress() %></td>
						<td> <a href="DeleteStudentServlet?sno=<%=student.getSno() %> ">删除</a> </td>
						
					</tr>
			<%
				}
			%>
	</table>
	<a href="addstudent.jsp">新增</a>
</body>
</html>