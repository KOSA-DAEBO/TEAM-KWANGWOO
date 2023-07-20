<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../../fixed/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Team KwangWoo</title>

    <script type="text/javascript" src="./js/joinScript.js"></script>
    <c:set var="duplChkId" value="${false}" scope="session"/>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</head>
<body>

<div class="join_title">직원 회원가입</div>

<section class="joinPage">
    <div class="joinBox">
        <form action="joinEmpOk.do" method="post" onsubmit="return joinChkEmp();" name="joinEmp">

            <div class="join_Row">

                <div class="col">

                    <label for="usrId" class="join_list">아이디 :</label>

                    <input type="text" class="join_input" id="usrId" placeholder="아이디 입력" name="usrId">

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

                <label for="sample6_postcode" class="join_list">우편번호 :</label>
                <input type="text" class="join_input" id="sample6_postcode" placeholder="우편번호" disabled>
                <input type="button" class="joinButton" id="sample6_button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>

            </div>

            <div class="join_Row">
                <label for="sample6_detailAddress" class="join_list">상세주소 :</label>
                <input type="text" class="join_input" id="sample6_address" name="sample6_address" placeholder="주소">
                <input type="text" class="join_input" id="sample6_detailAddress" name="sample6_detailAddress" placeholder="상세주소">

            </div>

            <div class="join_Row">

                <label class="join_list">성별 :</label>

                <input type="radio" class="join_radio_input" name="usrGender" value="0" checked >남
                <input type="radio" class="join_radio_input" name="usrGender" value="1">여

            </div>

            <div class="join_Row">

                <label for="usrBirth" class="join_list">생년월일 :</label>

                <input type="date" class="join_input" id="usrBirth" value="1900-01-01" placeholder="생년월일 8자리 입력"
                       name="usrBirth">

            </div>

            <div class="join_Row">

                <label for="companyCode" class="join_list">회사 식별번호 :</label>

                <input type="text" class="join_input" id="companyCode" placeholder="회사번호 입력" name="companyCode">

            </div>

            <input type="submit" class="joinButton" value="회원가입"/>

        </form>
    </div>
</section>

<div id="atag">
    <a href="joinCustomer.do"
       class="changeType">고객 회원가입</a>
</div>

</body>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>