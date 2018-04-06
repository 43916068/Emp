package com.ability.emp.admin.server.impl;

import java.util.List;
import java.util.Map;

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

	@SuppressWarnings("unchecked")
	@Override
	public Integer count(Map<String, Object> map) {
		return adminDao.count(map);
	}

	@Override
	public AdminEntity login(String name, String pwd) {
		return adminDao.login(name, pwd);
	}

}
