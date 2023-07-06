<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>leaveApplicationForm</title>
</head>
<body>
	<form action="leaveApply.do" method="post">
		<h1>휴가 신청</h1>
		<table border="1">
			<tbody>
				<tr>
					<th>휴가 종류</th>
					<td><select name="leaveType" id="leaveType">
							<option value="10">연차</option>
							<option value="20">공가</option>
							<option value="30">병가</option>
							<option value="40">특별휴가</option>
					</select></td>
				</tr>
				<tr>
					<th>휴가 일자</th>
					<td><input type="date" id="startDay" name="startDay"> <input
						type="date" id="endDay" name="endDay"></td>
				</tr>
				<tr>
					<th>휴가 사유</th>
					<td><textarea name="reason" id="reason" cols="30" rows="10"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="전송">&nbsp;&nbsp;
						<input type="button" value="리스트"
						onclick="javascript:location.href='leaveList.do'" /></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>