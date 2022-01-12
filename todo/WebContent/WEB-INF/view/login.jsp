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
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container pt-5 text-center">
		<h2>
			공지사항<a href="${pageContext.request.contextPath}/noticeList">more</a>
		</h2>
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th>제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			<c:forEach var="v" items="${noticeList}">
				<tr>
					<td><a href="${pageContext.request.contextPath}/noticeOne?noticeNo=${v.noticeNo}">${v.noticeTitle}</a></td>
					<td>${v.createDate}</td>
				</tr>
			</c:forEach>
		</table>
		</div>
		<div>
			<div class="text-center"><a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/adminLogin">관리자 로그인</a></div>
			<!-- 1) /adminLogin, AdminLoginController.doGet(), adminLogin.jsp -->
			<!-- 2) /adminLogin, dminLoginController.doPost(), /admin/adminIndex, AdminIndexController.doGet(), adminIndex.jsp -->
		</div>
		<div class="text-center">
		<h1 style="margin-top: 130px; color:#A5A5A5;">로그인</h1>
	</div>
	<div class="text-center">
	<form method="post" action="${pageContext.request.contextPath}/login">
			<div class="mx-auto m-3" style="width:400px;">
				<div><input type="text" name="memberId" placeholder="I D" class="form-control" value="1234"></div>
				<div><input type="password" name="memberPw" placeholder="Password" class="form-control" value="1234"></div>
			</div>
			<div>
				<button type="submit" class="btn btn-outline-primary">로그인</button>
				<a href="${pageContext.request.contextPath}/addMember" class="btn btn-outline-primary">회원가입</a>
			</div>
	</form>
	</div>
			<script>
    // 유효성 검사
    function login(){		
		if($("#memberId").val() == ""){
			alert('ID를 입력하세요.');
			return;
		} else if($("#memberPw").val() == ""){
			alert('PW를 입력하세요.');
			return;
		} else {
			Login.submit();
		}
	};
</script>
</body>
</html>