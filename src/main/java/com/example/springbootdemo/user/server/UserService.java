package com.example.springbootdemo.user.server;

import java.util.List;


import com.example.springbootdemo.user.entity.UserEntity;

public interface UserService {
	
	List<UserEntity> queryAll();
	
	int add(UserEntity userEntity);
	
	int del(String id);

}
