package com.ability.emp.admin.server;

import java.util.List;
import java.util.Map;

import com.ability.emp.admin.entity.AdminSystemParamEntity;
import com.ability.emp.admin.entity.AdminTaskEntity;
import com.ability.emp.admin.entity.AdminWordEntity;

public interface AdminTaskService {
	
	
	List<AdminTaskEntity> queryAll();
	
	Integer count(Map<String,Object> map);
	
	int insert(AdminTaskEntity taskEntiy);
	
	int update(AdminTaskEntity taskEntiy); 
	
	List<AdminTaskEntity> queryTaskById(String id);
	
	List<AdminTaskEntity> queryTaskAll(String taskName);
}
