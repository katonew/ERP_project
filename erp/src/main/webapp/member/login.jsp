<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/header.jsp" %>
	<div class="container">
		<div>
			<input class="cloginno" type="text" placeholder="회사코드">
		</div>
		<div>
			<input class="empid" type="text" placeholder="아이디">
		</div>
		<div>
			<input class="emppwd" type="password" placeholder="비밀번호">
		</div>
		<button onclick="login()" type="button">로그인</button>
		<div class="checkbox"></div>
	</div>
	
	<script src="/erp/js/member/login.js" type="text/javascript"></script>
</body>
</html>