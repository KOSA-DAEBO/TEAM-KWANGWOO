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
			<form action="addProduct.do" method="post" enctype="multipart/form-data">
				<div class="addImage">
					파일 : <input type="file" name="file">
				</div>
				<div class="addItem">
					<div>
						<div>제품명</div>
						<input type="text" class="productName" placeholder="제품명을 입력해주세요.">
					</div>
					<c:forEach var="dtoList" items="${dtoList}">
						<div>${dtoList.itemClsName}</div>
						<div>
							<select>
								<c:forEach var="list" items="${list}">
									<c:if test="${list.cDto.itemClsName.equals(dtoList.itemClsName)}">
										<option value="${list.dto.itemNo}">${list.dto.itemName}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</c:forEach>
				</div>
				<div>
					<input type="submit" value="추가하기" class="addProductBtn">
					<input type="reset" value="초기화" class="addProductBtn">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>
