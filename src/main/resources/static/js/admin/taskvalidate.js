$(function () {
    $('#addTaskForm').bootstrapValidator({
　　　　message: 'This value is not valid',
      　     feedbackIcons: {
        　　　　　　　　valid: 'glyphicon glyphicon-ok',
        　　　　　　　　invalid: 'glyphicon glyphicon-remove',
        　　　　　　　　validating: 'glyphicon glyphicon-refresh'
      　　　　　　　　  },
      fields: {
    	taskNameAdd: {
          validators: {
            notEmpty: {
              message: 'Please Input TaskName'
            }
          }
        },
        startDateAdd: {
          validators: {
            notEmpty: {
              message: 'Please Input StartDate'
            }
          }
        },
        endDateAdd: {
            validators: {
              notEmpty: {
                message: 'Please Input EndDate'
              }
            }
        }
      }
    });
});
