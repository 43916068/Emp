package com.ability.emp.admin.server;

import java.util.List;
import java.util.Map;

import com.ability.emp.admin.entity.AdminEntity;

public interface AdminService {
	
//	List<AdminEntity> queryAll();
	
	List<AdminEntity> queryAll(AdminEntity adminEntity);
	
	AdminEntity login(String name,String pwd);
	
	Integer insert(String adminName, String adminPwd);
	
	Integer verifieName(String adminName);
	
	Integer update(AdminEntity adminEntity);
	
}
