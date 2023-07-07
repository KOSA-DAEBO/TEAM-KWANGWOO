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
	if(!isValidInteger(cost)) {
		alert("원가를 숫자로 입력해주세요.")
		return false;
	}
	
	var price = document.addItem.price.value;
	if(!isValidInteger(price)) {
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