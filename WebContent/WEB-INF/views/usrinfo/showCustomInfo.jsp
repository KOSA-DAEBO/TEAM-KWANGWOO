<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원개인정보 페이지</title>
</head>
<body>
	<div align="center">
		<table>
			<tr>
				<td>계정</td>
				<td>${customInfo.usrId }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${customInfo.customerName }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${customInfo.customerAddr }</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${customInfo.customerTel }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${customInfo.customerEmail }</td>
			</tr>
			<tr>
				<td>성별:</td>
				<td><c:choose>
						<c:when test="${customInfo.customerGender == '1'  }">
								남
							</c:when>
						<c:when test="${customInfo.customerGender == '0'  }">
								여
							</c:when>
					</c:choose></td>
			</tr>
			<tr>
				<td>생년월일:</td>
				<td>${customInfo.customerBirth }</td>
			</tr>
		</table>
	</div>
	<br>
	<h1 align="center">
		<input type="button" value="돌아가기" onclick="location.href='index.html'">
	</h1>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>