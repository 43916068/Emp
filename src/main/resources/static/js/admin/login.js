$(function () {
    
});


//登录
function login(){
	var bootstrapValidator = $("#loginForm").data('bootstrapValidator');
	bootstrapValidator.validate();
	if(bootstrapValidator.isValid()){
		//$("#jindu").modal('show');
		$.ajax({
			url:'/Emp/admin/login',
			dataType:"json",
			data:{"adminName":"admin","adminPwd":"admin"},
			async:true,
			cache:false,
			type:"post",
			success:function(result){
				//$("#jindu").modal('hide');
				if(result=="0"){
					var uri = "/Emp/admin/main";
					window.location.href = uri;
				}else{
					alert(result);
				}
			}
		})
	}
}