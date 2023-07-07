<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, edu.kosa.third.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원개인정보 페이지</title>
</head>
<body>
	<table align="center" border="1">
		<tr>
			<th>사용자 계정</th>
			<td>${customMap.get("usrId") }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${customMap.get("customerName") }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${customMap.get("customerAddr") }</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${customMap.get("customerTel") }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${customMap.get("customerEmail") }</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${customMap.get("customerGender") }</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>${customMap.get("customerBirth") }</td>
		</tr>
	</table>
	<br>
	<h1 align="center">
		<input type="button" value="돌아가기" onclick="location.href='index.html'">
	</h1>
</body>
</html>