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

const buyFormToggle = document.getElementById("buyFormToggle");
const buyForm = document.getElementById("buyForm");

buyFormToggle.addEventListener("click", function() {
	buyFormToggle.style.display = "none";
	buyForm.style.display = "grid";
});

document.addEventListener("click", function(event) {
	const target = event.target;
	if (target !== buyFormToggle && !buyForm.contains(target)) {
		buyFormToggle.style.display = "flex";
		buyForm.style.display = "none";
	}
});

const addItemListBtn = document.getElementsByClassName("addItemListBtn")[0];
const buyCheckItem = document.getElementsByClassName("buy_check_item")[0];

addItemListBtn.addEventListener("click", function() {
	const itemNoInput = document.getElementsByClassName("buy_input")[0];
	const stockInput = document.getElementsByClassName("buy_input")[1];
	const itemNo = itemNoInput.value;
	const stock = stockInput.value;

	const itemName = getItemNameByItemNo(itemNo).substring(0, 10);
	const cost = getCostByItemNo(itemNo);
	const totalPrice = stock * cost;

	const itemText = `${itemNo}번 ${itemName} : ${stock}개 = ${totalPrice}`;

	const buyCheckItemContent = document.createElement("div");
	buyCheckItemContent.classList.add("buy_check_item_content");

	const itemContent = document.createElement("span");
	itemContent.textContent = itemText;

	const removeButton = document.createElement("button");
	removeButton.textContent = "x";

	buyCheckItemContent.appendChild(itemContent);
	buyCheckItemContent.appendChild(removeButton);
	buyCheckItemContent.dataset.itemNo = itemNo;

	buyCheckItem.appendChild(buyCheckItemContent);

	removeButton.addEventListener("click", function() {
		event.stopPropagation();
		buyCheckItem.removeChild(buyCheckItemContent);
	});

	itemNoInput.value = "";
	stockInput.value = "";
});

function getItemNameByItemNo(itemNo) {
	const itemNos = document.getElementsByClassName("t_body");
	for (let i = 0; i < itemNos.length; i += 6) {
		const currentItemNo = itemNos[i].textContent.trim();
		if (currentItemNo === itemNo) {
			const itemNameElement = itemNos[i + 1];
			return itemNameElement ? itemNameElement.textContent.trim() : "";
		}
	}
	return "";
}

function getCostByItemNo(itemNo) {
	const itemNos = document.getElementsByClassName("t_body");
	for (let i = 0; i < itemNos.length; i += 6) {
		const currentItemNo = itemNos[i].textContent.trim();
		if (currentItemNo === itemNo) {
			const costElement = itemNos[i + 2];
			return costElement ? costElement.textContent.trim() : "";
		}
	}
	return "";
}

document.getElementById("buyForm").addEventListener("submit", function(event) {
	event.preventDefault(); // 기본 동작인 폼 전송을 막음

	// 팝업 창 띄우기
	const confirmation = confirm("구매하시겠습니까?");
	if (confirmation) {
		// 추가한 항목들을 가져옴
		const buyCheckItems = document.querySelectorAll(".buy_check_item_content");

		// 추가한 항목들의 정보를 배열에 저장
		const items = [];
		buyCheckItems.forEach(function(item) {
			const itemNo = item.dataset.itemNo; // 데이터 속성에서 itemNo를 가져옴
			const itemText = item.textContent;
			const regex = /(\d+)개/;
			const match = itemText.match(regex);
			const stock = match ? parseInt(match[1]) : 0;
			const totalPrice = match ? parseInt(itemText.split(" = ")[1]) : 0;
			items.push({ itemNo: itemNo.trim(), stock: parseInt(stock), totalPrice: parseInt(totalPrice) });
		});

		// 서버로 데이터 전송
		sendToServer(items);

		// 새로고침
		window.location.reload();
	}
});

function sendToServer(items) {
	const xhr = new XMLHttpRequest();
	const url = "buyItem.do";

	// POST 요청 설정
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");

	// 요청 완료 후 처리
	xhr.onreadystatechange = function() {
		if (xhr.readyState === XMLHttpRequest.DONE) {
			if (xhr.status === 200) {
				// 서버 응답을 받았을 때의 처리
				console.log("데이터 전송 성공");
			} else {
				// 서버 응답을 받지 못했을 때의 처리
				console.error("데이터 전송 실패");
			}
		}
	};

	// 전송할 데이터 설정
	const data = JSON.stringify(items);

	// 데이터 전송
	xhr.send(data);
}