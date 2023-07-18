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
		let prevButton = document.getElementById("prevButton");
		if (currentPage === 1) {
			prevButton.disabled = true; // 첫 페이지일 경우 비활성화
		} else {
			prevButton.disabled = false; // 첫 페이지가 아닐 경우 활성화
		}

		// 다음 버튼 활성화/비활성화 상태 업데이트
		let nextButton = document.getElementById("nextButton");
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
	const preview = document.getElementById('imgPreview');
	const test = document.getElementById('fileInputText');
	const file = input.files[0];
	const reader = new FileReader();

	reader.onload = function(e) {
		preview.src = e.target.result;
		preview.style.display = 'block';
		test.style.display = 'none';
	};

	if (file) {
		reader.readAsDataURL(file);
	} else {
		preview.src = '#';
		preview.style.display = 'none';
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

function confirmDelete(productNo) {
	const confirmMessage = `해당 상품을 정말 삭제하시겠습니까?`;
	if (confirm(confirmMessage)) {
		location.href = `deleteProduct.do?productNo=${productNo}`;
	}
}

var itemNames = document.querySelectorAll(".itemNameValue");
var itemValues = document.querySelectorAll(".itemValue");
var nowOptions = document.querySelectorAll(".nowOption");

for (var i = 0; i < nowOptions.length; i++) {
	nowOptions[i].textContent = itemNames[i].textContent + "(현재상태)";
	nowOptions[i].setAttribute("value", itemValues[i].textContent);
}

// 수정하기 버튼 요소 가져오기
const updateBtn = document.querySelector(".updateBtn");

// productDetail 요소 가져오기
const productDetail = document.querySelector(".productDetail");

// updateProduct 요소 가져오기
const updateProduct = document.querySelector(".updateProduct");

// 수정하기 버튼 클릭 이벤트 처리
updateBtn.addEventListener("click", function() {
	// productDetail 보이지 않도록 설정
	productDetail.style.display = "none";

	// updateProduct 보이도록 설정
	updateProduct.style.display = "block";
});