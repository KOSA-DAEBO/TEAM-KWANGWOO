function checkAddItem() {
	if (!document.addItem.itemName.value) {
		document.addItem.itemName.focus();
		alert("상품명를 입력하십시요.");
		return false;
	}
	if (!document.addItem.cost.value) {
		document.addItem.cost.focus();
		alert("원가를 입력하십시요.");
		return false;
	}
	if (!document.addItem.price.value) {
		document.addItem.price.focus();
		alert("판매가를 입력하십시요.");
		return false;
	}

	var isChecked = isItemClsChecked();
	if (!isChecked) {
		alert("제품 구분을 선택해주세요.")
		return false;
	}

	var cost = document.addItem.cost.value;
	if (!isValidInteger(cost)) {
		alert("원가를 숫자로 입력해주세요.")
		return false;
	}

	var price = document.addItem.price.value;
	if (!isValidInteger(price)) {
		alert("판매가를 숫자로 입력해주세요.")
		return false;
	}

	function isItemClsChecked() {
		var radios = document.getElementsByName('itemClsNo');
		for (var i = 0; i < radios.length; i++) {
			if (radios[i].checked) {
				return true; // 라디오 버튼이 체크된 상태인 경우
			}
		}
		return false; // 라디오 버튼이 체크되지 않은 경우
	}

	function isValidInteger(value) {
		var pattern = /^-?\d+$/; // 숫자만 입력할 수 있게 패턴화
		return pattern.test(value);
	}
}

function openModal(itemNo, itemName, cost, price, stock, itemClsNo) {
	var modal = document.getElementById("modal");
	var modalContent = document.getElementById("modal_inner_content");
	var value = itemClsNo;

	modal.style.display = "block";
	modalContent.innerHTML = `
    <div class="modal_header">상품 업데이트</div>
    <form class="modal_body" action="updateItem.do" method="post" name="updateItem" onsubmit="return checkAddItem();">
      <div class="updateRow1">
	      <div class="inner_name">제품번호</div><div><input type="text" class="form_controll" id="itemNo" name="itemNo" value="${itemNo}" readonly></div>
	      <div class="inner_name">제품명</div><div><input type="text" placeholder="    제품명 입력해주세요." class="form_controll" id="itemName" name="itemName" value="${itemName}"></div>
      </div>
      <div class="updateRow2">
	      <div class="inner_name">원가</div>
		  <div><input type="text" placeholder="    원가를 입력해주세요." class="form_controll_half" id="cost" name="cost" value="${cost}"></div>
		  <div class="inner_name">판매가</div>
		  <div><input type="text" placeholder="    판매가를 입력해주세요." class="form_controll_half" id="price" name="price" value="${price}"></div>
	      <div class="inner_value">재고수량: ${stock}</div>
	  </div>
      <div class="updateRow3">
		  <div class="inner_name">제품구분</div>
		  <div class="update_radio">
			  <input type="radio" class="radio_inner" value="10" name="itemClsNo" ${itemClsNo === "10" ? "checked" : ""}>케이스
	          <input type="radio" class="radio_inner" value="20" name="itemClsNo" ${itemClsNo === "20" ? "checked" : ""}>프로세서
	          <input type="radio" class="radio_inner" value="30" name="itemClsNo" ${itemClsNo === "30" ? "checked" : ""}>쿨러
	          <input type="radio" class="radio_inner" value="40" name="itemClsNo" ${itemClsNo === "40" ? "checked" : ""}>메모리
	          <input type="radio" class="radio_inner" value="50" name="itemClsNo" ${itemClsNo === "50" ? "checked" : ""}>메인보드
	          <input type="radio" class="radio_inner" value="60" name="itemClsNo" ${itemClsNo === "60" ? "checked" : ""}>그래픽카드
	          <input type="radio" class="radio_inner" value="70" name="itemClsNo" ${itemClsNo === "70" ? "checked" : ""}>하드
	          <input type="radio" class="radio_inner" value="80" name="itemClsNo" ${itemClsNo === "80" ? "checked" : ""}>파워
		  </div>
    	</div>
	    <div class="updateRow4">
			<input class="modal_updateBtn" type="submit" value="수정하기">
			<input class="modal_deleteBtn" type="button" value="삭제하기" onclick="showConfirmation('${itemName}', ${itemNo})">
		</div>
    </form>
  `;
}

function closeModal() {
	var modal = document.getElementById("modal");
	modal.style.display = "none";
}

function showConfirmation(itemName, itemNo) {
  var confirmation = confirm(`정말로 ${itemName}을(를) 삭제하시겠습니까?`);
  if (confirmation) {
    location.href = 'deleteItem.do?itemNo=' + itemNo;
  }
}
