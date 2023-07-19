<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team KwangWoo</title>

<script type="text/javascript">
window.addEventListener("DOMContentLoaded", function() {
	  // 페이지 로드 시 초기화 작업
	  const listSize = parseInt(document.getElementById("listSize").value);
	  const itemsPerPage = 8; // 페이지당 아이템 수
	  let currentPage = 1; // 현재 페이지

	  // 페이지 업데이트 함수
	  function updatePage() {
	    const cards = document.querySelectorAll(".card_list > div");
	    const totalPages = Math.ceil(listSize / itemsPerPage); // 전체 페이지 수

	    // 각 아이템마다 보여줄지 여부 결정
	    cards.forEach(function(card, index) {
	      if (index >= (currentPage - 1) * itemsPerPage && index < currentPage * itemsPerPage) {
	        card.style.display = "grid"; // 해당 페이지의 아이템은 보이도록 설정
	      } else {
	        card.style.display = "none"; // 나머지 아이템은 숨김 처리
	      }
	    });

	    // 이전 버튼 활성화/비활성화 상태 업데이트
	    const prevButton = document.getElementById("prevButton");
	    if (currentPage === 1) {
	      prevButton.disabled = true; // 첫 페이지일 경우 비활성화
	    } else {
	      prevButton.disabled = false; // 첫 페이지가 아닐 경우 활성화
	    }

	    // 다음 버튼 활성화/비활성화 상태 업데이트
	    const nextButton = document.getElementById("nextButton");
	    if (currentPage === totalPages) {
	      nextButton.disabled = true; // 마지막 페이지일 경우 비활성화
	    } else {
	      nextButton.disabled = false; // 마지막 페이지가 아닐 경우 활성화
	    }
	  }

	  // 이전 버튼 클릭 이벤트 처리
	  document.getElementById("prevButton").addEventListener("click", function() {
	    if (currentPage > 1) {
	      currentPage--; // 이전 페이지로 이동
	      updatePage(); // 페이지 업데이트
	    }
	  });

	  // 다음 버튼 클릭 이벤트 처리
	  document.getElementById("nextButton").addEventListener("click", function() {
	    const totalPages = Math.ceil(listSize / itemsPerPage); // 전체 페이지 수
	    if (currentPage < totalPages) {
	      currentPage++; // 다음 페이지로 이동
	      updatePage(); // 페이지 업데이트
	    }
	  });

	  // 초기 페이지 로드 시 페이지 업데이트
	  updatePage();
	});
</script>
</head>
<body>
	<br>
	<br>
	<div class="leave_content">
		<div class="name">휴가 전체 목록</div>
		<table>
			<tr>
				<td><select name="searchField">
						<option value="deptName">부서 이름</option>
						<option value="posName">직급 이름</option>
						<option value="startDay">휴가 시작일</option>
						<option value="endDay">휴가 종료일</option>
				</select></td>
			</tr>
		</table>
		<table class="type07">
			<thead>
				<tr>
					<th scope="col" onclick="sortTableByColumn(0)">신청 번호</th>
					<th scope="col">사원 이름</th>
					<th scope="col">사번</th>
					<th scope="col">부서 이름</th>
					<th scope="col">직급 이름</th>
					<th scope="col">휴가 종류</th>
					<th scope="col" onclick="sortTableByColumn(6)">휴가 시작일</th>
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
	<form action="leaveList.do" class="levForm" method="post">
		<input type="hidden" name="listNum" id="listNum" value="2"> <input
			type="submit" class="leaveButton2" value="승인 대기 중인 휴가 확인">
	</form>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>