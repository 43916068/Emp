$(function () {
	$('iframe').attr('src','/Emp/admin/content'); 
});

function adminList(){
	alert("请求管理员列表");
	$('iframe').attr('src','/Emp/admin/list'); 
}