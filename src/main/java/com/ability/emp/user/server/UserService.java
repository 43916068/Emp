package com.ability.emp.user.server;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ability.emp.user.entity.UserEntity;

public interface UserService {
	
	List<UserEntity> queryAll();
	
	String importUser(String fileName,MultipartFile mfile);

}
