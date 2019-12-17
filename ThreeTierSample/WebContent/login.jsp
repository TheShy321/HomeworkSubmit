<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		function check() //true正常提交，false表单终止提交
		{
			var sno = $("#sno").val();
			var saddress = $("#spassword").val();
			if(!(sno>0 && sno < 9999999999)){
				alert("学号有误，请输入正确的学号");
				return false;
			}
			<!--if(!(sname.length > 1 && sname.length<5)){
				alert("姓名有误，必须是2-4位");
				return false;
			}-->
			if(!(sname.length > 5 && sname.length<15)){
				alert("密码有误，请输入6-14的正确密码");
				return false;
			}
			return true;
		}
		$(document).ready(function(){
			
		});

	</script>
<title>Insert title here</title>
</head>
<body>
		<form action="StudentLoginServlet" method = "post" onsubmit="return check()">
			学号：<input  type = "text" name = "sno" id="sno"><br/>
			密码：<input type = "password" name = "spassword" id = "spassword"><br/>
			身份：<select name="role" id="role">
					<option>-请选择-</option>
					<option>教师</option>
					<option>学生</option>
				</select>
			</br>
		<input type = "submit" value = "登录">
		<a href="addstudent.jsp">注册</a>
		</form>
</body>
</html>