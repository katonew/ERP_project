
console.log(empinfo)

if(empinfo.empid==null){
	alert('로그인 후 사용가능합니다.')
	location.href="/erp/member/login.jsp"
}

allrequest()
// 모든 발주 가져오기
function allrequest(){
	$.ajax({
		url : "/erp/request",
		method : "get",
		data : {"type" : 1},
		success : (r)=>{
			console.log(r)
			let html = `<tr>
							<th>발주번호</th>
							<th>발주날짜</th>
							<th>납기날짜</th>
							<th>상품이름</th>
							<th>수량</th>
							<th>금액</th>
							<th>담당자</th>
							<th>비고</th>
						</tr>`;
			r.forEach((o)=>{
				html += `<tr>
							<td>${o.rno}</td>
							<td>${o.enter_date}</td>
							<td>${o.delivery_date==null? " " : o.delivery_date}</td>
							<td>${o.pname}</td>
							<td>${o.quantity}</td>
							<td></td>
							<td>${o.empname}</td>
							<td>
								<button onclick="updatemodal(${o.rno})" type="button">수정</button>
								<button onclick="deletemodal(${o.rno})" type="button">삭제</button>
							</td>
						</tr>`
			})
			document.querySelector('.requesttable').innerHTML = html;
		} // success e
	}) // ajax e
} // newcust e

// 수정 모달 함수
function updatemodal(rno){
	document.querySelector('.modal_wrap').style.display = "block"
	document.querySelector('.modal_title').innerHTML = '발주 수정'
	document.querySelector('.modal_content').innerHTML = '수정하시겠습니까?'
	document.querySelector('.modal_btns').innerHTML = 
	`<button onclick="rupdate(${rno})" type="button">확인</button>
	<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>`
}

// 삭제 모달 함수
function deletemodal(rno){
	document.querySelector('.modal_wrap').style.display = "block"
	document.querySelector('.modal_title').innerHTML = '발주 삭제'
	document.querySelector('.modal_content').innerHTML = '삭제하시겠습니까?'
	document.querySelector('.modal_btns').innerHTML = 
	`<button onclick="rdelete(${rno})" type="button">확인</button>
	<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>`
}
// 모달 닫기 함수
function closeModal(){
	document.querySelector('.modal_wrap').style.display = "none"
}
// 수정페이지로 넘어가는 함수
function rupdate(rno){
	location.href="/erp/request/requestupdate.jsp?rno="+rno;
}

// 삭제 함수
function rdelete(rno){
	console.log(rno)
	$.ajax({
		url : "/erp/request",
		method : "delete",
		data : { "rno" : rno },
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


