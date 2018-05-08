$(function() {
	// 加载任务列表
	loadTaskList();
	datehandle();
});


// 任务列表
function loadTaskList() {
	var queryUrl = '/Emp/admin/task/queryAll'
	var table = $('#tasklist').bootstrapTable({
		url : queryUrl, // 请求后台的URL（*）
		method : 'GET', // 请求方式（*）
		toolbar : '#toolbar', // 工具按钮用哪个容器 
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, // 是否显示分页（*）
		sortable : true, // 是否启用排序
		sortOrder : "asc", // 排序方式
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页,并记录
		pageSize : 10, // 每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		search : false, // 是否显示表格搜索
		strictSearch : true,
		showColumns : true, // 是否显示所有的列（选择显示的列）
		showRefresh : true, // 是否显示刷新按钮
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		// height: 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		uniqueId : "ID", // 每一行的唯一标识，一般为主键列
		showToggle : false, // 是否显示详细视图和列表视图的切换按钮
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		// 得到查询的参数
		queryParams : function(params) {
			return {
				pageSize : params.limit,
				pageNumber : params.offset / params.limit + 1
			};
		},
		columns : [ {
			checkbox : true,
			visible : true
		// 是否显示复选框
		}, {
			field : 'taskname',
			title : 'Taskname',
			sortable : true
		}, {
			field : 'startStringDate',
			title : 'StartDate',
			sortable : true
		}, {
			field : 'endStringDate',
			title : 'EndDate',
			sortable : true
		},{
			title : 'Operation',
			width : 120,
			align : 'center',
			valign : 'middle',
			formatter : formatOperat
		}],
		onLoadSuccess : function() {
		},
		onLoadError : function() {
			
		},
		onDblClickRow : function(row, $element) {
			
		},
	});
}
 
function formatOperat(value, row, index) {
		return [ '<button type="button" onclick="return queryTaskById(\''+ row.id.toString()+ '\')" class="btn btn-warning glyphicon glyphicon-pencil">Edit</button>' ];
}

function openTaskModal() {
		$("#taskadd").modal('show');
		$("#txt_paramid").html('');
	    $.ajax({  
	    	url : '/Emp/admin/task/querySystemParam',
	 		type:"get",
	 		dataType:"json",
	        success : function(data) {//返回list数据并循环获取  
	            var select = $("#txt_paramid");  
	            var datas=data.systemParamList;
	            select.append("<option value='0'>Please Select</option>");
	            for (var i = 0; i < datas.length; i++) {  
	                select.append("<option value='"+datas[i].id+"'>"  
	                        + datas[i].parentName + "</option>");  
	            }  
	            $('.selectpicker').selectpicker('val', '');  
	            $('.selectpicker').selectpicker('refresh');  
	        }  
	    });
}
	
function saveTask() {
		var taskName = $('#taskNameAdd').val();
		var paramid = $('#txt_taskName').val();
		var startDate = $('#startDateAdd').val();
		var endDate = $('#endDateAdd').val();
		
		var bootstrapValidator = $("#addTaskForm").data('bootstrapValidator');
		bootstrapValidator.validate();
		if(bootstrapValidator.isValid()){
			$.ajax({
				url : '/Emp/admin/task/add',
	    		dataType:"json",
	    		data:{"taskname":taskName,"paramid":paramid, 
	    			"startStringDate":startDate,
	    			"endStringDate":endDate},
	    		async:true,
	    		cache:false,
	    		type:"post",
				success : function(data) {
					if(data > 0)
	                {
	                    alert(msg + "Edit Success！");
	                    location.reload();
	                }
				},
				error : function() {
		
				},
				complete : function() {
					$("#taskedit").modal('hide');
				}
			});
		}
}
//queryTaskById
function queryTaskById(task_id) {
		$("#taskedit").modal('show');
		$("#txt_edit_paramid").html('');
		$.ajax({  
	    	url : '/Emp/admin/task/querySystemParam',
	 		type:"get",
	 		dataType:"json",
	        success : function(data) {//返回list数据并循环获取  
	            var select = $("#txt_edit_paramid");  
	            var datas=data.systemParamList;
	            select.append("<option value='0'>Please Select</option>");
	            for (var i = 0; i < datas.length; i++) {  
	                select.append("<option value='"+datas[i].id+"'>"  
	                        + datas[i].parentName + "</option>");  
	            }  
	            $('.selectpicker').selectpicker('val', '');  
	            $('.selectpicker').selectpicker('refresh');  
	        }  
	    });  
		$.ajax({
			url : '/Emp/admin/task/taskedit/'+task_id,
			type : "get",
			beforeSend : function() {
				// $("#tip").html("<span style='color:blue'>正在处理...</span>");
				return true;
			},
			success : function(data) {
				if (data) {
					var data = data;
					var data_obj = eval("(" + data + ")");
					var task=data_obj.task[0]

					$("#txt_edit_id").val(task.id);
					$("#txt_edit_taskName").val(task.taskname);
					$('.selectpicker').selectpicker('val', task.paramid);  
			        $('.selectpicker').selectpicker('refresh');  
					//$("#txt_edit_paramid").val(task.paramid);					
					$("#txt_edit_startDate").val(task.startStringDate);
					$("#txt_edit_endDate").val(task.endStringDate);
					$('#txt_edit_startDate').datetimepicker('update');
					$('#txt_edit_endDate').datetimepicker('update');
				}
			},
			error : function() {
				//alert('request error');
			},
			complete : function() {
				// $('#tips').hide();
			}
		});
		return false;  
}
	
function updateTask()
{
		
		var editTaskId = $.trim($('#txt_edit_id').val());
		var editTaskName = $.trim($('#txt_edit_taskName').val());
		var editParamid = $.trim($('#txt_edit_paramid').val());
		var startStringDate =$.trim($('#txt_edit_startDate').val());
		var endStringDate = $.trim($('#txt_edit_endDate').val());
	    
	    $.ajax(
	            {            	
	        		url:'/Emp/admin/task/edit',
	        		dataType:"json",
	        		data:{"id":editTaskId,"taskname":editTaskName,"paramid":editParamid,
	        			"startStringDate":startStringDate,"endStringDate":endStringDate},
	        		async:true,
	        		cache:false,
	        		type:"post",
	                beforeSend:function() 
	                {
	                    //$("#tip").html("<span style='color:blue'>正在处理...</span>");
	                    return true;
	                },
	                success:function(data)
	                {
	                },
	                error:function()
	                {
	                  
	                },
	                complete:function()
	                {
	                	$("#wordedit").modal('hide');
	                }
	            });

	    return false;
}

function datehandle(){
	$('.form_datetime').datetimepicker({
		format: 'yyyy-mm-dd',//显示格式
		todayHighlight: 1,//今天高亮
		minView: "month",//设置只显示到月份
		startView:2,
		forceParse: 0,
		showMeridian: 1,
		autoclose: 1//选择后自动关闭
	}).on('changeDate', function(ev){
		 $('#addTaskForm').bootstrapValidator('revalidateField', 'startDateAdd');
		 $('#addTaskForm').bootstrapValidator('revalidateField', 'endDateAdd');
	});;
}

function loadParamTree(){
	var queryUrl = '/Emp/admin/sysparam/queryAll'
	    var table = $('#treeg').bootstrapTable({
	        url: queryUrl,                      //请求后台的URL（*）
	        method: 'GET',                      //请求方式（*）
	        //toolbar: '#toolbar',              //工具按钮用哪个容器
	        striped: true,                      //是否显示行间隔色
	        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	        pagination: true,                   //是否显示分页（*）
	        sortable: true,                     //是否启用排序
	        sortOrder: "asc",                   //排序方式
	        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
	        pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
	        pageSize: 10,                     //每页的记录行数（*）
	        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
	        search: false,                      //是否显示表格搜索
	        strictSearch: false,				//精确搜索
	        //showColumns: true,                  //是否显示所有的列（选择显示的列）
	        //showRefresh: true,                  //是否显示刷新按钮
	        minimumCountColumns: 2,             //最少允许的列数
	        clickToSelect: true,                //是否启用点击选中行
	        //height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
	        showToggle: false,                   //是否显示详细视图和列表视图的切换按钮
	        cardView: false,                    //是否显示详细视图
	        detailView: true,                  //是否显示父子表
	        singleSelect:true, 				//禁止多选_____
	        //得到查询的参数
	        queryParams : function (params) {
	        	return {
	        		pageSize: params.limit,
	        		pageNumber: params.offset/params.limit+1,
	            };
	        },
	        columns: [{
	            field: 'parentName',
	            title: 'Name',
	            sortable: true
	        },
	        {
	            field:'ID',
	            title: 'Operation',
	            width: 120,
	            align: 'center',
	            valign: 'middle'
	        }],
	        onLoadSuccess: function () {
	        },
	        onLoadError: function () {
	           
	        },
	        onDblClickRow: function (row, $element) {
	            
	        },
	        //注册加载子表的事件。注意下这里的三个参数！
	        onExpandRow: function (index, row, $detail) {
	            initSubTable(index, row, $detail);
	        }
	    });
}

//初始化子表格(无线循环)
function initSubTable(index, row, $detail) {
    var parentid = row.id;
    var cur_table = $detail.html('<table></table>').find('table');
    $(cur_table).bootstrapTable({
        url: '/Emp/admin/sysparam/queryChild',
        method: 'get',
        queryParams: {id:parentid},
        ajaxOptions: {id:parentid},
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
        pageSize: 10,                     //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: false,                      //是否显示表格搜索
        strictSearch: false,				//精确搜索
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        //height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        showToggle: false,                   //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: true,                  //是否显示父子表
        singleSelect:true, 				//禁止多选_____
        columns: [{
        	checkbox: true,  
            visible: true  
        }, {
            field: 'childName',
            title: 'Name'
        }, {
            field: 'childValue',
            title: 'Value'
        }],
        //无线循环取子表，直到子表里面没有记录
        onExpandRow: function (index, row, $Subdetail) {
        	initSubTable(index, row, $Subdetail);
        }
    });
    $("#cur_table").bootstrapTable('refresh');
}
