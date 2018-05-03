$(function () {
    $('#editwordform').bootstrapValidator({
　　　　message: 'This value is not valid',
      　     feedbackIcons: {
        　　　　　　　　valid: 'glyphicon glyphicon-ok',
        　　　　　　　　invalid: 'glyphicon glyphicon-remove',
        　　　　　　　　validating: 'glyphicon glyphicon-refresh'
      　　　　　　　　  },
      fields: {
    	wordedit: {
          validators: {
            notEmpty: {
              message: 'Please Input Word'
            }
          }
        },
        interpretationedit: {
          validators: {
            notEmpty: {
              message: 'Please Input Interpretation'
            }
          }
        },
        sentenceedit: {
            validators: {
              notEmpty: {
                message: 'Please Input Sentence'
              }
            }
        },
        errInterpretationedit1: {
            validators: {
              notEmpty: {
                message: 'Please Input ErrInterpretation1'
              }
            }
        },
        errInterpretationedit2: {
            validators: {
              notEmpty: {
                message: 'Please Input ErrInterpretation2'
              }
            }
        },
        errInterpretationedit3: {
            validators: {
              notEmpty: {
                message: 'Please Input ErrInterpretation3'
              }
            }
        }
      }
    });
});
