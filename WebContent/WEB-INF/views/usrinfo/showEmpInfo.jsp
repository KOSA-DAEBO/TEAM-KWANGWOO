<%@page import="edu.kosa.third.dto.EmpDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, edu.kosa.third.dto.*"%>
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
					<!-- If the count is a multiple of 5 and not the first index, close the current row and start a new row -->
					<c:if test="${status.count % 6 == 0 && status.count != 1}">
			</tr>
			<tr>
				</c:if>
				<td>
					<table>
						<tr>
							<td colspan="2"><br> <a href="manageEmpInfo.do"> 
								<img	src="./images/usericon.png"
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
