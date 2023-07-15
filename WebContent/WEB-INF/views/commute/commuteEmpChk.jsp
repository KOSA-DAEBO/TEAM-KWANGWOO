<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="../../../fixed/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>출근 체크</title>
</head>
<body>
<div class="commute_title">출퇴근 체크</div>
<section class="commute_Page">
    <form action="commuteEmpChkOk.do" method="post" name="commuteChk">
        <div>
            <table class=commute_table>
                <tr>
                    <td>
                        <label>출근 : </label>
                    </td>
                    <td>
                        <input class="commute_Input" type="text" name="goChk" id="goChk" placeholder="출근 전" disabled value = "${att[0]}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>퇴근 : </label>
                    </td>
                    <td>
                        <input class="commute_Input" type="text" name="leaveChk" id="leaveChk" placeholder="퇴근 전" disabled value = "${att[1]}"/>
                    </td>
                </tr>
            </table>
            <input type="submit" <c:if test="${!login.empStatus}"> value="출근 하기"</c:if>
                    <c:if test="${login.empStatus}"> value="퇴근 하기"</c:if>id="commuteButton" name="commuteButton"/>
        </div>
    </form>
</section>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>