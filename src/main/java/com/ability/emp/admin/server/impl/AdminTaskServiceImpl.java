package com.ability.emp.admin.server.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ability.emp.admin.dao.AdminTaskDao;
import com.ability.emp.admin.entity.AdminTaskEntity;
import com.ability.emp.admin.server.AdminTaskService;

@Service("AdminTaskService") 
public class AdminTaskServiceImpl implements AdminTaskService{
	
	@SuppressWarnings("rawtypes")
	@Resource
	private AdminTaskDao adminTaskDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminTaskEntity> queryAll() {
		return adminTaskDao.queryAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer count(Map<String, Object> map) {
		return adminTaskDao.count(map);
	}

}
