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
		<h3>상품 등록 페이지</h3>
		상풍명 : 	<input class="pname" type="text"></br>
		상품단가 :	<input class="pprice" type="text"></br>
		<button onclick="newproduct()" type="button">상품 등록</button>
				
	</div>
	
	
	<script src="/erp/js/product/product.js" type="text/javascript"></script>
	

</body>
</html>