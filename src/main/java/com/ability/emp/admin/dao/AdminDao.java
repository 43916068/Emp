package com.ability.emp.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ability.emp.admin.entity.AdminEntity;
import com.ability.emp.base.BaseDao;

@Mapper
public interface AdminDao<T>  extends BaseDao<T>{
	
	
	AdminEntity login(@Param("adminName") String name, @Param("adminPwd") String pwd);
	
	int verifieName(Map<String, Object> param);
	
	List<T> queryAll(Map<String, Object> param);
    
}