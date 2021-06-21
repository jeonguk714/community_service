<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must_revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>OO커뮤니티 : 주식</title>
    <script>
        let userRole = "${userInfo.ui_user_type}";
    </script>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/resources/js/detail.js"></script>
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/detail.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
    <div class="content_wrap">
        <h1>주식</h1>
        <div class="title_area">
            <div class="title_left">
                <span id="pi_seq" style="display: none;">${data.pi_seq}</span>
                <span id="no"></span>
                <span id="post_title">${data.pi_title} <span class="comment_cnt"></span></span>
            </div>
            <div class="title_right">
                <span id="post_date"><i class="far fa-calendar-check"></i>
                    <fmt:formatDate value="${data.pi_reg_dt}" pattern="yyyy-MM-dd HH:mm"/>
                </span>
                <span id="post_like"><i class="far fa-thumbs-up"></i>${likes[1]}</span>
                <span id="post_dislike"><i class="far fa-thumbs-down"></i>${likes[0]}</span>
                <span id="post_count"><i class="fas fa-eye"></i>${data.pi_count}</span>
            </div>
        </div>
        <div class="post_body">
            ${data.pi_content}
            <div class="likes_area" data-user-seq="${userInfo.ui_seq}">
                <button id="post_like_btn" data-value="1"><i class="far fa-thumbs-up"></i>좋아요 (${likes[1]})</button>
                <button id="post_dislike_btn" data-value="0"><i class="far fa-thumbs-down"></i>싫어요 (${likes[0]})</button>
            </div>
        </div>
        <c:if test="${data.pi_owner == userInfo.ui_seq}">
            <div class="post_control">
                <a href="/notice/modify?seq=${data.pi_seq}" id="post_modify">수정</a>
                <a href="#" id="post_delete">삭제</a>
            </div>
        </c:if>
        <div class="comment_area">
            <p><i class="far fa-comment-dots"></i>댓글 <span id="total_comments"></span>개</p>
            <div class="comment_list">

            </div>
            <div class="more">
                <button id="more_btn">댓글 더 보기</button>
            </div>
            <!-- <c:forEach items="${comments}" var="comment">
                <div class="comment" style="border: 1px solid #000; margin-bottom: 10px;">
                    <div>
                        <span>${comment.ui_name}</span><span><fmt:formatDate value="${comment.ci_reg_dt}" pattern="yyyy-MM-dd HH:mm"/></span>
                        <div class="likes">
                            <span class="like_cnt">
                                <button id="like_btn">${comment.ci_like}</button>
                            </span>
                            <span class="dislike_cnt">
                                <button id="dislike_btn">${comment.ci_dislike}</button>
                            </span>
                        </div>
                    </div>
                    <p>${comment.ci_content}</p>
                </div>
            </c:forEach> -->
            <c:if test="${userInfo != null}">
                <div class="comment_input" data-user-seq="${userInfo.ui_seq}">
                    <h1>댓글 쓰기</h1>
                    <textarea id="comment_content" placeholder="댓글을 입력해주세요"></textarea>
                    <button id="comment_input_btn">확인</button>
                </div>
            </c:if>
            <c:if test="${userInfo == null}">
                <div class="comment_input">
                    <h1>댓글 쓰기</h1>
                    <textarea disabled placeholder="로그인 후에 작성하실 수 있습니다."></textarea>
                    <button id="comment_input_btn" disabled>확인</button>
                </div>
            </c:if>
        </div>
    </div>
</body>
</html>