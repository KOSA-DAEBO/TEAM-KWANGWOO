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
<title>leaveDetail.jsp</title>

<script type="text/javascript">
	function approve() {
		alert('승인 처리하였습니다.');
		location.href = 'leaveApprove.do'
	}
</script>

<script type="text/javascript">
	function reject() {
		alert('반려 처리하였습니다.');
		location.href = 'leaveApprove.do'
	}
</script>

</head>

<body>
	<br>
	<br>

	<table class="type09">
		<c:forEach var="list" items="${ list }">
			<thead>
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
				<c:set var="leaveNo" value="${list.get('leaveNo')}" scope="session" />
				<c:set var="levStatus" value="${list.get('levStatus')}"
					scope="session" />
				<c:set var="typeNo" value="${list.get('typeNo')}" scope="session" />
				<c:set var="startDay" value="${list.get('startDay')}"
					scope="session" />
				<c:set var="endDay" value="${list.get('endDay')}" scope="session" />
				<c:set var="enpNo" value="${list.get('enpNo')}" scope="session" />
				<tr>
					<th scope="col">신청 번호</th>
					<td scope="col">${list.get('leaveNo')}</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">사번</th>
					<td>${list.get('empNo')}</td>
					<th scope="row">이름</th>
					<td>${list.get('empName')}</td>
				</tr>
				<tr>
					<th scope="row">부서</th>
					<td>${list.get('deptName')}</td>
					<th scope="row">직급</th>
					<td>${list.get('posName')}</td>
				</tr>
				<tr>
					<th scope="row">휴가 시작일</th>
					<td>${list.get('startDay')}</td>
					<th scope="row">휴가 종료일</th>
					<td>${list.get('endDay')}</td>
				</tr>
				<tr>
					<th scope="row">휴가 종류</th>
					<td>${type}</td>
					<th scope="row">휴가 사유</th>
					<td>${list.get('reason')}</td>
				</tr>
				<tr>
					<th scope="row">전화번호</th>
					<td>${list.get('empTel')}</td>
					<th scope="row">이메일</th>
					<td>${list.get('empEmail')}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<c:set var="app" value="1" />
	<c:set var="rej" value="2" />
	<br>
	<table class="type02">
		<tr>
			<th>
				<form action="leaveApprove.do" method="post">
					<input type="hidden" name="approveType" id="approveType"
						value="${app}"> <input type="submit" value="승인"
						class="lbutton">
				</form>
			</th>
			<th>
				<form action="leaveApprove.do" method="post">
					<input type="hidden" name="approveType" id="approveType"
						value="${rej}"> <input type="submit" value="거절"
						class="lbutton">
				</form>
			</th>
			<th>
				<form action="leaveApprove.do" method="post">
					<input type="hidden" name="approveType" id="approveType"
						value="${rej}"> <input type="submit" value="수정"
						class="lbutton">
				</form>
			</th>
			<th>
				<form action="leaveDelete.do" method="post">
					<input type="hidden" name="leaveNo" id="leaveNo" value="${leaveNo}">
					<input type="submit" value="삭제" class="lbutton">
				</form>
			</th>
		</tr>
	</table>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>