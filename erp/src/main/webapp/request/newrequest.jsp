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
		거래처명 : <input ondblclick="custmodal()" class="cust"></br>
		담당자명 :	<span class="custemp" type="text"></span></br>
		<table class="product-info table table-detail">
			<tr>
				<th>상품</th>
				<th>발주수량</th>
				<th>단가</th>
				<th>총금액</th>
			</tr>
		</table>
		납기일 :	<input class="delivery_date" type="date"></br>
		<button onclick="newrequest()" type="button">발주 등록</button>
				
	</div>
	
	<script src="/erp/js/request/newrequest.js" type="text/javascript"></script>

</body>
</html>