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
	<c:set var="dto" value="${dto}" />
	<div class="productDetail">
		<div class="productDetailImg">
			<img alt="pc이미지" src="${dto.pDto.imagePath}">
		</div>
		<div class="productContent">
			<div class="content">
				<c:forEach var="pimDto" items="${dto.pimDtoList}" varStatus="pimStatus">
				<c:set var="itemsDto" value="${dto.itemsDtoList[pimStatus.index]}" />
					<div class="clsName">${itemsDto.cDto.itemClsName}</div>
					<div class="itemName">:  ${itemsDto.dto.itemName}</div>
				</c:forEach>
			</div>
			<div>
				<input class="updateBtn" type="button" value="수정하기">
				<input class="deleteBtn" type="button" value="삭제하기" onclick="confirmDelete(${dto.pDto.productNo})">
			</div>
		</div>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>