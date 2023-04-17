<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file = "/header.jsp" %>
	
	
	<div class="container">
		<h3>발주 목록</h3>
		<table class="table requesttable"></table>
		<a href="/erp/request/newrequest.jsp"><button>발주 등록</button></a>
	</div>
	
	<table id="exampleTable" class="table table-bordered">

	  <thead>
	
	    <tr>
	      	<th>발주번호</th>
			<th>거래처</th>
			<th>담당자</th>
			<th>발주일자</th>
			<th>상품</th>
			<th>금액</th>
			<th>납기일자</th>
			<th>진행상태</th>
			<th>비고</th>
	    </tr>
	  </thead>
	
	  <tbody class="example">
	
	  </tbody>
	
	</table>
	
	<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js" type="text/javascript"></script>
	<script src="/erp/js/request/allrequest.js" type="text/javascript"></script>
	
</body>
</html>