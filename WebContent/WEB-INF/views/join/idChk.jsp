<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>

<script type="text/javascript" src="./js/joinScript.js"></script>

<h1>아이디 중복 체크 </h1>
<form action="idDuplOk.do" method="post" onsubmit="return idDupleChk();" name="dupleChk">
    <div>
        <tr>
            <td class="td_left">
                <label for="usrId">아이디:</label>
            </td>
            <td class="td_ right">
                <input type="text" name="usrId" id="usrId" value="${param.usrId}" <c:if
                        test="${sessionScope.duplChkId}"> readonly="true" </c:if> />
            </td>
        </tr>
        <c:choose>
            <c:when test="${!sessionScope.duplChkId}">
                <input type="submit" value="중복체크" id="submit"/>
            </c:when>
            <c:otherwise>
                <button type="button" id="idConfirm" onclick="idConfirm()">아이디 확인</button>
            </c:otherwise>
        </c:choose>
    </div>
</form>

</body>
</html>
