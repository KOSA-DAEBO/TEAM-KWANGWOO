<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team KwangWoo</title>
<script
	type="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
	function dataCheck() {
		if (document.getElementById("search").value == "") {
			alert("검색할 단어를 입력하세요");
			document.getElementById("search").focus();
			return;
		}
		document.form.submit();
	}		
</script>

</head>
<body>
	<br>
	<br>
	<div class="leave_content">
		<div class="name">휴가 전체 목록</div>

		<form name=form action="leaveList.do" method=post>
			<div class="form-group">
				<select name="field">
					<option value="selection">선택</option>
					<option value="empNo">사번</option>
					<option value="empName">사원 이름</option>
					<option value="deptName">부서 이름</option>
					<option value="posName">직급 이름</option>
				</select> <input onmouseover="this.focus()" type="text" id="search"
					name="search" placeholder="찾을 내용을 입력하세요">
				<button type="button" onclick=dataCheck() class="btn btn-default">검색</button>
			</div>
		</form>

		<table class="type07">
			<thead>
				<tr>
					<th scope="col" onclick="javajava()">신청 번호</th>
					<th scope="col">사원 이름</th>
					<th scope="col">사번</th>
					<th scope="col">부서 이름</th>
					<th scope="col">직급 이름</th>
					<th scope="col">휴가 종류</th>
					<th scope="col" onclick="sortTable()">휴가 시작일</th>
					<th scope="col">휴가 종료일</th>
					<th scope="col">승인 여부</th>
					<th scope="col">연차 일수</th>
				</tr>
			</thead>
			<tbody class="card_list">
				<c:forEach var="list" items="${ list }">
					<tr>
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
				</c:forEach>
			</tbody>
		</table>
	</div>
	<form action="leaveList.do" class="levForm" method="post">
		<input type="hidden" name="listNum" id="listNum" value="2"> <input
			type="submit" class="leaveButton2" value="승인 대기 중인 휴가 확인">
	</form>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>