package com.ability.emp.admin.server.impl;

import java.util.List;
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
	public List<AdminSystemParamEntity> queryAll(AdminSystemParamEntity aspe) {
		return systemParamDao.queryAll(aspe);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminSystemParamEntity> queryChild(AdminSystemParamEntity aspe) {
		return systemParamDao.queryChild(aspe);
	}

}
