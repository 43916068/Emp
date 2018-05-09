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
            }
          }
        },
        childValue: {
            validators: {
              notEmpty: {
                message: 'Please Input value'
              }
            }
        }
      }
    });
});
