package com.ability.emp.admin.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 后台管理员登录
 * @author Devin
 * @since 2018-3-29
 *
 */
@CrossOrigin//解决跨域请求
@Controller
@RequestMapping("/admin/login")
public class AdminLoginAction {

	
	@RequestMapping("")
	public String login(){
		
		return "login";
	}
}
