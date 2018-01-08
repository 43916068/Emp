package com.example.springbootdemo.user.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.springbootdemo.user.dao.UserDao;
import com.example.springbootdemo.user.entity.UserEntity;
import com.example.springbootdemo.user.server.UserService;

@Service("UserService") 
public class UserServiceImpl implements UserService{
	
	
	@SuppressWarnings("rawtypes")
	@Resource
	private UserDao userDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> queryAll() {
		return userDao.queryAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int add(UserEntity userEntity) {
		return userDao.insert(userEntity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int del(Long id) {
		return userDao.delete(id);
	}
	
}
