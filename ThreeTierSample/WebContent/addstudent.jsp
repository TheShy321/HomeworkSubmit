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
			var sname = $("#sname").val();
			var sage = $("#sage").val();
			var saddress = $("#saddress").val();
			var spassword = $("#spassword").val();
			if(!(sno>0 && sno < 9999999999)){
				alert("学号有误");
				return false;
			}
			if(!(sname.length > 1 && sname.length<5)){
				alert("姓名有误，必须是2-4位");
				return false;
			}
			if(!(sage>6 && sage < 101)){
				alert("年龄有误");
				return false;
			}
			if(!(spassword.length >5 && spassword.length<16)){
				alert("密码太短，请输入6-15位的密码！");
				return false;
			}
			return true;
		}
		$(document).ready(function(){
			
		});
	
	
	</script>
	
<title>增加学生个人信息</title>
</head>
	
<body>
	<form action="AddStudentServlet" method="post" onsubmit="return check()">
		学号：<input type="text" name="sno" id="sno"></br>
		姓名：<input type="text" name="sname" id="sname"></br>
		年龄：<input type="text" name="sage" id="sage"></br>
		地址：<input type="text" name="saddress" id="saddress"></br>
		密码：<input type="text" name="spassword" id="spassword"></br>
		<input type="submit" value="新增">
	</form>
</body>
</html>