package com.ability.emp.admin.server;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ability.emp.admin.entity.AdminUserEntity;

public interface AdminUserService {
	
	List<AdminUserEntity> queryAll();
	
	String importUser(String fileName,MultipartFile mfile);
	
	Integer count(Map<String,Object> map);

}
