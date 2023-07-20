<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team KwangWoo</title>
<script type="text/javascript" src="./js/deptScript.js" defer="defer"></script>
</head>
<body>
<div id="verticalDept">
	<table class="deptList">
		<tr class="dept_head">
			<th>부서 번호</th>
			<th>부서 이름</th>
		</tr>
		<c:forEach var="list" items="${deptList}">
			<tr class="dept_body">
				<td>${list.deptNo}</td>
				<td>${list.deptName}</td>
			</tr>
		</c:forEach>
	</table>
	<div id="allDeptMenu">
		<select id="selectDept" onchange="changeContent()">
			<option value="insertDept">부서 추가</option>
			<option value="deleteDept">부서 삭제</option>
			<option value="updateDept">부서 변경</option>
		</select>
	</div>
	<div id="content"></div>
</div>



	<div hidden="" id="insertDept">
		<form action="insertDept.do" method="post">
			<div align="center"><br>
			<input type="text" placeholder="부서 이름" class="deptName" id="deptName" name="deptName"><br><br>
			<input type="number" placeholder="부서 번호" class="deptNo" id="deptNo" name="deptNo">
				<div class="deptBtn">
					<input type="submit" class="choiceBtn" value="추 가">
					<input type="reset" class="cancleBtn" value="취 소">
				</div>
			</div>
		</form>
	</div>

	<div hidden="" id="deleteDept">
		<form action="deleteDept.do" method="post">
			<div align="center"><br>
				<input type="text" placeholder="부서 이름" class="deptName" id="deptName" name="deptName"><br><br>
				<input type="number" class="deptNo" placeholder="부서 번호" id="deptNo" name="deptNo">
				<div class="deptBtn">
					 <input type="submit" class="choiceBtn" value="삭 제">
					<input type="reset" class="cancleBtn" value="취 소">
				</div>
			</div>
		</form>
	</div>

	<div hidden="" id="updateDept">
		<form action="updateDept.do" method="post">
			<div align="center"><br>
				<input type="text" id="deptName" placeholder="변경할 부서 이름" name="deptName" class="deptName"><br><br>
				<input type="text" id="deptNo" placeholder="기존 부서 번호" name="deptNo" class="deptNo">
				<div class="deptBtn">
					 <input type="submit" class="choiceBtn" value="수 정">
					<input type="reset" class="cancleBtn" value="취 소">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>