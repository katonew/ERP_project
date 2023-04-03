let rno = document.querySelector('.rno').innerHTML
console.log(rno)
let requestinfo = null;

getrequest()
function getrequest(){
	$.ajax({
		url : "/erp/request",
		method : "get",
		data : { "type" : 2 , "rno" : rno},
		success : (r)=>{
			console.log(r)
			requestinfo = r[0]
			console.log(requestinfo)
			print()
		}
	})
}



function print(){
	// 거래처 모두 가져와서 출력하기
	$.ajax({
		url : "/erp/cust",
		method : "get",
		data : {"type" : 1},
		success : (r)=>{
			console.log(r)
			let html = ``;
			r.forEach((o)=>{
				if(requestinfo.cname==o.cname){
					html += `<option selected="selected" value=${o.custno}>${o.cname}</option>`
				}else{
					html += `<option value=${o.custno}>${o.cname}</option>`
				}
				
			})
			document.querySelector('.cust').innerHTML = html;
		} // success e
	}) // ajax e
	// 상품정보 모두 가져와서 출력하기
	$.ajax({
		url : "/erp/product",
		method : "get",
		data : {"type" : 1},
		success : (r)=>{
			console.log(r)
			let html = ``;
			r.forEach((o)=>{
				if(requestinfo.pname==o.pname){
					html += `<option selected="selected" value=${o.pno}>${o.pname}</option>`
				}else{
					html += `<option value=${o.pno}>${o.pname}</option>`
				}
			})
			document.querySelector('.product').innerHTML = html;
		} // success e
	}) // ajax e
	document.querySelector('.custemp').innerHTML = requestinfo.empname
	document.querySelector('.quantity').value = requestinfo.quantity
	document.querySelector('.enter_date').value = requestinfo.enter_date
}

function requestUpdate(){
	let custno = document.querySelector('.cust').value
	let pno = document.querySelector('.product').value
	let quantity = document.querySelector('.quantity').value
	$.ajax({
		url : "/erp/request",
		method : "put",
		data : { 
			"rno" : rno,
			"custno" : custno ,
			"pno" : pno,
			"quantity" : quantity
		},
		success : (r)=>{
			console.log(r)
			if(r=='true'){
				alert('수정성공')
				location.href="/erp/request/allrequest.jsp"
			}
		}
	})
}