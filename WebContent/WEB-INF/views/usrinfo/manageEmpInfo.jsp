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
	<form action="updateManageEmpInfo.do" method="post">
		<table id="usrinfo">
			<tr>
				<td rowspan="15" id="usrimage"><img src="#" alt="#"
					onerror="this.onerror=null; this.src='./images/usericon.png';"><input
					type="file" value="사진추가" accept="image/png, image/gif, image/jpeg"></td>
			</tr>
			<tr>
				<td class="usrinfocategory">이름</td>
				<td class="usrinfocontent">
				<input type="text" id="empName" name="empName" placeholder="${empDto.empName}"></td>
			</tr>
			<tr>
				<td class="usrinfocategory">사번</td>
				<td class="usrinfocontent">
				<input type="hidden" id="empNo" name="empNo" value="${empDto.empNo}">
				${empDto.empNo}</td>
			</tr>
			<tr>
				<td class="usrinfocategory">계정</td>
				<td class="usrinfocontent">${empDto.usrId}</td>

			</tr>
			<tr>
				<td class="updateDept">부서</td>
				<td class="updateDeptRadio">
					<div id="empDeptList">
						<input type="radio" value="5" name="deptNo" ${empDto.deptNo == "5" ? "checked" : ""}/>발령전
						<input type="radio" value="10" name="deptNo"${empDto.deptNo == "10" ? "checked" : ""}/>경영관리
						<input type="radio" value="20" name="deptNo"${empDto.deptNo == "20" ? "checked" : ""}/>기획
						<input type="radio" value="30" name="deptNo"${empDto.deptNo == "30" ? "checked" : ""}/>마케팅<br>
						<input type="radio" value="40" name="deptNo"${empDto.deptNo == "40" ? "checked" : ""}/>영상
						<input type="radio" value="50" name="deptNo"${empDto.deptNo == "50" ? "checked" : ""}/>개발
						<input type="radio" value="60" name="deptNo"${empDto.deptNo == "60" ? "checked" : ""}/>영업
						<input type="radio" value="70" name="deptNo" ${empDto.deptNo == "70" ? "checked" : ""}/>생산
					</div>
				</td>
			</tr>
			<tr>
				<td class="updatePos">직위</td>
				<td class="updatePosRadio">
					<div id="empPosList">
						<input type="radio" value="10" name="posNo"  ${empDto.posNo == "10" ? "checked" : ""}/>대표이사
						<input type="radio" value="20" name="posNo"  ${empDto.posNo == "20" ? "checked" : ""}/>이사
						<input type="radio" value="30" name="posNo"  ${empDto.posNo == "30" ? "checked" : ""}/>부장
						<input type="radio" value="40" name="posNo"  ${empDto.posNo == "40" ? "checked" : ""}/>차장<br>
						<input type="radio" value="50" name="posNo"  ${empDto.posNo == "50" ? "checked" : ""}/>과장
						<input type="radio" value="60" name="posNo"  ${empDto.posNo == "60" ? "checked" : ""}/>대리
						<input type="radio" value="70" name="posNo"  ${empDto.posNo == "70" ? "checked" : ""}/>주임
						<input type="radio" value="80" name="posNo"  ${empDto.posNo == "80" ? "checked" : ""}/>사원
						<input type="radio" value="100" name="posNo" ${empDto.posNo == "100" ? "checked" : ""}/>인턴<br>
						<input type="radio" value="5" name="posNo"  ${empDto.posNo == "5" ? "checked" : ""}/>임시직
					</div>
				</td>
			</tr>
			<tr>
				<td class="usrinfocategory">주소</td>
				<td class="usrinfocontent">${empDto.empAddr}</td>
			</tr>
			<tr>
				<td class="usrinfocategory">전화번호</td>
				<td class="usrinfocontent">${empDto.empTel}</td>
			</tr>
			<tr>
				<td class="usrinfocategory">성별</td>
				<td class="usrinfocontent"><c:choose>
						<c:when test="${empDto.empGender == '1'  }">
						남
					</c:when>
						<c:when test="${empDto.empGender == '0'  }">
						여
					</c:when>
					</c:choose></td>
			</tr>
			<tr>
				<td class="usrinfocategory">이메일</td>
				<td class="usrinfocontent">${empDto.empEmail}</td>
			</tr>
			<tr>
				<td class="usrinfocategory">생년월일</td>
				<td class="usrinfocontent">${empDto.empBirth}</td>
			</tr>
			<tr>
				<td class="usrinfocategory">입사일</td>
				<td class="usrinfocontent">${empDto.hireDate}</td>
			</tr>
			<tr>
				<td class="usrinfocategory">휴가상태</td>
				<td class="usrinfocontent">${empDto.annualLeave} 일</td>
			</tr>
			<tr>
				<td class="usrinfocategory">출근상태</td>
				<td class="usrinfocontent"><c:choose>
						<c:when test="${empDto.empStatus == true}">
				                출근
				            </c:when>
						<c:when test="${empDto.empStatus == false}">
				                결근
				            </c:when>
					</c:choose></td>
			</tr>
			<tr>
				<td class="usrinfocategory">기본급</td>
				<td class="usrinfocategory"><input type="number" id="salary"
					name="salary" placeholder="${empDto.salary}"></td>
			</tr>
			<tr>
				<td><input type="submit" id="usrupdate" value="수 정"></td>
				<td><input type="reset" id="usrreset" value="취 소"></td>
				<td><input type="button" id="empdelete" value="퇴 사" onclick="location.href='deleteUsrInfo.do?empNo=${empDto.empNo}&&usrId=${empDto.usrId}'"></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>