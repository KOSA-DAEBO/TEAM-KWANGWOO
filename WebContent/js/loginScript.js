
function loginChk(){

    if (!document.loginForm.usrId.value) {
        document.loginForm.usrId.focus();
        alert("아이디를 입력하십시요.");
        return false;
    }

    if (!document.loginForm.usrPwd.value) {
        alert("비밀번호를 입력하십시요.");
        document.loginForm.usrPwd.focus();
        return false;
    }

    return true;
}