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
				<div class="clsName">제품번호</div>
				<div class="itemName">:  ${dto.pDto.productNo}</div>
				<div class="clsName">제품명</div>
				<div class="itemName">:  ${dto.pDto.productName}</div>
				<c:forEach var="pimDto" items="${dto.pimDtoList}" varStatus="pimStatus">
				<c:set var="itemsDto" value="${dto.itemsDtoList[pimStatus.index]}" />
					<div class="clsName">${itemsDto.cDto.itemClsName}</div>
					<div class="itemName">:  <span class="itemNameValue">${itemsDto.dto.itemName}</span><span style="display: none;" class="itemValue">${itemsDto.dto.itemNo}</span></div>
				</c:forEach>
			</div>
			<div>
				<input class="updateBtn" type="button" value="수정하기">
				<input class="deleteBtn" type="button" value="삭제하기" onclick="confirmDelete(${dto.pDto.productNo})">
			</div>
		</div>
	</div>
	<div class="updateProduct">
		<form class="updateForm" action="updateProduct.do" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
			<div class="updateImage" onclick="document.getElementById('fileInput').click()">
				<label for="fileInput" class="addImageLabel" id="fileInputText">클릭해서 이미지 추가</label>
				<input type="file" id="fileInput" name="file" style="display: none;" onchange="previewImage(this)">
				<img class="imgPreview" id="imgPreview" src="${dto.pDto.imagePath}" alt="미리보기 이미지" style="display: block;">
			</div>
			<div class="updateItem">
				<div class="updateProductName">
					<div class="updateInputName">제품명</div>
					<input type="text" class="productName" id="productName" name="productName" value="${dto.pDto.productName}">
					<input type="text" class="productNo" name="productNo" style="display: none;" value="${dto.pDto.productNo}">
				</div>
				<div class="updateSelect">
					<c:forEach var="clsList" items="${clsList}">
						<div class="clsName">${clsList.itemClsName}</div>
						<select class="updateSelectContent" id="updateSelectContent" name="updateSelectContent">
							<option class="nowOption"></option>
							<c:forEach var="list" items="${list}">
								<c:if test="${list.cDto.itemClsName.equals(clsList.itemClsName)}">
									<option value="${list.dto.itemNo}">${list.dto.itemName}</option>
								</c:if>
							</c:forEach>
						</select>						
					</c:forEach>
				</div>
				<div>
					<input type="submit" value="수정완료" class="updateProductBtn">
					<input type="reset" value="초기화" class="updateProductBtn">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>