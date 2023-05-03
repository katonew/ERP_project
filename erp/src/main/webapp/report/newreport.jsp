<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file = "/header.jsp" %>
	<div class="container">
		<h3>기안 등록 페이지</h3>
		<div>
			<h5>결재라인</h5>
			<table class="table selectLine">
				<tr>
					<th>결재자</th>
					<th>직책</th>
					<th>결재순서</th>
				</tr>
			</table>
		</div>
		<div>수신참조</div>
		<div>
			<input class="title" type="text" placeholder="제목">
		</div>
		<div>첨부파일추가</div>
		<form method="post">
		  <textarea id="summernote" name="editordata"></textarea>
		</form>
		
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="/erp/js/report/newreport.js" type="text/javascript"></script>

</body>
</html>