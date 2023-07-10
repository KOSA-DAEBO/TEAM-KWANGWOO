<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="./js/itemScript.js"></script>
<meta charset="UTF-8">
<title>check</title>
</head>
<body>
<div class="check_item_content">
	<div class="name">재고 리스트</div>
	<div class="item">
		<div class="check_table_top">
			<div class="t_head">제품번호</div>
			<div class="t_head">제품명</div>
			<div class="t_head">원가</div>
			<div class="t_head">판매가</div>
			<div class="t_head">재고수량</div>
			<div class="t_head">제품구분</div>
		</div>
		<c:forEach var="list" items="${list}">
			<div class="check_table_body">
				<div class="t_body">${list.dto.itemNo}</div>
				<div class="t_body" style="color: ${list.dto.stock <= 10 ? 'red' : 'black'}">
				<a onclick="openModal('${list.dto.itemNo}', '${list.dto.itemName}', '${list.dto.cost}', '${list.dto.price}', '${list.dto.stock}', '${list.dto.itemClsNo}')">${list.dto.itemName}</a>
				</div>
				<div class="t_body">${list.dto.cost}</div>
				<div class="t_body">${list.dto.price}</div>
				<div class="t_body">${list.dto.stock}</div>
				<div class="t_body">${list.cDto.itemClsName}</div>
			</div>
		</c:forEach>
	</div>
</div>
<div id="modal" class="modal">
    <div class="modal-content">
      <span class="close" onclick="closeModal()">&times;</span>
      <div class="modal_inner_content" id="modal_inner_content"></div>
    </div>
  </div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>