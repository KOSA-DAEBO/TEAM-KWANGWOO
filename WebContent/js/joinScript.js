function joinChk() {

    if (!document.joinUsr.usrId.value) {
        document.joinUsr.usrId.focus();
        alert("아이디를 입력하십시요.");
        return false;
    }

    if (!document.joinUsr.usrPwd.value) {
        alert("비밀번호를 입력하십시요.");
        document.joinUsr.usrPwd.focus();
        return false;
    }

    if (!document.joinUsr.usrPwdCheck.value) {
        alert("비밀번호 확인을 입력하십시요.");
        document.joinUsr.usrPwdCheck.focus();
        return false;
    }

    if (!document.joinUsr.usrName.value) {
        alert("이름을 입력하십시요.");
        document.joinUsr.usrName.focus();
        return false;
    }

    if (!document.joinUsr.usrAddr.value) {
        alert("주소를 입력하십시요.");
        document.joinUsr.usrAddr.focus();
        return false;
    }

    if (!document.joinUsr.usrTel.value) {
        alert("전화번호를 입력하십시요.");
        document.joinUsr.usrTel.focus();
        return false;
    }

    var usrId = document.joinUsr.usrId.value;
    var pattern = /^[a-z0-9_-]{5,20}$/;

    if (!pattern.test(usrId)) {
        alert("아이디는 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
        document.joinUsr.usrId.focus();
        return false;
    }

    var usrPwd = document.joinUsr.usrPwd.value;
    var usrPwdCheck = document.joinUsr.usrPwdCheck.value;
    var pattern2 = /^[a-zA-Z0-9!@#$%^&*()_+]{8,16}$/;

    if (!pattern2.test(usrPwd)) {
        alert("비밀번호는 비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자를 사용가능합니다");
        document.joinUsr.usrPwd.focus();
        return false;
    }

    if (usrPwd != usrPwdCheck) {
        document.joinUsr.usrPwdCheck.focus();
        alert("비밀번호확인이 비밀번호와 일치 하지 않습니다.");
        return false;
    }


    return true;

}