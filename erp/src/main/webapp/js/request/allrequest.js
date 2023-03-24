allrequest()
// 모든 발주 가져오기
function allrequest(){
	$.ajax({
		url : "/erp/request",
		method : "get",
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
						</tr>`;
			r.forEach((o)=>{
				html += `<tr>
							<th>${o.rno}</th>
							<th>${o.enter_date}</th>
							<th>${o.delivery_date==null? " " : o.delivery_date}</th>
							<th>${o.pname}</th>
							<th>${o.quantity}</th>
							<th></th>
							<th>${o.empname}</th>
						</tr>`
			})
			document.querySelector('.requesttable').innerHTML = html;
		} // success e
	}) // ajax e
} // newcust e