<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서삭제페이지</title>
</head>
<body>
<br>
	<form action="deleteDept.do" method="post">
		<div align="center">
			부서이름<br> 
			<input type="text" id="deptName">
			<div align="center"><br>
			<br>
			<input type="submit" value="수 정">&nbsp;&nbsp;
			<input type="reset" value="취 소">
			</div>
		</div>
	</form>
</body>
</html>