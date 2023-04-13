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
		<h3>발주 등록 페이지</h3>
		거래처명 : <select class="cust"></select></br>
		담당자명 :	<span class="custemp" type="text"></span></br>
		<div class="product-info">
		    <div class="product-group">
		      상품: <select class="product"></select></br>
		      발주수량: <input class="quantity" type="text"></br>
		    </div>
		    <div class="product-group">
		      상품: <select class="product"></select></br>
		      발주수량: <input class="quantity" type="text"></br>
		    </div>
		    <div class="product-group">
		      상품: <select class="product"></select></br>
		      발주수량: <input class="quantity" type="text"></br>
		    </div>
		    <div class="product-group">
		      상품: <select class="product"></select></br>
		      발주수량: <input class="quantity" type="text"></br>
		    </div>
		    <div class="product-group">
		      상품: <select class="product"></select></br>
		      발주수량: <input class="quantity" type="text"></br>
		    </div>
		</div>
		등록일자 :	<input class="enter_date" type="text"></br>
		<button onclick="newrequest()" type="button">발주 등록</button>
				
	</div>
	
	<script src="/erp/js/request/newrequest.js" type="text/javascript"></script>

</body>
</html>