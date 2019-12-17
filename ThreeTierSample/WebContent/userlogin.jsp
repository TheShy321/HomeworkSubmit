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
			var sno = $("#userid").val();
			var password = $("#password").val();
			if(!(sno>0 && sno < 9999999999)){
				alert("账号有误，请输入正确的学号");
				return false;
			}
			<!--if(!(sname.length > 1 && sname.length<5)){
				alert("姓名有误，必须是2-4位");
				return false;
			}-->
			if(!(password.length > 5 && password.length<15)){
				alert("密码有误，请输入6-14的正确密码");
				return false;
			}
			return true;
		}
		$(document).ready(function(){
			
		});

	</script>
<title>用户登录</title>
</head>
<body>
		<form action="JudgeIdentityServlet" method = "post" onsubmit="return check()"> 
			账号：<input  type = "text" name = "userid" id="userid"><br/>
			密码：<input type = "password" name = "password" id = "password"><br/> 
			请输入您身份：学生或者教师</br>
			<input type = "text" name = "role" id = "role"><br/>
		<input type = "submit" value = "登录"></br>
		<a href="add_teacher.jsp">教师注册</a></br>
		<a href="addstudent.jsp">学生注册</a>
		
		</form>

</body>
</html>