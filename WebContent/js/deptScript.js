function changeContent() {
	const select = document.getElementById("selectDept");
	const selectedValue = select.options[select.selectedIndex].value;

	const contentDiv = document.getElementById("content");
	const srcDiv = document.getElementById(selectedValue);

	if (!srcDiv) {
		contentDiv.innerHTML = "";
		return;
	}

	contentDiv.innerHTML = srcDiv.innerHTML;
}
document.addEventListener("DOMContentLoaded", () => {
	changeContent();
});

