<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../../fixed/headerWhithoutMenu.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>고객 회원가입</title>

    <script type="text/javascript" src="./js/joinScript.js"></script>
    <c:set var="duplChkId" value="${false}" scope="session"/>

</head>
<body>

<div class="join_title">고객 회원가입</div>

<section class="joinPage">
    <div class="joinBox">
        <form action="joinCustomerOk.do" method="post" onsubmit="return joinChkCustomer();" name="joinCustomer">

            <div class="join_Row">

                <div class="col">

                    <label for="usrId" class="join_list">아이디 :</label>

                    <input type="text" class="join_input" id="usrId" placeholder="아이디 입력" name="usrId" style=" width : 240px;">

                    <button type="button" class="joinButton" id="idCheckButton" onclick="idChk()">중복확인</button>

                    <input type="hidden" id="idDuplicateChk" name="idDuplicateChk" value="no">

                </div>

            </div>

            <div class="join_Row">

                <label for="usrPwd" class="join_list">비밀번호 :</label>

                <input type="password" class="join_input" id="usrPwd" placeholder="비밀번호 입력" name="usrPwd">

            </div>

            <div class="join_Row">

                <label for="usrPwdCheck" class="join_list">비밀번호 확인 :</label>

                <input type="password" class="join_input" id="usrPwdCheck" placeholder="비밀번호 확인" name="usrPwdCheck">

            </div>

            <div class="join_Row">

                <label for="usrName" class="join_list">이름 :</label>

                <input type="text" class="join_input" id="usrName" placeholder="이름 입력" name="usrName">

            </div>

            <div class="join_Row">

                <label for="usrEmail" class="join_list">이메일 :</label>

                <input type="email" class="join_input" id="usrEmail" placeholder="이메일 입력" name="usrEmail">

            </div>

            <div class="join_Row">

                <label for="usrTel" class="join_list">휴대폰번호 :</label>

                <input type="tel" class="join_input" id="usrTel" placeholder="전화번호 입력" name="usrTel">

            </div>

            <div class="join_Row">

                <label for="usrAddr" class="join_list">주소 :</label>

                <input type="text" class="join_input" id="usrAddr" placeholder="주소 입력" name="usrAddr">

            </div>


            <div class="join_Row">

                <label class="join_list">성별 :</label>

                    <input type="radio" class="join_check_input" name="usrGender" value="0" checked>남


                    <input type="radio" class="join_check_input" name="usrGender" value="1">여

            </div>

            <div class="join_Row">

                <label for="usrBirth" class="join_list">생년월일 :</label>

                <input type="date" class="join_input" id="usrBirth" value="1900-01-01" placeholder="생년월일 8자리 입력"
                       name="usrBirth">

            </div>

            <input type="submit" class="joinButton" value="회원가입"/>

        </form>
    </div>
</section>

<div id="atag">
    <a href="joinEmp.do"
       class="changeType">직원 회원가입</a>
</div>

</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>