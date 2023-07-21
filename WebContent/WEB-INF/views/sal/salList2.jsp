<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team KwangWoo</title>
<script defer="defer" type="text/javascript" src="./js/leaveScript.js"></script>
</head>

<body>
	<br>
	<br>
	<div class="leave_content2">
		<div class="name">나의 급여 목록</div>

		<table class="type07">
			<thead>
				<tr>
					<th scope="col">지급 연월</th>
					<th scope="col">실수령액</th>
					<th scope="col">사원 이름</th>
					<th scope="col">사번</th>
					<th scope="col">부서 이름</th>
					<th scope="col">직급 이름</th>
					<th scope="col">지급일</th>
					<th scope="col">기본급</th>
				</tr>
			</thead>
			<c:forEach var="list" items="${ list }">
				<tbody>
					<tr>
						<th scope="row">${list.get('payMonth')}</th>
						<td><a
							href="salPayStub.do?empNo=${list.get('empNo')}&payDay=${list.get('payDay')}&applyPath=1">${list.get('amount')}</a></td>
						<td>${list.get('empName')}</td>
						<td>${list.get('empNo')}</td>
						<td>${list.get('deptName')}</td>
						<td>${list.get('posName')}</td>
						<td>${list.get('payDay')}</td>
						<td>${list.get('salary')}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>


</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>