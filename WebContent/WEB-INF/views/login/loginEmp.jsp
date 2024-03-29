<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="../../../fixed/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Team KwangWoo</title>

    <script type="text/javascript" src="./js/loginScript.js"></script>

</head>
<body>
<div class="login_title">직원 로그인</div>
<section class="loginPage">
    <form action="loginEmpOk.do" method="post" onsubmit="return loginChk();" name="loginForm">
        <div>
            <table class=login_table>
                <tr>
                    <td>
                        <label for="usrId">아이디</label>
                    </td>

                    <td>
                        <input class="login_input" type="text" name="usrId" id="usrId" class="login_input"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="usrPwd">비밀번호</label>
                    </td>
                    <td>
                        <input class="login_input" type="password" name="usrPwd" id="usrPwd"/>
                    </td>
                </tr>
            </table>
            <input type="submit" value="로그인" id="loginButton"/>
        </div>
    </form>
</section>
<div id="atag">
    <a href="loginCustomer.do"
       class="changeType">고객 로그인</a>
</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>