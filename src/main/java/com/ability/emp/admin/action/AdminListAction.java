package com.ability.emp.admin.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ability.emp.admin.entity.AdminEntity;
import com.ability.emp.admin.server.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 管理员列表
 * @author Devin
 * @since 2018-3-31
 *
 */
@CrossOrigin//解决跨域请求
@Controller
@RequestMapping("/admin/list")
public class AdminListAction {
	
	
	@Resource
	private AdminService adminService;
	
	ObjectMapper objectMapper = new ObjectMapper();  
	
	
	@RequestMapping("")
	public String login(HttpServletRequest request,HttpServletResponse response){
		return "adminlist";
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public String query(HttpServletRequest request,HttpServletResponse response) throws JsonProcessingException{
		List<AdminEntity> data = adminService.queryAll();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", 50);
		map.put("rows", data);
		System.out.println(objectMapper.writeValueAsString(map));
		return objectMapper.writeValueAsString(map);
	}

}
