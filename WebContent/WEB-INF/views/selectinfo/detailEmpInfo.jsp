<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, edu.kosa.third.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>개인 정보 변경하기</h2>
		<c:forEach items="${empList}" var="emplist">
			<div>
				<div>
					<span>이름: </span> <span><input type="text"
						value="${emplist.emp.empName}"></span>
				</div>
				<div>
					<span>사번: </span> <span>${emplist.emp.empNo}</span>
				</div>
				<div>
					<span>계정: </span> <span>${emplist.emp.usrId}</span>
				</div>
				<div>
					<span>부서: </span> <span>${emplist.dept.deptName}</span>
				</div>
				<div>
					<span>직위: </span> <span>${emplist.pos.posName}</span>
				</div>
				<div>
					<span>주소: </span> <span><input type="text"
						value="${emplist.emp.empAddr}"
						placeholder="${emplist.emp.empAddr}" id="empAddr"></span>
				</div>
				<div>
					<span>전화번호: </span> <span><input type="text"
						value="${emplist.emp.empTel}" id="emptel"></span>
				</div>
				<div>
					<span>성별: </span> <span>
<!-- 					<input type="text" -->
<%-- 						value="${emplist.emp.empGender}" id="empGender">  --%>
						<c:choose>
							<c:when test="${emplist.emp.empGender == '1'  }">
								남
							</c:when>
							<c:when test="${emplist.emp.empGender == '0'  }">
								여
							</c:when>
						</c:choose> </span>
				</div>
				<div>
					<span>이메일: </span> <span><input type="text"
						value="${emplist.emp.empEmail}" id="empemail"></span>
				</div>
				<div>
					<span>생년월일: </span> <span>${emplist.emp.empBirth}</span>
				</div>
				<div>
					<span>입사일: </span> <span>${emplist.emp.hireDate }</span>
				</div>
				<div>
					<span>휴가상태: </span> <span>${emplist.emp.annualLeave}</span>
				</div>
				<div>
					<span>출근여부: </span> <span> 
						<c:choose>
							<c:when test="${emplist.emp.empStatus == true}">
				                출근
				            </c:when>
							<c:when test="${emplist.emp.empStatus == false}">
				                결근
				            </c:when>
						</c:choose>
					</span>
				</div>
		</c:forEach>
		<input type="submit" value="수 정">&nbsp; <input type="reset"
			value="취 소">
	</div>
</body>
</html>