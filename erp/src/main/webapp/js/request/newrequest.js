console.log(empinfo)


print()
function print(){
	// 거래처 모두 가져와서 출력하기
	$.ajax({
		url : "/erp/cust",
		method : "get",
		success : (r)=>{
			console.log(r)
			let html = ``;
			r.forEach((o)=>{
				html += `<option value=${o.custno}>${o.cname}</option>`
			})
			document.querySelector('.cust').innerHTML = html;
		} // success e
	}) // ajax e
	// 상품정보 모두 가져와서 출력하기
	$.ajax({
		url : "/erp/product",
		method : "get",
		success : (r)=>{
			console.log(r)
			let html = ``;
			r.forEach((o)=>{
				html += `<option value=${o.pno}>${o.pname}</option>`
			})
			document.querySelector('.product').innerHTML = html;
		} // success e
	}) // ajax e
	document.querySelector('.custemp').innerHTML = empinfo.ename
}
function newrequest(){
	
	let custno = document.querySelector('.cust').value
	let pno = document.querySelector('.product').value
	let enter_date = document.querySelector('.enter_date').value
	let quantity = document.querySelector('.quantity').value
	$.ajax({
		url : "/erp/request",
		method : "post",
		data : {
			"custno" : custno ,
			"pno" : pno,
			"enter_date" : enter_date,
			"quantity" : quantity,
			"empno" : empinfo.empno,
			"comno" : empinfo.comno
		},
		success : (r)=>{
			console.log(r)
			if(r=='true'){
				alert('발주 등록 성공')
				location.href="/erp/index.jsp";
			}else{alert('발주 등록 실패')}
		}
	})
}