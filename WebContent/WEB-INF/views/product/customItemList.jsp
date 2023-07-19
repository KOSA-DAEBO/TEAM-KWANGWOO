<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../../fixed/customHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script defer="defer" type="text/javascript" src="./js/customScript.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="custom_item_content">
		<div class="name">컴퓨터 조립</div>
		<form class="buyForm" action="buyDiyProduct.do" method="post">
			<div class="item">
				<c:forEach var="clsList" items="${clsList}">
					<div class="clsName">${clsList.itemClsName}</div>
					<select onchange="updateTotalPrice()">
						<option>--선택하세요.(필수사항)</option>
						<c:forEach var="list" items="${list}">
							<c:if test="${clsList.itemClsNo == list.cDto.itemClsNo && list.dto.stock != 0}">
								<option data-price="${list.dto.price}" value="${list.dto.itemNo}">
										${list.dto.itemName} (+<fmt:formatNumber value="${list.dto.price}" pattern="###,###" />원)
								</option>
							</c:if>
						</c:forEach>
					</select>
				</c:forEach>
				<div class="clsName">총 합계</div>
				<div class="totalPrice">0원</div>
			</div>
			<div class="buyBtnDiv"><button type="button" class="buyDyiProduct" onclick="buyDiyProduct()">구매하기</button></div>
		</form>
	</div>
</body>
</html>
<%@ include file="../../../fixed/customFooter.jsp" %>