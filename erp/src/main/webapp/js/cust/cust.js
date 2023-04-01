console.log('cust js 열림')

// 거래처 등록하기
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
				location.href="/erp/cust/allcust.jsp";
			}else{alert('거래처 등록 실패')}
		} // success e
	}) // ajax e
} // newcust e

if(document.querySelector('.custno').innerHTML!=null){
	let custno = document.querySelector('.custno').innerHTML
	$.ajax({
		url : "/erp/cust",
		method : "get",
		data : {"type" : 2, "custno" : custno},
		success : (r)=>{
			console.log(r)
			document.querySelector('.cname').value = r[0].cname
			document.querySelector('.custemp').value = r[0].custemp
			document.querySelector('.cname').value = r[0].cname
			document.querySelector('.custphone').value = r[0].custphone
			document.querySelector('.custaddress').value = r[0].custaddress
			
		} // success e
	}) // ajax e
}


function custupdate(){
	let custno = document.querySelector('.custno').innerHTML
	let cname = document.querySelector('.cname').value
	let custemp = document.querySelector('.custemp').value
	let custphone = document.querySelector('.custphone').value
	let custaddress = document.querySelector('.custaddress').value
	
	$.ajax({
		url : "/erp/cust",
		method : "put",
		data : {
			"cname" : cname,
			"custemp" : custemp,
			"custphone" : custphone,
			"custaddress" : custaddress,
			"custno" : custno
		},
		success : (r)=>{
			console.log(r)
			if(r=='true'){
				alert('거래처 수정 성공')
				location.href="/erp/cust/allcust.jsp";
			}else{alert('거래처 수정 실패')}
		} // success e
	}) // ajax e
}


