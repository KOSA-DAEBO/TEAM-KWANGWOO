<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, edu.kosa.third.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 인사 관리</title>
</head>
<body>
	<br>
	<br>
	<br>
	<div align="center">
		<font color="red">인사 정보 변경하기</font>
		<table>
			<c:forEach items="${empList}" var="emplist">
				<tr>
					<td>이름:</td>
					<td>${emplist.empdto.empName}</td>
				</tr>
				<tr>
					<td>사번:</td>
					<td>${emplist.empdto.empNo}</td>
				</tr>
				<tr>
					<td>계정:</td>
					<td>${emplist.empdto.usrId}</td>
				</tr>
				<tr>
					<td>부서:</td>
					<td><input type="text" value="${emplist.deptdto.deptName}"
						placeholder="${emplist.deptdto.deptName}" id="deptName"></td>
				</tr>
				<tr>
					<td>직위:</td>
					<td>
					<input type="text" value="${emplist.posdto.posName}"
					placeholder="${emplist.posdto.posName}" id="posName"></td>
				</tr>
				<tr>
					<td>주소:</td>
					<td>${emplist.empdto.empAddr}</td>
				</tr>
				<tr>
					<td>전화번호:</td>
					<td>${emplist.empdto.empTel}</td>
				</tr>
				<tr>
					<td>성별:</td>
					<td><c:choose>
							<c:when test="${emplist.empdto.empGender == '1'  }">
								남
							</c:when>
							<c:when test="${emplist.empdto.empGender == '0'  }">
								여
							</c:when>
						</c:choose></td>
				</tr>
				<tr>
					<td>이메일:</td>
					<td>${emplist.empdto.empEmail}</td>
				</tr>
				<tr>
					<td>생년월일:</td>
					<td>${emplist.empdto.empBirth}</td>
				</tr>
				<tr>
					<td>입사일:</td>
					<td>${emplist.empdto.hireDate }</td>
				</tr>
				<tr>
					<td>사용 가능 휴가일:</td>
					<td>${emplist.empdto.annualLeave}일</td>
				</tr>
				<tr>
					<td>출근여부:</td>
					<td><c:choose>
							<c:when test="${emplist.empdto.empStatus == true}">
				                출근
				            </c:when>
							<c:when test="${emplist.empdto.empStatus == false}">
				                결근
				            </c:when>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			<tr><td colspan="2">
			<input type="submit" value="수 정">&nbsp;
			<input type="reset" value="취 소"></td>
			</tr>
		</table>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>