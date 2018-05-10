package com.ability.emp.admin.server;

import java.util.List;
import com.ability.emp.admin.entity.AdminTaskEntity;

public interface AdminTaskService {
	
	List<AdminTaskEntity> queryAll(String taskname);
	
	int insert(AdminTaskEntity taskEntiy);
	
	int update(AdminTaskEntity taskEntiy); 
	
	List<AdminTaskEntity> queryTaskById(String id);
	
	List<AdminTaskEntity> allWrongWord();

}
