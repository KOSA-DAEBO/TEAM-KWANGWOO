<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team KwangWoo</title>
<script type="text/javascript" src="./js/leaveScript.js"></script>
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
		<div class="name">이번달 급여 목록</div>

		<form name=formformff action="salList.do" method=post>
				<select name="field">
					<option value="selection">선택</option>
					<option value="empNo">사번</option>
					<option value="empName">사원 이름</option>
					<option value="deptName">부서 이름</option>
					<option value="posName">직급 이름</option>
				</select> <input onmouseover="this.focus()" type="text" id="search"
					name="search" placeholder="찾을 내용을 입력하세요">
				<button type="button" onclick=dataCheck() class="btn btn-defaults">검색</button>
		</form>
		
		<table class="type07">
			<thead>
				<tr>
					<th scope="col">지급 연월</th>
					<th scope="col">지급 총액</th>
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
						<th scope="row"><a
							href="leaveList.do?No=${list.get('leaveNo')}">${list.get('payMonth')}</a></th>
						<td>${list.get('amount')}</td>
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

	<form class="levForm" action="salList.do" method="post">
		<input type="hidden" name="slistNum" id="slistNum" value="1"> <input
			type="submit" class="leaveButton" value="급여 기록 추가">
	</form>
	
	
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>