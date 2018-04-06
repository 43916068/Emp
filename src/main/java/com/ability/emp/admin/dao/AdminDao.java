package com.ability.emp.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ability.emp.admin.entity.AdminEntity;
import com.ability.emp.base.BaseDao;

@Mapper
public interface AdminDao<T>  extends BaseDao<T>{
	
	
	AdminEntity login(@Param("adminName") String name, @Param("adminPwd") String pwd);
    
}