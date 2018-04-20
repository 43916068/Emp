$(function () {
	$('iframe').attr('src','/Emp/admin/content'); 
});

function adminList(){
	$('iframe').attr('src','/Emp/admin/adminuser'); 
}

function userList(){
	$('iframe').attr('src','/Emp/admin/user'); 
}

function taskList(){
	$('iframe').attr('src','/Emp/admin/task'); 
}

function wordList(){
	$('iframe').attr('src','/Emp/admin/word');
}