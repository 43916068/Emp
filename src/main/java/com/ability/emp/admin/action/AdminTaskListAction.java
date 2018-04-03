package com.ability.emp.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 任务
 * @author Devin
 * @since 2018-4-3
 *
 */
@CrossOrigin//解决跨域请求
@Controller
@RequestMapping("/admin/task")
public class AdminTaskListAction {
	
	
	/**
	 * 返回首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("")
	public String listPage(HttpServletRequest request,HttpServletResponse response){
		return "tasklist";
	}

}
