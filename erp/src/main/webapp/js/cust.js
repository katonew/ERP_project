console.log('cust js 열림')

function newcust(){
	let cname = document.querySelector('.cname').value
	let custemp = document.querySelector('.custemp').value
	let custphone = document.querySelector('.custphone').value
	let custaddress = document.querySelector('.custaddress').value
	
	$.ajax({
		url : "/erp/cust",
		method : "post",
		data : {
			"cname" : cname,
			"custemp" : custemp,
			"custphone" : custphone,
			"custaddress" : custaddress,
		},
		success : (r)=>{
			console.log(r)
			if(r=='true'){
				alert('거래처 등록 성공')
				location.href="/erp/index.jsp";
			}else{alert('거래처 등록 실패')}
		} // success e
	}) // ajax e
} // newcust e