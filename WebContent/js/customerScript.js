function checkCustomer() {
	var customEmail = document.changeCustomerInfo.customEmail.value;
	var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if (!pattern.test(customEmail)) {
		document.changeCustomerInfo.customEmail.focus();
		alert('영어와 숫자 @ 를 사용하여 입력해 주십시오.');
		return false;
	}

	var customTel = document.changeCustomerInfo.customTel.value;
	var pattern = /^\d{3}-\d{3,4}-\d{4}$/;
	if (!pattern.test(customTel)) {
		document.changeCustomerInfo.customTel.focus();
		alert("전화번호는 숫자와 '-'를 이용하여 입력해 주십시오");
		return false;
	}

	return true;
}

