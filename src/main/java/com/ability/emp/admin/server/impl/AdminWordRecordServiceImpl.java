package com.ability.emp.admin.server.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ability.emp.admin.dao.AdminWordRecordDao;
import com.ability.emp.admin.entity.AdminWordRecordEntity;
import com.ability.emp.admin.server.AdminWordRecordService;
import com.ability.emp.util.UUIDUtil;


@Service("AdminWordRecordService") 
public class AdminWordRecordServiceImpl implements AdminWordRecordService {

	@SuppressWarnings("rawtypes")
	@Resource
	private AdminWordRecordDao wordRecordDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminWordRecordEntity> queryAll() {
		return wordRecordDao.queryAll();
	}

	@Override
	public Integer count(Map<String, Object> map) {
		return wordRecordDao.count(map);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Integer update(AdminWordRecordEntity wordRecordEntiy) {
		return wordRecordDao.update(wordRecordEntiy);
	}

	@Override
	public Integer insert(AdminWordRecordEntity wordRecordEntiy) {
		return wordRecordDao.insert(wordRecordEntiy);
	}	
}
