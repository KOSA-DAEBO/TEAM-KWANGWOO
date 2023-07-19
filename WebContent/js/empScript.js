window.addEventListener("DOMContentLoaded", function() {
	let empsPerPage = 5; //페이지당 출력할 항목
	let currentPage = 1; // 현 페이지 번호

	let allEmps = document.querySelectorAll("#allempinfo > div").length;
	let totalPage = Math.ceil(allEmps / empsPerPage);

	function updatePage() {
		let emps = document.querySelectorAll("#allempinfo > div");
		
		emps.forEach(function(empno, index){
			if (index >= (currentPage - 1) * empsPerPage && index < currentPage * empsPerPage) {
				empno.style.display = "grid";
			} else {
				empno.style.display = "none";
			}
		});
		
		let prevButton = document.getElementById("prevButton");
		if (currentPage === 1) {
			prevButton.disabled = true;
		} else {
			prevButton.disabled = false;
		}
		
		
		let nextButton = document.getElementById("nextButton");
		if (currentPage === totalPage) {
			nextButton.disabled = true;
		} else {
			nextButton.disabled = false;
		}
	}
	
	document.getElementById("prevButton").addEventListener("click",function(){
		if(currentPage > 1){
			currentPage--;
			updatePage();
		}
	});
	
	document.getElementById("nextButton").addEventListener("click", function() {
		if (currentPage < totalPage) {
			currentPage++; // 다음 페이지로 이동
			updatePage(); // 페이지 업데이트
		}
	});
	updatePage();
});