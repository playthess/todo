<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addMember</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
@import url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap');
</style>
<style>
body {
  font-family:  'Ubuntu', sans-serif;
  padding: 20px;
  background: #f1f1f1;
}

</style>
</head>
<body>
<div class="mx-auto m-3" style="width:400px;">
	<h1 style="margin-top: 130px; color:#A5A5A5;">회원가입</h1>
	<br>
	<form name="MemberIdCheck" method="post" action="${pageContext.request.contextPath}/memberIdCheck">
		<table class="table">
			<tr>
				<td>ID CHECK</td>
				<td><input type="text" class="form-control text-center" name="memberIdCheck">
					<c:if test="${param.idCheck == true}">
						<p style="color:blue">사용할 수 있는 아이디입니다.</p>
					</c:if>
					<c:if test="${param.idCheck == false}">
						<p style="color:red">사용할 수 없는 아이디입니다.</p>
					</c:if>
				</td>
			</tr>
		</table>
		<button type="button" class="btn btn-outline-primary" onclick="memberIdCheckAction()">중복확인</button>
	</form>
	<br>
	<div class="mx-auto m-3" style="width:400px;">
	<c:set var="memberId" value="${param.memberId}" />
	<form name="AddMember" method="post" action="${pageContext.request.contextPath}/addMember">
		<table class="table">
			<tr>
				<td>ID</td>
				<td><input class="form-control text-center" type="text" name="memberId" value="${memberId}" readonly></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><input class="form-control text-center" type="password" name="memberPw"></td>
			</tr>
		</table>
		<button type="submit" class="btn btn-outline-primary">회원가입</button>
	</form>
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	// 유효성 검사
	function addMember(){
		if($(".memberId").val() == ""){
			alert('ID 중복확인해주세요.');
			return;
		} else if($(".memberPw").val() == ""){
			alert('PW를 입력해주세요.');
			return;
		} else if(!($(".memberPw").val() == $(".memberPw2").val())){
			alert('비밀번호가 다릅니다.');
			return;
		} else{
			AddMember.submit();
		}
	};
	
	function memberIdCheckAction(){
		if($(".memberIdCheck").val() == ""){
			alert('공백을 입력하셨습니다 다시 입력해주세요.');
			return;
		}else{
			MemberIdCheck.submit();
		}
	};
</script>
</body>
</html>