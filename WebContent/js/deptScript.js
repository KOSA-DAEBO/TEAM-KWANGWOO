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
function getDepartments() {
	$.ajax({
		url: "your_daofile.jsp", // DAO 파일 경로를 입력해야 합니다.
		type: "GET",
		success: function(response) {
			// 서버에서 받아온 결과를 "content" div 요소에 업데이트합니다.
			$("#content").html(response);
		},
		error: function(error) {
			console.error("오류 발생:", error);
		}
	});
}