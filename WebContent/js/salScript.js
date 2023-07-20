function Cal() {
	// 각 입력 요소에서 값을 가져와 더합니다.
	const salary = parseFloat(document.getElementById('salary').value) || 0;
	const allowance1 = parseFloat(document.getElementById('allowance1').value) || 0;
	const allowance2 = parseFloat(document.getElementById('allowance2').value) || 0;
	const allowance3 = parseFloat(document.getElementById('allowance3').value) || 0;

	const totalAllowance = salary + allowance1 + allowance2 + allowance3;

	// 계산된 결과를 "totalAllowance" ID를 가진 입력 요소에 나타냅니다.
	document.getElementById('totalAllowance').value = totalAllowance
		.toFixed(0);

	// 각 입력 요소에서 값을 가져와 더합니다.
	const expense1 = parseFloat(document.getElementById('expense1').value) || 0;
	const expense2 = parseFloat(document.getElementById('expense2').value) || 0;
	const expense3 = parseFloat(document.getElementById('expense3').value) || 0;
	const expense4 = parseFloat(document.getElementById('expense4').value) || 0;

	const totalExpense = expense1 + expense2 + expense3 + expense4;

	// 계산된 결과를 "totalAllowance" ID를 가진 입력 요소에 나타냅니다.
	document.getElementById('totalExpense').value = totalExpense.toFixed(0);

	const total = totalAllowance - totalExpense;
	document.getElementById('total').value = total.toFixed(0);
}

// 각 입력 요소가 변경될 때마다 총액을 다시 계산합니다.
document.getElementById('salary').addEventListener('input', Cal);
document.getElementById('allowance1').addEventListener('input', Cal);
document.getElementById('allowance2').addEventListener('input', Cal);
document.getElementById('allowance3').addEventListener('input', Cal);

document.getElementById('expense1').addEventListener('input', Cal);
document.getElementById('expense2').addEventListener('input', Cal);
document.getElementById('expense3').addEventListener('input', Cal);
document.getElementById('expense4').addEventListener('input', Cal);

function enableModify() {
	var allowance3Input = document.getElementById('allowance3');
	allowance3Input.removeAttribute('readonly');
	var modifyButton = document.querySelector('.leaveButton');
	var hiddenButton = document.getElementById('hiddenButtonS');
	modifyButton.style.display = 'none';
	hiddenButtonS.style.display = 'inline-block';

	// 각 입력 요소에서 값을 가져와 더합니다.
	const salary = parseFloat(document.getElementById('salary').value) || 0;
	const allowance1 = parseFloat(document.getElementById('allowance1').value) || 0;
	const allowance2 = parseFloat(document.getElementById('allowance2').value) || 0;
	const allowance3 = parseFloat(document.getElementById('allowance3').value) || 0;

	const totalAllowance = salary + allowance1 + allowance2 + allowance3;

	// 계산된 결과를 "totalAllowance" ID를 가진 입력 요소에 나타냅니다.
	document.getElementById('totalAllowance').value = totalAllowance
		.toFixed(0);

	// 각 입력 요소에서 값을 가져와 더합니다.
	const expense1 = parseFloat(document.getElementById('expense1').value) || 0;
	const expense2 = parseFloat(document.getElementById('expense2').value) || 0;
	const expense3 = parseFloat(document.getElementById('expense3').value) || 0;
	const expense4 = parseFloat(document.getElementById('expense4').value) || 0;

	const totalExpense = expense1 + expense2 + expense3 + expense4;

	// 계산된 결과를 "totalAllowance" ID를 가진 입력 요소에 나타냅니다.
	document.getElementById('totalExpense').value = totalExpense.toFixed(0);

	const total = totalAllowance - totalExpense;
	document.getElementById('total').value = total.toFixed(0);
}

function modifySubmit() {
	document.form.submit();
}
