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
	<%
		int rno = Integer.parseInt(request.getParameter("rno"));
	%>
	<div class="rno" hidden=""><%=rno %></div>
	
	<div class="container">
		<h3>발주 수정</h3>
		거래처명 : <select class="cust"></select></br>
		담당자명 :	<span class="custemp" type="text"></span></br>
		상품 : 	<select class="product"></select></br>
		주문수량 : <input class="quantity" type="text"></br>
		등록일자 :	<input disabled="disabled" class="enter_date" type="text"></br>
		<button onclick="requestUpdate()" type="button">발주 수정</button>
	</div>
	<script src="/erp/js/request/requestupdate.js" type="text/javascript"></script>
	
</body>
</html>