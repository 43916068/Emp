package com.ability.emp.admin.server;

import java.util.List;
import com.ability.emp.admin.entity.AdminSystemParamEntity;

public interface AdminSystemParamService {
	
	
	List<AdminSystemParamEntity> queryAll(AdminSystemParamEntity aspe);
	
	List<AdminSystemParamEntity> queryChild(AdminSystemParamEntity aspe);
	
	Integer insert(AdminSystemParamEntity aspe);
	
	AdminSystemParamEntity queryById(String id);
}
