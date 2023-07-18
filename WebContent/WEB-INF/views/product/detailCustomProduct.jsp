<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/customHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script defer="defer" type="text/javascript" src="./js/customScript.js"></script>
<meta charset="UTF-8">
<title>Com KwangWoo</title>
</head>
<body>
	<c:set var="dto" value="${dto}" />
	<div class="custom_productDetail">
		<div class="productDetailImg">
			<img alt="pc이미지" src="${dto.pDto.imagePath}">
		</div>
		<div class="productContent">
			<div class="content">
				<div class="clsName">제품명</div>
				<div class="itemName">:  ${dto.pDto.productName}</div>
				<c:forEach var="pimDto" items="${dto.pimDtoList}" varStatus="pimStatus">
				<c:set var="itemsDto" value="${dto.itemsDtoList[pimStatus.index]}" />
					<div class="clsName">${itemsDto.cDto.itemClsName}</div>
					<div class="itemName">:  <span class="itemNameValue">${itemsDto.dto.itemName}</span><span style="display: none;" class="itemValue">${itemsDto.dto.itemNo}</span></div>
				</c:forEach>
				<div class="totalPrice">총가격</div>
				<div class="price"></div>
			</div>
			<div>
				<input class="buyBtn" type="button" value="구매하기">
			</div>
		</div>
	</div>
</body>
</html>
<%@ include file="../../../fixed/customFooter.jsp" %>