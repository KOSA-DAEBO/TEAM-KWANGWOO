<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&family=Noto+Sans+KR:wght@300;400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="./css/main.css">
<link rel="icon" href="./favicon.ico" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="header noindex">
      <div class="head" id="head">
         <div class="head_top">
            <h1>
               <a href="/" title="메인으로 이동"><img src="./images/logo.png"
                  alt="광우" class="logo" /></a>
            </h1>
            <div>
                <c:choose>
                    <c:when test="${not empty sessionScope.login}">
                        <span class="material-symbols-outlined">logout</span>
                        <a class="iconText" href="logout.do"> 로그아웃</a>
                        <a class="iconText"> ${sessionScope.login.usrId}님 안녕하세요.</a>
                    </c:when>
                    <c:otherwise>
                        <span class="material-symbols-outlined">login</span>
                        <a class="iconText" href="loginCustomer.do"> 로그인</a>
                        <span class="material-symbols-outlined">person_add</span>
                        <a class="iconText" href="joinCustomer.do"> 회원가입</a>
                    </c:otherwise>
                </c:choose>
            </div>
         </div>
         <!-- //head_top -->

         <div class="head_bottom">
             <c:if test="${not empty sessionScope.login}">
            <div class="head_bottom_in">
               <div class="head_menu">
                  <ul>
                     <li class=""><a href="#" title="인사">인사</a></li>
                     <li class=""><a href="leaveList.do?listNum=3" title="휴가">휴가</a></li>
                     <li class=""><a href="#" title="급여">급여</a></li>
                     <li class=""><a href="#" title="출퇴근">출퇴근</a></li>
                     <li class=""><a href="productList.do" title="제품관리">제품관리</a></li>
                  </ul>
               </div>
        <div class="local_menu">
            <div class="local_menu_in">
            <div class="lm group1">
               <ul>
                  <li><a href="deptMenu.do">부서관리</a></li>
                  <li><a href="#">마이페이지</a></li>
                  <li><a href="#">등등등</a></li>
               </ul>
            </div>
            <div class="lm group2">
               <ul>
                  <li><a href="leaveList.do?listNum=1">휴가관리</a></li>
                  <li><a href="leaveList.do?listNum=3">휴가신청</a></li>
               </ul>
            </div>
            <div class="lm group3">
               <ul>
                  <li><a href="salList.do">급여관리</a></li>
                  <li><a href="salList.do?slistNum=4">급여확인</a></li>
               </ul>
            </div>
            <div class="lm group4">
               <ul>
                   <li><a href="commuteEmpChk.do">출퇴근체크</a></li>
                   <li><a href="commuteEmp.do">출퇴근확인</a></li>
                   <c:if test="${login.role}"> <%--관리자 로그인--%>
                       <li><a href="commuteAdmin.do">출퇴근관리</a></li>
                   </c:if>
               </ul>
            </div>
            <div class="lm group5">
               <ul>
                  <li><a href="productList.do">제품관리</a></li>
                  <li><a href="goAddProduct.do">제품추가</a></li>
                  <li><a href="itemList.do">상품관리</a></li>
                  <li><a href="addItem.do">상품추가</a></li>
                  <li><a href="itemList.do?listNo=3">상품발주</a></li>
               </ul>
            </div>
         </div>
         <!--// local_menu_in -->
        </div>
      <!--// local_menu -->
            </div>
            <!-- //head_bottom_in -->
             </c:if>
         </div>
      </div>
   </div>
</body>
</html>