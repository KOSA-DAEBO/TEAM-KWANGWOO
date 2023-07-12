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
               <span class="material-symbols-outlined" OnClick="location.href='loginCustomer.do'">login</span>
               <span class="material-symbols-outlined" OnClick="location.href='logout.do'">logout</span>
               <span class="material-symbols-outlined" OnClick="location.href='joinCustomer.do'">person_add</span>
            </div>
         </div>
         <!-- //head_top -->

         <div class="head_bottom">
            <div class="head_bottom_in">
               <div class="head_menu">
                  <ul>
                     <li class=""><a href="#" title="인사">인사</a></li>
                     <li class=""><a href="leaveList.do" title="휴가">휴가</a></li>
                     <li class=""><a href="#" title="급여">급여</a></li>
                     <li class=""><a href="#" title="출퇴근">출퇴근</a></li>
                     <li class=""><a href="itemList.do" title="제품관리">제품관리</a></li>
                  </ul>
               </div>
        <div class="local_menu">
            <div class="local_menu_in">
            <div class="lm group1">
               <ul>
                  <li><a href="#">부서관리</a></li>
                  <li><a href="#">마이페이지</a></li>
                  <li><a href="#">등등등</a></li>
               </ul>
            </div>
            <div class="lm group2">
               <ul>
                  <li><a href="leaveList.do?listNum=1">휴가관리</a></li>
                  <li><a href="leaveList.do?listNum=3">휴가신청</a></li>
                  <li><a href="#">등등등</a></li>
               </ul>
            </div>
            <div class="lm group3">
               <ul>
                  <li><a href="#">급여관리</a></li>
                  <li><a href="#">급여지급</a></li>
                  <li><a href="#">등등등</a></li>
               </ul>
            </div>
            <div class="lm group4">
               <ul>
                  <li><a href="#">출퇴근관리</a></li>
                  <li><a href="#">출퇴근확인</a></li>
                  <li><a href="#">등등등</a></li>
               </ul>
            </div>
            <div class="lm group5">
               <ul>
                  <li><a href="#">제품관리</a></li>
                  <li><a href="#">제품추가</a></li>
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
         </div>
      </div>
   </div>
</body>
</html>