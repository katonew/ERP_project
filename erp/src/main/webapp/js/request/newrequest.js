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
			let productSelects = document.querySelectorAll('.product');
			for(let i=0; i<productSelects.length; i++){
			  productSelects[i].innerHTML = html;
			}
		} // success e
	}) // ajax e
	document.querySelector('.custemp').innerHTML = empinfo.ename
	document.querySelector('.enter_date').value = '2023-04-14'
}

function newrequest(){
  let custno = document.querySelector('.cust').value
  let delivery_date = document.querySelector('.delivery_date').value
  let empno = empinfo.empno
  let comno = empinfo.comno
  let products = []
  let productGroups = document.querySelectorAll('.product-group')
  for(let i=0; i<productGroups.length; i++){
    let pno = productGroups[i].querySelector('.product').value
    let quantity = productGroups[i].querySelector('.quantity').value
    if(pno && quantity){ // Only add product if both values are present
      products.push({ "pno" :pno, "quantity" : quantity})
    }
  }
  console.log(products)
  console.log(JSON.stringify({
      "custno" : custno ,
      "delivery_date" : delivery_date,
      "empno" : empno,
      "comno" : comno,
      "products" : products
    }))
  $.ajaxSettings.traditional = true
  $.ajax({
    url : "/erp/request",
    method : "post",
    contentType : "application/json",
    data : JSON.stringify({
      "custno" : custno ,
      "delivery_date" : delivery_date,
      "empno" : empno,
      "comno" : comno,
      "products" : products
    }),
    success : (r)=>{
      console.log(r)
      if(r=='true'){
        alert('발주 등록 성공')
        location.href="/erp/request/allrequest.jsp";
      }else{
        alert('발주 등록 실패')
      }
    }
  })
}