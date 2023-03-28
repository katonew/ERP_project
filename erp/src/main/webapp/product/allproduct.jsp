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
		<h3>상품 목록</h3>
		<table class="table ptable"></table>
		<a href="/erp/product/newproduct.jsp"><button>상품 등록</button></a>
	</div>
	
	<script src="/erp/js/product/allproduct.js" type="text/javascript"></script>


</body>
</html>