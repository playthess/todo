<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calendar</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
@import url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap');
</style>
<style>
.button {
  padding: 25px 30px;
  font-size: 18px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: #6ae4fc;
  border: none;
  border-radius: 30px;
  box-shadow: 0 8px #ddd;
  width: 150px;
}

.button:hover {background-color: #70e7ff}

.button:active {
  background-color: #5c74ff;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}

.Blue:hover {
  border-color: #0080ff !important;
  background-color: #0080ff !important;
}

body {
  font-family:  'Ubuntu', sans-serif;
  padding: 20px;
  background: #f1f1f1;
}

/* Header/Blog Title */
.header {
  padding: 30px 50px 40px 40px;
  font-size: 35px;
  text-align: center;
  background: white;
  width: 100%;
}

/* Create two unequal columns that floats next to each other */
/* Left column */
.leftcolumn {
  float: left;
  width: 100%;
}

/* Right column */
.rightcolumn {
  float: right;
  width: 100%;
}

/* Fake image */
.fakeimg {
  background-color: #d5f4e6;
  width: 100%;
  padding: 20px;
}

/* Add a card effect for articles */
.card {
  background-color: white;
  padding: 20px;
  margin-top: 20px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Footer */
.footer {
  padding: 20px;
  text-align: center;
  background: #ddd;
  margin-top: 20px;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
  .leftcolumn, .rightcolumn {
    width: 100%;
    padding: 0;
  }
}

</style>
</head>
<body>
		<div class="text-center">
			<h3>${loginMember.memberId}님의 TODO LIST</h3>
		</div>
	<div class="container">
	<div class="header">
	  	<span class="float-left">
	         <a class="button btn btn-primary" href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=pre"> 이전 </a>
	    </span>
	    <span class="display-4">
			${targetYear}년 ${targetMonth}월
		</span>
		<span class="float-right">
	         <a class="button btn btn-primary" href="${pageContext.request.contextPath}/member/calendar?currentYear=${targetYear}&currentMonth=${targetMonth}&option=next"> 다음 </a>
	    </span>
	</div>
	</div>
	<div class="container">
		  <div class="leftcolumn">
		    <div class="card" style="height: 100%;">
		     <div class="table-responsive">
				<table class="table table-bordered" border="1">
					<tr class="text-center font-weight-bold">
						<th style="color: red; width: 14%">SUN</th><th style="width: 14%">MON</th><th style="width: 14%">TUE</th><th style="width: 14%">WED</th><th style="width: 14%">THU</th><th style="width: 14%">FRI</th><th style="color: blue; width: 14%">SAT</th>
					</tr>
			<tr>
				<!-- JSTL for문 -->
					<c:forEach var="i" begin="1" end="${startBlank+endDay+endBlank}" step="1">
						<c:if test="${i-startBlank >= 1 && i-startBlank<=endDay}">
							<td>
								<a href="${pageContext.request.contextPath }/member/todoList?y=${targetYear }&m=${targetMonth }&d=${i-startBlank }">${i-startBlank}</a>
								<div>
									<!-- 날짜별 일정 -->
									<c:forEach var="todo" items="${todoList }">
										<c:if test="${i-startBlank == todo.todoDate.substring(8)}">
											<div>${todo.todoContent }</div>
										</c:if>
									</c:forEach>
								</div>
							</td>
						</c:if>
						<c:if test="${i-startBlank < 1 || i-startBlank>endDay}">
							<td>&nbsp;</td>
						</c:if>
						
						<c:if test="${i%7 == 0}">
							</tr><tr>
						</c:if>
					</c:forEach>
			</tr>
		</table>
		</div>
			</div>
				</div>
				</div>
		<div class="container">
			<div class="rightcolumn">
		    <div class="card">
		      <h2 class="font-weight-bold"><span class="font-weight-light small">About </span> ${loginMember.memberId }</h2>
		      <div class="fakeimg" style="height:100px;">Image</div>
		      <p style="padding: 30px 12px 0 10px;">
				<a href="${pageContext.request.contextPath}/member/logout" class="btn btn-outline-primary">로그아웃</a> 
				<a href="${pageContext.request.contextPath}/member/removeMember" class="btn btn-outline-primary">회원탈퇴</a>
			</div>
		    <div class="card">
		      <h3 class="font-weight-bold">total todo</h3>
		      <p>${todoList.size()}</p>
		    </div>
		   </div>
	
	</div>
</body>
</html>