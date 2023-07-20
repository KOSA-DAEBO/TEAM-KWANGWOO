<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="../../../fixed/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Team KwangWoo</title>
    <script type="text/javascript" src="./js/joinScript.js"></script>
</head>
<body id="idCheckPage">

<div class="join_title" id="idCheckTitle">아이디 중복 체크 </div>
<form action="idDuplOk.do" method="post" onsubmit="return idDupleChk();" name="dupleChk">
    <div>
        <tr >
            <td class="join_list" >
                <label for="usrId" id = "idChecklist">아이디 : </label>
            </td>
            <td>
                <input type="text" name="usrId" id="usrId" class="join_input" value="${param.usrId}" <c:if
                        test="${sessionScope.duplChkId}"> readonly="true" </c:if> />
            </td>
        </tr>
            <c:if test="${!sessionScope.duplChkId}">
                <input type="submit" class="joinButton" value="중복체크" id="submitButton"/>
            </c:if>
    </div>
    <c:if test="${sessionScope.duplChkId}">
        <button type="button" id="idConfirmButton" class="joinButton" onclick="idConfirm()" >아이디 확인</button>
    </c:if>
</form>

</body>
</html>
