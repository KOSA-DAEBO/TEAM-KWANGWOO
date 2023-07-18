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
<br> Username:
   <c:out value="${login.empName}" />
   <br> 유저Id:
   <c:out value="${login.usrId}" />
   <br> 관리자여부: 
   <c:out value="${login.role}" />
	전화번호 : <c:out value="${login.empTel}" />
         주소:   <c:out value="${login.empAddr}" />
	<div id="usrcontainer">
		<form action="updateUsrInfo.do" method="get">
			<table id="usrinfo">
				<tr>
					<td rowspan="14" id="usrimage"><input type="file" value="사진추가"
						accept="image/png, image/gif, image/jpeg"> 
						<img src="#" alt="#" onerror="this.onerror=null; this.src='./images/usericon.png';">
					</td>
					<td>
						<table>
							<tr>
								<td class="usrinfocategory">이름</td>
								<td class="usrinfocontent">
								<input type="text" id="empName" class="usrinput" name="empName"
									placeholder="${login.empName}"></td>
							</tr>
							<tr>
								<td class="usrinfocategory">사번</td>
								<td class="usrinfocontent">${login.empNo}</td>
							</tr>
							<tr>
								<td class="usrinfocategory">계정</td>
								<td class="usrinfocontent">${empInfo.empdto.usrId}</td>
							</tr>
							<tr>
								<td class="usrinfocategory">부서</td>
								<td class="usrinfocontent">${empInfo.deptdto.deptName}</td>
							</tr>
							<tr>
								<td class="usrinfocategory">직위</td>
								<td class="usrinfocontent">${empInfo.posdto.posName}</td>
							</tr>
							<tr>
								<td class="usrinfocategory">주소</td>
								<td class="usrinfocontent"><input type="text" id="empAddr" name="empAddr"
									placeholder="${login.empAddr}"></td>
							</tr>
							<tr>
								<td class="usrinfocategory">전화번호</td>
								<td class="usrinfocontent"><input type="text" id="empTel" name="empTel"
									placeholder="${login.empTel}"></td>
							</tr>
							<tr>
								<td class="usrinfocategory">성별</td>
								<td class="usrinfocontent"><c:choose>
										<c:when test="${login.empGender == '1'  }">
								남
							</c:when>
										<c:when test="${login.empGender == '0'  }">
								여
							</c:when>
									</c:choose></td>
							</tr>
							<tr>
								<td class="usrinfocategory">이메일</td>
								<td class="usrinfocontent"><input type="text" id="empEmail" name="empEmail"
									placeholder="${login.empEmail}"></td>
							</tr>
							<tr>
								<td class="usrinfocategory">생년월일</td>
								<td class="usrinfocontent">${login.empBirth}</td>
							</tr>
							<tr>
								<td class="usrinfocategory">입사일</td>
								<td class="usrinfocontent">${login.hireDate}</td>
							</tr>
							<tr>
								<td class="usrinfocategory">휴가상태</td>
								<td class="usrinfocontent">${login.annualLeave}일</td>
							</tr>
							<tr>
								<td class="usrinfocategory">출근상태</td>
								<td class="usrinfocontent"><c:choose>
										<c:when test="${login.empStatus == true}">
				                출근
				            </c:when>
										<c:when test="${login.empStatus == false}">
				                결근
				            </c:when>
									</c:choose></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2" id="usrbtn">
					<input type="submit"	id="usrupdate" value="수 정"> 
					<input	type="reset" id="usrreset" value="취 소">
					<input	type="button" id="deleteusr" value="삭 제" onclick="javascript:location.href = 'deleteUsrInfo.do'"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp"%>