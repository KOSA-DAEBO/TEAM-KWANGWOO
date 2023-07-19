function joinChkCustomer() {

    if (!document.joinCustomer.usrId.value) {
        document.joinCustomer.usrId.focus();
        alert("아이디를 입력하십시요.");
        return false;
    }

    if(document.joinCustomer.idDuplicateChk.value == "no"){
        document.joinCustomer.usrId.focus();
        alert("아이디 중복체크를 해주세요.");
        return false;
    }

    if (!document.joinCustomer.usrPwd.value) {
        alert("비밀번호를 입력하십시요.");
        document.joinCustomer.usrPwd.focus();
        return false;
    }

    if (!document.joinCustomer.usrPwdCheck.value) {
        alert("비밀번호 확인을 입력하십시요.");
        document.joinCustomer.usrPwdCheck.focus();
        return false;
    }

    if (!document.joinCustomer.usrName.value) {
        alert("이름을 입력하십시요.");
        document.joinCustomer.usrName.focus();
        return false;
    }

    if (!document.joinCustomer.sample6_postcode.value) {
        alert("우편번호 찾기를 해주십시오.");
        document.joinCustomer.sample6_postcode.focus();
        return false;
    }

    if (!document.joinCustomer.sample6_detailAddress.value) {
        alert("상세주소를 입력하십시요.");
        document.joinCustomer.sample6_detailAddress.focus();
        return false;
    }

    if (!document.joinCustomer.usrTel.value) {
        alert("전화번호를 입력하십시요.");
        document.joinCustomer.usrTel.focus();
        return false;
    }

    var usrId = document.joinCustomer.usrId.value;
    var pattern = /^[a-z0-9_-]{5,20}$/;

    if (!pattern.test(usrId)) {
        alert("아이디는 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
        document.joinCustomer.usrId.focus();
        return false;
    }

    var usrPwd = document.joinCustomer.usrPwd.value;
    var usrPwdCheck = document.joinCustomer.usrPwdCheck.value;
    var pattern2 = /^[a-zA-Z0-9!@#$%^&*()_+]{8,16}$/;

    if (!pattern2.test(usrPwd)) {
        alert("비밀번호는 비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자를 사용가능합니다");
        document.joinCustomer.usrPwd.focus();
        return false;
    }

    if (usrPwd != usrPwdCheck) {
        document.joinCustomer.usrPwdCheck.focus();
        alert("비밀번호확인이 비밀번호와 일치 하지 않습니다.");
        return false;
    }

    return true;

}

function joinChkEmp() {

    if (!document.joinEmp.usrId.value) {
        document.joinEmp.usrId.focus();
        alert("아이디를 입력하십시요.");
        return false;
    }

    if(document.joinEmp.idDuplicateChk.value == "no"){
        document.joinEmp.usrId.focus();
        alert("아이디 중복체크를 해주세요.");
        return false;
    }


    if (!document.joinEmp.usrPwd.value) {
        alert("비밀번호를 입력하십시요.");
        document.joinEmp.usrPwd.focus();
        return false;
    }

    if (!document.joinEmp.usrPwdCheck.value) {
        alert("비밀번호 확인을 입력하십시요.");
        document.joinEmp.usrPwdCheck.focus();
        return false;
    }

    if (!document.joinEmp.usrName.value) {
        alert("이름을 입력하십시요.");
        document.joinEmp.usrName.focus();
        return false;
    }

    if (!document.joinEmp.sample6_postcode.value) {
        alert("우편번호 찾기를 해주십시오.");
        document.joinEmp.sample6_postcode.focus();
        return false;
    }

    if (!document.joinEmp.sample6_detailAddress.value) {
        alert("상세주소를 입력하십시요.");
        document.joinEmp.sample6_detailAddress.focus();
        return false;
    }

    if (!document.joinEmp.usrTel.value) {
        alert("전화번호를 입력하십시요.");
        document.joinEmp.usrTel.focus();
        return false;
    }

    var usrId = document.joinEmp.usrId.value;
    var pattern = /^[a-z0-9_-]{5,20}$/;

    if (!pattern.test(usrId)) {
        alert("아이디는 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
        document.joinEmp.usrId.focus();
        return false;
    }

    var usrPwd = document.joinEmp.usrPwd.value;
    var usrPwdCheck = document.joinEmp.usrPwdCheck.value;
    var pattern2 = /^[a-zA-Z0-9!@#$%^&*()_+]{8,16}$/;

    if (!pattern2.test(usrPwd)) {
        alert("비밀번호는 비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자를 사용가능합니다");
        document.joinEmp.usrPwd.focus();
        return false;
    }

    if (usrPwd != usrPwdCheck) {
        document.joinEmp.usrPwdCheck.focus();
        alert("비밀번호확인이 비밀번호와 일치 하지 않습니다.");
        return false;
    }

    if (!document.joinEmp.companyCode.value) {
        alert("회사 식별번호를 입력하십시요.");
        document.joinEmp.companyCode.focus();
        return false;
    }

    return true;

}



function idChk() {
    var usrId = document.getElementById("usrId").value;
    var new_window_width = 500;
    var new_window_height = 370;
    var positionX = (window.screen.width / 2) - (new_window_width / 2);
    var positionY = (window.screen.height / 2) - (new_window_height / 2);
    var pattern = /^[a-z0-9_-]{5,20}$/;


    if (!usrId) {
        alert("아이디를 입력하십시요.");
    }else if (!pattern.test(usrId)) {
        alert("아이디는 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
        return false;
    }else{
        window.open(
            "idDuplChk.do?usrId="+usrId,
            "아이디 중복체크",
            "width=" + new_window_width + ", height=" + new_window_height + ", top=" + positionY + ", left=" + positionX
        );
    }
}

function idConfirm(){
    opener.document.getElementById("usrId").value = document.dupleChk.usrId.value;
    opener.document.getElementById("usrId").readOnly = true;
    opener.document.getElementById("idDuplicateChk").value = "ok";
    window.close();
}

function idDupleChk(){
    if (!document.dupleChk.usrId.value) {
        document.dupleChk.usrId.focus();
        alert("아이디를 입력하십시요.");
        return false;
    }

    var usrId = document.dupleChk.usrId.value;
    var pattern = /^[a-z0-9_-]{5,20}$/;

    if (!pattern.test(usrId)) {
        alert("아이디는 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
        document.dupleChk.usrId.focus();
        return false;
    }

    return true;
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