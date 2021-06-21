<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must_revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>OO커뮤니티 : 사용자정보</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/user_detail.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <script>
    	<c:if test="${userInfo == null}">
    		location.href = "/";
    	</c:if>
    </script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <div class="content_wrap">
        <div class="userInfo">
            <div class="profile_img">
                <img src="http://placehold.it/200x200">
                <button>사진교체</button>
            </div>
            <div class="profile_info">
                <a id="modify" href="/member/modify"><i class="fas fa-edit"></i> 정보수정</a>
                <div>
                    <span class="user_level">${user_detail.ui_user_grade}</span>
                    <span class="user_id">${user_detail.ui_name} (${user_detail.ui_id})</span>
                    <span class="item_label"><i class="fas fa-user"></i> 유형</span>
                    <span class="item_content">
                        <c:if test="${user_detail.ui_user_type == 1}">관리자</c:if>
                        <c:if test="${user_detail.ui_user_type == 2}">정회원</c:if>
                        <c:if test="${user_detail.ui_user_type == 3}">준회원</c:if>
                        <c:if test="${user_detail.ui_user_type == 4}">가입대기</c:if>
                    </span>
                    <span class="item_label"><i class="fas fa-envelope"></i> 메일</span>
                    <span class="item_cotent"><a href="#">${user_detail.ui_email}</a></span>
                </div>
                <div>
                    <span class="item_label"><i class="fas fa-rss"></i> 블로그</span>
                    <span class="item_cotent">
                        <c:if test="${user_detail.ui_blog != null}">
                            <a href="${user_detail.ui_blog}">${user_detail.ui_blog}</a>
                        </c:if>
                        <c:if test="${user_detail.ui_blog == null}">
                            <span style="color:#aaa">블로그 정보가 없습니다.</span>
                        </c:if>

                    </span>
                </div>
                <div>
                    <span class="item_label"><i class="fas fa-edit"></i> 작성 게시글 수</span>
                    <span class="item_cotent">${postCnt}</span>
                    <span class="item_label"><i class="fas fa-thumbs-up"></i> 좋아요</span>
                    <span class="item_cotent">${likeCnt}</span>
                    <span class="item_label"><i class="fas fa-thumbs-down"></i> 싫어요</span>
                    <span class="item_cotent">${dislikeCnt}</span>
                </div>
                <textarea disabled>
                    <c:if test="${user_detail.ui_introduce == null}">등록된 자기소개가 없습니다.</c:if>
                    <c:if test="${user_detail.ui_introduce != null}">${user_detail.ui_introduce}</c:if>
                </textarea>
            </div>
        </div>
        <div class="user_recent_posts">
            <table>
            	<thead>
            		<th>게시판</th>
            		<th>제목</th>
            		<th>작성일</th>
            		<th>조회수</th>
            	</thead>
            	<tbody>
            		<c:forEach items="${recentPosts}" var="post">
            			<tr>
            				<td>${post.bi_name}</td>
            				<td>
            					<c:choose>
            						<c:when test="${post.pi_board_seq == 1}">
            							<a href="/notice/detail?no=${post.pi_seq}" target="_blink">
            								${post.pi_title}
            							</a>
            						</c:when>
            						<c:when test="${post.pi_board_seq == 5}">
            							<a href="/stock/detail?no=${post.pi_seq}" target="_blink">
            								${post.pi_title}
            							</a>
            						</c:when>
            					</c:choose>
            				</td>
            				<td>
            					<fmt:formatDate value="${post.pi_reg_dt}" pattern="yyyy-MM-dd HH-mm"/>
            				</td>
            				<td>${post.pi_count}</td>
            			</tr>
            		</c:forEach>
            	</tbody>
            </table>
        </div>
    </div>
</body>
</html>