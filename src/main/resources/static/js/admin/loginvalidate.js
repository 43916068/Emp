$(function () {
    $('#loginForm').bootstrapValidator({
　　　　message: 'This value is not valid',
      　     feedbackIcons: {
        　　　　　　　　valid: 'glyphicon glyphicon-ok',
        　　　　　　　　invalid: 'glyphicon glyphicon-remove',
        　　　　　　　　validating: 'glyphicon glyphicon-refresh'
      　　　　　　　　  },
      fields: {
        username: {
          validators: {
            notEmpty: {
              message: 'Please Input UserName'
            }
          }
        },
        pwd: {
          validators: {
            notEmpty: {
              message: 'Please Input Password'
            }
          }
        }
      }
    });
});
