package com.ability.emp.user.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ability.emp.user.entity.UserEntity;
import com.ability.emp.user.server.UserService;
import com.ability.emp.util.ExcelImportUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;

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
		//第一个参数当前页码，第二个参数每页条数
		PageHelper.startPage(1,2);  
		List<UserEntity> data = userService.queryAll();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", 50);
		map.put("rows", data);
		return objectMapper.writeValueAsString(map);
	}
	
    /**
     * 导入用户
     * @param file
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
	@RequestMapping(value="/importUser",method = RequestMethod.POST)
	@ResponseBody
    public String importUser(
    		@RequestParam(value="file") MultipartFile file,
            HttpServletRequest request,
            HttpServletResponse response
            ) throws Exception{
		
		Map<String,Object> map = new HashMap<String,Object>();
        //判断文件是否为空
        if(file==null){
         map.put("msg", "文件不能为空！");
         return objectMapper.writeValueAsString(map);
        }
        
        //获取文件名
        String fileName=file.getOriginalFilename();
        
        //验证文件名是否合格
        if(!ExcelImportUtils.validateExcel(fileName)){
         map.put("msg", "文件必须是excel格式！");
       	 return objectMapper.writeValueAsString(map);
        }
        
        //进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
        long size=file.getSize();
        if(fileName==null ||fileName.equals("") || size==0){
       	 map.put("msg", "文件不能为空！");
       	 return objectMapper.writeValueAsString(map);
        }
        
        //批量导入
        String message = userService.importUser(fileName, file);
        map.put("msg", message);
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
