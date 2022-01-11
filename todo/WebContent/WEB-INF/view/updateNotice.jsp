<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>todoList</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap');
</style>
<style>
.button {
  padding: 10px 20px;
  font-size: 18px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: #6ae4fc;
  border: none;
  border-radius: 25px;
  box-shadow: 0 8px #ddd;
  
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

/* Create two unequal columns that floats next to each other */
/* Left column */
.leftcolumn {
  float: left;
  width: 80%;
}

/* Right column */
.rightcolumn {
  float: left;
  width: 20%;
  padding-left: 20px;
}

/* Fake image */
.fakeimg {
  background-color: #aaa;
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
	<div class="container pt-5 text-center">
		<div class="container">
			<c:forEach var="n" items="${noticeList}">
				<h3>공지사항 수정</h3>
				<form method="post" action="${pageContext.request.contextPath}/admin/adminUpdateNotice">
					<input type="hidden" name="noticeNo" value="${n.noticeNo}">
					<table class="table table-borderless text-center">
						<tr>
							<td>제목:</td>
							<td><input type="text" name="noticeTitle" value="${n.noticeTitle}"></td>
						</tr>
						<tr>
							<td>내용:</td>
							<td><textarea rows="3" cols="50" name="noticeContent">${n.noticeContent}</textarea>
							</td>
						</tr>
					</table>
					<button type="submit" class="btn btn-outline-primary">수정</button>
				</form>
			</c:forEach>
		</div>
	</div>
</body>
</html>