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
    <title>OO커뮤니티 : 변경</title>
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/join.css">
    <script>
    	let ui_seq = "${userInfo.ui_seq}";
    </script>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/resources/js/modify_user.js"></script>
    <script>
    	<c:if test="${userInfo == null}">
    		location.href = "/";
    	</c:if>
    </script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
    <div class="join_form">
        <h1>필수 입력 정보</h1>
        <div class="input_cell">
            <p>아이디</p>
            <input type="text" id="user_id" disabled value="${userInfo.ui_id }">
            <p class="err_msg"></p>
        </div>
        <div class="input_cell">
            <p>이름</p>
            <input type="text" id="user_name" value="${userInfo.ui_name }">
        </div>
        <div class="input_cell">
            <p>이메일</p>
            <input type="text" id="user_email" value="${userInfo.ui_email }">
        </div>
        <div class="input_cell">
            <p>이전 비밀번호</p>
            <input type="password" id="prev_pwd">
        </div>
        <div class="input_cell">
            <p>새 비밀번호</p>
            <input type="password" id="user_pwd">
        </div>
        <div class="input_cell">
            <p>비밀번호 확인</p>
            <input type="password" id="user_pwd_confirm">
        </div>
    </div>
    <div class="join_form">
        <h1>선택 입력 정보</h1>
        <div class="input_cell">
            <p>블로그 주소</p>
            <input type="text" id="user_blog" value="${userInfo.ui_blog }">
        </div>
        <div class="input_cell" style="display: none;">
            <p>프로필 이미지</p>
            <input type="text" disabled id="user_pf_img" value="${userInfo.ui_profile_img }">
        </div>
        <div class="input_cell">
            <p>프로필 메시지</p>
            <input type="text" id="user_pf_msg" value="${userInfo.ui_introduce }">
        </div>
        <button id="join_btn">변경</button>
    </div>
</body>
</html>