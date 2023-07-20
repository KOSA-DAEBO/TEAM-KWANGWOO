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
	<table>
		<tr>
			<td>이름</td>
			<td>계정</td>
		</tr>
		<c:forEach items="${customList}" var="customList">
		<tr>
			<td><a href="customManage.do?customerNo=${customList.customerNo }"> ${customList.customerName }</a></td>
			<td><a href="customManage.do?customerNo=${customList.customerNo }">${customList.usrId }</a></td>
		
		</tr>
		</c:forEach>
	</table>
	<button onclick="location.href='index.html'">돌아가기</button>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>