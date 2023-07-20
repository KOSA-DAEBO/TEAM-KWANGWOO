window.addEventListener("DOMContentLoaded", function() {
	let empsPerPage = 10; //페이지당 출력할 항목
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

function sample6_execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if(data.userSelectedType === 'R'){
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if(data.buildingName !== '' && data.apartment === 'Y'){
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}

			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('sample6_postcode').value = data.zonecode;
			document.getElementById("sample6_address").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("sample6_detailAddress").focus();
		}
	}).open();
}