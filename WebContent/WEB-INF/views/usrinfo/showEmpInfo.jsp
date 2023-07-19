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
			<form class="infoList">
				<div id="allempinfo">
					<c:forEach items="${empList}" var="empList">
						<div id="simpleInfoAll">
							<div>
								<a href="manageEmpInfo.do?empNo=${empList.empNo }"> 
									<img src="#" alt="#" onerror="this.onerror=null;
									 this.src='./images/usericon.png';">
								</a>
							</div>
							<div>
								이 름<a href="manageEmpInfo.do?empNo=${empList.empNo }">${empList.empName}</a>
							</div>
							<div>
								입사일<a href="manageEmpInfo.do?empNo=${empList.empNo }">${empList.hireDate}</a>
							</div>
						</div>
					</c:forEach>
				</div>
				<div id="pagionation">
					<button type="button" id="prevButton" disabled>이전</button>
					<button type="button" id="nextButton">다음</button>
				</div>
			</form>
		</div>
	</div>
	<br>
	<div id="empButtonHome">
		<input type="button" value="돌아가기" onclick="location.href='index.html'">
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>
