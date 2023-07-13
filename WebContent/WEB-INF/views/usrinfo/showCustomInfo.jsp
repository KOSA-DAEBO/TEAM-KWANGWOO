<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, edu.kosa.third.dto.*"%>
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
		<table border="1">
			<c:forEach items="${customList}" var="customList">
				<tr>
					<td>계정</td>
					<td>${customList.customerNo }</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${customList.customerName }</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>${customList.customerAddr }</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>${customList.customerTel }</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>${customList.customerEmail }</td>
				</tr>
				<tr>
					<td>성별:</td>
					<td><c:choose>
							<c:when test="${customList.customerGender == '1'  }">
								남
							</c:when>
							<c:when test="${customList.customerGender == '0'  }">
								여
							</c:when>
						</c:choose></td>
				</tr>
				<tr>
					<td>생년월일:</td>

					<td>${customList.customerBirth }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<h1 align="center">
		<input type="button" value="돌아가기" onclick="location.href='index.html'">
	</h1>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>