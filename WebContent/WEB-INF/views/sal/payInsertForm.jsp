<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team KwangWoo</title>
<script type="text/javascript" src="./js/salScript.js"></script>
</head>
<body>
	<br>
	<br>
	
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
				<td><input type="text" name="allowance3" id="allowance3"></td>
				<th scope="row">장기요양보험</th>
				<td><input type="text" name="expense4" id="expense4"
					value="${map.CI}" readonly></td>
			</tr>
			<tr>
				<th scope="row">지급 총액</th>
				<td class="totalA"><input type="text" name="totalAllowance"
					id="totalAllowance" value="0" readonly="readonly"></td>
				<th scope="row">공제 총액</th>
				<td class="totalE"><input type="text" name="totalExpense"
					id="totalExpense" value="0" readonly="readonly"></td>
			</tr>
		</tbody>
	</table>

	<form class="levForm" action="" method="post">
		<table class="type071">
			<tbody>
				<tr>
					<th scope="row" colspan="2">총 급여액</th>
					<td colspan="2">&nbsp; &nbsp; &nbsp; &nbsp; <input type="text" name="total" id="total"
						value="0" readonly="readonly"></td>
				</tr>
			</tbody>
		</table>

		<input type="hidden" name="empNo" id="empNo" value="${map.empNo}"> 

		<button type="button" class="leaveButton" onclick="Cal()">총 급여액
			계산</button>
		<input type="hidden" name="slistNum" id="slistNum" value="3"> <input
			type="submit" class="leaveButton" value="급여 확정">
	</form>

</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>