package com.ability.emp.admin.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ability.emp.admin.dao.AdminDao;
import com.ability.emp.admin.entity.AdminEntity;
import com.ability.emp.admin.server.AdminService;

@Service("AdminService") 
public class AdminServiceImpl implements AdminService{
	
	@SuppressWarnings("rawtypes")
	@Resource
	private AdminDao adminDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminEntity> queryAll() {
		return adminDao.queryAll();
	}

}
