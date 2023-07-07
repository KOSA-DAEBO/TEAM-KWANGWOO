<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="./js/itemScript.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="add_content">
	<div class="name">상품 추가 페이지</div>
	<form action="addItem.do" method="post" class="add_form" name="addItem" onsubmit="return checkAddItem();">
		<div class="addRow1">
			<div class="inner_name">제품명</div>
			<div><input type="text" placeholder="    제품명 입력해주세요." class="form_controll" id="itemName" name="itemName"></div>
		</div>
		<div class="addRow2">
			<div class="inner_name">원가</div>
			<div><input type="text" placeholder="    원가를 입력해주세요." class="form_controll_half" id="cost" name="cost"></div>
			<div class="inner_name">판매가</div>
			<div><input type="text" placeholder="    판매가를 입력해주세요." class="form_controll_half" id="price" name="price"></div>
		</div>
		<div class="addRow3">
			<div class="inner_name">제품구분</div>
			<div class="add_radio">
				<input type="radio" class="radio_inner" value="10" name="itemClsNo">케이스
				<input type="radio" class="radio_inner" value="20" name="itemClsNo">프로세서
				<input type="radio" class="radio_inner" value="30" name="itemClsNo">쿨러
				<input type="radio" class="radio_inner" value="40" name="itemClsNo">메모리
				<input type="radio" class="radio_inner" value="50" name="itemClsNo">메인보드
				<input type="radio" class="radio_inner" value="60" name="itemClsNo">그래픽카드
				<input type="radio" class="radio_inner" value="70" name="itemClsNo">하드
				<input type="radio" class="radio_inner" value="80" name="itemClsNo">파워
			</div>
		</div>
		<div>
			<input type="submit" class="addBtn" value="추가하기">
			<input type="reset" class="resetBtn" value="모두지우기">
			<input type="button" class="listBtn" value="제품리스트">
		</div>
	</form>
</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>