package com.ability.emp.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ability.emp.base.BaseDao;

@Mapper
public interface AdminUserDao<T> extends BaseDao<T>{
    
    Integer countLine(Map<String, Object> map);
   
    List<T> queryAll(Map<String, Object> map);  
    
    String verifyUserAppoint(@Param("id")String id);
}