package com.ability.emp.admin.server.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ability.emp.admin.dao.AdminSystemParamDao;
import com.ability.emp.admin.entity.AdminSystemParamEntity;
import com.ability.emp.admin.server.AdminSystemParamService;
import com.ability.emp.util.UUIDUtil;

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

	@Override
	public Integer insert(AdminSystemParamEntity aspe) {
		aspe.setId(UUIDUtil.generateUUID());
		aspe.setDel("0");
		return systemParamDao.insert(aspe);
	}

	@Override
	public AdminSystemParamEntity queryById(String id) {
		return (AdminSystemParamEntity) systemParamDao.queryById(id);
	}
	public Integer delete(String id) {
		return systemParamDao.delete(id);
	}

}
