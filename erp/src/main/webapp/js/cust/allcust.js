

console.log(empinfo)
if(empinfo.empid==null){
	alert('로그인 후 사용가능합니다.')
	location.href="/erp/member/login.jsp"
}

allcust()
// 모든 거래처 가져오기
function allcust(){
	$.ajax({
		url : "/erp/cust",
		method : "get",
		data : {"type" : 1},
		success : (r)=>{
			console.log(r)
			let html = `<tr>
							<th>거래처번호</th>
							<th>거래처명</th>
							<th>담당자</th>
							<th>번호</th>
							<th>주소</th>
							<th>비고</th>
						</tr>`;
			r.forEach((o)=>{
				html += `<tr>
							<td>${o.custno}</td>
							<td>${o.cname}</td>
							<td>${o.custemp}</td>
							<td>${o.custphone}</td>
							<td>${o.custaddress}</td>
							<td>
								<button onclick="updatemodal(${o.custno})" type="button">수정</button>
								<button onclick="deletemodal(${o.custno})" type="button">삭제</button>
							</td>
						</tr>`
			})
			document.querySelector('.custtable').innerHTML = html;
		} // success e
	}) // ajax e
} // newcust e

// 특정 거래처 정보 가져오기
function getCust(custno){
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
	return custinfo;
}

// 수정 모달 함수
function updatemodal(custno){
	document.querySelector('.modal_wrap').style.display = "block"
	document.querySelector('.modal_title').innerHTML = '발주 수정'
	let custinfo = getCust(custno);
	console.log(custinfo)
	let html = `<div> 거래처 : ${custinfo.cname} </div>
				수정하시겠습니까?
				`
	document.querySelector('.modal_content').innerHTML = html
	document.querySelector('.modal_btns').innerHTML = 
	`<button onclick="custupdate(${custno})" type="button">확인</button>
	<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>`
}

// 삭제 모달 함수
function deletemodal(custno){
	document.querySelector('.modal_wrap').style.display = "block"
	document.querySelector('.modal_title').innerHTML = '발주 삭제'
	let custinfo = getCust(custno);
	console.log(custinfo)
	let html = `<div> 거래처 : ${custinfo.cname} </div>
				삭제하시겠습니까?
				`
	document.querySelector('.modal_content').innerHTML = html
	document.querySelector('.modal_btns').innerHTML = 
	`<button onclick="custdelete(${custno})" type="button">확인</button>
	<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>`
}


// 모달 닫기 함수
function closeModal(){
	document.querySelector('.modal_wrap').style.display = "none"
}


function custupdate(custno){
	
}


function custdelete(custno){
	
}






