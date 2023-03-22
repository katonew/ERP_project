
allcust()
// 모든 거래처 가져오기
function allcust(){
	$.ajax({
		url : "/erp/cust",
		method : "get",
		success : (r)=>{
			console.log(r)
			let html = `<tr>
							<th>거래처번호</th>
							<th>거래처명</th>
							<th>담당자</th>
							<th>번호</th>
							<th>주소</th>
						</tr>`;
			r.forEach((o)=>{
				html += `<tr>
							<td>${o.custno}</td>
							<td>${o.cname}</td>
							<td>${o.custemp}</td>
							<td>${o.custphone}</td>
							<td>${o.custaddress}</td>
						</tr>`
			})
			document.querySelector('.custtable').innerHTML = html;
		} // success e
	}) // ajax e
} // newcust e