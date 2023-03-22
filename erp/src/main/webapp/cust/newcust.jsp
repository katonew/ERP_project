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
		<h3>거래처 등록 페이지</h3>
		거래처명 : 	<input class="cname" type="text"></br>
		담당자명 :		<input class="custemp" type="text"></br>
		거래처번호 : 	<input class="custphone" type="text"></br>
		거래처주소 :	<input class="custaddress" type="text"></br>
		<button onclick="newcust()" type="button">거래처 등록</button>
				
	</div>
	
	<script src="/erp/js/cust/cust.js" type="text/javascript"></script>
	
</body>
</html>