<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>leaveList.jsp</title>

<script type="text/javascript">
	function openModal() {
		var modal = document.getElementById("myModal");
		modal.style.display = "block";
	}

	function closeModal() {
		var modal = document.getElementById("myModal");
		modal.style.display = "none";
	}

	window.onclick = function(event) {
		var modal = document.getElementById("myModal");
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
</script>

</head>
<body>
	<h1>usrId님 보유하신 연차 일수는 %{annualLeave}일 입니다.</h1>
	<br><br>
	<div class="leave_content">
		<div class="name">휴가 신청 내역</div>
	<table class="type07">
		<thead>
			<tr>
				<th scope="col">신청 번호</th>
				<th scope="col">사원 이름</th>
				<th scope="col">사번</th>
				<th scope="col">부서 이름</th>
				<th scope="col">직급 이름</th>
				<th scope="col">휴가 종류</th>
				<th scope="col">휴가 시작일</th>
				<th scope="col">휴가 종료일</th>
				<th scope="col">승인 여부</th>
				<th scope="col">연차 일수</th>
			</tr>
		</thead>
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
			<tbody>
				<tr>
					<th scope="row"><a
						href="leaveList.do?No=${list.get('leaveNo')}">${list.get('leaveNo')}</a></th>
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
			</tbody>
		</c:forEach>
	</table>
	</div>
	<table class="type02">
		<tr>
			<td>
				<button onclick="openModal()">휴가 신청</button>
			</td>
			<td>
				<form action="leaveList.do" method="post">
					<input type="hidden" name="listNum" id="listNum" value="4">
					<input type="submit" value="승인 대기 중인 휴가 확인">
				</form>
			</td>
		</tr>
	</table>

	<div id="myModal" class="levmodal">
		<div class="modal_content">
			<jsp:include page="leaveApplicationForm.jsp" />
		</div>
	</div>

</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>