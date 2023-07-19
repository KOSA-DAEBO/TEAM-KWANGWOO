<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="deptTable">
		<table>
			<tr>
				<td>부서 번호</td>
				<td>부서 이름</td>
			</tr>
			<c:forEach items="${deptList }" var="deptList">
				<tr>
					<td>${deptList.deptNo }</td>
					<td>${deptList.deptName }</td>
				</tr>
			</c:forEach>
		</table>
		<input type="button" value="돌아가기"
			onclick="location.href='deptMenu.do'">
	</div>
</body>
</html>