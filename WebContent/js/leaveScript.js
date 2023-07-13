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