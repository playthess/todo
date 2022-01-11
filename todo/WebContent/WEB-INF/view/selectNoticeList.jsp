<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>공지 리스트</title>
</head>
<body>
<div class="container pt-5 text-center">
	<h1>공지사항 목록</h1>
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th>제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			<c:forEach var="f" items="${noticeList}">
			<tr>
				<td><a href="${pageContext.request.contextPath}/noticeOne?noticeNo=${f.noticeNo}">${f.noticeTitle}</a></td>
				<td>${f.createDate}</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<a href="${pageContext.request.contextPath}/login" class="btn btn-outline-info">돌아가기</a>
	</div>
</body>
</html>