console.log(empinfo)


print()
function print(){
	// 거래처 모두 가져와서 출력하기
	$.ajax({
		url : "/erp/cust",
		method : "get",
		data : { "type" : 1},
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
		data : { "type" : 1},
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
  let enter_date = document.querySelector('.enter_date').value
  let empno = empinfo.empno
  let comno = empinfo.comno
  let products = []
  let productGroups = document.querySelectorAll('.product-group')
  for(let i=0; i<productGroups.length; i++){
    let pno = productGroups[i].querySelector('.product').value
    let quantity = productGroups[i].querySelector('.quantity').value
    if(pno && quantity){ // Only add product if both values are present
      products.push({"pno": pno, "quantity": quantity})
    }
  }
  $.ajax({
    url : "/erp/request",
    method : "post",
    data : {
      "custno" : custno ,
      "enter_date" : enter_date,
      "empno" : empno,
      "comno" : comno,
      "products" : products
    },
    success : (r)=>{
      console.log(r)
      if(r=='true'){
        alert('발주 등록 성공')
        location.href="/erp/index.jsp";
      }else{
        alert('발주 등록 실패')
      }
    }
  })
}