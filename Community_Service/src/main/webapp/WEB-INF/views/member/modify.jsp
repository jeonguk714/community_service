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
	<title>OO커뮤니티 : 정보수정</title>
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<script>
    	<c:if test="${userInfo == null}">
    		location.href = "/";
    	</c:if>
    </script>
	<style>
		body{padding-top: 100px;}
	</style>
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	<h1>정보수정</h1>
	<div class="cert_area">
		<form action="/member/cert" method="post">
			<input hidden name="user_id" type="text" value="${userInfo.ui_id }">
			<span>비밀번호</span><input type="password" name="user_pwd">
			<button type="submit" id="cert_submit">확인</button>
		</form>
	</div>
</body>
</html>