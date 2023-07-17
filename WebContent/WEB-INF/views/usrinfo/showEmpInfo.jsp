<%@page import="edu.kosa.third.dto.EmpDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShowEmpInfo</title>
</head>
<body>
	<div align="center">
		<table align="center">
			<tr>
				<c:forEach items="${empList}" var="emplist" varStatus="status">
				 <c:if test="${status.count % 5 == 0}">
			</tr>
			<tr>
				</c:if>
				<td>
					<table>
						<tr>
							<td colspan="2"><br> <a href="manageEmpInfo.do"> <img
									onerror="this.onerror=null; this.src='./images/usericon.png';">
							</a></td>
						</tr>
						<tr>
							<th>이 름</th>
							<td>${emplist.empName}</td>
						</tr>
						<tr>
							<th>입사일</th>
							<td>${emplist.hireDate}</td>
						</tr>
					</table>
				</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	<br>
	<h1 align="center">
		<input type="button" value="돌아가기" onclick="location.href='index.html'">
	</h1>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>
