<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="../../../fixed/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Team KwangWoo</title>
    <!-- fullcalendar CDN -->
    <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
    <!-- fullcalendar 언어 CDN -->
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>

    <script type="text/javascript" src='./js/apikey.js'></script>
    <script> var jsonArray = ${jsonArray};  </script>
    <script src='./js/commuteScript.js'></script>

</head>
<body>

<div class="commutePage">
    <div class='commuteTitle'>출퇴근 관리</div>
    <div id='commuteInfo' class = "commutePage" >
        출근 <span class="commuteRounded-bar" id="commuteWork"></span>
        <br>
        휴가 <span class="commuteRounded-bar" id="commuteLeave"></span>
    </div>
    <div id='calendar'>
    </div>
</div>
</body>
</html>
<%@ include file="../../../fixed/footer.jsp" %>