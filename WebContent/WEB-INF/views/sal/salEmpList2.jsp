<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/nice-forms.css@0.1.7/dist/nice-forms.css" />
<meta charset="UTF-8">
<title>Team KwangWoo</title>
<script type="text/javascript" src="./js/leaveScript.js"></script>
</head>

<body>
	<br>
	<br>

	<table class="type091">
		<thead>
			<tr>
				<th scope="col" colspan="10">급여 기록 전 리스트</th>
			</tr>
		</thead>
		<c:forEach var="list" items="${list}">
			<tbody>
				<tr>
					<th scope="row">사번</th>
					<td class="empnumber"><a
						href="salApply.do?sNo=${list.get('empNo')}">${list.get('empNo')}</a></td>
					<th scope="row">이름</th>
					<td>${list.get('empName')}</td>
					<th scope="row">부서</th>
					<td>${list.get('deptName')}</td>
					<th scope="row">직급</th>
					<td>${list.get('posName')}</td>
					<th scope="row">기본급</th>
					<td>${list.get('salary')}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>


</body>
</html>