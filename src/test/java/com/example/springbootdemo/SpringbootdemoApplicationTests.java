package com.example.springbootdemo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springbootdemo.user.action.UserAction;
import com.example.springbootdemo.user.entity.UserEntity;
import com.example.springbootdemo.util.GenerateUUID;

import net.minidev.json.JSONArray;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {
	
	@Resource
	private UserAction userAction;

	@SuppressWarnings("unchecked")
	@Test
	public void queryAll() {
		 List<UserEntity> list = new ArrayList<UserEntity>();
		 list = (List<UserEntity>) userAction.query().get("data");
		 String json = JSONArray.toJSONString(list);
		 System.out.println(json);
	}
	
	@Test
	public void add() {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(GenerateUUID.generateUUID());
		userEntity.setPassword("123");
		userEntity.setUsername("大鹏");
		userAction.add(userEntity);
	}

}
