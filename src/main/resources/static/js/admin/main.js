$(function () {
	$('iframe').attr('src','/Emp/admin/content'); 
});

function adminList(){
	$('iframe').attr('src','/Emp/admin/list'); 
}

function userList(){
	$('iframe').attr('src','/Emp/admin/user/list'); 
}

function taskList(){
	$('iframe').attr('src','/Emp/admin/task'); 
}