console.log('cust js 열림')

function newproduct(){
	console.log('newproduct 버튼 눌림')
	let pname = document.querySelector('.pname').value
	let pprice = document.querySelector('.pprice').value
	
	
	$.ajax({
		url : "/erp/product",
		method : "post",
		data : {
			"pname" : pname,
			"pprice" : pprice,
		},
		success : (r)=>{
			console.log(r)
			if(r=='true'){
				alert('상품 등록 성공')
				location.href="/erp/index.jsp";
			}else{alert('상품 등록 실패')}
		} // success e
	}) // ajax e
} // newcust e