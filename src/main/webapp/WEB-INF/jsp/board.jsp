<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.jsp.system.Ajax, org.json.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
	div{
		display:inline-block;
	}
	div.id, span.author{
		width:100px;
	}
	div.title{
		width:600px
	}
</style>
<script src="/resource/boardlist.js" defer></script>
</head>
<body>
	<div id="boards">
		<template>
			<div class="id">0</div>
			<div class="title">제목</div>
			<div class="author">작성자</div>
		</template>
	</div>
</body>
</html>