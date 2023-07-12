function loadSelectedPage() {
  var selectBox = document.getElementById('selectDept');
  var selectedId = selectBox.options[selectBox.selectedIndex].id;
  var xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      document.getElementById('content').innerHTML = xhr.responseText;
    }
  };

  switch(selectedId) {
    case 'insertDept':
      xhr.open('GET', 'insertDeptView.do', true);
      xhr.send();
      break;
    case 'deleteDept':
      xhr.open('GET', 'deleteDeptView.do', true);
      xhr.send();
      break;
    case 'updateDept':
      xhr.open('GET', 'updateDeptView.do', true);
      xhr.send();
      break;
  }
}