package com.ability.emp.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ability.emp.admin.entity.AdminSystemParamEntity;
import com.ability.emp.base.BaseDao;

@Mapper
public interface AdminSystemParamDao <T> extends BaseDao<T>{
	
	List<AdminSystemParamEntity> queryChild(AdminSystemParamEntity aspe);
	
	List<AdminSystemParamEntity> queryAll(AdminSystemParamEntity aspe);

}
