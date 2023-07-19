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

// price 합계를 저장할 변수
let totalPrice = 0;

// 각 itemNameValue 요소에 대해 반복
let itemValues = document.querySelectorAll('.itemPrice');
for (let i = 0; i < itemValues.length; i++) {
	// price 값을 가져와서 totalPrice에 더함
	let price = parseInt(itemValues[i].textContent);
	totalPrice += price;
}

// totalPrice를 price 요소에 출력
let priceElement = document.querySelector('.price');
priceElement.textContent = ":  " + totalPrice.toLocaleString() + "원";

function buyProduct(usrId) {
	// 로그인 상태 확인
	let customerDto = usrId;
	if (customerDto === "") {
		alert("로그인 후 가능한 기능입니다.");
		window.location.href = "loginCustomer.do"; // 로그인 페이지로 이동
	} else {
		let confirmed = confirm("정말 구매하시겠습니까?");
		if (confirmed) {
			sendDataToServer(); // 구매하기 기능
		}
	}
}

function sendDataToServer() {
	// forEach 문에서 추출한 데이터를 배열에 저장
	let itemData = [];
	let itemValues = $(".itemValue");
	let itemPrices = $(".itemPrice");

	for (var i = 0; i < itemValues.length; i++) {
		let item = {
			itemValue: $(itemValues[i]).text(),
			itemPrice: $(itemPrices[i]).text()
		};
		itemData.push(item);
	}

	// AJAX 호출
	$.ajax({
		url: "./buyProduct.do",
		type: "POST",
		data: JSON.stringify(itemData),
		contentType: "application/json;charset=UTF-8",
		success: function(response) {
			window.location.href = "index.jsp";
		},
		error: function(xhr, status, error) {
			console.error(error);
		}
	});
}

function updateTotalPrice() {
	let totalPrice = 0;
	let selectedItems = [];
	let selects = document.getElementsByTagName("select");
	let isOptionSelected = false;

	for (let i = 0; i < selects.length; i++) {
		if (selects[i].selectedIndex === 0) {
			isOptionSelected = true;
			break;
		}

		let selectedOption = selects[i].options[selects[i].selectedIndex];
		let price = selectedOption.getAttribute("data-price");
		let itemNo = selectedOption.value;
		if (price) {
			totalPrice += Number(price);
			selectedItems.push(itemNo);
		}
	}

	let totalPriceDiv = document.querySelector(".totalPrice");
	totalPriceDiv.textContent = totalPrice.toLocaleString() + " 원";

	return {
		isOptionSelected: isOptionSelected,
		selectedItems: selectedItems,
		totalPrice: totalPrice
	};
}

function buyDiyProduct() {
	let { isOptionSelected, selectedItems, totalPrice } = updateTotalPrice();

	if (isOptionSelected) {
		alert("필수사항을 모두 선택해주세요.");
	} else {
		let url = "buyDiyProduct.do";

		let requestData = {
			totalPrice: totalPrice,
			selectedItems: selectedItems
		};

		let xhr = new XMLHttpRequest();
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		xhr.onreadystatechange = function() {
			if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
				// 요청 완료 후 처리할 작업
				console.log("잘돌아가나?")
				window.location.href = "buyDiyProduct.do";
			} else if (xhr.readyState === XMLHttpRequest.DONE) {
				// 요청 실패 시 처리할 작업
				console.error("Error:", xhr.status);
			}
		};
		xhr.send(JSON.stringify(requestData));
	}
}