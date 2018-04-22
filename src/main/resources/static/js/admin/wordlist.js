$(function() {
	// 加载词库列表
	loadWordList("","");
	
	$("#btn_query").bind("click",function(){    
	    var word=$("#txt_search_word").val();
		var interpretation=$("#txt_search_interpretation").val();
		loadWordList(word,interpretation);
	});
});

function loadWordList(txt_word,txt_interpretation) {
	$("#wordlist").bootstrapTable('destroy'); 
	var queryUrl = '/Emp/admin/word/queryAll';
	var table = $('#wordlist').bootstrapTable({
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
		search : true, // 是否显示表格搜索
		strictSearch : true,
		showColumns : true, // 是否显示所有的列（选择显示的列）
		showRefresh : true, // 是否显示刷新按钮
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		// height: 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		uniqueId : "id", // 每一行的唯一标识，一般为主键列
		showToggle : false, // 是否显示详细视图和列表视图的切换按钮
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		// 得到查询的参数
		queryParams : function(params) {
			// 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			/*
			 * var temp = { rows: params.limit, //页面大小 page: (params.offset /
			 * params.limit) + 1, //页码 sort: params.sort, //排序列名 sortOrder:
			 * params.order //排位命令（desc，asc） };
			 */
			return {
				pageSize : params.limit,
				pageNumber : params.offset / params.limit + 1,
				word:txt_word,
				interpretation:txt_interpretation,
			};
		},
		columns : [ {
			checkbox : true,
			visible : true
		// 是否显示复选框
		}, {
			field : 'word',
			title : 'Word',
			sortable : true
		}, {
			field : 'interpretation',
			title : 'Interpretation',
			sortable : true
		}, {
			title : 'Operation',
			width : 120,
			align : 'center',
			valign : 'middle',
			formatter : formatOperat
		}, ],
		onLoadSuccess : function() {
		},
		onLoadError : function() {
			// showTips("数据加载失败！");
		},
		onDblClickRow : function(row, $element) {
			// var id = row.ID;
			// EditViewById(id, 'view');
		},
	});
}

function formatOperat(value, row, index) {
	return [ '<button type="button" onclick="return openEditWord(\''+ row.id.toString()+ '\')" class="btn btn-warning glyphicon glyphicon-pencil">Edit</button>' ];
}

function openImportPage() {
	$("#uimport").modal('show');
}

function openEditWord(word_id) {
	$("#wordedit").modal('show');
	$.ajax({
		url : '/Emp/admin/word/wordedit/'+word_id,
		type : "get",
		beforeSend : function() {
			// $("#tip").html("<span style='color:blue'>正在处理...</span>");
			return true;
		},
		success : function(data) {
			if (data) {
				var data = data;
				var data_obj = eval("(" + data + ")");
				var word=data_obj.word[0];
				$("#txt_id").val(word.id);
				$("#txt_word").val(word.word);
				$("#txt_interpretation").val(word.interpretation);
				
				$("#txt_sentence").val(word.sentence);
				$("#txt_mp3name").val(word.mp3name);
				$("#txt_video").val(word.video);
				$("#txt_img").val(word.img);
				$("#txt_err_interpretation1").val(word.interpretation1);
				$("#txt_err_interpretation2").val(word.interpretation2);
				$("#txt_err_interpretation3").val(word.interpretation3);
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

//提交表单
function saveWord()
{
    var word_id = $.trim($('#txt_id').val());
    var word = $.trim($('#txt_word').val());
    var interpretation= $.trim($('#txt_interpretation').val());	
    var sentence= $.trim($('#txt_sentence').val());
    var mp3name= $.trim($('#txt_mp3name').val());
    var video= $.trim($('#txt_video').val());
    var img= $.trim($('#txt_img').val());
    var interpretation1= $.trim($('#txt_err_interpretation1').val());
    var interpretation2= $.trim($('#txt_err_interpretation2').val());
    var interpretation3= $.trim($('#txt_err_interpretation3').val());

    $.ajax(
            {
            	url : '/Emp/admin/word/edit',
                data:{"id":word_id,"word":word,"interpretation":interpretation,
                	"sentence":sentence,"mp3name":mp3name,"video":video,"img":img,
                	"interpretation1":interpretation1,"interpretation2":interpretation2,"interpretation3":interpretation3
                },
                type: "post",
                beforeSend:function()
                {
                    //$("#tip").html("<span style='color:blue'>正在处理...</span>");
                    return true;
                },
                success:function(data)
                {
                    if(data > 0)
                    {
                        alert(msg + "Edit Success！");
                        location.reload();
                    }
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