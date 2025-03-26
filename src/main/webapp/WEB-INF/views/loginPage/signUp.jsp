<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입 페이지</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="<c:url value='/js/signUp.js' />"></script>
</head>
<body>
        <div id="form-wrapper">
            <h2>회원가입</h2>
            <div class="end"> *은 필수 입력값 입니다.</div>
            <form action="${pageContext.request.contextPath}/login/sign-up" name="signUp" id="signUpForm" class="signUp-form" method="post">
                <div class="mb-3">
                    <label for="id" class="form-label">*아이디</label>
                    <input type="text" class="form-control" id="id" name="id" required>
                    <button type="button" id="checkIdBtn">중복 확인</button>
                    <div id="idHelp" class="form-text"></div>
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">*비밀번호</label>
                    <input type="text" class="form-control" id="password" name="password">
                    <div id="pwHelp" class="form-text"></div>
                </div>

                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">*비밀번호 확인</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                    <div id="confirmPwHelp" class="form-text"></div>
                </div>

                <div class="mb-3">
                    <label for="nickName" class="form-label">*성함</label>
                    <input type="text" class="form-control" id="nickName" name="nickName">
                    <div id="nickNameHelp" class="form-text"></div>
                </div>

                <div class="mb-3">
                    <label for="phoneNumber" class="form-label">*휴대폰 번호</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
                    <div id="pnHelp" class="form-text"></div>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">*이메일</label>
                    <input type="text" class="form-control" id="email" name="email">
                    <div id="emailHelp" class="form-text"></div>
                </div>


                <div class="container">
                    <button id="sign_ok" type="submit" class="btn btn-primary">가입하기</button>
                </div>


            </form>
        </div>

</body>
</html>