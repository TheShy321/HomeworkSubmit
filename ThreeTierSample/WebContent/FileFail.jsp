<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<form action="UploadServet" method="post"  enctype="multipart/form-data">
			文件上传失败！</br>
			作业类型有误！格式只能是txt doc pdf docx 或者文件太大</br>
			请重新上传！</br>
			上传作业: <input type="file"  name="homework"/>
			<br/>
			<input type="submit" value="提交"/>
		</form>
</body>
</html>