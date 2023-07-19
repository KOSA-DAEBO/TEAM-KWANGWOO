<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script defer="defer" type="text/javascript" src="./js/productScript.js"></script>
<meta charset="UTF-8">
<title>Team KwangWoo</title>
</head>
<body>
<div class="goAddProduct" onclick="javascript:location.href='goAddProduct.do'"><a>제품추가</a></div>
<div class="product_content">
	<div class="name">제품 리스트</div>
	<form class="card_form">
		<div class="card_list">
			<c:forEach var="list" items="${list}">
				<div class="card" onclick="location.href='detailProduct.do?productNo=${list.productNo}'">
					<div class="card_left">
						<div class="p_image"><img alt="PC이미지" src="${list.thumbnailPath}"></div>
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
			<button type="button" id="prevButton" disabled> 이전</button>
			<button type="button" id="nextButton">다음</button>
		</div>
	</form>
</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>