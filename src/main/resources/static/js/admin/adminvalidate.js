$(function () {
    $("#addAdminForm").bootstrapValidator({
　　　　message: 'This value is not valid',
      　     feedbackIcons: {
        　　　　　　　　valid: 'glyphicon glyphicon-ok',
        　　　　　　　　invalid: 'glyphicon glyphicon-remove',
        　　　　　　　　validating: 'glyphicon glyphicon-refresh'
      　　　　　　　　  },
      fields: {
    	 AdminName: {
    		 validators: {
    			 notEmpty: {
    				 message: '用户名不能为空'
    			 },
	            stringLength: {
	                min: 4,  
	                max: 18,  
	                message: '用户名长度必须在4到18位之间'
	            },  
	            regexp: {
	                regexp: /^[a-zA-Z0-9_]+$/, 
	                message: '用户名只能包含大写、小写、数字和下划线'  
	            },
	            remote: {
	            	threshold: 4,
		        	url: "/Emp/admin/adminuser/verifieName",
		        	message: '用户已存在',
		        	type:'post',
		            data:{
		            	AdminName:function(){
		            		return $('#AdminName').val();
		            	}
		            }
	            }
    		}
        },
        
        AdminPwd: {
        	 message:'密码无效',
             validators: {
                 notEmpty: {
                     message: '密码不能为空'
                 },
                 stringLength: {
                     min: 4,
                     max: 30,
                     message: '密码长度必须在4到30之间'
                 },
                 regexp: {
                     regexp: /^[a-zA-Z0-9_\.]+$/,
                     message: 'The username can only consist of alphabetical, number, dot and underscore'
                 }
             }
        },
        AdminConPwd: {
        	message: '密码无效',
            validators: {
                notEmpty: {
                    message: '确认密码不能为空'
                },
                identical: {
                    field: 'AdminPwd',
                    message: '两次密码不一致'
                }
            }
        }
      }
    });
});
