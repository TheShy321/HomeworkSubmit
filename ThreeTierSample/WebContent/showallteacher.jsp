<%@page import="org.service.impl.TeacherServiceImpl"%>
<%@page import="org.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示教师全部信息</title>
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
			<th>账号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>院系</th>
			<th>操作</th>
		</tr>
			<%
				//获取request域中的数据
				List<Teacher> teachers = (List<Teacher>)request.getAttribute("teachers") ;
				for(Teacher teacher:teachers){
			%>
					<tr>
						<td><a href="QueryTeacherByTnoServlet?tno=<%=teacher.getTno()%>"><%=teacher.getTno()%></a> </td>
						<td><%=teacher.getTname() %></td>
						<td><%=teacher.getTage() %></td>
						<td><%=teacher.getDepart() %></td>
						<td> <a href="DeleteTeacherServlet?tno=<%=teacher.getTno() %> ">删除</a> </td>
						
					</tr>
			<%
				}
			%>
	</table>
	<a href="add_teacher.jsp">新增</a>
</body>
</html>