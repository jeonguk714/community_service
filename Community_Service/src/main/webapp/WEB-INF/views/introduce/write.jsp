<%-- write.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항 : 새글</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/resources/js/write.js"></script>
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/write.css">
    <!-- introduce/write.jsp -->
    <script>
        let board_seq = 1;
    </script>
    <%--
    <script>
        <c:if test="${userInfo == null || userInfo.ui_user_type != 1}">
            alert("관리자전용 메뉴입니다.");
            location.href="/";
        </c:if>
    </script>
    --%>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <div class="content_wrap">
        <h1>공지사항 등록</h1>
        <div class="title_area" data-user-seq="${userInfo.ui_seq}">
            <span>제목</span>
            <input type="text" id="post_title">
        </div>
        <div class="content_area">
            <textarea id="post_content"></textarea>
        </div>
        <div class="btn_area">
            <button id="post_save">등록</button>
            <button id="post_cancel">취소</button>
        </div>
    </div>
</body>
</html>