window.addEventListener("DOMContentLoaded", function() {
	// 페이지 로드 시 초기화 작업
	const listSize = parseInt(document.getElementById("listSize").value);
	const itemsPerPage = 8; // 페이지당 아이템 수
	let currentPage = 1; // 현재 페이지

	// 페이지 업데이트 함수
	function updatePage() {
		const cards = document.querySelectorAll(".card_list > div");
		const totalPages = Math.ceil(listSize / itemsPerPage); // 전체 페이지 수

		// 각 아이템마다 보여줄지 여부 결정
		cards.forEach(function(card, index) {
			if (index >= (currentPage - 1) * itemsPerPage && index < currentPage * itemsPerPage) {
				card.style.display = "grid"; // 해당 페이지의 아이템은 보이도록 설정
			} else {
				card.style.display = "none"; // 나머지 아이템은 숨김 처리
			}
		});

		// 이전 버튼 활성화/비활성화 상태 업데이트
		const prevButton = document.getElementById("prevButton");
		if (currentPage === 1) {
			prevButton.disabled = true; // 첫 페이지일 경우 비활성화
		} else {
			prevButton.disabled = false; // 첫 페이지가 아닐 경우 활성화
		}

		// 다음 버튼 활성화/비활성화 상태 업데이트
		const nextButton = document.getElementById("nextButton");
		if (currentPage === totalPages) {
			nextButton.disabled = true; // 마지막 페이지일 경우 비활성화
		} else {
			nextButton.disabled = false; // 마지막 페이지가 아닐 경우 활성화
		}
	}

	// 이전 버튼 클릭 이벤트 처리
	document.getElementById("prevButton").addEventListener("click", function() {
		if (currentPage > 1) {
			currentPage--; // 이전 페이지로 이동
			updatePage(); // 페이지 업데이트
		}
	});

	// 다음 버튼 클릭 이벤트 처리
	document.getElementById("nextButton").addEventListener("click", function() {
		const totalPages = Math.ceil(listSize / itemsPerPage); // 전체 페이지 수
		if (currentPage < totalPages) {
			currentPage++; // 다음 페이지로 이동
			updatePage(); // 페이지 업데이트
		}
	});

	// 초기 페이지 로드 시 페이지 업데이트
	updatePage();
});

function showFileInput() {
	document.getElementById("fileInput").click();
}

function previewImage(input) {
	if (input.files && input.files[0]) {
		const reader = new FileReader();
		reader.onload = function(e) {
			const imgPreview = document.getElementById("imgPreview");
			imgPreview.src = e.target.result;
			imgPreview.style.display = "block";
		};
		reader.readAsDataURL(input.files[0]);
	}
}

function validateForm() {
	const fileInput = document.getElementById('fileInput');
	const productName = document.querySelector('.productName').value;
	const selectElements = document.querySelectorAll('.addSelectContent');

	if (productName.trim() === '') {
		alert('제품명을 입력해주세요.');
		return false;
	}

	for (let i = 0; i < selectElements.length; i++) {
		if (selectElements[i].value === '') {
			alert('필수 항목을 선택해주세요.');
			return false;
		}
	}

	if (fileInput.value === '') {
		alert('파일을 등록하세요.');
		return false;
	}
	return true;
}