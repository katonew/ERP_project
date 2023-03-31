<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 모든페이지 공통 css -->
	<link href="/erp/css/header.css" rel="stylesheet">
	<link href="/erp/css/modal.css" rel="stylesheet">
</head>
<body>
	<%
		int empno = 0;
		if(request.getSession().getAttribute("empno")!=null){
			empno = (Integer)request.getSession().getAttribute("empno") ;
		}
	%>
	<div hidden="" class="empno"><%= empno%></div>
	<div class="container">
		<div class="header">
			<div class="mainlogo">
				<a href="/erp/member/login.jsp"><img src="/erp/img/testimg.png"></a>
			</div>
				<ul class="mainmenu">
					<li><a href="/erp/cust/allcust.jsp">거래처 </a></li>
					<li><a href="/erp/product/allproduct.jsp">상품</a></li>
					<li><a href="/erp/request/allrequest.jsp">발주</a></li>
				</ul>
			
			<div class="submenu"></div>
		</div>
		
	</div>
	
	
	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 js  -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<!-- 모든페이지 공통 js -->
	<script src="/erp/js/header.js" type="text/javascript"></script>
</body>
</html>