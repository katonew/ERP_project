
console.log(empinfo)
let productinfo = null;


if(empinfo.empid==null){
	alert('로그인 후 사용가능합니다.')
	location.href="/erp/member/login.jsp"
}

allproduct()
// 모든 거래처 가져오기
function allproduct(){
	$.ajax({
		url : "/erp/product",
		method : "get",
		data : {"type" : 1},
		success : (r)=>{
			console.log(r)
			let html = `<tr>
							<th>상품번호</th>
							<th>상품명</th>
							<th>상품가격</th>
							<th>비고</th>
						</tr>`;
			r.forEach((o)=>{
				html += `<tr>
							<td>${o.pno}</td>
							<td>${o.pname}</td>
							<td>${o.pprice}</td>
							<td>
								<button onclick="updatemodal(${o.pno})" type="button">수정</button>
								<button onclick="deletemodal(${o.pno})" type="button">삭제</button>
							</td>
						</tr>`
			})
			document.querySelector('.ptable').innerHTML = html;
		} // success e
	}) // ajax e
} // allproduct e

// 특정 상품 정보 가져오기
function getProduct(pno){
	$.ajax({
		url : "/erp/product",
		method : "get",
		async : false,
		data : {"type" : 2, "pno" : pno},
		success : (r)=>{
			console.log(r)
			productinfo = r[0]
		}
	})
}

// 수정 모달 함수
function updatemodal(pno){
	getProduct(pno)
	document.querySelector('.modal_wrap').style.display = "block"
	document.querySelector('.modal_title').innerHTML = '상품 수정'
	console.log(pno)
	let html = `<div> 상품명 : ${productinfo.pname} </div>
				<div> 상품가격 : ${productinfo.pprice} </div>
				수정하시겠습니까?
				`
	document.querySelector('.modal_content').innerHTML = html
	document.querySelector('.modal_btns').innerHTML = 
	`<button onclick="pupdate(${pno})" type="button">확인</button>
	<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>`
}

// 삭제 모달 함수
function deletemodal(pno){
	getProduct(pno)
	document.querySelector('.modal_wrap').style.display = "block"
	document.querySelector('.modal_title').innerHTML = '상품 삭제'
	console.log(productinfo)
	let html = `<div> 상품명 : ${productinfo.pname} </div>
				<div> 상품가격 : ${productinfo.pprice} </div>
				삭제하시겠습니까?
				`
	document.querySelector('.modal_content').innerHTML = html
	document.querySelector('.modal_btns').innerHTML = 
	`<button onclick="pdelete(${pno})" type="button">확인</button>
	<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>`
}

function pupdate(pno){
	location.href = "/erp/product/pupdate.jsp?pno="+pno
}

function pdelete(pno){
	$.ajax({
		url : "/erp/product",
		method : "delete",
		data : {"pno" : pno},
		success : (r)=>{
			console.log(r)
			if(r=='true'){
				closeModal()
				alert('삭제가 완료되었습니다.')
				location.href="/erp/product/allproduct.jsp";
			}
		}
	})
	
}