function openModal() {
	var modal = document.getElementById("myModal");
	modal.style.display = "block";
}

function closeModal() {
	var modal = document.getElementById("myModal");
	modal.style.display = "none";
}

window.onclick = function(event) {
	var modal = document.getElementById("myModal");
	if (event.target == modal) {
		modal.style.display = "none";
	}
}

function dataCheck() {
	if (document.getElementById("search").value == "") {
		alert("검색할 단어를 입력하세요");
		document.getElementById("search").focus();
		return;
	}
	document.form.submit();
}		