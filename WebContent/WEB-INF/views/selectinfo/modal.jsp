<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.modal {
	display: none; /* 모달이 기본적으로 숨겨져 있습니다. */
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
	background-color: #fefefe;
	margin: 15% auto;
	padding: 20px;
	border: 1px solid #888;
	width: 20%;
	height: 20%
}

.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		// 모달 창 및 닫기 버튼 요소를 찾습니다.
		var modal = document.getElementById("myModal");
		var closeModal = document.getElementsByClassName("close")[0];

		// 버튼을 클릭하면 모달 창을 표시하는 이벤트 리스너를 추가합니다.
		document.getElementById("showModalButton").onclick = function() {
			modal.style.display = "block";
		}

		document.getElementById("check").onclick = function() {
			var inputaccount = document.getElementById("inputaccount");
			var inputpwd = document.getElementById("inputpwd");
			var empid = document.getElementsByName("empid")[0].value;
			var empno = document.getElementsByName("empno")[0].value;

			if (inputaccount.value == "11" && inputpwd.value == "11") {
				alert("계정과 사번이 일치합니다.");
				modal.style.display = "none";
			} else {
				alert("입력된 값이 올바르지 않습니다.");
				modal.style.display = "none";
			}
		}
		// 닫기 버튼을 클릭하거나 모달 창 외부를 클릭하면 모달 창을 숨기는 이벤트 리스너를 추가합니다.
		closeModal.onclick = function() {
			modal.style.display = "none";
		}
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	});
</script>
</head>
<body>
	<input type="hidden" name="empid" value="${empid }">
	<!-- 비교할 계정 호출 -->
	<input type="hidden" name="empno" value="${empno }">
	<!-- 비교할 암호 호출 -->
	<div id="myModal" class="modal">
		<div class="modal-content">
			<table>
				<tr>
					<th align="left">계정</th>
				</tr>
				<tr>
					<td><input type="text" id="inputaccount"></td>
				</tr>
				<tr>
					<th align="left">사번</th>
				</tr>
				<tr>
					<td><input type="password" id="inputpwd"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" id="check" value="확인"></td>

				</tr>
			</table>
		</div>
	</div>
	<button id="showModalButton">모달 창 표시</button>
</body>
</html>