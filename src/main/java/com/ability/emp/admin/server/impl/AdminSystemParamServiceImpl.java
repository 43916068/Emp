package com.ability.emp.admin.server.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ability.emp.admin.dao.AdminSystemParamDao;
import com.ability.emp.admin.entity.AdminSystemParamEntity;
import com.ability.emp.admin.server.AdminSystemParamService;

@Service("AdminSystemParamService")
public class AdminSystemParamServiceImpl implements AdminSystemParamService {
	
	@SuppressWarnings("rawtypes")
	@Resource
	private AdminSystemParamDao systemParamDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AdminSystemParamEntity> queryAll() {
		return systemParamDao.queryAll();
	}

}
