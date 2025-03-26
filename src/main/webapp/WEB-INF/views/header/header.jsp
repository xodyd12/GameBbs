<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Custom JSP</title>
</head>
<body>
<div id="sh_nav_wrap" class="mainLogo">
    <h1 id="sh_top_logo"><a href="/mainPage"><img src="<c:url value='/img/icon03.png' />" alt="GNCompany">GNCompany</a></h1>
    <!-- sh_nav [s] -->
    <ul id="sh_nav">
        <li class="menu-item active">
            <a href="/mainPage">회사소개</a>
            <ul class="sh_nav_s">
            </ul>
        </li>
        <li class="menu-item">
            <a href="">사업안내</a>
            <ul class="sh_nav_s">
            </ul>
        </li>
        <li class="menu-item">
            <a href="">서비스 분야</a>
            <ul class="sh_nav_s">
            </ul>
        </li>
        <li class="menu-item">
            <a href="">공지사항</a>
            <ul class="sh_nav_s">
            </ul>
        </li>
        <li class="menu-item">
            <a href="">고객센터</a>
            <ul class="sh_nav_s">
            </ul>
        </li>
        <c:choose>
            <c:when test="${not empty loginUser}">
                <li class="menu-item">
                    <a href="/logout">로그아웃</a>
                    <span class="user-greeting">${UserName}님, 안녕하세요!</span>
                </li>
            </c:when>
            <c:otherwise>
                <li class="menu-item">
                    <a href="/login">로그인</a>
                    <ul class="sh_nav_s"></ul>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
    <div id="menuLine" style="left: 354.5px; width: 128.891px;"></div>
    <!-- sh_nav [e] -->

    <!-- pfWrap [s] -->
    <div id="pfWrap" style="display: none; right: -100%;">
        <div class="pf_cate" style="display: block; overflow: hidden; width: 0px;">
            <ul>
                <li style="opacity: 0; margin-left: 100px;"><a href="sub1.html"><span class="nav_num">01</span>회사소개</a></li>
                <li style="opacity: 0; margin-left: 100px;"><a href=""><span class="nav_num">02</span>사업안내</a></li>
                <li style="opacity: 0; margin-left: 100px;"><a href=""><span class="nav_num">03</span>서비스 분야</a></li>
                <li style="opacity: 0; margin-left: 100px;"><a href=""><span class="nav_num">04</span>공지사항</a></li>
                <li style="opacity: 0; margin-left: 100px;"><a href=""><span class="nav_num">05</span>고객센터</a></li>
                <c:choose>
                    <c:when test="${not empty loginUser}">
                        <li style="opacity: 0; margin-left: 100px;"><a href="/logout"><span class="nav_num">06</span>로그아웃</a></li>
                    </c:when>
                    <c:otherwise>
                        <li style="opacity: 0; margin-left: 100px;"><a href="/login"><span class="nav_num">06</span>로그인</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <a class="ct_link" href="">Contact Us</a>
        </div>
    </div>
</div>

</body>
</html>