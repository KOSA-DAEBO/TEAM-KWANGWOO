<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/customHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/customerScript.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<form action="changeCustomInfo.do" method="post" name="changeCustomerInfo" onsubmit="return checkCustomer();">
		<table id="usrinfo">
			<tr>
				<td class="usrinfoTitle">계정<input type="hidden" id="customNo"
					name="customNo" value="${customInfo.customerNo }"></td>
				<td class="usrinfoContent"><input type="text" id="customUsrId"
					name="customUsrId" readonly="readonly" value="${customInfo.usrId }"></td>
			</tr>
			<tr>
				<td class="usrinfoTitle">이름</td>
				<td class="usrinfoContent"><input type="text" id="customName"
					name="customName" value="${customInfo.customerName }"></td>
			</tr>
			<tr>
				<td class="usrinfoTitle">주소</td>
				<td class="usrinfoContent"><input type="text" id="customAddr"
					name="customAddr" value="${customInfo.customerAddr }"></td>
			</tr>
			<tr>
				<td class="usrinfoTitle">전화번호</td>
				<td class="usrinfoContent"><input type="text" id="customTel"
					name="customTel" value="${customInfo.customerTel }"></td>
			</tr>
			<tr>
				<td class="usrinfoTitle">이메일</td>
				<td class="usrinfoContent"><input type="text" id="customEmail"
					name="customEmail" value="${customInfo.customerEmail }"></td>
			</tr>
			<tr>
				<td class="usrinfoTitle">성별</td>
				<td class="usrinfoContent"><c:choose>
						<c:when test="${customInfo.customerGender == 1}">
							<span class="customGender">남</span>
						</c:when>
						<c:when test="${customInfo.customerGender == 0}">
							<span class="customGender">여</span>
						</c:when>
					</c:choose></td>
			</tr>
			<tr>
				<td class="usrinfoTitle">생년월일</td>
				<td class="usrinfoContent"><input type="text"
					id="customerBirth" name="customerBirth" readonly="readonly"
					value="${customInfo.customerBirth }"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="hidden" name="customerGender"value="${selectedValue}" />
					<input type="submit" id="updateBtn" value="수 정">
					<button type="button" onclick="javascript:location.href='departureCustom.do?customNo=${customInfo.customerNo }'" id="departureBtn">탈 퇴</button></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ include file="../../../fixed/customFooter.jsp"%>
