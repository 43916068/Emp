package com.ability.emp.admin.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ability.emp.admin.entity.AdminSystemParamEntity;
import com.ability.emp.admin.entity.AdminUserEntity;
import com.ability.emp.admin.server.AdminSystemParamService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@CrossOrigin//解决跨域请求
@Controller
@RequestMapping("/admin/sysparam")
public class AdminSystemParamAction {
	
	
	@Resource
	private AdminSystemParamService adminSystemParamService;
	
	ObjectMapper objectMapper = new ObjectMapper();  
	
	
	
	/**
	 * 返回首页
	 * @param userEntity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("")
	public String listPage(AdminUserEntity userEntity) throws Exception {
		return "systemparamlist";
	}
	
	
	/**
	 * 返回数据
	 * @param userEntity
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/queryAll")
	@ResponseBody
	public String queryAll(int pageSize,int pageNumber,AdminSystemParamEntity aspe) throws Exception {
		//第一个参数当前页码，第二个参数每页条数
		PageHelper.startPage(pageNumber,pageSize);  
		List<AdminSystemParamEntity> data = adminSystemParamService.queryAll(aspe);
		Map<String,Object> map = new HashMap<String,Object>();
		@SuppressWarnings("unchecked")
		PageInfo<AdminUserEntity> page = new PageInfo(data);
		map.put("total",page.getTotal());
		map.put("rows", data);
		return objectMapper.writeValueAsString(map);
	}
	
	/**
	 * 返回子数据
	 * @param userEntity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryChild")
	@ResponseBody
	public String queryChild(AdminSystemParamEntity aspe) throws Exception {
		List<AdminSystemParamEntity> data = adminSystemParamService.queryChild(aspe);
		String count = String.valueOf(data.size());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", count);
		map.put("rows", data);
		return objectMapper.writeValueAsString(map);
	}
	
	@RequestMapping("/addSysParam")
	@ResponseBody
	public Integer addSysParam(AdminSystemParamEntity aspe) throws Exception {
		return adminSystemParamService.insert(aspe);
	}
	
	@RequestMapping("/deleteSysParam")
	@ResponseBody
	public Integer deleteSysParam(String id) throws Exception {
		return adminSystemParamService.delete(id);
	}
}
