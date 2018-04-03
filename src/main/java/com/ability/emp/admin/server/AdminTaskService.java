package com.ability.emp.admin.server;

import java.util.List;
import java.util.Map;

import com.ability.emp.admin.entity.AdminTaskEntity;

public interface AdminTaskService {
	
	
	List<AdminTaskEntity> queryAll();
	
	Integer count(Map<String,Object> map);

}
