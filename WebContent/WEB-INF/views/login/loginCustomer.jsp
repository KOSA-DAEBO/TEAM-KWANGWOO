<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>고객 로그인</title>

    <script type="text/javascript" src="../../../js/loginScript.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<section class="loginForm">

    <h1>로그인</h1>
    <form action= "loginCustomerOk.do" method="post" onsubmit="return loginChk();" name="login">
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
