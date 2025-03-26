<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>GnCompony</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/footer.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/companyProfile.css' />">
</head>
<body>
<%@ include file="../header/header.jsp" %>

<div class="wrapper">
    <div class="content">
        <h1 class="title">GnCompony의 생각</h1>
        <p>회사 소개입니다. 회사를 소개합니다...</p>
    </div>

    <%@ include file="../footer/footer.jsp" %>
</div>
</body>

</html>