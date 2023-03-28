<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/header.jsp" %>
	<div class="container">
		<h3>직원 등록 페이지</h3>
	    사원이름 :  	<input class="ename" type="text"></br>
	    직급 : 		<input class="erank" type="text"></br>
	    사내전화번호 :	<input class="officephone" type="text"></br>
	    주민번호  : 	<input class="ssnum" type="text"></br>
	    집주소  : 	<input class="address" type="text"></br>
	    연락처  : 	<input class="mobile" type="text"></br>
	    아이디 : 		<input class="empid" type="text"></br>
	    비밀번호 :  	<input class="emppwd" type="password"></br>
	    입사일 :  	
	    <select class="year">
			<option>2023</option>
		</select>-
		<select class="month">
			<option>03</option>
		</select>-
		<select class="date">
			<option>28</option>
		</select></br>
	    권한정보 : <select class=authority>
	    			<option value="1">일반</option>	
	    			<option value="2">인사</option>
	    			<option value="3">관리자</option>
	    		</select></br>
		<button onclick="newmember()" type="button">직원 등록</button>
	</div>
	
	<script src="/erp/js/admin/newmember.js" type="text/javascript"></script>
</body>
</html>