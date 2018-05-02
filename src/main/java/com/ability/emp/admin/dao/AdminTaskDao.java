package com.ability.emp.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import com.ability.emp.admin.entity.AdminTaskEntity;
import com.ability.emp.base.BaseDao;

@Mapper
public interface AdminTaskDao<T> extends BaseDao<T>{
	
	String findTaskName(AdminTaskEntity adminTaskEntity);
	
}