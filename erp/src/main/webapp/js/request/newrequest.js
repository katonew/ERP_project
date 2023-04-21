console.log(empinfo)

if(empinfo.empid==null){
	alert('로그인 후 사용가능합니다.')
	location.href="/erp/member/login.jsp"
}

print()
function print(){
	document.querySelector('.custemp').innerHTML = empinfo.ename
	let html = ``
	for(let i=0; i<5;i++){
		html += `<tr class="product-group">
		      <td>
		        <input class="product" ondblclick="productmodal(${i})">
		      </td>
		      <td><input class="quantity" onchange="gettotalPrice(${i})" type="number"></td>
		      <td><input class="pprice" readonly></td>
		      <td><input class="totalPrice" readonly></td>
		    </tr>`
	}
	document.querySelector('.product-info').innerHTML += html;
}
// 발주 등록 함수
function newrequest(){
  let custno = document.querySelector('.cust').dataset.custno;
  let delivery_date = document.querySelector('.delivery_date').value
  let empno = empinfo.empno
  let comno = empinfo.comno
  let products = []
  let productGroups = document.querySelectorAll('.product-group')
  for(let i=0; i<productGroups.length; i++){
    let pno = productGroups[i].querySelector('.product').dataset.pno
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
// 거래처 검색 모달 띄우기
function custmodal(){
	document.querySelector('.modal_wrap').style.display = "block"
	document.querySelector('.modal_title').innerHTML = '거래처 검색';
	let html = 
	`<input class="searchCustbox" type="text">
	<button onclick="searchCust()">검색</button>
	<div class="custList"></div>`
	document.querySelector('.modal_content').innerHTML = html
	searchCust()
	document.querySelector('.modal_btns').innerHTML = 
	`<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>`
}

// 거래처 검색
function searchCust(){
	let search = document.querySelector('.searchCustbox').value;
	let type = 0;
	if(search==''){
		type = 1;
	}else{
		type = 3;
	}
	console.log(type)
	$.ajax({
		url : "/erp/cust",
		method : "get",
		data : { "type" : type , "search" : search},
		success : (r)=>{
			console.log(r)
			let html = ``;
			r.forEach((o)=>{
				html += `<div onclick="selectcust(${o.custno})" value=${o.custno}>${o.cname}</div>`
			})
			document.querySelector('.custList').innerHTML = html;
		} // success e
	}) // ajax e
}
// 모달에서 거래처를 선택했을때 
function selectcust(custno){
	let custinfo = null;
	$.ajax({
		url : "/erp/cust",
		method : "get",
		async : false,
		data : {"type" : 2, "custno" : custno},
		success : (r)=>{
			console.log(r)
			custinfo = r[0]
		}
	})
	document.querySelector('.cust').value = custinfo.cname;
	document.querySelector('.cust').dataset.custno = custno;
	closeModal()
}
// 상품 선택 모달
function productmodal(listno) {
	console.log(listno)
	document.querySelector('.modal_wrap').style.display = "block"
	document.querySelector('.modal_title').innerHTML = '상품 검색';
	let html = 
	`<input class="searchProductbox" type="text">
	<button onclick="searchProduct(${listno})">검색</button>
	<div class="productList"></div>`
	document.querySelector('.modal_content').innerHTML = html;
	searchProduct(listno);
	document.querySelector('.modal_btns').innerHTML = 
	`<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>`
}

// 상품 모달에서 검색버튼 눌렀을때
function searchProduct(listno){
	console.log(listno)
	let search = document.querySelector('.searchProductbox').value;
	let type = 0;
	if(search==''){
		type = 1;
	}else{
		type = 3;
	}
	console.log(type)
	$.ajax({
		url : "/erp/product",
		method : "get",
		data : { "type" : type , "search" : search},
		success : (r)=>{
			console.log(r)
			let html = ``;
			r.forEach((o)=>{
				html += `<div onclick="selectproduct(${o.pno},${listno})" value=${o.pno}>${o.pname}</div>`
			})
			document.querySelector('.productList').innerHTML = html;
		} // success e
	}) // ajax e
}

// 모달에서 상품을 선택했을때
function selectproduct(pno,listno){
	console.log(listno)
	let productInfo = null;
	$.ajax({
		url : "/erp/product",
		method : "get",
		async : false,
		data : {"type" : 2, "pno" : pno},
		success : (r)=>{
			console.log(r)
			productInfo = r[0]
		}
	})
	document.querySelectorAll('.product')[listno].value = productInfo.pname;
	document.querySelectorAll('.product')[listno].dataset.pno = pno;
	document.querySelectorAll('.pprice')[listno].value = productInfo.pprice;
	closeModal()
}

function gettotalPrice(listno){
	let pprice = (document.querySelectorAll('.pprice')[listno].value)*1
	let quantity = document.querySelectorAll('.quantity')[listno].value
	let totalprice = pprice * quantity
	document.querySelectorAll('.totalPrice')[listno].value = totalprice.toLocaleString();
}