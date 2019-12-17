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
			var tno = $("#tno").val();
			var tpassword = $("#tpassword").val();
			if(!(tno>0 && tno < 9999999999)){
				alert("账号有误，请输入正确的账号");
				return false;
			}
			<!--if(!(sname.length > 1 && sname.length<5)){
				alert("姓名有误，必须是2-4位");
				return false;
			}-->
			if(!(tpassword.length > 5 && tpassword.length<15)){
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
		<form action="TeacherLoginServlet" method = "post" onsubmit="return check()">
			账号：<input  type = "text" name = "tno" id="tno"><br/>
			密码：<input type = "password" name = "tpassword" id = "tpassword"><br/>
		<input type = "submit" value = "登录">
		<a href="add.jsp">注册</a>
		
		</form>
</body>
</html>