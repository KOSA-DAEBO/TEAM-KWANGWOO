<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../../fixed/customHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script defer="defer" type="text/javascript" src="./js/customScript.js"></script>
<meta charset="UTF-8">
</head>
<body>
	<div class="product_content">
	<div class="content_name">판매 상품</div>
	<form class="card_form">
		<div class="card_list">
			<c:forEach var="list" items="${list}">
				<div class="card" onclick="location.href='detailCustomProduct.do?productNo=${list.productNo}'">
					<div class="card_left">
						<div class="p_image"><img alt="PC이미지" src="${list.thumbnailPath}"></div>
					</div>
					<div class="card_right">
						<div class="p_content">제품번호 : ${list.productNo}</div>
						<div class="p_content">제품명 : ${list.productName}</div>
						<div class="p_content">총가격 : <fmt:formatNumber value="${list.totalPrice}" pattern="###,###" />원</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="pagination">
			<input type="hidden" id="listSize" value="${list.size()}">
			<button class="custom_button" type="button" id="custom_prevButton" disabled> 이전</button>
			<button class="custom_button" type="button" id="custom_nextButton">다음</button>
		</div>
	</form>
</div>
</body>
</html>
<%@ include file="../../../fixed/customFooter.jsp" %>