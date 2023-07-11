<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="../../../fixed/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>직원 로그인</title>

    <script type="text/javascript" src="./js/joinScript.js"></script>

</head>
<body>

<section class="loginForm">

    <h1>로그인</h1>
    <form action= "loginEmpOk.do" method="post" onsubmit="return loginChk();" name="login">
        <div>
            <table>
                <tr>
                    <td class="td_left">
                        <label for="usrId">아이디:</label>
                    </td>

                    <td class="td_ right">
                        <input type="text" name="usrId" id="usrId"/>
                    </td>
                </tr>
                <tr>
                    <td class="td_left">
                        <label for="usrPwd">비밀번호:</label>
                    </td>
                    <td class="td_ right">
                        <input type="password" name="usrPwd" id="usrPwd"/>
                    </td>
                </tr>
            </table>
            <input type="submit" value="로그인" id="selectButton"/>
        </div>
    </form>
</section>

</body>
</html>
