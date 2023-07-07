<%@page import="edu.kosa.third.dto.EmpDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, edu.kosa.third.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<c:forEach items="${empMap}" var="empMap">
					<td>
						<table>
							<tr>
								<td colspan="2" width="200px" height="200px"><input
									type="hidden" name="empid" value="${empid}"></td>
							</tr>
							<tr>
								<th>이 름</th>
								<td class="modalButton">${empMap.empName}</td>
							</tr>
							<tr>
								<th>사 번</th>
								<td class="modalButton">${empMap.empNo}</td>
							</tr>
							<tr>
								<th>입사일</th>
								<td class="modalButton">${empMap.hireDate}</td>
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
	<jsp:include page="/WEB-INF/views/selectinfo/modal.jsp" />
</body>
</html>
