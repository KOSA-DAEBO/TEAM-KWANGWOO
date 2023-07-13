<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
	<form action="updateDept.do" method="post">
		<div align="center">
			부서번호<br> 
			<input type="number" id="deptNo"><br> 
			부서이름<br>
			<input type="text" id="deptName"><br>
		</div>
		<br>
		<input type="submit" value="수 정">&nbsp;&nbsp;
		<input type="reset" value="취 소">
	</form>
</body>
</html>