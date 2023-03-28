
console.log(memberinfo)

if(memberinfo.empid==null){
	alert('로그인 후 사용가능합니다.')
	location.href="/erp/member/login.jsp"
}

allproduct()
// 모든 거래처 가져오기
function allproduct(){
	$.ajax({
		url : "/erp/product",
		method : "get",
		success : (r)=>{
			console.log(r)
			let html = `<tr>
							<th>상품번호</th>
							<th>상품명</th>
							<th>상품가격</th>
						</tr>`;
			r.forEach((o)=>{
				html += `<tr>
							<td>${o.pno}</td>
							<td>${o.pname}</td>
							<td>${o.pprice}</td>
						</tr>`
			})
			document.querySelector('.ptable').innerHTML = html;
		} // success e
	}) // ajax e
} // newcust e