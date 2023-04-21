
$("#exampleTable").DataTable({ });
console.log(empinfo)

if(empinfo.empid==null){
	alert('로그인 후 사용가능합니다.')
	location.href="/erp/member/login.jsp"
}

allrequest()
// 모든 발주 가져오기
function allrequest(){
	console.log('allrequest 시작')
	$.ajax({
		url : "/erp/request",
		method : "get",
		data : {"type" : 1},
		success : (r)=>{
			console.log(r)
			let html = `<tr>
							<th>발주번호</th>
							<th>거래처</th>
							<th>담당자</th>
							<th>발주일자</th>
							<th>상품</th>
							<th>금액</th>
							<th>납기일자</th>
							<th>진행상태</th>
							<th>비고</th>
						</tr>`;
			r.forEach((o)=>{
				let productlist = o.products
				let totalprice = 0;
				for(let i=0;i<productlist.length;i++){
					totalprice += productlist[i].pprice * productlist[i].quantity
				}
				html += `<tr>
							<td>${o.rno}</td>
							<td>${o.cname}</td>
							<td>${o.empname}</td>
							<td>${o.enter_date}</td>
							<td onclick="updatemodal(${o.rno})">${o.products[0].pname} 외 ${o.products.length-1}건 </td>
							<td>${totalprice.toLocaleString()}원</td>
							<td>${o.delivery_date==null? " " : o.delivery_date}</td>
							<td>${o.state?"진행중":"납기완료"}</td>
							<td>
								<button onclick="onDone(${o.rno},${o.state})" type="button">완료</button>
							</td>
						</tr>`
			})
			document.querySelector('.example').innerHTML = html;
		} // success e
	}) // ajax e
} // newcust e

// 특정 발주 정보 가져오기
function getRequest(rno){
	let rinfo = null;
	$.ajax({
		url : "/erp/request",
		method : "get",
		async : false,
		data : {"type" : 2, "rno" : rno},
		success : (r)=>{
			console.log(r)
			console.log(r[0])
			rinfo = r[0]
		}
	})
	return rinfo;
}


// 수정 모달 함수
function updatemodal(rno){
	document.querySelector('.modal_wrap').style.display = "block"
	document.querySelector('.modal_title').innerHTML = '발주 수정'
	let rinfo = getRequest(rno);
	console.log(rinfo)
	let html = `<div>발주번호 : ${rinfo.rno}</div>
				<div>거래처 : ${rinfo.cname}</div>
				<table class="table">
				<tr>
					<th>발주품목</th>
					<th>발주수량</th>
					<th>단가</th>
					<th>금액</th>
					<th>비고></th>
				</tr>`
	let totalprice = 0;
	rinfo.products.forEach((o,i)=>{
		html += 
		`<tr class="product-group"> 
			<td><input class="product" value="${o.pname}" readonly></td>
			<td><input type="number" id="${o.ino}" class="quantity" value="${o.quantity}" onchange="gettotalPrice(${i})"></td>
			<td><input class="pprice" value="${o.pprice}" readonly></td>
			<td><input class="totalPrice" value="${(o.pprice*o.quantity).toLocaleString()}" readonly></td>
			<td><button type="button" onclick="idelete(${o.ino},${i})">삭제</td>
		</tr>`
		totalprice += o.pprice*o.quantity
	})
	html += `
	<tr>
		<td> </td>
		<td> </td>
		<td> </td>
		<th>${totalprice.toLocaleString()}</th>
	</tr>
	</table>`
	document.querySelector('.modal_content').innerHTML = html
	document.querySelector('.modal_btns').innerHTML = 
	`<button onclick="rupdate(${rno})" type="button">수정</button>
	<button onclick="rdelete(${rno})" type="button">삭제</button>
	<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>`
}

// 삭제 모달 함수
function deletemodal(rno){
	document.querySelector('.modal_wrap').style.display = "block"
	document.querySelector('.modal_title').innerHTML = '발주 삭제'
	let rinfo = getRequest(rno);
	console.log(rinfo)
	let html = `<div> 발주품목 : ${rinfo.pname} </div>
				<div> 발주수량 : ${rinfo.quantity.toLocaleString()} EA </div>
				삭제하시겠습니까?
				`
	document.querySelector('.modal_content').innerHTML = html
	document.querySelector('.modal_btns').innerHTML = 
	`<button onclick="rdelete(${rno})" type="button">확인</button>
	<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>`
}

// 수정함수
function rupdate(rno) {
	let products = []
	let productGroups = document.querySelectorAll('.product-group')
	for(let i=0; i<productGroups.length; i++){
		let ino = productGroups[i].querySelector('.quantity').id
		console.log(ino)
		let quantity = productGroups[i].querySelector('.quantity').value
		if(ino && quantity){ 
			products.push({ "ino" :ino, "quantity" : quantity})
    }
  }
  console.log(products)
  $.ajaxSettings.traditional = true
  $.ajax({
    url : "/erp/request/info_product",
    method : "put",
    contentType : "application/json",
    data : JSON.stringify({
      "custno" : 1 ,
      "delivery_date" : 1,
      "empno" : 1,
      "comno" : 1,
      "products" : products
    }),
    success : (r)=>{
      console.log(r)
      if(r=='true'){
        alert('발주 수정 성공')
        location.href="/erp/request/allrequest.jsp";
      }else{
        alert('발주 수정 실패')
      }
    }
  })
}

// 삭제 함수
function rdelete(rno){
	console.log(rno)
	$.ajax({
		url : "/erp/request",
		method : "delete",
		data : { "rno" : rno , "type" : 1 },
		success : (r)=>{
			console.log(r)
			if(r=='true'){
				document.querySelector('.modal_content').innerHTML = ''
				document.querySelector('.modal_title').innerHTML = '삭제 성공'
				document.querySelector('.modal_btns').innerHTML = 
				`<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>`
				allrequest();			
			}
		}
	})
}

// 납기완료 버튼함수
function onDone(rno, state){
	$.ajax({
		url : "/erp/request",
		method : "put",
		data : {
			"type" : 2,
			"rno" : rno,
			"state" : state,
		},
		success : (r)=>{
			console.log(r)
			if(r=='true'){
				allrequest()
			}
		}
	})
}

//총 금액 계산하기
function gettotalPrice(listno){
	let pprice = (document.querySelectorAll('.pprice')[listno].value)*1
	let quantity = document.querySelectorAll('.quantity')[listno].value
	let totalprice = pprice * quantity
	document.querySelectorAll('.totalPrice')[listno].value = totalprice.toLocaleString();
}

function idelete(ino,listno){
	$.ajax({
		url : "/erp/request",
		method : "delete",
		data : { "ino" : ino , "type" : 2},
		success : (r)=>{
			console.log('ino 삭제')
		}
	})
	document.querySelectorAll('.product')[listno].value = "";
	document.querySelectorAll('.pprice')[listno].value = "";
	document.querySelectorAll('.quantity')[listno].value = "";
	document.querySelectorAll('.totalPrice')[listno].value = "";
}






