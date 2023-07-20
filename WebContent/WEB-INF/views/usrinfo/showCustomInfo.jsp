 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team KwangWoo</title>
</head>
<body>
	<div align="center">
		<table>
			<tr>
				<td>계정</td>
				<td>${loginCustomer.usrId }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${loginCustomer.customerName }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${loginCustomer.customerAddr }</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${loginCustomer.customerTel }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${loginCustomer.customerEmail }</td>
			</tr>
			<tr>
				<td>성별:</td>
				<td><c:choose>
						<c:when test="${loginCustomer.customerGender == '1'  }">
								남
							</c:when>
						<c:when test="${loginCustomer.customerGender == '0'  }">
								여
							</c:when>
					</c:choose></td>
			</tr>
			<tr>
				<td>생년월일:</td>
				<td>${loginCustomer.customerBirth }</td>
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