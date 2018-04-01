package com.ability.emp.admin.server;

import java.util.List;

import com.ability.emp.admin.entity.AdminEntity;

public interface AdminService {
	
	List<AdminEntity> queryAll();
}
