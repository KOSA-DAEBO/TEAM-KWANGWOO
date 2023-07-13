<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/nice-forms.css@0.1.7/dist/nice-forms.css" />
<meta charset="UTF-8">
<title>leaveApplicationForm</title>
</head>
<body>
	<form action="leaveApply.do" method="post">
		<div class="nice-form-group">
			<label>휴가 종류</label> <select name="leaveType" id="leaveType">
				<option value="10">연차</option>
				<option value="20">공가</option>
				<option value="30">병가</option>
				<option value="40">특별휴가</option>
			</select>
		</div>
		<div class="nice-form-group">
			<label>휴가 시작일</label> <input type="date" id="startDay"
				name="startDay" value="${startDay}">
		</div>
		<div class="nice-form-group">
			<label>휴가 종료일</label> <input type="date" id="endDay" name="endDay"
				value="${endDay}">
		</div>
		<div class="nice-form-group">
			<label>휴가 사유</label>
			<textarea name="reason" id="reason" cols="30" rows="10">${reason}</textarea>
		</div>
		<div align="center">
			<input type="submit" value="전송">
		</div>
	</form>

</body>
</html>