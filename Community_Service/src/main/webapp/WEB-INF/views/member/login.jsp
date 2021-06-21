<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must_revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>커뮤니티 사이트 : 로그인</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/resources/js/login.js"></script>
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/login.css">
    <script>
        <c:if test="${userInfo != null}">
            location.href = "/";
        </c:if>
    </script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
    <div class="loginbox2">
        <h1>커뮤니티 사이트</h1>
        <div class="input_cell">
            <p>아이디</p>
            <input type="text" id="user_name">
        </div>
        <div class="input_cell">
            <p>비밀번호</p>
            <input type="password" id="user_pwd">
        </div>
        <div class="input_cell">
            <button id="login_btn">로그인</button>
        </div>
        <div class="input_cell">
            <a href="/member/join">회원가입</a>
            <a href="/member/find">아이디/비밀번호 찾기</a>
        </div>
    </div>
</body>
</html>