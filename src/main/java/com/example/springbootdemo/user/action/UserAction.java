package com.example.springbootdemo.user.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springbootdemo.user.entity.UserEntity;
import com.example.springbootdemo.user.server.UserService;


@Controller
@RequestMapping("/user")
public class UserAction {
	
	
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/add")
	public boolean add(UserEntity userEntity) {
		if(userService.add(userEntity)>0){
			return true;
		}
	    return false;
	}
	
	@RequestMapping("/del/{id}")
	public boolean del(@PathVariable("id") Long id) {
		if(userService.del(id)>0){
			return true;
		}
	    return false;
	}
	
	@RequestMapping("/update")
	public String update() {
	    return "";
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public Map<String,Object> query() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("data", userService.queryAll());
	    return map;
	}

}
