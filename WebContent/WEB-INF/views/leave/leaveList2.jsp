<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
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
	<div class="item_content">
		<div class="name">승인 대기 휴가 리스트</div>
		<table>
			<tr>
				<th>신청 번호</th>
				<th>사원 이름</th>
				<th>사번</th>
				<th>부서 이름</th>
				<th>직급 이름</th>
				<th>휴가 종류</th>
				<th>휴가 시작일</th>
				<th>휴가 종료일</th>
				<th>승인 여부</th>
				<th>연차 일수</th>
			</tr>
			<c:forEach var="list" items="${ list }">
				<c:if test="${list.get('typeNo')==10}">
					<c:set var="type" value="연차" />
				</c:if>
				<c:if test="${list.get('typeNo')==20}">
					<c:set var="type" value="공가" />
				</c:if>
				<c:if test="${list.get('typeNo')==30}">
					<c:set var="type" value="병가" />
				</c:if>
				<c:if test="${list.get('typeNo')==40}">
					<c:set var="type" value="특별휴가" />
				</c:if>
				<c:if test="${list.get('levStatus')==0}">
					<c:set var="status" value="승인 대기" />
				</c:if>
				<c:if test="${list.get('levStatus')==1}">
					<c:set var="status" value="승인" />
				</c:if>
				<c:if test="${list.get('levStatus')==2}">
					<c:set var="status" value="반려" />
				</c:if>
				<c:if test="${list.get('levStatus')==0}">
					<tr>
						<td><a href="leaveList.do?No=${list.get('leaveNo')}">${list.get('leaveNo')}</a></td>
						<td>${list.get('empName')}</td>
						<td>${list.get('empNo')}</td>
						<td>${list.get('deptName')}</td>
						<td>${list.get('posName')}</td>
						<td>${type}</td>
						<td>${list.get('startDay')}</td>
						<td>${list.get('endDay')}</td>
						<td>${ status }</td>
						<td>${list.get('annualLeave')}일</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
	<table>
		<tr>
			<td>
				<form action="leave.do" method="post">
					<input type="hidden" name="apply" id="apply" value="휴가신청">
					<input type="submit" value="휴가 등록">
				</form>
			</td>
			<td>
				<form action="leaveList.do" method="post">
					<input type="hidden" name="listNum" id="listNum" value="1">
					<input type="submit" value="전체 휴가 확인">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>