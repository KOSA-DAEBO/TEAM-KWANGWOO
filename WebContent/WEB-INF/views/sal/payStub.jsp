<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team KwangWoo</title>

</head>
<body>
	<br>
	<br>
	
	<c:set var="amount" value="${map.amount}"/>
	
	<table class="type09">
		<thead>
			<tr>
				<th scope="col">지급 항목</th>
				<td scope="col">금액</td>
				<th scope="col">공제 항목</th>
				<td scope="col">금액</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">기본급</th>
				<td><input type="text" name="salary" id="salary"
					value="${map.salary}" readonly></td>
				<th scope="row">국민연금</th>
				<td><input type="text" name="expense1" id="expense1"
					value="${map.NP}" readonly></td>
			</tr>
			<tr>
				<th scope="row">식대</th>
				<td><input type="text" name="allowance1" id="allowance1"
					value="200000" readonly></td>
				<th scope="row">건강보험</th>
				<td><input type="text" name="expense2" id="expense2"
					value="${map.HI}" readonly></td>
			</tr>
			<tr>
				<th scope="row">직급수당</th>
				<td><input type="text" name="allowance2" id="allowance2"
					value="${map.rankAllowance }" readonly></td>
				<th scope="row">고용보험</th>
				<td><input type="text" name="expense3" id="expense3"
					value="${map.EI}" readonly></td>
			</tr>
			<tr>
				<th scope="row">연장근로수당</th>
				<td><input type="text" name="allowance3" id="allowance3" value="0" readonly></td>
				<th scope="row">장기요양보험</th>
				<td><input type="text" name="expense4" id="expense4"
					value="${map.CI}" readonly></td>
			</tr>
			<tr>
				<th scope="row">지급 총액</th>
				<td class="totalA"><input type="text" name="totalAllowance"
					id="totalAllowance" value="${map.totalAllowance}" readonly="readonly"></td>
				<th scope="row">공제 총액</th>
				<td class="totalE"><input type="text" name="totalExpense"
					id="totalExpense" value="${map.totalExpense}" readonly="readonly"></td>
			</tr>
		</tbody>
	</table>

		<table class="type071">
			<tbody>
				<tr>
					<th scope="row" colspan="2">총 급여액</th>
					<td colspan="2">&nbsp; &nbsp; &nbsp; &nbsp; <input type="text" name="total" id="total"
						value="<fmt:formatNumber value="${amount*10000}" pattern="#"/>" readonly="readonly"></td>
				</tr>
			</tbody>
		</table>

</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>