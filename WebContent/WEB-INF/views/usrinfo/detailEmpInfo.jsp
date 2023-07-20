<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script defer="defer" type="text/javascript" src="./js/empScript.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<meta charset="UTF-8">
<title>Team KwangWoo</title>
</head>
<body>
	<div id="usrcontainer">
		<form class="manageForm" action="updateUsrInfo.do" method="post">
			<div class="usrInfo">
				<div class="head_name">마이페이지</div>
				<div class="table1">
					<div class="empImage">
						<label for="fileInput" class="addImageLabel" id="fileInputText">클릭해서 이미지 추가</label>
						<input type="file" id="fileInput" name="file" style="display: none;" onchange="previewImage(this)">
						<img class="imgPreview" id="imgPreview" src="${login.imagePath}" alt="미리보기 이미지" style="display: block;">
					</div>
					<div class="innerTable">
						<div class="innerContent">
							<div>이름</div>
							<div>${login.empName}</div>
							<div>사번</div>
							<div>${login.empNo}</div>
						</div>
						<div class="innerContent">
							<div>계정</div>
							<div>${login.usrId}</div>
							<div>성별</div>
							<div>
								<c:choose>
									<c:when test="${login.empGender == '1'}">남</c:when>
									<c:when test="${login.empGender == '0'}">여</c:when>
								</c:choose>
							</div>
						</div>
						<div class="innerContent">
							<div>이메일</div>
							<div><input value="${login.empEmail}"></div>
							<div>전화번호</div>
							<div><input value="${login.empTel}"></div>
						</div>
						<div class="innerContent">
							<div>연차개수</div>
							<div>${login.annualLeave}일</div>
							<div>출근상태</div>
							<div>
								<c:choose>
									<c:when test="${login.empStatus == true}">출근</c:when>
									<c:when test="${login.empStatus == false}">결근</c:when>
								</c:choose>	
							</div>
						</div>
					</div>
				</div>
				<div class="table5">
					<div class="name">우편번호</div>
					<div class="content" ><input value="" id="sample6_postcode" disabled></div>
					<div><button type="button" class="empUpdateBtn" id="sample6_button" onclick="sample6_execDaumPostcode()" >우편번호 찾기</button></div>
				</div>
				<div class="table4">
					<div class="name">주소</div>
					<div class="content"><input value="" id="sample6_address" name="sample6_address" ></div>
					<div class="name">상세주소</div>
					<div class="content"><input value="" id="sample6_detailAddress" name="sample6_detailAddress" ></div>
				</div>
				<div class="table4">
					<div>생년월일</div>
					<div>${login.empBirth}</div>
					<div>입사일</div>
					<div>${login.hireDate}</div>
				</div>
				<div class="table4">
					<div class="name">부서</div>
					<div>${empInfo.deptDto.deptName}</div>					
					<div class="name">직책</div>
					<div>${empInfo.posDto.posName}</div>
				</div>
				<div class="empUpdateBtn">
					<input class="manageUpdateBtn" type="submit" id="usrUpdate" value="수 정">
					<input class="manageResetBtn" type="reset" id="usrReset" value="취 소">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>