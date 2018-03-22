package com.ability.emp.user.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ability.emp.user.dao.UserDao;
import com.ability.emp.user.entity.UserEntity;
import com.ability.emp.user.server.UserService;

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
	public int del(String id) {
		return userDao.delete(id);
	}
	
}
