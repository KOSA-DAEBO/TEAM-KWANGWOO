<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>고객 회원가입</title>

    <script type="text/javascript" src="../../../js/joinScript.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<h1>Customer 회원가입</h1>

<div class="container">
    <form action= "joinCustomerOk.do" method="post" onsubmit="return joinChkCustomer();" name="joinCustomer">

        <div class="row">

            <div class="col">

                <label for="usrId">아이디 :</label>

                <input type="text" class="form-control" id="usrId" placeholder="아이디 입력" name="usrId">

            </div>

            <%--<div class="col align-self-end">
            // ID 중복체크 추후 구현

                <button type="button" id="idCheck" class="btn btn-primary" onclick="location.href='/usrIdChk.do?id='" >중복확인</button>

            </div>--%>

        </div>


        <div class="form-group">

            <label for="usrPwd">비밀번호 :</label>

            <input type="password" class="form-control" id="usrPwd" placeholder="비밀번호 입력" name="usrPwd">

        </div>


        <div class="form-group">

            <label for="usrPwdCheck">비밀번호 확인 :</label>

            <input type="password" class="form-control" id="usrPwdCheck" placeholder="비밀번호 확인" name="usrPwdCheck">

        </div>

        <div class="form-group">

            <label for="usrName">이름 :</label>

            <input type="text" class="form-control" id="usrName" placeholder="이름 입력" name="usrName">

        </div>


        <div class="form-group">

            <label for="usrEmail">이메일 :</label>

            <input type="email" class="form-control" id="usrEmail" placeholder="이메일 입력" name="usrEmail">

        </div>


        <div class="form-group">

            <label for="usrTel">휴대폰번호 :</label>

            <input type="tel" class="form-control" id="usrTel" placeholder="전화번호 입력" name="usrTel">

        </div>

        <div class="form-group">

            <label for="usrAddr">주소 :</label>

            <input type="text" class="form-control" id="usrAddr" placeholder="주소 입력" name="usrAddr">

        </div>


        <div class="form-check-inline">

            <label class="form-check-label">

                <input type="radio" class="form-check-input" name="usrGender" value="0" checked>남

            </label>

        </div>


        <div class="form-check-inline">

            <label class="form-check-label">

                <input type="radio" class="form-check-input" name="usrGender" value="1">여

            </label>

        </div>

        <br/><br/>


        <div class="form-group">

            <label for="usrBirth">생년월일 :</label>

            <input type="date" class="form-control" id="usrBirth" value="1900-01-01" placeholder="생년월일 8자리 입력"
                   name="usrBirth">

        </div>

        <br/>

        <input type="submit" class="btn btn-primary" value="회원가입"/>

    </form>
</div>


</body>
</html>
