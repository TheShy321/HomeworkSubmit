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
			var tname = $("#tname").val();
			var tage = $("#tage").val();
			var depart = $("#depart").val();
			var password = $("#password").val();
			if(!(tno>0 && tno < 9999999999)){
				alert("账号有误");
				return false;
			}
			if(!(tname.length > 1 && tname.length<5)){
				alert("姓名有误，必须是2-4位");
				return false;
			}
			if(!(tage>6 && tage < 101)){
				alert("年龄有误");
				return false;
			}
			if(!(password.length >5 && password.length<16)){
				alert("密码太短，请输入6-15位的密码！");
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
	<form action="AddTeacherServlet" method="post" onsubmit="return check()">
		账号：<input type="text" name="tno" id="tno"></br>
		姓名：<input type="text" name="tname" id="tname"></br>
		年龄：<input type="text" name="tage" id="tage"></br>
		院系：<input type="text" name="depart" id="depart"></br>
		密码：<input type="text" name="password" id="password"></br>
		<input type="submit" value="新增">
	</form>
</body>
</html>