<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div id="form-wrapper">

    <!-- 로그인 오류 메시지 표시 -->
    <c:if test="${not empty loginError}">
        <div style="color: red;">${loginError}</div>
    </c:if>

    <h2>로그인</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="mb-3">
            <label for="id" class="form-label">아이디</label>
            <input type="text" class="form-control" id="id" name="id" required>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">비밀번호</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>

        <div class="container">
            <button id="login_btn" type="submit" class="btn btn-primary">로그인</button>
        </div>

        <div class="links">
            <a href="${pageContext.request.contextPath}login/sign-up">회원가입</a>
            <a href="${pageContext.request.contextPath}/find-id">아이디 찾기</a>
            <a href="${pageContext.request.contextPath}/find-password">비밀번호 찾기</a>
        </div>
    </form>
</div>
</body>
</html>
