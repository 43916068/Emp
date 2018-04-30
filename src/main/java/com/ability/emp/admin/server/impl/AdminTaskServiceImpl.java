package com.ability.emp.admin.server.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ability.emp.admin.dao.AdminTaskDao;
import com.ability.emp.admin.entity.AdminSystemParamEntity;
import com.ability.emp.admin.entity.AdminTaskEntity;
import com.ability.emp.admin.entity.AdminWordEntity;
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

	@SuppressWarnings("unchecked")
	@Override
	public int insert(AdminTaskEntity taskEntiy) {
		return adminTaskDao.insert(taskEntiy);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int update(AdminTaskEntity taskEntiy) {
		return adminTaskDao.update(taskEntiy);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AdminTaskEntity> queryTaskById(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return adminTaskDao.queryTaskById(map);
	}
	

	@Override
	public List<AdminTaskEntity> queryTaskAll(String taskName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("taskName", "%" + taskName + "%");
		return adminTaskDao.queryTaskAll(map);
	}
}
