package com.ability.emp.util;

import java.util.UUID;

public class UUIDUtil {

	
	public static String generateUUID(){
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}
}
