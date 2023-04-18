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
		거래처명 : <input onclick="custmodal()" class="cust"></br>
		담당자명 :	<span class="custemp" type="text"></span></br>
		<table class="product-info table table-detail">
			<tr>
				<th>상품</th>
				<th>발주수량</th>
			</tr>
		    <tr class="product-group">
		      <td><select class="product"></select></td>
		      <td><input class="quantity" type="number"></td>
		    </tr>
		    <tr class="product-group">
		      <td><select class="product"></select></td>
		      <td><input class="quantity" type="number"></td>
		    </tr>
		    <tr class="product-group">
		      <td><select class="product"></select></td>
		      <td><input class="quantity" type="number"></td>
		    </tr>
		    <tr class="product-group">
		      <td><select class="product"></select></td>
		      <td><input class="quantity" type="number"></td>
		    </tr>
		    <tr class="product-group">
		      <td><select class="product"></select></td>
		      <td><input class="quantity" type="number"></td>
		    </tr>
		</table>
		납기일 :	<input class="delivery_date" type="date"></br>
		<button onclick="newrequest()" type="button">발주 등록</button>
				
	</div>
	
	<script src="/erp/js/request/newrequest.js" type="text/javascript"></script>

</body>
</html>