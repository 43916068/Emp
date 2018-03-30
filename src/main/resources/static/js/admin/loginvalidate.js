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
              message: '用户名不能为空'
            }
          }
        },
        pwd: {
          validators: {
            notEmpty: {
              message: '密码不能为空'
            }
          }
        }
      }
    });
});
