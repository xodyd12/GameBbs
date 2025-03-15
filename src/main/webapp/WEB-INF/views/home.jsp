<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>홈 페이지</title>
</head>
<body>
<h1>홈 페이지</h1>

<c:choose>
    <c:when test="${not empty sessionScope.loginUser}">
        <p>${sessionScope.loginUser}님 반갑습니다!</p>
        <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
    </c:when>
    <c:otherwise>
        <p>로그인하지 않았습니다.</p>
        <a href="${pageContext.request.contextPath}/login">로그인</a>
    </c:otherwise>
</c:choose>
</body>
</html>
