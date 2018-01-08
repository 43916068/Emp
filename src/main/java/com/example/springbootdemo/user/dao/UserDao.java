package com.example.springbootdemo.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.springbootdemo.base.BaseDao;

@Mapper
public interface UserDao<T> extends BaseDao<T>{
    
}