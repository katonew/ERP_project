let pno = document.querySelector('.pno').innerHTML

$.ajax({
	url : "/erp/product",
	method : "get",
	data : {"type" : 2 , "pno" : pno},
	success : (r)=>{
		console.log(r)
		let productinfo = r[0]
		console.log(productinfo)
		console.log(productinfo.pname)
		console.log(productinfo.pprice)
		document.querySelector('.pname').value = productinfo.pname
		document.querySelector('.pprice').value = productinfo.pprice
	}
})

function pupdate(){
	let pname = document.querySelector('.pname').value
	let pprice = document.querySelector('.pprice').value
	$.ajax({
	url : "/erp/product",
	method : "put",
	data : {
		"pno" : pno,
		"pname" : pname,
		"pprice" : pprice
	},
	success : (r)=>{
		console.log(r)
		if(r=='true'){
			alert('수정 완료되었습니다.')
			location.href="/erp/product/allproduct.jsp";
		}
	}
})
}