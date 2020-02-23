
$('#register_btn').off().on('click',function(){
	var yearVal =  $(searchYear).val();
	
	let signUpRequest = {};
	signUpRequest.email=$('#email').val();
	signUpRequest.nickname=$('#nickname').val();
	signUpRequest.password=$('#password').val();
	signUpRequest.sex=$('#sex').val();
	signUpRequest.birth=$('#birth').val();
	signUpRequest.role=yearVal;

	let formData = new FormData();
//	formData.append("file", $('#people_image_file')[0].files[0]);
//	formData.append('signUpRequest', new Blob([JSON.stringify(signUpRequest)], {
//	        type: "application/json; charset=UTF-8"
//	    }));
	$.ajax({
		url:'/api/auth/signup',
		type:'POST',
		// enctype: 'multipart/form-data',
	        dataType:'json',
		//mimeType:"multipart/form-data",
	    data: signUpRequest,
		success:function(data){
			if(data.code==1){
				alert(data.message);
				//location.href='/signinView';
			}else{
				alert(data.message);
			}
		},
		error:function(){

		}
	});
});