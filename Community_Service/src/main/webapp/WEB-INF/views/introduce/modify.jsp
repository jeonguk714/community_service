<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항 : 수정</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/resources/js/modify.js"></script>
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/write.css">
    <script>
        <c:if test="${userInfo.ui_seq != postInfo.pi_owner}">
            alert("수정 권한이 없습니다.")
            location.href="/notice"
        </c:if>
    </script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <div class="content_wrap">
        <h1>공지사항 수정</h1>
        <div class="title_area" data-user-seq="${userInfo.ui_seq}" data-post-seq="${postInfo.pi_seq}">
            <span>제목</span>
            <input type="text" id="post_title" value="${postInfo.pi_title}">
        </div>
        <div class="content_area">
            <textarea id="post_content">${postInfo.pi_content}</textarea>
        </div>
        <div class="btn_area">
            <button id="post_save">수정</button>
            <button id="post_cancel">취소</button>
        </div>
    </div>
</body>
</html>