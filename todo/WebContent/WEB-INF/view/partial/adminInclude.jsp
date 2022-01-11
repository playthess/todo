<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container pt-5 text-center">
		<h3>관리자 ${loginAdmin.adminId}님의 메뉴</h3>
		<p>관리자 메뉴</p>
		<ul class="nav justify-content-center">
			<li class="nav-link"><a class="nav-link" href="${pageContext.request.contextPath}/admin/adminMain">관리자 홈</a></li>
			<li class="nav-link"><a class="nav-link" href="${pageContext.request.contextPath}/admin/adminNotice">공지관리</a></li>
			<li class="nav-link"><a class="nav-link" href="${pageContext.request.contextPath}/admin/logout">로그아웃</a></li>
		</ul>
	</div>


</body>
</html>