console.log('header js 열림')
let empinfo = null;

getLogininfo();
function getLogininfo(){
	let empno = document.querySelector('.empno').innerHTML
	console.log(empno)
	$.ajax({
		url : "/erp/member/login" ,
		method : "get" , 
		async : false,
		data : {"empno" : empno},
		success : (r) => {
			console.log(r)
			console.log('통신성공');
			empinfo = {
				empid : r.empid,
				ename : r.ename,
				empno : r.empno,
				erank : r.erank,
				mobile : r.mobile,
				officephone : r.officephone,
				comno : r.comno
			};	// 응답 결과를 전역변수로 옮기리 [다름 함수에서 쓰기 위해]
			let html = '';	// 1. html 구성 
			if( r.empid == null ){	// 2. 로그인 안했으면
				html += `<a href="/erp/member/login.jsp">로그인</a>`;
				
			}else{	// 3.로그인 했으면
			
				html +=`
					<div>로그인한 아이디 : ${r.empid}</div>
					<div><a class="dropdown-item" href="/erp/member/logout.jsp"> 로그아웃 </a></div>
				`
				
				if( r.empid == 'admin'){ // 관리자이면 
					html += `<a href="/erp/admin/admin.jsp">관리자</a>`
				}
			
			}
			document.querySelector(".submenu").innerHTML = html;
		}
	})
}

function closeModal(){
	document.querySelector('.modal_wrap').style.display = "none"
}






