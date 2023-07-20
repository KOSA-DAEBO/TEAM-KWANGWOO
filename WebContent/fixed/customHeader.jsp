<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&family=Noto+Sans+KR:wght@300;400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="./css/main.css">
<link rel="icon" href="./favicon.ico" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Com KwangWoo</title>
</head>
<body>
	<div class="head" id="head">
		<div class="head_top">
			<h1>
				<a href="./index.jsp" title="메인으로 이동"><img src="./images/customLogo.jpg" alt="광우" class="logo" /></a>
			</h1>
			<div>
				<c:choose>
					<c:when test="${not empty sessionScope.loginCustomer}">
						<span class="material-symbols-outlined">logout</span> <a class="iconText" href="logout.do"> 로그아웃</a>
						<button class="iconText joinButton" id="myPageCustomerButton" onClick="javascript:location.href='customDetail.do'">마이페이지</button>
						<a class="iconText"> ${sessionScope.loginCustomer.usrId}님 안녕하세요&nbsp&nbsp</a>
					</c:when>
					<c:otherwise>
						<span class="material-symbols-outlined">login</span> <a	class="iconText" href="loginCustomer.do"> 로그인</a>
						<span class="material-symbols-outlined">person_add</span> <a class="iconText" href="joinCustomer.do"> 회원가입</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<!-- //head_top -->
		<div class="custom_head_bottom">
			<div class="custom_head_menu">
				<ul>
					<li class=""><a href="./index.jsp" title="제품구매">조립컴퓨터 구매</a></li>
					<li class=""><a href="customItemList.do" title="상품구매">DYI 컴퓨터</a></li>
				</ul>
			</div>
			<!--// local_menu -->

		</div>
	</div>
</body>
</html>