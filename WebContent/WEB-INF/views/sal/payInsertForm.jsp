<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team KwangWoo</title>

</head>
<body>

국민연금 <c:out value="${map.NP}"/>
건강보험<c:out value="${map.HI}"/>
고용보험<c:out value="${map.EI}"/>
장기요양보험<c:out value="${map.CI}"/>

	<form action="leaveApply.do" method="post">
		<div class="nice-form-group">
			<label>사원 이름</label> <input type="text" id="empName"
				name="empName">
		</div>
		<div class="nice-form-group">
			<label>휴가 시작일</label> <input type="date" id="startDay"
				name="startDay">
		</div>
		<div class="nice-form-group">
			<label>휴가 종료일</label> <input type="date" id="endDay" name="endDay">
		</div>
		<div class="nice-form-group">
			<label>휴가 사유</label>
			<textarea name="reason" id="reason" cols="30" rows="10"></textarea>
		</div>
		<div align="center">
			<input type="submit" value="전송">
		</div>
	</form>
</body>
</html>