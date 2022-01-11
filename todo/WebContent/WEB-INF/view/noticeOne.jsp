<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>공지사항</title>
</head>
<body>
	<h1 class="text-center">공지사항</h1>
	<div class="text-center container">
		<table class="text-center table table-striped">
			<c:forEach var="f" items="${noticeElement}">
				<h2>${f.noticeTitle}</h2>
				<tr>
					<th>공지 일자</th>
					<th>수정 일자</th>
				</tr>
				<tr>
					<td>${f.createDate}</td>
					<td>${f.updateDate}</td>
				</tr>
		</table>
		<div class="table table-striped">
			[본문] <br> ${f.noticeContent}
		</div>
		</c:forEach>
		<br>
		<a href="${pageContext.request.contextPath}/login" class="btn btn-outline-primary">돌아가기</a>
	</div>

</body>
</html>