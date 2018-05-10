$(function () {
    $('#addAdminForm').bootstrapValidator({
　　　　message: 'This value is not valid',
      　     feedbackIcons: {
        　　　　　　　　valid: 'glyphicon glyphicon-ok',
        　　　　　　　　invalid: 'glyphicon glyphicon-remove',
        　　　　　　　　validating: 'glyphicon glyphicon-refresh'
      　　　　　　　　  },
      fields: {
    	parentName: {
          validators: {
            notEmpty: {
              message: 'Please Input Name'
            }
          }
        },
        childName: {
          validators: {
            notEmpty: {
              message: 'Please Input Name'
            },
            regexp: {
                regexp: /^[a-zA-Z0-9_]+$/, 
                message: '用户名只能包含大写、小写、数字和下划线'  
            }
          }
        },
        childValue: {
			validators: {
				notEmpty: {
					message: 'Please Input value'
				},
				stringLength: {
					max: 4,  
					message: '值必须在4位数以内'
				},  
				regexp: {
					regexp: /^[0-9_]+$/, 
					message: '只允许输入数字'  
				}
			}
        }
      }
    });
});
