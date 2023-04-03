console.log('login js 열림')

if(empinfo.empid!=null){
	location.href="/erp/request/allrequest.jsp"
}

function login(){
	let cloginno = document.querySelector('.cloginno').value;
	let empid = document.querySelector('.empid').value;
	let emppwd = document.querySelector('.emppwd').value;
	
	$.ajax({
		url : "/erp/member/login" ,
		method : "post" ,
		data : { 
			"empid" : empid , 
			"emppwd" : emppwd ,
			"cloginno" :cloginno
			} ,
		success : (r)=>{
			console.log( r );
			if( r == 'true' ){ location.href="/erp/index.jsp"; }
			else{
				document.querySelector('.checkbox').innerHTML ='회원정보가 다릅니다.';	
			} 
		}
	})
	
}