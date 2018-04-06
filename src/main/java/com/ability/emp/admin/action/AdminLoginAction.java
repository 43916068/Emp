package com.ability.emp.admin.action;




import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ability.emp.admin.entity.AdminEntity;
import com.ability.emp.admin.server.AdminService;
import com.ability.emp.constant.SysConstant;
import com.ability.emp.util.Encryption;
import com.fasterxml.jackson.databind.ObjectMapper;



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
	
	
	@Resource
	private AdminService adminService;
	
	ObjectMapper objectMapper = new ObjectMapper();  

	
	@RequestMapping("")
	public String loginPage(){
		
		return "login";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public String login(AdminEntity adminEntity) throws Exception{
		String checkResult = checkField(adminEntity);
		if(checkResult!=null && !"".equals(checkResult)){
			return objectMapper.writeValueAsString(checkResult);
		}
		//使用MD5加密密码
		String pwd = Encryption.Md5Encrypt(adminEntity.getAdminPwd());
		AdminEntity ae = adminService.login(adminEntity.getAdminName(), pwd);
		if(ae==null){
			return objectMapper.writeValueAsString("Please Check Name or Password");
		}
		if(ae.getStatus().equals(SysConstant.FORBIDDEN)){
			return objectMapper.writeValueAsString("Account is Disabled");
		}
		return objectMapper.writeValueAsString("0");
	}
	
	@RequestMapping("/main")
	public String main(HttpServletRequest request,HttpServletResponse response){
	
		return "main";
	}
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request,HttpServletResponse response){
	
		return "content";
	}
	
	private String checkField(AdminEntity adminEntity){
		if(adminEntity!=null){
			if(adminEntity.getAdminName()==null || "".equals(adminEntity.getAdminName())){
				return "Please Input Name";
			}
			if(adminEntity.getAdminPwd()==null || "".equals(adminEntity.getAdminPwd())){
				return "Please Input Password";
			}
		}
		return "";
	}
}
