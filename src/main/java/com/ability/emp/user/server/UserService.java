package com.ability.emp.user.server;

import java.util.List;

import com.ability.emp.user.entity.UserEntity;

public interface UserService {
	
	List<UserEntity> queryAll();
	
	int add(UserEntity userEntity);
	
	int del(String id);

}
