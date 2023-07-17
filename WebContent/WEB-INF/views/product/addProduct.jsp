<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team KwangWoo</title>
<script defer="defer" type="text/javascript" src="./js/productScript.js"></script>
</head>
<body>
	<div class="addProduct">
		<div class="name">제품 추가하기</div>
		<div>
			<form class="addForm" action="addProduct.do" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
				<div class="addImage" onclick="document.getElementById('fileInput').click()">
					<label for="fileInput" class="addImageLabel" id="fileInputText">클릭해서 이미지 추가</label>
					<input type="file" id="fileInput" name="file" style="display: none;" onchange="previewImage(this)">
					<img class="imgPreview" id="imgPreview" src="#" alt="미리보기 이미지" style="display: none;">
				</div>
				<div class="addItem">
					<div class="insertProductName">
						<div class="addInputName">제품명</div>
						<input type="text" class="productName" placeholder="제품명을 입력해주세요." id="productName" name="productName">
					</div>
					<div class="addSelect">
						<c:forEach var="dtoList" items="${dtoList}">
							<div class="addSelectName">${dtoList.itemClsName}</div>
							<select class="addSelectContent" id="addSelectContent" name="addSelectContent">
									<option value="">--선택하세요(필수항목)</option>
								<c:forEach var="list" items="${list}">
									<c:if test="${list.cDto.itemClsName.equals(dtoList.itemClsName)}">
										<option value="${list.dto.itemNo}">${list.dto.itemName}</option>
									</c:if>
								</c:forEach>
							</select>
						</c:forEach>
					</div>
					<div>
						<input type="submit" value="추가하기" class="addProductBtn">
						<input type="reset" value="초기화" class="addProductBtn">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>
