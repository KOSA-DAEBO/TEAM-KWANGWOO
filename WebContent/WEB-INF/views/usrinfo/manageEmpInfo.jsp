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
	<div id="usrcontainer">
		<table id="usrinfo">
			<tr>
				<td rowspan="14" id="usrimage"><input type="file" value="사진추가"
					accept="image/png, image/gif, image/jpeg"></td>
			  </tr>
			<tr>
				<td class="usrinfocategory">이름</td>
				<td class="usrinfocontent">${empInfo.empdto.empName}</td>
			</tr>
			<tr>
				<td class="usrinfocategory">사번</td>
				<td class="usrinfocontent">${empInfo.empdto.empNo}</td>
			</tr>
			<tr>
				<td class="usrinfocategory">계정</td>
				<td class="usrinfocontent">${empInfo.empdto.usrId}</td>
			</tr>
			<tr>
				<td class="updateDept">부서</td>
				<td class="updateDeptRadio">
					<input type="radio" value="5" name="pos"/>발령전
					<input type="radio" value="10" name="pos"/>경영관리
					<input type="radio" value="20" name="pos"/>기획
					<input type="radio" value="30" name="pos"/>마케팅<br>
					<input type="radio" value="40" name="pos"/>영상
					<input type="radio" value="50" name="pos"/>개발
					<input type="radio" value="60" name="pos"/>영업
					<input type="radio" value="70" name="pos"/>생산
				</td>
			</tr>
			<tr>
				<td class="updatePos">직위</td>
				<td class="updatePosRadio">
				<div>
					<input type="radio" value="10" name="pos"/>대표이사
					<input type="radio" value="20" name="pos"/>이사
					<input type="radio" value="30" name="pos"/>부장
					<input type="radio" value="40" name="pos"/>차장<br>
					<input type="radio" value="50" name="pos"/>과장
					<input type="radio" value="60" name="pos"/>대리
					<input type="radio" value="70" name="pos"/>주임
					<input type="radio" value="80" name="pos"/>사원
					<input type="radio" value="100" name="pos"/>인턴<br>
					<input type="radio" value="5" name="pos"/>임시직
				</div>
			</td>
			</tr>
			<tr>
				<td class="usrinfocategory">주소</td>
				<td class="usrinfocontent">${empInfo.empdto.empAddr}</td>
			</tr>
			<tr>
				<td class="usrinfocategory">전화번호</td>
				<td class="usrinfocontent">${empInfo.empdto.empTel}</td>
			</tr>
			<tr>
				<td class="usrinfocategory">성별</td>
				<td class="usrinfocontent"><c:choose>
						<c:when test="${empInfo.empdto.empGender == '1'  }">
								남
							</c:when>
						<c:when test="${empInfo.empdto.empGender == '0'  }">
								여
							</c:when>
					</c:choose></td>
			</tr>
			<tr>
				<td class="usrinfocategory">이메일</td>
				<td class="usrinfocontent">${empInfo.empdto.empEmail}</td>
			</tr>
			<tr>
				<td class="usrinfocategory">생년월일</td>
				<td class="usrinfocontent">${empInfo.empdto.empBirth}</td>
			</tr>
			<tr>
				<td class="usrinfocategory">입사일</td>
				<td class="usrinfocontent">${empInfo.empdto.hireDate}</td>
			</tr>
			<tr>
				<td class="usrinfocategory">휴가상태</td>
				<td class="usrinfocontent">${empInfo.empdto.annualLeave}일</td>
			</tr>
			<tr>
				<td class="usrinfocategory">출근상태</td>
				<td class="usrinfocontent"><c:choose>
						<c:when test="${empInfo.empdto.empStatus == true}">
				                출근
				            </c:when>
						<c:when test="${empInfo.empdto.empStatus == false}">
				                결근
				            </c:when>
					</c:choose></td>
			</tr>
			<tr>
				<td><input type="submit" id="usrupdate" value="수 정"></td>
				<td><input type="reset" id="usrreset" value="취 소"></td>
			</tr>

		</table>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>