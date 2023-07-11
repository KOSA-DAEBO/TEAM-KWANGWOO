<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <meta charset="UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&family=Noto+Sans+KR:wght@300;400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/main.css">
    <link rel="icon" href="./favicon.ico" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="header noindex">
    <div class="head" id="head">
        <div class="head_top">
            <h1>
                <a href="/" title="메인으로 이동"><img src="./images/logo.png"
                                                 alt="광우" class="logo" /></a>
            </h1>
            <div>
                <span class="material-symbols-outlined" OnClick="location.href='loginCustomer.do'">login</span>
                <span class="material-symbols-outlined">logout</span>
                <span class="material-symbols-outlined" OnClick="location.href='joinCustomer.do'">person_add</span>
            </div>
        </div>
        <!-- //head_top -->

        <div class="head_bottom">
            <div class="head_bottom_in">


            </div>
            <!-- //head_bottom_in -->
        </div>
    </div>
</div>
</body>
</html>