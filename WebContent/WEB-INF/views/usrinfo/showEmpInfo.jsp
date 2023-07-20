<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script defer="defer" type="text/javascript" src="./js/empScript.js"></script>
<meta charset="UTF-8">
<title>Team KwangWoo</title>
</head>
<body>
	<div id="empinfoContent">
		<div id="simpleList">
			<div class="deptListName">부서 관리</div>
			<div id="allempinfo">
				<c:forEach items="${empList}" var="empList">
					<div id="simpleInfoAll">
						<div class="usrImage">
							<a href="manageEmpInfo.do?empNo=${empList.empNo }"> 
								<img src="#" alt="#" onerror="this.onerror=null;
								 this.src='./images/usericon.png';">
							</a>
						</div>
						<div class="usrInfo" onclick="javascript:location.href='manageEmpInfo.do?empNo=${empList.empNo}'">
							<div>이 름</div>
							<div>${empList.empName}</div>
							<div>입사일</div>
							<div>${empList.hireDate}</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div id="pagionation">
				<button type="button" id="prevButton" disabled>이전</button>
				<button type="button" id="nextButton">다음</button>
			</div>
		</div>
	</div>
	<br>
	<div id="empButtonHome">
		<button type="button" onclick="javascript:location.href='commuteEmpChk.do'" >돌아가기</button>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>
