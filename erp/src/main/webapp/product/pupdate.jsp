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
		int pno = Integer.parseInt(request.getParameter("pno"));
	%>
	<div class="pno" hidden="hidden"><%=pno %></div>
	<div class="container">
		<h3>상품 수정 페이지</h3>
		상품명 : 	<input class="pname" type="text"></br>
		상품단가 :	<input class="pprice" type="text"></br>
		<button onclick="pupdate()" type="button">상품 수정</button>
				
	</div>
	
	
	<script src="/erp/js/product/pupdate.js" type="text/javascript"></script>
	

</body>
</html>