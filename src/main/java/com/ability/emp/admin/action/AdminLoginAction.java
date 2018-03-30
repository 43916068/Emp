package com.ability.emp.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 后台管理员登录
 * @author Devin
 * @since 2018-3-29
 *
 */
@CrossOrigin//解决跨域请求
@Controller
@RequestMapping("/admin")
public class AdminLoginAction {

	
	@RequestMapping("")
	public String loginPage(){
		
		return "login";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public boolean login(HttpServletRequest request,HttpServletResponse response){
		System.out.println("验证通过，登录"+request.getParameter("name"));
		return true;
	}
	
	@RequestMapping("/main")
	public String main(HttpServletRequest request,HttpServletResponse response){
	
		return "main";
	}
}
