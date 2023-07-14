<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../../../fixed/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script defer="defer" type="text/javascript" src="./js/productScript.js"></script>
<meta charset="UTF-8">
<title>Team KwangWoo</title>
</head>
<body>
<div class="product_content">
	<div class="name">상품 리스트</div>
	<form class="card_form">
		<div class="card_list">
			<c:forEach var="list" items="${list}">
				<div class="card">
					<div class="card_left">
						<div class="p_image"><img alt="PC이미지" src="${list.imagePath}"></div>
					</div>
					<div class="card_right">
						<div class="p_content">제품번호 : ${list.productNo}</div>
						<div class="p_content">제품명 : ${list.productName}</div>
						<div class="p_content">총가격 : ${list.totalPrice}</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="pagination">
			<input type="hidden" id="listSize" value="${list.size()}">
			<button id="prevButton" disabled>&lt; 이전</button>
			<button id="nextButton">다음 &gt;</button>
		</div>
	</form>
</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>