<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="manageDept.do" method="post">
		<div align="center">
			<select>
				<option id="insertDept">부서 추가</option>
				<option id="deleteDept">부서 삭제</option>
				<option id="updateDept">부서 변경</option>
			</select>
			<input type="submit" value="확인">
		</div>
	</form>
</body>
</html>