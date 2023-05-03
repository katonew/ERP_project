$(document).ready(function() {
  $('#summernote').summernote();
});

start()
function start(){
	let html = ``
	for(let i=1; i<=5;i++){
		html += `<tr class="approval">
					<td><input ondblclick="selectLine(${i})" type="text"></td>
					<td><input class="checkname"  type="text"></td>
					<td><input class="checkno" type="number" min="1" max="5"></td>
				</tr>`
	}
	document.querySelector('.selectLine').innerHTML = html;
}


// 결재라인 등록 모달
function selectLine(listno){
	document.querySelector('.modal_wrap').style.display = "block"
	document.querySelector('.modal_title').innerHTML = '결재라인 등록';
	let html = 
	`<input class="searchempbox" type="text">
	<button onclick="searchEmp()">검색</button>
	<div class="emplist">1</div>`
	document.querySelector('.modal_content').innerHTML = html;
	document.querySelector('.modal_btns').innerHTML = 
	`<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>`
}

function searchEmp(){
	console.log('searchEmp')
	let search = document.querySelector('.searchempbox').value;
	let type = 0;
	if(search==''){
		type = 1;
	}else{
		type = 2;
	}
	console.log(type)
	$.ajax({
		url : "/erp/searchemp",
		method : "get",
		data : { "type" : type , "search" : search},
		success : (r)=>{
			console.log(r)
			let html = ``;
			r.forEach((o)=>{
				html += `<div value=${o.empno}>${o.ename}</div>`
			})
			document.querySelector('.emplist').innerHTML = html;
		} // success e
	}) // ajax e
}
