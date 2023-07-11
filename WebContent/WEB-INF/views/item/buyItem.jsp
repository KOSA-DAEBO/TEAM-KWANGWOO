<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../../fixed/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team KwangWoo</title>
</head>
<body>
	<div class="buy_item_content">
		<div class="name">재고 리스트</div>
		<div class="item">
			<div class="buy_table_top">
				<div class="t_head">제품번호</div>
				<div class="t_head">제품명</div>
				<div class="t_head">원가</div>
				<div class="t_head">판매가</div>
				<div class="t_head">재고수량</div>
				<div class="t_head">제품구분</div>
			</div>
			<c:forEach var="list" items="${list}">
				<div class="buy_table_body">
					<div class="t_body">${list.dto.itemNo}</div>
					<div class="t_body"	style="color: ${list.dto.stock <= 10 ? 'red' : 'black'}">${list.dto.itemName}</div>
					<div class="t_body">${list.dto.cost}</div>
					<div class="t_body">${list.dto.price}</div>
					<div class="t_body">${list.dto.stock}</div>
					<div class="t_body">${list.cDto.itemClsName}</div>
				</div>
			</c:forEach>
		</div>
		<div class="buy_check_item">
		</div>
	</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>