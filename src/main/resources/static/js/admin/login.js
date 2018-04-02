$(function () {
    
});


//登录
function login(){
	var bootstrapValidator = $("#loginForm").data('bootstrapValidator');
	bootstrapValidator.validate();
	if(bootstrapValidator.isValid()){
		$("#jindu").modal('show');
		$.ajax({
			url:'/Emp/admin/login',
			dataType:"json",
			data:{"name":"周鹏"},
			async:true,
			cache:false,
			type:"post",
			success:function(resultFlag){
				if(resultFlag){
					
					//alert("登录成功");
					var uri = "/Emp/admin/main";
					window.location.href = uri;
				}
			}
		})
	}
}