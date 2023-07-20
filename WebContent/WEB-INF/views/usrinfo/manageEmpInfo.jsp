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
		<form class="manageForm" action="updateManageEmpInfo.do" method="post">
			<div class="usrInfo">
				<div class="head_name">근로자 상세페이지</div>
				<div class="table1">
					<div><img src="#" alt="#" onerror="this.onerror=null; this.src='./images/usericon.png';"></div>
					<div class="innerTable">
						<div class="innerContent">
							<div>이름</div>
							<div>${empDto.empName}</div>
							<div>사번</div>
							<div>${empDto.empNo}</div>
						</div>
						<div class="innerContent">
							<div>계정</div>
							<div>${empDto.usrId}</div>
							<div>성별</div>
							<div>
								<c:choose>
									<c:when test="${empDto.empGender == '1'}">남</c:when>
									<c:when test="${empDto.empGender == '0'}">여</c:when>
								</c:choose>
							</div>
						</div>
						<div class="innerContent">
							<div>이메일</div>
							<div>${empDto.empEmail}</div>
							<div>전화번호</div>
							<div>${empDto.empTel}</div>
						</div>
						<div class="innerContent">
							<div>연차개수</div>
							<div>${empDto.annualLeave}일</div>
							<div>출근상태</div>
							<div>
								<c:choose>
									<c:when test="${empDto.empStatus == true}">출근</c:when>
									<c:when test="${empDto.empStatus == false}">결근</c:when>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
				<div class="table2">
					<div class="name">주소</div>
					<div class="content">${empDto.empAddr}</div>
				</div>
				<div class="table3">
					<div>생년월일</div>
					<div>${empDto.empBirth}</div>
					<div>입사일</div>
					<div>${empDto.hireDate}</div>
					<div>기본급</div>
					<div>${empDto.salary}</div>
				</div>
				<div class="table2">
					<div class="name">부서</div>
					<div id="empDeptList">
						<input type="radio" value="5" name="deptNo" id="deptNo" ${empDto.deptNo == "5" ? "checked" : ""}/>발령전 
						<input type="radio" value="10" name="deptNo" id="deptNo" ${empDto.deptNo == "10" ? "checked" : ""}/>경영관리 
						<input type="radio" value="20" name="deptNo" id="deptNo" ${empDto.deptNo == "20" ? "checked" : ""}/>기획 
						<input type="radio" value="30" name="deptNo" id="deptNo" ${empDto.deptNo == "30" ? "checked" : ""}/>마케팅
						<input type="radio" value="40" name="deptNo" id="deptNo" ${empDto.deptNo == "40" ? "checked" : ""}/>영상 
						<input type="radio" value="50" name="deptNo" id="deptNo" ${empDto.deptNo == "50" ? "checked" : ""}/>개발 
						<input type="radio" value="60" name="deptNo" id="deptNo" ${empDto.deptNo == "60" ? "checked" : ""}/>영업 
						<input type="radio" value="70" name="deptNo" id="deptNo" ${empDto.deptNo == "70" ? "checked" : ""}/>생산
					</div>
				</div>
				<div class="table2">
					<div class="name">직책</div>
					<div id="empPosList">
						<input type="radio" value="10" name="posNo" id="posNo"  ${empDto.posNo == "10" ? "checked" : ""}/>대표이사 
						<input type="radio" value="20" name="posNo" id="posNo"  ${empDto.posNo == "20" ? "checked" : ""}/>이사 
						<input type="radio" value="30" name="posNo" id="posNo"  ${empDto.posNo == "30" ? "checked" : ""}/>부장 
						<input type="radio" value="40" name="posNo" id="posNo"  ${empDto.posNo == "40" ? "checked" : ""}/>차장
						<input type="radio" value="50" name="posNo" id="posNo"  ${empDto.posNo == "50" ? "checked" : ""}/>과장
						<input type="radio" value="60" name="posNo" id="posNo"  ${empDto.posNo == "60" ? "checked" : ""}/>대리
						<input type="radio" value="70" name="posNo" id="posNo"  ${empDto.posNo == "70" ? "checked" : ""}/>주임
						<input type="radio" value="80" name="posNo" id="posNo"  ${empDto.posNo == "80" ? "checked" : ""}/>사원
						<input type="radio" value="100" name="posNo" id="posNo"  ${empDto.posNo == "100" ? "checked" : ""}/>인턴
						<input type="radio" value="5" name="posNo" id="posNo"  ${empDto.posNo == "5" ? "checked" : ""}/>임시직
					</div>
				</div>
				<div class="manageBtn">
					<input class="manageUpdateBtn" type="submit" id="usrUpdate" value="수 정">
					<input class="manageResetBtn" type="reset" id="usrReset" value="취 소">
					<input class="manageDeleteBtn" type="button" id="empDelete" value="퇴 사" onclick="location.href='deleteUsrInfo.do?empNo=${empDto.empNo}&&usrId=${empDto.usrId}'">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>