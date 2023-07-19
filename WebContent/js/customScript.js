window.addEventListener("DOMContentLoaded", function() {
	let itemsPerPage = 8; // 페이지당 아이템 수
	let currentPage = 1; // 현재 페이지

	// 전체 페이지 수 계산
	let totalItems = document.querySelectorAll(".card_list > div").length;
	let totalPages = Math.ceil(totalItems / itemsPerPage);

	// 페이지 업데이트 함수
	function updatePage() {
		let cards = document.querySelectorAll(".card_list > div");

		// 각 아이템마다 보여줄지 여부 결정
		cards.forEach(function(card, index) {
			if (index >= (currentPage - 1) * itemsPerPage && index < currentPage * itemsPerPage) {
				card.style.display = "grid"; // 해당 페이지의 아이템은 보이도록 설정
			} else {
				card.style.display = "none"; // 나머지 아이템은 숨김 처리
			}
		});

		// 이전 버튼 활성화/비활성화 상태 업데이트
		let prevButton = document.getElementById("custom_prevButton");
		if (currentPage === 1) {
			prevButton.disabled = true; // 첫 페이지일 경우 비활성화
		} else {
			prevButton.disabled = false; // 첫 페이지가 아닐 경우 활성화
		}

		// 다음 버튼 활성화/비활성화 상태 업데이트
		let nextButton = document.getElementById("custom_nextButton");
		if (currentPage === totalPages) {
			nextButton.disabled = true; // 마지막 페이지일 경우 비활성화
		} else {
			nextButton.disabled = false; // 마지막 페이지가 아닐 경우 활성화
		}
	}

	// 이전 버튼 클릭 이벤트 처리
	document.getElementById("custom_prevButton").addEventListener("click", function() {
		if (currentPage > 1) {
			currentPage--; // 이전 페이지로 이동
			updatePage(); // 페이지 업데이트
		}
	});

	// 다음 버튼 클릭 이벤트 처리
	document.getElementById("custom_nextButton").addEventListener("click", function() {
		if (currentPage < totalPages) {
			currentPage++; // 다음 페이지로 이동
			updatePage(); // 페이지 업데이트
		}
	});

	// 초기 페이지 로드 시 페이지 업데이트
	updatePage();
});