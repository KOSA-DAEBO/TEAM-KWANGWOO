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
	<div class="leave_content">
		<div class="name">${title} 급여목록</div>

		<form name="form" action="salList.do" method=post>
			<select name="field1">
				<option value="지급연도">지급연도</option>
				<option value="2023년">2023년</option>
				<option value="2022년">2022년</option>
			</select> <select name="field2">
				<option value="지급월">지급월</option>
				<option value="01월">01월</option>
				<option value="02월">02월</option>
				<option value="03월">03월</option>
				<option value="04월">04월</option>
				<option value="05월">05월</option>
				<option value="06월">06월</option>
				<option value="07월">07월</option>
				<option value="08월">08월</option>
				<option value="09월">09월</option>
				<option value="10월">10월</option>
				<option value="11월">11월</option>
				<option value="12월">12월</option>
			</select> <input type="submit" value="검색">
		</form>
		<div>
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
								href="salPayStub.do?empNo=${list.get('empNo')}&payDay=${list.get('payDay')}">${list.get('amount')}</a></td>
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
	</div>

	<form class="levForm" action="salList.do" method="post">
		<input type="hidden" name="slistNum" id="slistNum" value="1">
		<input type="submit" class="leaveButton" value="급여 기록 추가">
	</form>


</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>