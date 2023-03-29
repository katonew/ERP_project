<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/erp/css/login.css" rel="stylesheet">
</head>
<body>
	<%@ include file = "/header.jsp" %>
	<div class="container">
		<div class="loginbox">
			<h3>로그인</h3>
			<div>
				<input class="cloginno form-control" type="text" placeholder="회사코드">
			</div>
			<div>
				<input class="empid form-control" type="text" placeholder="아이디">
			</div>
			<div>
				<input class="emppwd form-control" type="password" placeholder="비밀번호">
			</div>
			<button class="loginbtn btn btn-primary" onclick="login()" type="button">로그인</button>
			<div class="checkbox"></div>
		
		</div>
		
	</div>
	
	<script src="/erp/js/member/login.js" type="text/javascript"></script>
</body>
</html>