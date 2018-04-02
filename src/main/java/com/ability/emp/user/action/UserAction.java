package com.ability.emp.user.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ability.emp.user.entity.UserEntity;
import com.ability.emp.user.server.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin//解决跨域请求
@Controller
@RequestMapping("/user/list")
public class UserAction {
	
	
	@Resource
	private UserService userService;
	
	ObjectMapper objectMapper = new ObjectMapper();  
	
	
	/**
	 * 返回首页
	 * @param userEntity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("")
	public String listPage(UserEntity userEntity) throws Exception {
		return "userlist";
	}
	
	
	/**
	 * 返回数据
	 * @param userEntity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryAll")
	@ResponseBody
	public String queryAll(UserEntity userEntity) throws Exception {
		List<UserEntity> data = userService.queryAll();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", 50);
		map.put("rows", data);
		return objectMapper.writeValueAsString(map);
	}
	
	@RequestMapping(value="/query",method = RequestMethod.GET)  
	@ResponseBody
	public String query(HttpServletResponse response) throws Exception {
//		List<UserEntity> ulist = userService.queryAll();
//		
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("data", ulist);
//		String temp = ulist.get(0).getUsername();
//		//语音合成
//		SpeechUtil.convert(temp);
//		
//	    return objectMapper.writeValueAsString(map);
		return "";
	}

}
