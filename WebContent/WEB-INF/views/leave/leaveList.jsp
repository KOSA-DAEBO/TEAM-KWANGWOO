<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>leaveList.jsp</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #ddd;
	text-align: center;
}
</style>
</head>
<body>
<h1>휴가 리스트</h1>
	<table>
		<tr>
			<th>휴가 번호</th>
			<th>사번</th>
			<th>휴가 종류</th>
			<th>휴가 시작일</th>
			<th>휴가 종료일</th>
			<th>승인 여부</th>
		</tr>
		<c:forEach var="list" items="${ list }">
			<c:if test="${list.typeNo==10}">
				<c:set var="type" value="연차" />
			</c:if>
			<c:if test="${list.typeNo==20}">
				<c:set var="type" value="공가" />
			</c:if>
			<c:if test="${list.typeNo==30}">
				<c:set var="type" value="병가" />
			</c:if>
			<c:if test="${list.typeNo==40}">
				<c:set var="type" value="특별휴가" />
			</c:if>
			<c:if test="${list.levStatus==0}">
				<c:set var="status" value="승인 대기" />
			</c:if>
			<c:if test="${list.levStatus==1}">
				<c:set var="status" value="승인" />
			</c:if>
			<c:if test="${list.levStatus==2}">
				<c:set var="status" value="반려" />
			</c:if>
			<tr>
				<td>${ list.leaveNo }</td>
				<td>${ list.empNo }</td>
				<td>${type}</td>
				<td>${ list.startDay }</td>
				<td>${ list.endDay }</td>
				<td>${ status }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="leave.do">휴가 등록</a>
</body>
</html>