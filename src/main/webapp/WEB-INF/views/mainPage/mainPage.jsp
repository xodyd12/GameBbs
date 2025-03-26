<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>GN Company</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/mainPage.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/footer.css' />">
</head>
<body>

<div id="middle_content" class="middle_content">
    <h2 id="txt_box01" class="txt_box01">GN COMPANY</h2>
    <p id="txt_box02" class="txt_box02">GN COMPANY</p>
    <div id="scroll_container" class="scroll_container">
        <p id="scroll" class="scroll">Scroll Down</p>
        <img src="/img/scroll.png" alt="Scroll Icon" class="scroll_icon">
    </div>
</div>

<div id="main_content" class="main_content">
    <div class="content_wrapper" style="display: flex;">
        <img src="img/main_banner_03.jpg" alt="img" class="inc01" style="background-color: transparent;">
        <div class="text_container">
            <h1 id="main_content01" class="main_content01">새로운 내일을</h1>
            <p id="pmain_content01" class="pmain_content01">함께 만들어 갑니다.</p>
            <p id="company_introduction" class="company_introduction">
                회사 소개 입니다 회사를 소개해 주세요 회사를 소개해주세요<br>
                회사 소개 입니다 회사를 소개해 주세요 회사를 소개해주세요<br>
                회사 소개 입니다 회사를 소개해 주세요 회사를 소개해주세요<br>
                회사 소개 입니다 회사를 소개해 주세요 회사를 소개해주세요
            </p>
        </div>
    </div>
</div>

<div id="company_content" class="company_content">
    <div id="company_text" class="company_text">
        <ul id="main_con">
            <li id="main_con1">
                <a href="/mainPage/companyProfile">
                    <h5>회사소개</h5>
                </a>
            </li>

            <li id="main_con2">
                <a href="/mainPage">
                    <h5>사업안내</h5>
                </a>
            </li>
            <!-- 2025.03.26 서비스 분야 제거
            <li id="main_con3">
                <a href="/mainPage">
                    <h5>서비스 분야</h5>
                </a>
            </li> -->
            <li id="main_con4">
                <a href="/mainPage">
                    <h5>공지사항</h5>
                </a>
            </li>
            <li id="main_con5">
                <a href="/mainPage">
                    <h5>고객센터</h5>
                </a>
            </li>
        </ul>
    </div>
</div>

<%@ include file="../footer/footer.jsp" %>
</body>
</html>
