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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ability.emp.admin.entity.AdminUserEntity;
import com.ability.emp.admin.server.AdminUserService;
import com.ability.emp.util.ExcelImportUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;

@CrossOrigin//解决跨域请求
@Controller
@RequestMapping("/admin/user")
public class AdminUserListAction {
	
	
	@Resource
	private AdminUserService adminUserService;
	
	ObjectMapper objectMapper = new ObjectMapper();  
	
	
	/**
	 * 返回首页
	 * @param userEntity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("")
	public String listPage(AdminUserEntity userEntity) throws Exception {
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
	public String queryAll(int pageSize,int pageNumber) throws Exception {
		//第一个参数当前页码，第二个参数每页条数
		PageHelper.startPage(pageNumber,pageSize);  
		List<AdminUserEntity> data = adminUserService.queryAll();
		//汉字转换
		convertText(data);
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		map.put("total", adminUserService.count(param));
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
        if(!ExcelImportUtil.validateExcel(fileName)){
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
        String message = adminUserService.importUser(fileName, file);
        map.put("msg", message);
        return "importusersuccess";
    }
	
	
	@RequestMapping("/importSuccess")
	public String importSuccess() throws Exception {
		return "importusersuccess";
	}
	
//	@RequestMapping("/appointTask")
//	public String importSuccess() throws Exception {
//		return "importusersuccess";
//	}
	
	
	
	
	
	
	
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
	
	
	@RequestMapping(value="/updateAppoint",method = RequestMethod.POST)
	@ResponseBody
	public Integer updateAppoint(AdminUserEntity adminUserEntity) throws Exception {
		adminUserEntity.getId();
		adminUserEntity.setIsAppoint("1");
		adminUserEntity.getTaskid();
		return adminUserService.updateAppoint(adminUserEntity);
	}
	
	@RequestMapping(value="/userSearch",method = RequestMethod.POST)
	@ResponseBody
	public String userSearch(AdminUserEntity adminUserEntity) throws Exception {
		String userName = adminUserEntity.getUserName();
		String nickName = adminUserEntity.getNickName();
		String phone = adminUserEntity.getPhone();
		String isAppoint = adminUserEntity.getIsAppoint();
		List<AdminUserEntity> data = adminUserService.userSearch(userName, nickName, phone, isAppoint);
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> param = new HashMap<String,Object>();
//		map.put("total", adminUserService.count(param));
		map.put("total", adminUserService.countLine(userName, nickName, phone, isAppoint));
		map.put("rows", data);
		/**
		 * 汉字转换
		 */
		convertText(data);
		return objectMapper.writeValueAsString(map);
	}
	
	/*
	 **汉字转换
	 */
	public void convertText(List<AdminUserEntity> data) {
		if (data != null) {
			for(int i=0;i<data.size();i++){
				//未指派
				if(data.get(i).getIsAppoint().equals("0")){
					data.get(i).setIsAppointName("未指派");
				}
				//已指派
		        if(data.get(i).getIsAppoint().equals("1")){
		        	data.get(i).setIsAppointName("已指派");
				}
		        
		        if(data.get(i).getTaskid().equals("1")){
		        	data.get(i).setTaskName("背单词");
				}
		        
		        if(data.get(i).getTaskid().equals("2")){
		        	data.get(i).setTaskName("默写单词");
				}
		        
		        if(data.get(i).getTaskid().equals("3")){
		        	data.get(i).setTaskName("默写单词3");
				}			
			}
		}
	}
}
