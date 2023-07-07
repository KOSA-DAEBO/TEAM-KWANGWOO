
function loginChk(){

    if (!document.login.usrId.value) {
        document.login.usrId.focus();
        alert("아이디를 입력하십시요.");
        return false;
    }

    if (!document.login.usrPwd.value) {
        alert("비밀번호를 입력하십시요.");
        document.login.usrPwd.focus();
        return false;
    }

    return true;
}