<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, edu.kosa.third.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 정보 수정</title>
</head>
<body>
	<div id="usrcontainer" align="center">
		<table id="usrinfo">
			<tr>
				<td>이름</td>
				<td><input type="text" value="${empInfo.empdto.empName}"
					placeholder="${empInfo.empdto.empName}"></td>
			</tr>
			<tr>
				<td>사번</td>
				<td>${empInfo.empdto.empNo}</td>
			</tr>
			<tr>
				<td>계정</td>
				<td>${empInfo.empdto.usrId}</td>
			</tr>
			<tr>
				<td>부서</td>
				<td>${empInfo.deptdto.deptName}</td>
			</tr>
			<tr>
				<td>직위</td>
				<td>${empInfo.posdto.posName}</td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" value="${empInfo.empdto.empAddr}"
					placeholder="${empInfo.empdto.empAddr}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" value="${empInfo.empdto.empTel}"
					placeholder="${empInfo.empdto.empTel}"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><c:choose>
						<c:when test="${empInfo.empdto.empGender == '1'  }">
								남
							</c:when>
						<c:when test="${empInfo.empdto.empGender == '0'  }">
								여
							</c:when>
					</c:choose></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" value="${empInfo.empdto.empEmail}"
					placeholder="${empInfo.empdto.empEmail}"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>${empInfo.empdto.empBirth}</td>
			</tr>
			<tr>
				<td>입사일</td>
				<td>${empInfo.empdto.hireDate}</td>
			</tr>
			<tr>
				<td>휴가상태</td>
				<td>${empInfo.empdto.annualLeave}일</td>
			</tr>
			<tr>
				<td>출근상태</td>
				<td><c:choose>
						<c:when test="${empInfo.empdto.empStatus == true}">
				                출근
				            </c:when>
						<c:when test="${empInfo.empdto.empStatus == false}">
				                결근
				            </c:when>
					</c:choose></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수 정"> <input
					type="reset" value="취 소"></td>
			</tr>
		</table>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>