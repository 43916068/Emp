package com.ability.emp.admin.server;

import java.util.List;
import java.util.Map;

import com.ability.emp.admin.entity.AdminEntity;

public interface AdminService {
	
	List<AdminEntity> queryAll();
	
	Integer count(Map<String,Object> map);
	
	AdminEntity login(String name,String pwd);
}
