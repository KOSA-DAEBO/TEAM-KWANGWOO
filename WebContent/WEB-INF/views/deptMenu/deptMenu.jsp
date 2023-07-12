<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript" src="./js/deptScript.js"></script>
	<br>
	<div align="center">
		<select id="selectDept">
			<option id="insertDept">부서 추가</option>
			<option id="deleteDept">부서 삭제</option>
			<option id="updateDept">부서 변경</option>
		</select>&nbsp;&nbsp;
		<input type="button" value="확인" onclick="loadSelectedPage()">
		<br>
		<div id="content">
			<jsp:include page="insertDept.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>