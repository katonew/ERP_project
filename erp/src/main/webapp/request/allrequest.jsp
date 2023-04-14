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
		<h3>발주 목록</h3>
		<table class="table requesttable"></table>
		<a href="/erp/request/newrequest.jsp"><button>발주 등록</button></a>
	</div>
	
	<script src="/erp/js/request/allrequest.js" type="text/javascript"></script>

</body>
</html>