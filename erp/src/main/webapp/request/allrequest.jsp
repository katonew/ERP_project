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
	
	
	<!-- 모달 HTML -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">
				<!-- 제목이 들어가는 자리  -->
			</h3>
			<div class="modal_content">
				<!-- 내용이 들어가는 자리  -->
			</div>
			<div class="modal_btns">
				<button class="modal_check" 	type="button">확인</button>
				<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>
			</div>
		</div>
	</div>
	
	
	<div class="container">
		<h3>발주 목록</h3>
		<table class="table requesttable"></table>
		<a href="/erp/request/newrequest.jsp"><button>발주 등록</button></a>
	</div>
	
	<script src="/erp/js/request/allrequest.js" type="text/javascript"></script>

</body>
</html>