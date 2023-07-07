<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>고객 로그인</title>
</head>
<body>

<section class="loginForm">

    <h1>로그인</h1>
    <form action= "loginOk.do" method="post" onsubmit="return loginChkCustomer();" name="loginCustomer">
        <div>
            <table>
                <tr>
                    <td class="td_left">
                        <label for="id">아이디:</label>
                    </td>

                    <td class="td_ right">
                        <input type="text" name="id" id="id"/>
                    </td>
                </tr>
                <tr>
                    <td class="td_left">
                        <label for="passwd">비밀번호:</label>
                    </td>
                    <td class="td_ right">
                        <input type="password" name="passwd" id="passwd"/>
                    </td>
                </tr>
            </table>
            <input type="submit" value="로그인" id="selectButton"/>
        </div>
    </form>
</section

</body>
</html>
